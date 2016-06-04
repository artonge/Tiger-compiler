#ifndef tds_helpers_h
#define tds_helpers_h


#include "tds_globals.h"


scope *newScope();
void freeEntity(entity *e);
void freeScope(scope *scope);
entity *buildVarEntity(ANTLR3_BASE_TREE *scope);
entity *buildParamEntity(ANTLR3_BASE_TREE *scope);
entity *buildFuncEntity(ANTLR3_BASE_TREE *scope);
int isDuplicate(char *name);
int getDeplacement(int type);
entity *search_helper(scope *scope, char *name, int classe);
void printEntities(entity *e);
char *typeToString(int type);
char *classeToString(int type);


#endif /* tds_helpers_h */
