#include "generation.h"


// TODO - Handle string
chunk *computeInstruction(ANTLR3_BASE_TREE *node);
chunk *computeExpr(ANTLR3_BASE_TREE *node);
chunk *computeIf(ANTLR3_BASE_TREE *node);
chunk *computeWhile(ANTLR3_BASE_TREE *node);
chunk *computeFor(ANTLR3_BASE_TREE *node);
chunk *computeLet(ANTLR3_BASE_TREE *node);
chunk *computeVarDeclaration(ANTLR3_BASE_TREE *node);
chunk *computeFuncDeclaration(ANTLR3_BASE_TREE *node);


void generateASM(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mGenerate ASM\033[0m");
  initRegisters();

  program = initChunk();

  addInstruction(program, "SP EQU R15");
  addInstruction(program, "FP EQU R14");
  addInstruction(program, "DISPLAY EQU R13");
  // TODO - dynamise load adr
  addInstruction(program, "ORG 0xE000");
  addInstruction(program, "START MAIN");


  chunk *stack = stackEnvironement();
  chunk *instructionASM = computeInstruction(node);
  chunk *unstack = unstackEnvironement();


  addInstruction(program, "\n\n\n// PRGM");
  addEtiquette(program, "MAIN");
  addInstruction(program, "STACKBASE 0x1000");
  addInstruction(program, "LDW FP, SP");
  addInstruction(program, "LDW DISPLAY, #0x2000");
  addInstruction(program, "// STACK FACK RETURN");
  addInstruction(program, "ADQ -2, SP");
  appendChunks(program, stack);
  appendChunks(program, instructionASM);
  appendChunks(program, unstack);
  addInstruction(program, "// UNSTACK FACK RETURN");
  addInstruction(program, "ADQ 2, SP");


  FILE *file = fopen("a.asm", "w");
  fprintf(file, program->string);
  fclose(file);

  // printChunk(program);

  freeChunk(instructionASM);
  freeChunk(stack);
  freeChunk(unstack);
  freeChunk(program);
}


chunk *computeInstruction(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute instruction\033[0m");

  chunk *chunk, *tmp_chunk;
  int i, scope_tmp;

  static int scope = 0;


  switch (node->getType(node)) {

    case INTEGER :
    case STRING :
    case ID :
    case FUNC_CALL :
    case SUP    :
    case INF    :
    case SUP_EQ :
    case INF_EQ :
    case EQ     :
    case DIFF   :
    case AND :
    case OR :
    case MINUS :
    case PLUS :
    case DIV :
    case MULT :
    case NEG :
    case ASSIGNE :
      return computeExpr(node);


    case IF:
      return computeIf(node);

    case WHILE :
      return computeWhile(node);

    case FOR :
      return computeFor(node);


    case VAR_DECLARATION :
      return computeVarDeclaration(node);

    case FUNC_DECLARATION :
    case LET :
      enterScopeN(scope);

      scope_tmp = scope;
      scope = 0;

      switch (node->getType(node)) {
        case LET:
          chunk = computeLet(node);
          break;
        case FUNC_DECLARATION:
          chunk = computeFuncDeclaration(node);
          break;
      }

      scope = scope_tmp;
      scope++;

      leaveScope();

      return chunk;


    default:
      chunk = initChunk();

      // Compute all children
      for (i = 0; i < node->getChildCount(node); i++) {
        tmp_chunk = computeInstruction(node->getChild(node, i));
        appendChunks(chunk, tmp_chunk);
        // appendChunks replace chunk->registre with tmp_chunk's one
        // but freeChunk free the registre of tmp_chunk
        // we don't want chunk->registre to be overwritten !
        if (tmp_chunk != NULL)
          tmp_chunk->registre = -1;
        freeChunk(tmp_chunk);
      }

      return chunk;
  }
}


chunk *computeExpr(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION,
        "\033[22;93mCompute expression [%s] (%d:%d)\033[0m",
        (char *)node->toString(node)->chars,
        node->getLine(node),
        node->getCharPositionInLine(node));

  chunk *chunk, *chunk_left = NULL, *chunk_right = NULL;
  int type = node->getType(node);
  char *template;
  char etiq_1[10], etiq_2[10];
  static int etiq_nb = 0;


  chunk = initChunk();

  // If it's an atom, get the address to access it
  if (type == INTEGER ||
      type == STRING ||
      type == ID ||
      type == FUNC_CALL) {
    loadAtom(node, chunk);
    return chunk;
  }


  // Else get both operand chunk
  // unless it's assign, we only want the address of the left opperand
  if (type != ASSIGNE) chunk_left  = computeExpr(node->getChild(node, 0));
  // unless it's a NEG node, because NEG only has one child
  if (type != NEG)     chunk_right = computeExpr(node->getChild(node, 1));


  appendChunks(chunk, chunk_left);
  // It frees chunk_left->registre. Weird but ok because no more registre needed
  // unless for assign, but it will erased chunk_left->registre that is not initialised
  // SO KEEP THAT ORDER UNLESS YOU KNOW WHAT YOU'RE DOING !
  appendChunks(chunk, chunk_right);


  // Do operation
  switch (type) {
    case SUP :
    case INF :
    case SUP_EQ :
    case INF_EQ :
    case EQ :
    case DIFF :
      addInstruction(chunk, "SUB R%d, R%d, R%d // %d:%d",
                    chunk_left->registre,
                    chunk_right->registre,
                    chunk->registre,
                    node->getLine(node),
                    node->getCharPositionInLine(node));

      sprintf(etiq_1, "ETIQ_%d", etiq_nb++);
      sprintf(etiq_2, "ETIQ_%d", etiq_nb++);

      jumpTo(chunk, type, etiq_1, 0);

      addInstruction(chunk, "LDW R%d, #0", chunk->registre);
      jumpTo(chunk, 0, etiq_2, 0);

      addEtiquette(chunk, etiq_1);
      addInstruction(chunk, "LDW R%d, #1", chunk->registre);

      addEtiquette(chunk, etiq_2);

      chunk_right->registre = -1;

      break;


    case AND :
    case OR :
    case MINUS :
    case PLUS :
    case DIV :
    case MULT :
      switch (type) {
        case OR :
          template = "OR R%d, R%d, R%d // %d:%d";
          break;
        case MINUS :
          template = "SUB R%d, R%d, R%d // %d:%d";
          break;
        case PLUS :
          template = "ADD R%d, R%d, R%d // %d:%d";
          break;
        case DIV :
          template = "DIV R%d, R%d, R%d // %d:%d";
          break;
        case MULT :
          template = "ADD R%d, R%d, R%d // %d:%d";
          break;
      }

      addInstruction(chunk, template,
                    chunk_left->registre,
                    chunk_right->registre,
                    chunk->registre,
                    node->getLine(node),
                    node->getCharPositionInLine(node));

      chunk_right->registre = -1;

      break;


    case NEG :
      addInstruction(chunk, "NEG R%d, R%d", chunk_left->registre, chunk->registre);

      chunk_left->registre = -1;

      break;

    case ASSIGNE :
      chunk_left = getVarAddress(
                    (char*)node->toString(node->getChild(node, 0))->chars
                 );
      appendChunks(chunk, chunk_left);
      addInstruction(chunk, "STW R%d, (R%d)", chunk_right->registre, chunk_left->registre);
      // Set chunk->registre so we have the value
      chunk->registre = chunk_right->registre;
      // Free left register, now useless
      freeRegister(chunk_left->registre);

      chunk_right->registre = -1;

      break;

    default:
      error("Not handling that kind of opperations. Sorry.");
  }


  freeChunk(chunk_left);
  freeChunk(chunk_right);

  return chunk;
}


chunk *computeIf(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute if\033[0m");

  ANTLR3_BASE_TREE *expr;
  chunk *chunk = initChunk(), *chunk_expr, *chunk_if, *chunk_else = NULL;
  static int if_nb = 0;
  char else_etiq[10], if_end_etiq[10];
  int reg;

  addInstruction(chunk, "// IF (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  // Get chunks
  chunk_expr = computeExpr(node->getChild(node, 0));
  chunk_if   = computeInstruction(node->getChild(node, 1));
  if (node->getChildCount(node) > 2)
    chunk_else = computeInstruction(node->getChild(node, 2));

  reg = getRegister();


  // Set etiquettes
  sprintf(  else_etiq, "IF_%d", if_nb++);
  sprintf(if_end_etiq, "IF_%d", if_nb++);


  // Add ASM
  //         CONDITION COMPUTING
             appendChunks(chunk, chunk_expr);
  //         |
             jumpTo(chunk, EQ, else_etiq, 0);
  //     <-- JUMP TO AFTER IF INSTRUCTIONS IF RESULT == 0
  //    |    |
  //    |    IF INSTRUCTION
  /*    |  */appendChunks(chunk, chunk_if);
  //    |    Store if's last result into chunk's registre
  /*    |  */addInstruction(chunk, "LDW R%d, R%d", reg, chunk_if->registre);
  //    |    |
  //  <-|--- JUMP TO AFTER ELSE INSTRUCTION
  /* |  |  */jumpTo(chunk, 0, if_end_etiq, 0);
  // |  |
  // |   --> if_etiq_1
  /* |     */addEtiquette(chunk, else_etiq);
  // |       |
  // |       ELSE INSTRUCTION
  /* |     */appendChunks(chunk, chunk_else);
  // |       Store else's last result into chunk's registre
  /* |     */addInstruction(chunk, "LDW R%d, R%d", reg, chunk_else->registre);
  // |       |
  //  -----> if_etiq_2
             addEtiquette(chunk, if_end_etiq);

  // Free chunk->registre that is equal to chunk_else->registre
  freeRegister(chunk->registre);
  // Set chunk registre to be the one we reserved for if or else last result
  chunk->registre = reg;


  // Free chunks, because now useless
  freeChunk(chunk_expr);
  freeChunk(chunk_if);
  freeChunk(chunk_else);

  // Return our chunk filled with the condition, if expression,
  // and optionaly else expression
  return chunk;
}


chunk *computeVarDeclaration(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute var declaration\033[0m");

  chunk *chunk = initChunk(), *chunk_expr, *chunk_var;
  int count = node->getChildCount(node);


  addInstruction(chunk, "\n\n// VAR_DECLARATION (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  // Get var address
  chunk_var  = getVarAddress(
                  (char*)node->toString(node->getChild(node, 0))->chars
                );
  // Get expression result
  chunk_expr = computeExpr(node->getChild(node, count-1));


  appendChunks(chunk, chunk_var);
  appendChunks(chunk, chunk_expr);


  // Write result in var address
  addInstruction(chunk,
                "STW R%d, (R%d)",
                chunk_expr->registre,
                chunk_var->registre);


  chunk_expr->registre = -1;
  freeChunk(chunk_expr);
  freeChunk(chunk_var);

  return chunk;
}


chunk *computeFuncDeclaration(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute func declaration\033[0m");

  chunk *chunk = initChunk(),
        *chunk_instr,
        *chunk_stack, *chunk_unstack;
  entity *e = searchFunc((char*)node->toString(node->getChild(node, 0))->chars);
  int i, count = node->getChildCount(node),
      _registres[15];


  // Save registers
  for (i = 0; i <= 15; i++)
    _registres[i] = registres[i];
  initRegisters();


  addInstruction(chunk, "\n\n\n// FUNC_DECLARATION %s (%d:%d)",
                e->name,
                node->getLine(node),
                node->getCharPositionInLine(node));


  addEtiquette(chunk, e->etiquette);

  chunk_stack   = stackEnvironement();
  chunk_instr   = computeInstruction(node->getChild(node, count-1));
  chunk_unstack = unstackEnvironement();

  // Get instructions chunk
  appendChunks(chunk, chunk_stack);
  addInstruction(chunk, "\n// FUNC CORE");
  appendChunks(chunk, chunk_instr);
  appendChunks(chunk, chunk_unstack);

  chunk->registre = chunk_instr->registre;
  chunk_instr->registre = -1;

  freeChunk(chunk_stack);
  freeChunk(chunk_instr);
  freeChunk(chunk_unstack);

  // Put last operation result into R0
  addInstruction(chunk, "LDW R0, R%d", chunk->registre);
  // Return
  addInstruction(chunk, "RTS");


  // Restor registers
  for (i = 0; i <= 15; i++)
    registres[i] = _registres[i];

  appendChunks(program, chunk);

  freeChunk(chunk);

  return NULL;
}


chunk *computeWhile(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute while\033[0m");

  chunk *chunk = initChunk(), *chunk_cond, *chunk_instr;
  char while_begin_etiq[10], while_end_etiq[10];
  static int while_nb = 0;


  addInstruction(chunk, "\n\n// WHILE (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  // Get chunks
  chunk_cond  = computeExpr(node->getChild(node, 0));
  chunk_instr = computeInstruction(node->getChild(node, 1));


  // Set etiquettes
  sprintf(while_begin_etiq, "WHILE_%d", while_nb++);
  sprintf(  while_end_etiq, "WHILE_%d", while_nb++);


  // Add ASM
  //     --> while_begin_etiq
  /*    |   */addEtiquette(chunk, while_begin_etiq);
  //    |    |
  //    |    CONDITION COMPUTING
  /*    |  */appendChunks(chunk, chunk_cond);
  //    |    |
  //  <-|----JUMP TO AFTER INSTRUCTIONS IF RESULT == 0
  /* |  |  */jumpTo(chunk, EQ, while_end_etiq, 0);
  // |  |    |
  // |  |    INSTRUCTIONS...
  /* |  |  */appendChunks(chunk, chunk_instr);
  // |  |    |
  // |   <---JUMP TO BEGIN
  /* |     */jumpTo(chunk, 0, while_begin_etiq, 1);
  // |
  //  ------>while_end_etiq
             addEtiquette(chunk, while_end_etiq);

  chunk_instr->registre = -1;

  // Free chunks
  freeChunk(chunk_cond);
  freeChunk(chunk_instr);

  return chunk;
}


chunk *computeFor(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute for\033[0m");

  chunk *chunk = initChunk(), *chunk_init, *chunk_cond, *chunk_instr;
  char for_begin_etiq[10], for_end_etiq[10];
  static int for_nb = 0;


  addInstruction(chunk, "\n\n// FOR (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  // Set chunks
  chunk_init  = computeExpr(node->getChild(node, 0));
  chunk_cond  = computeExpr(node->getChild(node, 1));
  chunk_instr = computeInstruction(node->getChild(node, 2));


  // Set etiquettes
  sprintf(for_begin_etiq, "FOR_%d", for_nb++);
  sprintf(  for_end_etiq, "FOR_%d", for_nb++);


  // Add ASM
  //          INITIALISATION (for ...)
  /*        */appendChunks(chunk, chunk_init);
  //     ---->for_begin_etiq
  /*    |   */addEtiquette(chunk, for_begin_etiq);
  //    |     |
  //    |     CONDITION COMPUTING (to ...)
  /*    |   */appendChunks(chunk, chunk_cond);
  //    |     |
  //    |     INIT - COND
  /*    |   */addInstruction(chunk, "SUB R%d, R%d, R%d",
  /*    |     |            */chunk_init->registre,
  /*    |     |            */chunk_cond->registre,
  /*    |     |            */chunk_cond->registre);
  //    |     |
  //  <-|-----JUMP TO AFTER INSTRUCTIONS IF RESULT == 0
  /* |  |   */jumpTo(chunk, SUP_EQ, for_end_etiq, 0);
  // |  |     |
  // |  |     INSTRUCTIONS (do ...) -->
  /* |  |   */appendChunks(chunk, chunk_instr);
  // |  |     |
  // |  |     LOOP INSTRUCTION (var init ++ and jump)
  /* |  |   */addInstruction(chunk, "ADQ 1, R%d", chunk_init->registre);
  /* |   <--*/jumpTo(chunk, 0, for_begin_etiq, 1);
  // |
  //  ------->for_end_etiq
              addEtiquette(chunk, for_end_etiq);

  chunk_instr->registre = -1;


  // Free chunks
  freeChunk(chunk_init);
  freeChunk(chunk_cond);
  freeChunk(chunk_instr);

  return chunk;
}


// Act like a function, without params and no return ?
chunk *computeLet(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute let\033[0m");

  chunk *chunk = initChunk(),
        *chunk_decl, *chunk_instr,
        *chunk_stack, *chunk_unstack;

  addInstruction(chunk, "\n\n\n// LET (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  chunk_stack   = stackEnvironement();
  chunk_decl    = computeInstruction(node->getChild(node, 0));
  chunk_instr   = computeInstruction(node->getChild(node, 1));
  chunk_unstack = unstackEnvironement();


  addInstruction(chunk, "// STACK FACK RETURN");
  addInstruction(chunk, "ADQ -2, SP");
  appendChunks(chunk, chunk_stack);
  appendChunks(chunk, chunk_decl);
  appendChunks(chunk, chunk_instr);
  appendChunks(chunk, chunk_unstack);
  addInstruction(chunk, "// UNSTACK FACK RETURN");
  addInstruction(chunk, "ADQ 2, SP");

  // Set chunk's registre to the instruction chunk registre
  chunk->registre = chunk_instr->registre;
  chunk_instr->registre = -1;

  freeChunk(chunk_stack);
  freeChunk(chunk_unstack);
  freeChunk(chunk_decl);
  freeChunk(chunk_instr);

  return chunk;
}
