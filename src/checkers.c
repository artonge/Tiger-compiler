#include "checkers.h"

int findReturnInstruction(ANTLR3_BASE_TREE *tree);


// Check that type is 'int' or 'string'
void checkVarDeclaration(ANTLR3_BASE_TREE *tree) {

  ANTLR3_BASE_TREE * typeNode   =         tree->getChild(tree, 1);
  char             * typeString = (char *)tree->toString(typeNode)->chars;

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

// Check that return type is 'int' or 'string'
// Check if a RETURN node exists when return type is set
void checkFuncDeclaration(ANTLR3_BASE_TREE *tree) {

  ANTLR3_UINT32 count = tree->getChildCount(tree);

  ANTLR3_BASE_TREE * nameNode   = tree->getChild(tree, 0);
  char             * nameString = (char *)tree->toString(nameNode)->chars;

  ANTLR3_BASE_TREE * returnTypeNode   =         tree->getChild(tree, 2);
  char             * returnTypeString = (char *)tree->toString(returnTypeNode)->chars;

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


// Look for a RETURN node in the children of the nodes
// If the child is a FUNC_DECLARATION do not dig deeper because any RETURN
// would concern only the child function
int findReturnInstruction(ANTLR3_BASE_TREE *tree) {

  int i;

  ANTLR3_UINT32          count = tree->getChildCount(tree);
  pANTLR3_COMMON_TOKEN   token;
  ANTLR3_BASE_TREE     * child;


  for (i = 0; i < count; i++) {
    child = tree->getChild(tree, i);
    token = tree->getToken(child);

    if      (token->type == RETURN)           return 1;
    else if (token->type == FUNC_DECLARATION) continue;
    else if (findReturnInstruction(child))    return 1;
  }

  return 0;
}


// Check that type is 'int' or 'string' for each param
void checkParam(ANTLR3_BASE_TREE *tree) {

  NTLR3_BASE_TREE  *      param = tree->getChild(tree, i);;
  ANTLR3_BASE_TREE *   typeNode = tree->getChild(tree, 1);
  char             * typeString = (char *)tree->toString(typeNode)->chars;

  if (strcmp(typeString, "int") &&
      strcmp(typeString, "string") ) {

    printf("Unknown type (%s) at line %d:%d\n",
           typeString,
           tree->getLine(typeNode),
           tree->getCharPositionInLine(typeNode));
  }
}


// Check that one of the parent node is a loop
// THINK - Until where is it smart to climb the tree ?
void checkBreak(ANTLR3_BASE_TREE *tree) {

}

// Check that one of the parent node is a function with a return type specified
// THINK - Until where is it smart to climb the tree ?
void checkReturn(ANTLR3_BASE_TREE *tree) {

}


// Check that left operand is an ID and do not contain any children
// Check that right operand do not contains any instructions beside an EXPR
void checkAssigne(ANTLR3_BASE_TREE *tree) {

}


// Check that both operands are not an INSTRUCTIONS node
// THINK - Can a STRING can be in an EXPR ?
void checkOr(ANTLR3_BASE_TREE *tree) {

}


// Check that both operands are not an INSTRUCTIONS node
// THINK - Can a STRING can be in an EXPR ?
void checkAnd(ANTLR3_BASE_TREE *tree) {

}

// Check that both operands are not an INSTRUCTIONS node
// THINK - Can a STRING can be in an EXPR ?
void checkComp(ANTLR3_BASE_TREE *tree) {

}

// Check that both operands are not an INSTRUCTIONS node
// Check that both operands are not NIL NODE
// THINK - Can a STRING can be in an EXPR ?
void checkAdd(ANTLR3_BASE_TREE *tree) {

}


// Check that both operands are not an INSTRUCTIONS node
// Check that both operands are not NIL NODE
// THINK - Can a STRING can be in an EXPR ?
void checkMult(ANTLR3_BASE_TREE *tree) {

}

// Check that ARGS are not an INSTRUCTIONS node
void checkArgs(ANTLR3_BASE_TREE *tree) {

}
