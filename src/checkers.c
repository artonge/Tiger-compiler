#include "checkers.h"

int findReturnInstruction(ANTLR3_BASE_TREE *tree);


// Check that type is 'int' or 'string'
void checkVarDeclaration(ANTLR3_BASE_TREE *tree) {

  ANTLR3_BASE_TREE *typeNode = tree->getChild(tree, 1);
  char *typeString = (char *)tree->toString(typeNode)->chars;

  if (tree->getChildCount(tree) == 3) {
      if (strcmp(typeString, "int") &&
          strcmp(typeString, "string") ) {

        printf("Unknown type (%s) at line %d:%d\n",
               typeString,
               tree->getLine(typeNode),
               tree->getCharPositionInLine(typeNode));
      }
  }
}

// Check that returnType is 'int' or 'string'
// Check if a return instruction exist when return type is set
void checkFuncDeclaration(ANTLR3_BASE_TREE *tree) {
  
  ANTLR3_UINT32 count = tree->getChildCount(tree);

  ANTLR3_BASE_TREE *nameNode = tree->getChild(tree, 0);
  char *nameString = (char *)tree->toString(nameNode)->chars;

  ANTLR3_BASE_TREE *returnTypeNode = tree->getChild(tree, 2);
  char *returnTypeString = (char *)tree->toString(returnTypeNode)->chars;

  ANTLR3_BASE_TREE *instructionsNode = tree->getChild(tree, count-1);


  if (count == 4) {
    
      if (strcmp(returnTypeString, "int") &&
          strcmp(returnTypeString, "string") ) {

        printf("Unknown return type (%s) at line %d:%d\n",
               returnTypeString,
               tree->getLine(returnTypeNode),
               tree->getCharPositionInLine(returnTypeNode));
      }


      if (!findReturnInstruction(instructionsNode)) {
        printf("Reached end of non void function (%s) at line %d:%d\n",
               nameString,
               tree->getLine(instructionsNode),
               tree->getCharPositionInLine(instructionsNode));
      }
  }
}


// Look for a return instruction in the childs of a nodes
// If the child is a function do not dig deeper because any return instruction
// would concern only the child function
int findReturnInstruction(ANTLR3_BASE_TREE *tree) {
  
  int i;
  ANTLR3_UINT32 count = tree->getChildCount(tree);
  pANTLR3_COMMON_TOKEN token;
  ANTLR3_BASE_TREE *child;


  for (i = 0; i < count; i++) {
    
    child = tree->getChild(tree, i);
    token = tree->getToken(child);

    if (token->type == RETURN) return 1;

    else if (token->type == FUNC_DECLARATION) continue;

    else if (findReturnInstruction(child)) return 1;
  }

  return 0;
}


// Check that type is 'int' or 'string'
void checkParam(ANTLR3_BASE_TREE *tree) {
  
  ANTLR3_BASE_TREE *typeNode = tree->getChild(tree, 1);
  char * typeString = (char *)tree->toString(typeNode)->chars;

  if (strcmp(typeString, "int") &&
      strcmp(typeString, "string") ) {

    printf("Unknown type (%s) at line %d:%d\n",
           typeString,
           tree->getLine(typeNode),
           tree->getCharPositionInLine(typeNode));
  }
}


// Check that left operand is an ID and don't any children
// Check that right operant don't contains an instruction beside an expr
void checkAssigne(ANTLR3_BASE_TREE *tree) {

}


// Check that right operant don't contains an instruction beside an expr
void checkOr(ANTLR3_BASE_TREE *tree) {

}


// Check that right operant don't contains an instruction beside an expr
void checkAnd(ANTLR3_BASE_TREE *tree) {

}


// Check that right operant don't contains an instruction beside an expr
void checkAdd(ANTLR3_BASE_TREE *tree) {

}


// Check that right operant don't contains an instruction beside an expr
void checkMult(ANTLR3_BASE_TREE *tree) {

}


// Check that right operant don't contains an instruction beside an expr
void checkID(ANTLR3_BASE_TREE *tree) {

}


// Check that all args don't contains an instruction beside an expr
void checkArgs(ANTLR3_BASE_TREE *tree) {

}

