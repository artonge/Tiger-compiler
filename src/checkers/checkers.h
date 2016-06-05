#ifndef checkers_h
#define checkers_h

#include <string.h>
#include <antlr3.h>

#include "TigerParser.h"
#include "helpers.h"
#include "tds.h"


#define DEBUG_CHECKERS 1


void checkVarDeclaration(ANTLR3_BASE_TREE *tree);
void checkFuncDeclaration(ANTLR3_BASE_TREE *tree);
void checkParam(ANTLR3_BASE_TREE *tree);
void checkBreak(ANTLR3_BASE_TREE *tree);
void checkReturn(ANTLR3_BASE_TREE *tree);
void checkAssigne(ANTLR3_BASE_TREE *tree);
void checkOr(ANTLR3_BASE_TREE *tree);
void checkAnd(ANTLR3_BASE_TREE *tree);
void checkComp(ANTLR3_BASE_TREE *tree);
void checkAdd(ANTLR3_BASE_TREE *tree);
void checkMult(ANTLR3_BASE_TREE *tree);
void checkNeg(ANTLR3_BASE_TREE *tree);
void checkFuncCall(ANTLR3_BASE_TREE *tree);
void checkArgs(ANTLR3_BASE_TREE *tree);

#endif /* checkers_h */
