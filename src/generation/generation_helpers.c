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
  c->address = malloc(sizeof(char) * 10);
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

  strcpy(c1->address, c2->address);

  return c1;
}


void freeChunk(chunk *c) {
  freeRegister(c->registre);

  free(c->string);

  free(c->address);

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


char *addStringToProgram(char *string) {
  static int compteur = 0;

  char *s_name = malloc(sizeof(char) * 5);

  sprintf(s_name, "S_%d", compteur++);

  addInstruction(program, "%s string %s", s_name, string);

  return s_name;
}


void getAddress(ANTLR3_BASE_TREE *tree, chunk *c) {
  debug(DEBUG_GENERATION, "\033[22;93mGet address var\033[0m");

  if (tree == NULL) {
    c->registre = getRegister();

    sprintf(c->address, "R%d", c->registre);

    return;
  }


  char *string = (char *)tree->toString(tree)->chars;

  entity *e;

  switch (tree->getType(tree)) {
    case INTEGER :
      sprintf(c->address, "#%s", string);
      break;

    case STRING :
      c->address = addStringToProgram(string);
      break;

    case ID :
      c->registre = getRegister();

      addInstruction(c, "ADD R14, #%d, R%d", getScope()*2, c->registre);
      e = searchVar(string);
      sprintf(c->address,
              "(R%d)%d",
              c->registre,
              e == NULL ? 0 : e->deplacement*2);
      break;

    case FUNC_CALL :
      sprintf(c->address, "TODO");
      // TODO - handle function calls
      // save registers
      // save display
      // add paramters
      // add return pointer
      // add static pointer
      break;

  }
}


void jumpTo(chunk *c, int type, int gap) {
  switch (type) {
    case SUP :
      addInstruction(c, "JGT %d", gap);
      break;
    case INF :
      addInstruction(c, "JLW %d", gap);
      break;
    case SUP_EQ :
      addInstruction(c, "JGE %d", gap);
      break;
    case INF_EQ :
      addInstruction(c, "JLE %d", gap);
      break;
    case EQ :
      addInstruction(c, "JEQ %d", gap);
      break;
    case DIFF :
      addInstruction(c, "JNE %d", gap);
      break;
    default :
      addInstruction(c, "JMP %d", gap);
      break;
  }
}
