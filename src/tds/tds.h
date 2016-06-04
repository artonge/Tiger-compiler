#ifndef tds_h
#define tds_h

#include "tds_globals.h"
#include "tds_helpers.h"


void newTDS();
void freeTDS();

void enterScope();
void enterScopeN(int n);
void leaveScope();

void addEntity(ANTLR3_BASE_TREE *scope);

void printTDS(scope *TDS);

entity *searchVar(char *name);
entity *searchFunc(char *name);

#endif /* tds_h */
