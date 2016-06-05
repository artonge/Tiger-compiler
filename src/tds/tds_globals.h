#ifndef tds_globals
#define tds_globals


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "TigerParser.h"
#include "helpers.h"


#define DEBUG_TDS 0


/* Scope's entities point to last entity
 * To acces the others, use entity->borther
 * Same logic between scopes
 *
 * scope -----------------
 *                        |
 *  entity <- entity <- entity
 */

struct scope;



typedef struct entity {
  char *name;
  int type; // var type or return type for function, -1 if nothing
  int classe; // VAR_DECLARATION or FUNC_DECLARATION
  int deplacement; // position in memory
  int infos; // nb of args
  char *etiquette; // etiquette for functions
  struct entity *brother;
  struct scope *scope;
} entity;


typedef struct scope {
  struct scope *father;
  struct scope *brother;
  struct scope *children;
  int depth;
  entity *entities;
} scope;


scope *TDS;


int getType(ANTLR3_BASE_TREE *tree);


#endif /* tds_globals */
