#include "tds_helpers.h"

node *newNode() {
  debug(DEBUG_TDS, "\033[01;36mnewNode\033[0m");
  node *TDS = malloc(sizeof(node));

  TDS->father   = NULL;
  TDS->brother  = NULL;
  TDS->children = NULL;

  return TDS;
}

entity *buildVarEntity(ANTLR3_BASE_TREE *node) {
  char *string;

  entity *e = malloc(sizeof(entity));


  e->name   = (char *)node->toString(node->getChild(node, 0))->chars;
  e->classe = VAR_DECLARATION;
  e->type   = getType(node);

  switch (e->type) {
    case INT:
      e->deplacement = getDeplacement(1);
      break;
    case STRING:
      string = (char *)node->toString(node->getChild(node, 0))->chars;
      e->deplacement = getDeplacement(strlen(string)+1);
      break;
  }

  return e;
}


entity *buildFuncEntity(ANTLR3_BASE_TREE *node) {
  char *string;

  entity *e = malloc(sizeof(entity));

  e->name        = (char *)node->toString(node->getChild(node, 0))->chars;
  e->type        = getReturnType(node);
  e->classe      = FUNC_DECLARATION;
  e->deplacement = -1;

  return e;
}


/* Compute the entity relative memory position depending on the entity size
 * and last entity's siblings deplacement
 */
int getDeplacement(int size) {
  entity *current_entity = TDS->entities;
  int deplacement = size;

  while (current_entity != NULL) {
    if (current_entity->classe != VAR_DECLARATION) {
      deplacement += current_entity->deplacement;
      break;
    }

    current_entity = current_entity->brother;
  }

  debug(DEBUG_TDS, "\033[01;36mdeplacement\033[0m %d", deplacement);
  return deplacement;
}

entity *search_helper(node *scope, char *name, int type) {
  debug(DEBUG_TDS, "\033[01;36msearch_helper\033[0m");
  entity *current_entity = scope->entities;

  if (scope == NULL) return NULL;

  while (current_entity != NULL) {
    if (strcmp(current_entity->name, name) == 0
        && current_entity->type == type)
      return current_entity;

    current_entity = current_entity->brother;
  }

  return search_helper(scope->father, name, type);
}

void printEntities(entity *e) {
  debug(DEBUG_TDS, "\033[01;36mprintEntities\033[0m");

  if (e == NULL) return;

  debug(DEBUG_TDS, "%s : %s - %s (%d)",
        classeToString(e->classe),
        typeToString(e->type),
        e->name,
        e->deplacement);

  printEntities(e->brother);
}


char *typeToString(int type) {
  debug(DEBUG_TDS, "\033[01;36mtypeToString\033[0m");
  switch (type) {
    case INT  : return "int";
    case STRING : return "string";
    default : return "error";
  }
}


char *classeToString(int type) {
  debug(DEBUG_TDS, "\033[01;36mclasseToString\033[0m");
  switch (type) {
    case VAR_DECLARATION  : return "var";
    case FUNC_DECLARATION : return "func";
    default : return "error";
  }
}
