#ifndef tds_h
#define tds_h

#include "tds_globals.h"
#include "tds_helpers.h"


void newTDS();

void enterScope();
void leaveScope();

void addEntity(ANTLR3_BASE_TREE *node);

void printTDS(node *TDS);

entity *searchVar(char *name);
entity *searchFunc(char *name);

#endif /* tds_h */
