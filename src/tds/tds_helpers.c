#include "tds_helpers.h"

node *newNode() {
  debug(DEBUG_TDS, "\033[01;36mnewNode\033[0m");
  node *TDS = malloc(sizeof(node));

  TDS->father   = NULL;
  TDS->brother  = NULL;
  TDS->children = NULL;
  TDS->entities = NULL;

  return TDS;
}

void freeEntity(entity *e) {
  if (e == NULL) return;

  debug(DEBUG_TDS, "\033[01;36mfreeEntity\033[0m");

  freeEntity(e->brother);
  free(e);
}

void freeScope(node *scope) {
  if (scope == NULL) return;

  debug(DEBUG_TDS, "\033[01;36mfreeScope\033[0m");

  freeScope(scope->children);
  freeScope(scope->brother);

  freeEntity(scope->entities);

  free(scope);
}

entity *buildVarEntity(ANTLR3_BASE_TREE *node) {
  entity *e = malloc(sizeof(entity));

  e->name        = (char *)node->toString(node->getChild(node, 0))->chars;
  e->classe      = node->getType(node);
  e->type        = getType(node);
  e->deplacement = getDeplacement(e->classe);

  return e;
}

entity *buildFuncEntity(ANTLR3_BASE_TREE *node) {
  char *string;

  entity *e = malloc(sizeof(entity));

  e->name        = (char *)node->toString(node->getChild(node, 0))->chars;
  e->classe      = FUNC_DECLARATION;
  e->type        = getReturnType(node);

  return e;
}


/* Compute the entity relative memory position depending on the entity size
 * and last entity's siblings deplacement
 */
int getDeplacement(int type) {

  entity *current_entity = TDS->entities;
  int deplacement = 0;


  while (current_entity != NULL && current_entity->classe != type)
    current_entity = current_entity->brother;

  if (current_entity != NULL)
    deplacement = current_entity->deplacement;


  if (type == PARAM) // If params, deplacement is negatif
    deplacement--;
  else // If var declaration, deplacement is positif
    deplacement++;

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


char *classeToString(int type) {
  debug(DEBUG_TDS, "\033[01;36mclasseToString\033[0m");
  switch (type) {
    case VAR_DECLARATION  : return "var";
    case PARAM            : return "param";
    case FUNC_DECLARATION : return "func";
    default : return "error";
  }
}
