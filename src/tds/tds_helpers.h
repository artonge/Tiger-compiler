#ifndef tds_helpers_h
#define tds_helpers_h


#include "tds_globals.h"


node *newNode();
void freeEntity(entity *e);
void freeScope(node *scope);
entity *buildVarEntity(ANTLR3_BASE_TREE *node);
entity *buildParamEntity(ANTLR3_BASE_TREE *node);
entity *buildFuncEntity(ANTLR3_BASE_TREE *node);
int isDuplicate(char *name);
int getDeplacement(int type, int size);
entity *search_helper(node *scope, char *name, int type);
void printEntities(entity *e);
char *typeToString(int type);
char *classeToString(int type);
int getScope();

#endif /* tds_helpers_h */
