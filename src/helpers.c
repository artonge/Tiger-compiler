#include "helpers.h"


void print(FILE *stream, char *template, va_list argp) {

	vfprintf(stream, template, argp);
	va_end(argp);

	fprintf(stream, "\n");
}

void debug(int DISPLAY, char *template, ...) {
	va_list argp;
	va_start(argp, template);

	if (!DEBUG || !DISPLAY) return;

	fprintf(stdout, "\033[22;34m[DEBUG] \033[0m");
	print(stdout, template, argp);
}

void error(char *template, ...) {
	va_list argp;
	va_start(argp, template);

	fprintf(stderr, "\033[22;31m[ERROR] \033[0m");
	print(stderr, template, argp);
}

void warning(char *template, ...) {
	va_list argp;
	va_start(argp, template);

	fprintf(stdout, "\033[22;33m[WARNING] \033[0m");
	print(stdout, template, argp);
}



// Given 'string' or 'int', the function return STRING or INTEGER
// If note 'string' or 'int', return -1
int typeToInt(char *type) {
	if (strcmp(type, "string") == 0)
		return STRING;

	else if (strcmp(type, "int") == 0)
		return INTEGER;

	else
		return -1;
}

// Given INTEGER or STRING, the function return 'int' or 'string'
// If note 'string' or 'int', return 'error'
char *typeToString(int type) {
  debug(DEBUG_HELPERS, "typeToString");

  switch (type) {
    case INTEGER : return "int";
    case STRING  : return "string";
    default : return "error";
  }
}

// Return the return type of a function declaration
// Return -1 is the function does not have a return type
int getReturnType(ANTLR3_BASE_TREE *tree) {
	debug(DEBUG_HELPERS, "return type : %s", tree->toString(tree->getChild(tree, 2))->chars);

	if (tree->getChildCount(tree) == 4)
		return typeToInt((char *)tree->toString(tree->getChild(tree, 2))->chars);

	return -1;
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


// Parse all children's node looking for an instruction node
int containsInstruction(ANTLR3_BASE_TREE *tree) {

  pANTLR3_COMMON_TOKEN token = tree->getToken(tree);
  ANTLR3_UINT32        count = tree->getChildCount(tree);

  int i;

  for (i = 0; i < count; i++) {
    token = tree->getToken(tree->getChild(tree, i));

    switch (token->type) {
      case LET :
      case IF :
      case WHILE :
      case FOR :
      case BREAK :
      case RETURN :
        return 1;

      default :
        if (containsInstruction(tree->getChild(tree, i))) return 1;
    }
  }

  return 0;
}
