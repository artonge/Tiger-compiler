#include "generation_helpers.h"


void initRegisters() {
  int i;

  for (i = 0; i < 15; i++)
    registres[i] = 0;
}


int getRegister() {
  int i = 0;

  while (registres[i] == 1 && i < 13) i++;

  if (i == 13) {
    error("Out of registers. Expression to long !");
    return -1;
  }

  registres[i] = 1;

  return i;
}


void freeRegister(int registre) {
  if (registre == -1) return;

  registres[registre] = 0;
}


chunk* initChunk() {
  chunk *c = malloc(sizeof(chunk));

  c->string = malloc(sizeof(char));
  c->string[0] = '\0';
  c->length = 0;
  c->nb_instructions = 0;
  c->registre = -1;

  return c;
}


void printChunk(chunk *c) {
  printf("chunk : '%s'\nlength : %d - %d\n---\n",
         c->string, c->length, c->nb_instructions);
}


chunk *appendChunks(chunk *c1, chunk *c2) {
  debug(DEBUG_GENERATION, "\033[22;93mAppend chunks\033[0m");

  c1->length += c2->length;


  c1->string = realloc(c1->string, c1->length * sizeof(char) + 1);
  strcat(c1->string, c2->string);

  c1->nb_instructions += c2->nb_instructions;

  c1->registre = c2->registre;

  freeRegister(c1->registre);

  return c1;
}


void freeChunk(chunk *c) {
  if (c == NULL) return;

  freeRegister(c->registre);

  free(c->string);

  free(c);
}


void addInstruction(chunk *c, char *template, ...) {
  debug(DEBUG_GENERATION, "\033[22;93mAdd instruction\033[0m %s", template);

  char *inst = malloc(100 * sizeof(char));

  int inst_length;

  // Build instruction line with template and trailing arguments
  va_list argp;
	va_start(argp, template);

  vsprintf(inst, template, argp);

  va_end(argp);

  inst_length = strlen(inst);

  c->length += inst_length + 1;

  // Update chunk size in memory to accepte new instruction
  c->string = realloc(c->string, c->length*sizeof(char) + 1);
  // Add instruction to end of chunk and update chunk lenght
  strcat(c->string, inst);
  c->string[c->length-1] = '\n';
  c->string[c->length] = '\0';

  free(inst);

  c->nb_instructions++;
}


void addEtiquette(chunk *c, char *etiquette) {
  addInstruction(c, "%s NOP", etiquette);
}


chunk *computeFuncCall(ANTLR3_BASE_TREE *tree) {
  debug(DEBUG_GENERATION, "\033[22;93mCompute func call\033[0m");

  ANTLR3_BASE_TREE *args = tree->getChild(tree, 0);
  entity *e = searchFunc((char*)tree->toString(tree->getChild(tree, 1))->chars);
  chunk *chunk = initChunk();
  int i, count = tree->getChildCount(args);

  // Stack registers
  for (i = 0; i <= 15; i++) {
    if (registres[i] == 1)
      addInstruction(chunk, "STW R%d, -(SP)", i);
  }

  // Stack params
  for (i = 0; i < count; i++) {
    loadAtom(args->getChild(args, i), chunk);
    addInstruction(chunk, "STW R%d, -(SP)", chunk->registre);
    freeRegister(chunk->registre);
  }

  // Jump to function
  addInstruction(chunk, "JSR @%s", e->etiquette);

  // Unstack params
  for (i = 0; i < count; i++)
    addInstruction(chunk, "ADQ -2, SP");

  // Unstack registers
  for (i = 0; i <= 15; i++) {
    if (registres[i] == 1)
      addInstruction(chunk, "LDW R%d, (SP)+", i);
  }

  return chunk;
}


char *addStringToProgram(chunk *c, char *string) {
  static int compteur = 0;

  char *s_name = malloc(sizeof(char) * 5);

  sprintf(s_name, "S_%d", compteur++);

  addInstruction(c, "%s STRING %s", s_name, string);

  return s_name;
}


void loadAtom(ANTLR3_BASE_TREE *tree, chunk *c) {
  debug(DEBUG_GENERATION, "\033[22;93mLoad atom\033[0m");

  int tmp_reg;

  chunk *chunk_func_call;

  if (tree == NULL) {
    c->registre =  getRegister();
    return;
  }

  char *string = (char *)tree->toString(tree)->chars;

  entity *e;


  switch (tree->getType(tree)) {
    case INTEGER :
      c->registre = getRegister();
      addInstruction(c, "LDW R%d, #%s", c->registre, string);
      break;

    case STRING :
      string = addStringToProgram(c, string);
      c->registre = getRegister();
      addInstruction(c, "LDW R%d, #%s", c->registre, string);
      break;

    case ID :
      c->registre = getRegister();
      tmp_reg     = getRegister();

      e = searchVar(string);
      // Load address of var's scope in c->registre
      addInstruction(c, "LDW R%d, *(R14)%d", c->registre, e->scope->depth*2);
      // Load deplacement in tmp_reg
      addInstruction(c, "LDW R%d, #%d", tmp_reg, e->deplacement);
      // Add var's scope base and var deplacement into c->registre
      addInstruction(c, "ADD R%d, R%d, R%d", c->registre, tmp_reg, c->registre);
      // Load var into c->registre
      addInstruction(c, "LDW R%d, (R%d)", c->registre, c->registre);

      freeRegister(tmp_reg);

      break;

    case FUNC_CALL :
      chunk_func_call = computeFuncCall(tree);
      appendChunks(c, chunk_func_call);
      freeChunk(chunk_func_call);
      break;

  }
}


void jumpTo(chunk *c, int type, char *etiquette) {
  switch (type) {
    case SUP :
      addInstruction(c, "JGT #%s", etiquette);
      break;
    case INF :
      addInstruction(c, "JLW #%s", etiquette);
      break;
    case SUP_EQ :
      addInstruction(c, "JGE #%s", etiquette);
      break;
    case INF_EQ :
      addInstruction(c, "JLE #%s", etiquette);
      break;
    case EQ :
      addInstruction(c, "JEQ #%s", etiquette);
      break;
    case DIFF :
      addInstruction(c, "JNE #%s", etiquette);
      break;
    default :
      addInstruction(c, "JMP #%s", etiquette);
      break;
  }
}
