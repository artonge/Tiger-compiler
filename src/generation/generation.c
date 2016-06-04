#include "generation.h"


chunk *computeInstruction(ANTLR3_BASE_TREE *tree);
chunk *computeExpr(ANTLR3_BASE_TREE *tree);
chunk *computeIf(ANTLR3_BASE_TREE *node);
chunk *computeWhile(ANTLR3_BASE_TREE *node);
chunk *computeFor(ANTLR3_BASE_TREE *node);
chunk *computeVarDeclaration(ANTLR3_BASE_TREE *node);
chunk *computeFuncDeclaration(ANTLR3_BASE_TREE *node);

void generateASM(ANTLR3_BASE_TREE *tree) {
  debug(DEBUG_GENERATION, "\033[22;93mGenerate ASM\033[0m");
  initRegisters();

  program = initChunk();
  chunk *instructionASM = computeInstruction(tree);

  addInstruction(program, "STACK_A EQU 0x1000");
  addInstruction(program, "SP EQU R15");
  addInstruction(program, "MAIN_A	EQU 0xFF10");
  addInstruction(program, "ORG MAIN");
  addInstruction(program, "START MAIN");

  appendChunks(program, instructionASM);

  FILE *file = fopen("a.asm", "w");
  fprintf(file, program->string);
  fclose(file);

  printChunk(program);

  freeChunk(instructionASM);
  freeChunk(program);
}


chunk *computeInstruction(ANTLR3_BASE_TREE *tree) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute instruction\033[0m");

  chunk *chunk, *tmp_chunk;
  int i;

  switch (tree->getType(tree)) {
    case IF:
      return computeIf(tree);


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
      return computeExpr(tree);


    case VAR_DECLARATION :
      return computeVarDeclaration(tree);

    case WHILE :
      return computeWhile(tree);

    case FOR :
      return computeFor(tree);


    default:
      chunk = initChunk();

      // Compute all children
      for (i = 0; i < tree->getChildCount(tree); i++) {
        tmp_chunk = computeInstruction(tree->getChild(tree, i));
        appendChunks(chunk, tmp_chunk);
        freeChunk(tmp_chunk);
      }

      return chunk;
  }
}


chunk *computeExpr(ANTLR3_BASE_TREE *tree) {
  debug(DEBUG_GENERATION,
        "\033[22;93mCompute expression [%s] (%d:%d)\033[0m",
        (char *)tree->toString(tree)->chars,
        tree->getLine(tree),
        tree->getCharPositionInLine(tree));

  chunk *chunk, *chunk_left, *chunk_right;
  int type = tree->getType(tree);

  char *template;

  chunk = initChunk();

  // If it's an atom, get the address to access it
  if (type == INTEGER ||
      type == STRING ||
      type == ID ||
      type == FUNC_CALL) {
    getAddress(tree, chunk);
    return chunk;
  }

  // Else get both operand chunk
  // unless it's a NEG node, because NEG only has one child
  // Append chunks
  chunk_left  = computeExpr(tree->getChild(tree, 0));
  appendChunks(chunk, chunk_left);

  if (type != NEG) {
    chunk_right = computeExpr(tree->getChild(tree, 1));
    appendChunks(chunk, chunk_right);
  }

  // Get free register to host result
  getAddress(NULL, chunk);


  // Do operation with chunk's register
  switch (type) {
    case SUP :
    case INF :
    case SUP_EQ :
    case INF_EQ :
    case EQ :
    case DIFF :
      addInstruction(chunk, "SUB %s, %s, %s // %d:%d",
                    chunk_left->address,
                    chunk_right->address,
                    chunk->address,
                    tree->getLine(tree),
                    tree->getCharPositionInLine(tree));

      jumpTo(chunk, type, 2);

      addInstruction(chunk, "STW #0 %s", chunk->address);
      jumpTo(chunk, 0, 2);
      addInstruction(chunk, "STW #1 %s", chunk->address);

      break;


    case AND :
    case OR :
    case MINUS :
    case PLUS :
    case DIV :
    case MULT :
      switch (type) {
        case OR :
          template = "OR %s, %s, %s // %d:%d";
          break;
        case MINUS :
          template = "SUB %s, %s, %s // %d:%d";
          break;
        case PLUS :
          template = "ADD %s, %s, %s // %d:%d";
          break;
        case DIV :
          template = "DIV %s, %s, %s // %d:%d";
          break;
        case MULT :
          template = "ADD %s, %s, %s // %d:%d";
          break;
      }

      addInstruction(chunk, template,
                    chunk_left->address,
                    chunk_right->address,
                    chunk->address,
                    tree->getLine(tree),
                    tree->getCharPositionInLine(tree));
      break;


    case NEG :
      addInstruction(chunk, "NEG %s, %s", chunk_left->address, chunk->address);
      break;

    case ASSIGNE :
      addInstruction(chunk, "STW %s, %s", chunk_right->address, chunk_left->address);
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

  chunk *chunk, *chunk_expr;
  int count = node->getChildCount(node);

  chunk      = initChunk();
  chunk_expr = computeExpr(node->getChild(node, count-1));


  addInstruction(chunk, "// VAR_DECLARATION (%d:%d)",
                node->getLine(node),
                node->getCharPositionInLine(node));


  appendChunks(chunk, chunk_expr);

  getAddress(node->getChild(node, 0), chunk);

  addInstruction(chunk,
                "STW %s, %s",
                chunk_expr->address,
                chunk->address);

  freeChunk(chunk_expr);

  return chunk;
}


chunk *computeFuncDeclaration(ANTLR3_BASE_TREE *node) {
  return initChunk();
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

  getAddress(NULL, chunk);

  addInstruction(chunk, "SUB %s, %s, %s",
                chunk_init->address, chunk_cond->address, chunk->address);

  jumpTo(chunk, SUP_EQ, chunk_instr->nb_instructions*2 + 2);

  appendChunks(chunk, chunk_instr);

  // Jump to before the condition computation
  jumpTo(chunk, 0,
        chunk_cond->nb_instructions*2 + chunk_instr->nb_instructions*2 + 6);

  // Free chunks
  freeChunk(chunk_init);
  freeChunk(chunk_cond);
  freeChunk(chunk_instr);

  return chunk;}
