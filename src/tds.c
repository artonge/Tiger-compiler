#include "tds.h"

char *typeToString(entity_type type);

node *TDS;

node *newNode() {
  node *TDS = malloc(sizeof(node));

  TDS->father   = NULL;
  TDS->brother  = NULL;
  TDS->children = NULL;

  return TDS;
}

void newTDS() {
  TDS = newNode();
}


void enterScope() {
  node *scope = newNode();

  if (TDS->children != NULL)
    scope->brother = TDS->children;

  TDS->children = scope;

  TDS = scope;
}


void leaveScope() {
  TDS = TDS->father;
}

void addEntity(char *name, entity_type type, int deplacement) {
  entity *e = malloc(sizeof(entity));

  e->name = name;
  e->type = type;
  e->deplacement = deplacement;
  e->brother = NULL;


  if (TDS->entities != NULL)
    e->brother = TDS->entities;

  TDS->entities = e;
}


int search_helper(node *scope, char *name, entity_type type) {
  entity *current_entity = scope->entities;

  while (current_entity != NULL) {
    if (strcmp(current_entity->name, name) == 0
        && current_entity->type == type)
      return 1;

    current_entity = current_entity->brother;
  }

  return search_helper(scope->father, name, type);
}

int searchVar(char *name) {
  return search_helper(TDS, name, VAR);
}

int searchFunc(char *name) {
  return search_helper(TDS, name, FUNC);
}



void printEntities(entity *e) {
  if (e == NULL) return;

  printf("%s : %s (%d)",
        typeToString(e->type),
        e->name,
        e->deplacement);

  printEntities(e->brother);
}


void printTDS(node *TDS) {
  if (TDS == NULL) return;

  printEntities(TDS->entities);

  printTDS(TDS->children);
  printTDS(TDS->brother);
}


char *typeToString(entity_type type) {
  switch (type) {
    case VAR  : return "var";
    case FUNC : return "func";
  }
}
