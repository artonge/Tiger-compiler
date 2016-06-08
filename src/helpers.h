#ifndef helpers_h
#define helpers_h

#include <antlr3.h>
#include <stdarg.h>

#include "TigerParser.h"


#define DEBUG 1
#define DEBUG_HELPERS 1


void debug(int DISPLAY, char *template, ...);
void error(char *template, ...);
void warning(char *template, ...);

int typeToInt(char *);

int getReturnType(ANTLR3_BASE_TREE *tree);

int findReturnInstruction(ANTLR3_BASE_TREE *tree);

int containsInstruction(ANTLR3_BASE_TREE *tree);

#endif /* helpers_h */
