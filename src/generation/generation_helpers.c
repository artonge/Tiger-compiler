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


void appendChunks(chunk *c1, chunk *c2) {
  debug(DEBUG_GENERATION, "\033[22;93mAppend chunks\033[0m");

  if (c2 == NULL) return;

  c1->length += c2->length;


  c1->string = realloc(c1->string, c1->length * sizeof(char) + 1);
  strcat(c1->string, c2->string);

  c1->nb_instructions += c2->nb_instructions;

  freeRegister(c1->registre);

  c1->registre = c2->registre;

  return;
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
  chunk *chunk = initChunk(), *chunk_tmp;
  int i, count = tree->getChildCount(args);
  int reg;

  addInstruction(chunk, "\n// STACK REGISTERS");
  // Stack registers
  for (i = 0; i <= 15; i++) {
    if (registres[i] == 1)
      addInstruction(chunk, "STW R%d, -(SP)", i);
  }

  addInstruction(chunk, "\n// STACK PARAMS");
  // Stack params in reverse
  for (i = count-1; i >= 0; i--) {
    chunk_tmp = computeExpr(args->getChild(args, i));
    appendChunks(chunk, chunk_tmp);
    addInstruction(chunk, "STW R%d, -(SP)", chunk->registre);
    freeChunk(chunk_tmp);
  }

  // Jump to function
  addInstruction(chunk, "JSR @%s", e->etiquette);

  addInstruction(chunk, "\n// STORE FUNC RETURN");
  // Get register to store function return
  reg = getRegister();
  addInstruction(chunk, "LDW R%d, R0", reg);
  chunk->registre = reg;

  addInstruction(chunk, "\n// UNSTACK PARAMS");
  // Unstack params
  for (i = 0; i < count; i++)
    addInstruction(chunk, "ADQ 2, SP");

    addInstruction(chunk, "\n// UNSTACK REGISTERS");
  // Unstack registers unless for reg which contains the return value and wasn't stacked
  for (i = 0; i <= 15; i++) {
    if (registres[i] == 1 && i != reg)
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


chunk *getVarAddress(char *name) {
  debug(DEBUG_GENERATION, "\033[22;93mGet var address\033[0m");

  chunk *chunk = initChunk();
  entity *e;


  chunk->registre = getRegister();


  // Get var entity in TDS
  e = searchVar(name);
  // Load address of var's scope in chunk->registre
  addInstruction(chunk, "LDW R%d, (DISPLAY)%d", chunk->registre, e->scope->depth*2);
  // Add var's scope base - var deplacement into chunk->registre
  // -deplacement because stack...
  addInstruction(chunk, "ADQ %d, R%d", -e->deplacement, chunk->registre);


  return chunk;
}


void loadAtom(ANTLR3_BASE_TREE *tree, chunk *c) {
  debug(DEBUG_GENERATION, "\033[22;93mLoad atom\033[0m");


  chunk *chunk_tmp;
  char *string = (char *)tree->toString(tree)->chars;


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
      chunk_tmp = getVarAddress(string);
      appendChunks(c, chunk_tmp);

      // Load var into c->registre
      addInstruction(c, "LDW R%d, (R%d)", c->registre, chunk_tmp->registre);

      chunk_tmp->registre = -1;

      freeChunk(chunk_tmp);
      break;

    case FUNC_CALL :
      chunk_tmp = computeFuncCall(tree);
      appendChunks(c, chunk_tmp);
      chunk_tmp->registre = -1; // See com in computeInstruction
      freeChunk(chunk_tmp);
      break;
  }
}


void jumpTo(chunk *c, int type, char *etiquette, int up) {
  switch (type) {
    case SUP :
      addInstruction(c, "JGT #%s - $ %s", etiquette, up ? "-2" : "");
      break;
    case INF :
      addInstruction(c, "JLW #%s - $ %s", etiquette, up ? "-2" : "");
      break;
    case SUP_EQ :
      addInstruction(c, "JGE #%s - $ %s", etiquette, up ? "-2" : "");
      break;
    case INF_EQ :
      addInstruction(c, "JLE #%s - $ %s", etiquette, up ? "-2" : "");
      break;
    case EQ :
      addInstruction(c, "JEQ #%s - $ %s", etiquette, up ? "-2" : "");
      break;
    case DIFF :
      addInstruction(c, "JNE #%s - $ %s", etiquette, up ? "-2" : "");
      break;
    default :
      addInstruction(c, "JMP #%s - $ %s", etiquette, up ? "-2" : "");
      break;
  }
}


chunk *stackEnvironement() {
  chunk *chunk = initChunk();
  entity *current_entity = TDS->entities;

  // Stack FP in dynamic link
  addInstruction(chunk, "\n// STACK DYN LINK");
  addInstruction(chunk, "STW FP, -(SP)");
  // Store SP in FP
  addInstruction(chunk, "STW SP, FP");
  // Increment FP to match real one
  addInstruction(chunk, "ADQ 2, FP");

  chunk->registre = getRegister();

  // Stack display
  addInstruction(chunk, "\n// STACK DISPLAY");
  // Store FP of same scope stored in DISPLAY in a register
  addInstruction(chunk, "LDW R%d, (DISPLAY)%d", chunk->registre, TDS->depth*2);
  // Stack that FP
  addInstruction(chunk, "STW R%d, -(SP)", chunk->registre);
  // Update DISPLAY with our FP
  addInstruction(chunk, "STW FP, (DISPLAY)%d", TDS->depth*2);

  freeRegister(chunk->registre);

  // Search for the latest VAR_DECLARATION
  while (current_entity != NULL && current_entity->classe != VAR_DECLARATION)
    current_entity = current_entity->brother;

  // Free as mutch as memory as its deplacement, if it exists
  addInstruction(chunk, "\n// ADD VAR IN STACK");
  if (current_entity != NULL)
    addInstruction(chunk, "ADQ -%d, SP", current_entity->deplacement - 4);

  return chunk;
}

chunk *unstackEnvironement() {
  chunk *chunk = initChunk();
  entity *current_entity = TDS->entities;

  // Unstack local vars
  // Search for the latest VAR_DECLARATION
  while (current_entity != NULL && current_entity->classe != VAR_DECLARATION)
    current_entity = current_entity->brother;

  // Free as mutch as memory as its deplacement, if it exists
  addInstruction(chunk, "\n// REMOVE VAR FROM STACK");
  if (current_entity != NULL)
    addInstruction(chunk, "ADQ %d, SP", current_entity->deplacement - 4);


  chunk->registre = getRegister();

  // Unstack display
  addInstruction(chunk, "\n// UNSTACK DISPLAY");
  // Unstack previous FP of same scope for DISPLAY
  addInstruction(chunk, "LDW R%d, (SP)+", chunk->registre);
  // Store it in DISPLAY
  addInstruction(chunk, "STW R%d, (DISPLAY)%d", chunk->registre, TDS->depth*2);

  freeRegister(chunk->registre);

  // Unstack old dynamic link int FP
  addInstruction(chunk, "\n// UNSTACK OLD DYN LINK");
  addInstruction(chunk, "LDW FP, (SP)+");

  return chunk;
}
