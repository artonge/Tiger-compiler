#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum {
  VAR,
  FUNC
} entity_type;


typedef struct entity {
  char *name;
  entity_type type;
  int deplacement;

  struct entity *brother;
} entity;


typedef struct node {
  struct node *father;
  struct node *brother;
  struct node *children;
  entity *entities;
} node;


void newTDS();
void enterScope();
void leaveScope();
void addEntity(char *name, entity_type type, int deplacement);
int searchEntity(char *name, entity_type type);
void printTDS(node *tds);
