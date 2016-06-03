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

typedef struct entity {
  char *name;
  int type; // var type or return type for function, -1 if nothing
  int classe; // VAR_DECLARATION or FUNC_DECLARATION
  int deplacement; // position in memory
  int infos; // nb of args
  struct entity *brother;
} entity;


typedef struct node {
  struct node *father;
  struct node *brother;
  struct node *children;
  entity *entities;
} node;


node *TDS;


int getType(ANTLR3_BASE_TREE *tree);


#endif /* tds_globals */
