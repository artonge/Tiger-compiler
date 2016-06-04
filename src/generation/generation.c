#include "generation.h"


chunk *computeInstruction(ANTLR3_BASE_TREE *node);
chunk *computeExpr(ANTLR3_BASE_TREE *node);
chunk *computeIf(ANTLR3_BASE_TREE *node);
chunk *computeWhile(ANTLR3_BASE_TREE *node);
chunk *computeFor(ANTLR3_BASE_TREE *node);
chunk *computeLet(ANTLR3_BASE_TREE *node);
chunk *computeVarDeclaration(ANTLR3_BASE_TREE *node);
chunk *computeFuncDeclaration(ANTLR3_BASE_TREE *node);


// TODO - build DISPLAY, link it in R14
void generateASM(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mGenerate ASM\033[0m");
  initRegisters();

  program = initChunk();
  chunk *instructionASM = computeInstruction(node);

  addInstruction(program, "STACK EQU 0x1000");
  addInstruction(program, "SP EQU R15");
  addInstruction(program, "MAIN EQU 0xFF10");
  addInstruction(program, "ORG MAIN");
  addInstruction(program, "START MAIN");
  addInstruction(program, "// PRGM");

  appendChunks(program, instructionASM);

  FILE *file = fopen("a.asm", "w");
  fprintf(file, program->string);
  fclose(file);

  printChunk(program);

  freeChunk(instructionASM);
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

  chunk *chunk, *chunk_left, *chunk_right;
  int type = node->getType(node);

  char *template;

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
  // unless it's a NEG node, because NEG only has one child
  // Append chunks
  chunk_left  = computeExpr(node->getChild(node, 0));
  appendChunks(chunk, chunk_left);

  if (type != NEG) {
    chunk_right = computeExpr(node->getChild(node, 1));
    appendChunks(chunk, chunk_right);
  }

  // Get free register to host result
  loadAtom(NULL, chunk);


  // Do operation with chunk's register
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

      jumpTo(chunk, type, 2);

      addInstruction(chunk, "STW R%d, #0", chunk->registre);
      jumpTo(chunk, 0, 2);
      addInstruction(chunk, "STW R%d, #1", chunk->registre);

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
      break;


    case NEG :
      addInstruction(chunk, "NEG R%d, R%d", chunk_left->registre, chunk->registre);
      break;

    case ASSIGNE :
      addInstruction(chunk, "STW R%d, R%d", chunk_right->registre, chunk_left->registre);
      break;

    default:
      error("Not handling that kind of opperations. Sorry.");
  }

  freeChunk(chunk_left);

  if (type != NEG)
    freeChunk(chunk_right);

  return chunk;
}


chunk *computeIf(ANTLR3_BASE_TREE *node) {
  //         CONDITION COMPUTING
  //         |
  //     <-- JUMP TO AFTER IF INSTRUCTIONS IF RESULT == 0
  //    |    |
  //    |    IF INSTRUCTION
  //    |    |
  //  <-|--- JUMP TO AFTER ELSE INSTRUCTION
  // |  |
  // |   -->
  // |       |
  // |       ELSE INSTRUCTION
  // |       |
  //  -----> END

  debug(DEBUG_GENERATION, "\033[22;93mCompute if\033[0m");

  ANTLR3_BASE_TREE *expr;
  chunk *chunk, *chunk_expr, *chunk_if, *chunk_else;

  chunk = initChunk();


  // Get expression chunks
  chunk_expr = computeExpr(node->getChild(node, 0));
  // Merge chunk_expr into chunk
  appendChunks(chunk, chunk_expr);


  // Get if chunks
  chunk_if = computeInstruction(node->getChild(node, 1));


  // Jump to after the if expression and the jump at the end of the if
  jumpTo(chunk, EQ, chunk_if->nb_instructions*2 + 2);


  // Merge if's chunk into chunk
  appendChunks(chunk, chunk_if);


  // If 'if else', get else chunk and append it
  if (node->getChildCount(node) > 2) {
    chunk_else = computeInstruction(node->getChild(node, 2));

    // Jump to after else at the end of the if
    jumpTo(chunk, 0, chunk_else->nb_instructions*2);

    appendChunks(chunk, chunk_else);
  }

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

  chunk *chunk, *chunk_expr;
  int count = node->getChildCount(node);

  chunk      = initChunk();
  chunk_expr = computeExpr(node->getChild(node, count-1));


  addInstruction(chunk, "// VAR_DECLARATION (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  appendChunks(chunk, chunk_expr);

  loadAtom(node->getChild(node, 0), chunk);

  addInstruction(chunk,
                "STW R%d, R%d",
                chunk_expr->registre,
                chunk->registre);

  freeChunk(chunk_expr);

  return chunk;
}


chunk *computeFuncDeclaration(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute func declaration\033[0m");

  chunk *chunk, *chunk_instr;

  int count = node->getChildCount(node);

  chunk = initChunk();

  chunk_instr = computeInstruction(node->getChild(node, count-1));
  appendChunks(chunk, chunk_instr);
  freeChunk(chunk_instr);

  return chunk;
}


chunk *computeWhile(ANTLR3_BASE_TREE *node) {
  //     -->
  //    |   |
  //    |  CONDITION COMPUTING
  //    |   |
  //  <-|- JUMP TO AFTER INSTRUCTIONS IF RESULT == 0
  // |  |   |
  // |  |  INSTRUCTIONS...-->
  // |  |                    |
  // |   <-------------------
  // |
  //  -->  END

  debug(DEBUG_GENERATION, "\033[22;93mCompute while\033[0m");

  chunk *chunk, *chunk_cond, *chunk_instr;
  // Set chunks
  chunk       = initChunk();
  chunk_cond  = computeExpr(node->getChild(node, 0));
  chunk_instr = computeInstruction(node->getChild(node, 1));


  addInstruction(chunk, "// WHILE (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  appendChunks(chunk, chunk_cond);

  jumpTo(chunk, EQ, chunk_instr->nb_instructions*2 + 2);

  appendChunks(chunk, chunk_instr);

  // Jump to before the condition computation
  jumpTo(chunk, 0,
        chunk_cond->nb_instructions*2 + chunk_instr->nb_instructions*2 + 4);

  // Free chunks
  freeChunk(chunk_cond);
  freeChunk(chunk_instr);

  return chunk;
}


chunk *computeFor(ANTLR3_BASE_TREE *node) {
  //       INITIALISATION (for ...)
  //     -->
  //    |   |
  //    |  CONDITION COMPUTING (to ...)
  //    |   |
  //  <-|- JUMP TO AFTER INSTRUCTIONS IF RESULT == 0
  // |  |   |
  // |  |  INSTRUCTIONS (do ...) -->
  // |  |                           |
  // |  |                LOOP INSTRUCTION (var init ++)
  // |  |                           |
  // |   <--------------------------
  // |
  //  -->  END

  debug(DEBUG_GENERATION, "\033[22;93mCompute for\033[0m");

  chunk *chunk, *chunk_init, *chunk_cond, *chunk_instr;

  // Set chunks
  chunk       = initChunk();
  chunk_init  = computeExpr(node->getChild(node, 0));
  chunk_cond  = computeExpr(node->getChild(node, 1));
  chunk_instr = computeInstruction(node->getChild(node, 2));


  addInstruction(chunk, "// FOR (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  appendChunks(chunk, chunk_init);

  appendChunks(chunk, chunk_cond);

  loadAtom(NULL, chunk);

  addInstruction(chunk, "SUB R%d, R%d, R%d",
                chunk_init->registre, chunk_cond->registre, chunk->registre);

  jumpTo(chunk, SUP_EQ, chunk_instr->nb_instructions*2 + 2);

  appendChunks(chunk, chunk_instr);

  // Jump to before the condition computation
  jumpTo(chunk, 0,
        chunk_cond->nb_instructions*2 + chunk_instr->nb_instructions*2 + 6);

  // Free chunks
  freeChunk(chunk_init);
  freeChunk(chunk_cond);
  freeChunk(chunk_instr);

  return chunk;
}


chunk *computeLet(ANTLR3_BASE_TREE *node) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute let\033[0m");

  chunk *chunk, *chunk_decl, *chunk_instr;

  chunk = initChunk();
  chunk_decl  = computeInstruction(node->getChild(node, 0));
  chunk_instr = computeInstruction(node->getChild(node, 1));

  appendChunks(chunk, chunk_decl);
  appendChunks(chunk, chunk_instr);

  freeChunk(chunk_decl);
  freeChunk(chunk_instr);

  return chunk;
}
