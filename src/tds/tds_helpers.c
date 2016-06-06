#include "tds_helpers.h"

scope *newScope() {
  debug(DEBUG_TDS, "\033[01;36mnewNode\033[0m");
  scope *TDS = malloc(sizeof(scope));

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

void freeScope(scope *scope) {
  if (scope == NULL) return;

  debug(DEBUG_TDS, "\033[01;36mfreeScope\033[0m");

  freeScope(scope->children);
  freeScope(scope->brother);

  freeEntity(scope->entities);

  free(scope);
}

entity *buildVarEntity(ANTLR3_BASE_TREE *scope) {
  entity *e = malloc(sizeof(entity));

  e->name        = (char *)scope->toString(scope->getChild(scope, 0))->chars;
  e->classe      = scope->getType(scope);
  e->type        = getType(scope);
  e->deplacement = getDeplacement(e->classe);

  return e;
}

entity *buildFuncEntity(ANTLR3_BASE_TREE *scope) {
  char *string;
  static int func_n = 0;

  entity *e = malloc(sizeof(entity));

  e->name        = (char *)scope->toString(scope->getChild(scope, 0))->chars;
  e->classe      = FUNC_DECLARATION;
  e->type        = getReturnType(scope);
  e->infos       = scope->getChildCount(scope->getChild(scope, 1));
  e->etiquette   = malloc(sizeof(char) * 10);

  // Create unique etiquette for the function
  sprintf(e->etiquette, "FUNC_%d", func_n++);

  return e;
}

int isDuplicate(char *name) {
  entity *current_entity = TDS->entities;

  while (current_entity != NULL) {
    if (strcmp(current_entity->name, name) == 0)
      return 1;

    current_entity = current_entity->brother;
  }

  return 0;
}

/* Compute the entity relative memory position depending on the entity size
 * and last entity's siblings deplacement
 */
int getDeplacement(int type) {

  entity *current_entity = TDS->entities;
  int deplacement = type == PARAM ? 0 : 4;
  // Desgusting logic here :
  // We have two options :
  //  1 - It's a param, so the initial deplacement is 0
  //  2 - It's a variable, so the initial deplacement is either :
  //        + 4 if we are in a LET
  //        + 6 if we are in a FUNC
  // But there is no varaible in a FUNC
  // so it's either 0 or 4 depending on the type PARAM or VAR
  // Damn Tiger language !

  while (current_entity != NULL && current_entity->classe != type)
    current_entity = current_entity->brother;

  if (current_entity != NULL)
    deplacement = current_entity->deplacement;


  if (type == PARAM) // If params, deplacement is negatif
    deplacement -= 2;
  else // If var declaration, deplacement is positif
    deplacement += 2;

  debug(DEBUG_TDS, "\033[01;36mdeplacement\033[0m %d", deplacement);
  return deplacement;
}

entity *search_helper(scope *scope, char *name, int classe) {
  debug(DEBUG_TDS, "\033[01;36msearch_helper\033[0m");
  if (scope == NULL) return NULL;

  entity *current_entity = scope->entities;

  while (current_entity != NULL) {
    if (strcmp(current_entity->name, name) == 0) {

      // IF FUNC_DECLARATION, we need a function
      if (   classe == FUNC_DECLARATION
          && current_entity->classe == classe)
            return current_entity;

      // IF VAR_DECLARATION, we need a var or a param
      if (   classe == VAR_DECLARATION
          && (   current_entity->classe == VAR_DECLARATION
              || current_entity->classe == PARAM ) )
            return current_entity;
    }

    
    current_entity = current_entity->brother;
  }

  return search_helper(scope->father, name, classe);
}


void printEntities(entity *e) {
  debug(DEBUG_TDS, "\033[01;36mprintEntities\033[0m");

  if (e == NULL) return;

  debug(1, "%s : %s - %s (%d) [%d]",
        classeToString(e->classe),
        typeToString(e->type),
        e->name,
        e->deplacement,
        e->scope->depth);

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
