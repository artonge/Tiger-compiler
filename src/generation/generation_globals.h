#ifndef generation_globals_h
#define generation_globals_h

#include <antlr3.h>
#include <string.h>

#include "helpers.h"
#include "tds.h"


#define DEBUG_GENERATION 1


struct chunk {
  char *string;
  int length;
  int nb_instructions;
  int registre;
} typedef chunk;


int registres[15];
chunk *program;


chunk *computeExpr(ANTLR3_BASE_TREE *node);


#endif /*  generation_globals_h */
