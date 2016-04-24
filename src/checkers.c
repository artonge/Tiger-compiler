#include "checkers.h"

void checkVarDeclaration(ANTLR3_BASE_TREE *tree) {
  ANTLR3_UINT32 count = tree->getChildCount(tree);

  ANTLR3_BASE_TREE *name  = tree->getChild(tree, 0);
  ANTLR3_BASE_TREE *type  = tree->getChild(tree, 1);
  ANTLR3_BASE_TREE *value = tree->getChild(tree, count);
  pANTLR3_STRING string;


  string = name->toString(name);
  printf("name: %s\n", string->chars);


  if (count == 3) {
    	string = type->toString(type);
    	printf("type: %s\n", string->chars);
  }
}


void checkFuncDeclaration(ANTLR3_BASE_TREE *tree) {

}


void checkParam(ANTLR3_BASE_TREE *tree) {

}


void checkAssigne(ANTLR3_BASE_TREE *tree) {

}


void checkOr(ANTLR3_BASE_TREE *tree) {

}


void checkAnd(ANTLR3_BASE_TREE *tree) {

}


void checkAdd(ANTLR3_BASE_TREE *tree) {

}


void checkMult(ANTLR3_BASE_TREE *tree) {

}


void checkID(ANTLR3_BASE_TREE *tree) {

}


void checkArgs(ANTLR3_BASE_TREE *tree) {

}


void checkInt(ANTLR3_BASE_TREE *tree) {

}


void checkStr(ANTLR3_BASE_TREE *tree) {

}


void checkNeg(ANTLR3_BASE_TREE *tree) {

}
