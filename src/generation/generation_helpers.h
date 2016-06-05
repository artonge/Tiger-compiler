#ifndef generation_helpers_h
#define generation_helpers_h


#include "generation_globals.h"


void initRegisters();
int getRegister();
void freeRegister(int registre);

chunk* initChunk();
void printChunk(chunk *c);
chunk *appendChunks(chunk *c1, chunk *c2);
void freeChunk(chunk *c);

void addInstruction(chunk *c, char *template, ...);
void addEtiquette(chunk *c, char *etiquette);

void loadAtom(ANTLR3_BASE_TREE *tree, chunk *c);

void jumpTo(chunk *c, int type, int gap);


#endif /*  generation_helpers_h */
