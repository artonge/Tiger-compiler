#include "checkers.h"

// Check that type is 'int' or 'string'
void checkVarDeclaration(ANTLR3_BASE_TREE *tree) {
  ANTLR3_UINT32 count = tree->getChildCount(tree);

  ANTLR3_BASE_TREE *type  = tree->getChild(tree, 1);
  char * typeString = (char *)type->toString(type)->chars;

  if (count == 3) {
      if (strcmp(typeString, "int") &&
          strcmp(typeString, "string") ) {

        printf("Unknown type (%s) at line %d:%d\n",
               typeString,
               type->getLine(type),
               type->getCharPositionInLine(type));
      }
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
