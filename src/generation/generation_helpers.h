#ifndef generation_helpers_h
#define generation_helpers_h


#include "generation_globals.h"


void initRegisters();
int getRegister();
void freeRegister(int registre);

chunk* initChunk();
void printChunk(chunk *c);
void appendChunks(chunk *c1, chunk *c2);
void freeChunk(chunk *c);

void addInstruction(chunk *c, char *template, ...);
void addEtiquette(chunk *c, char *etiquette);

chunk *getVarAddress(char *name);
void loadAtom(ANTLR3_BASE_TREE *tree, chunk *c);

void jumpTo(chunk *c, int type, char *etiquette);

chunk *stackEnvironement();
chunk *unstackEnvironement();


#endif /*  generation_helpers_h */
