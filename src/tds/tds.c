#include "tds.h"

void freeTDS() {
  debug(DEBUG_TDS, "\033[01;36mfreeTDS\033[0m");

  freeScope(TDS);
}


void newTDS() {
  debug(DEBUG_TDS, "\033[01;36mnewTDS\033[0m");
  freeTDS();
  TDS = newNode();
}


/* Create a new children scope in the current scope
 * Set the current scope to the one just created
 */
void enterScope() {
  debug(DEBUG_TDS, "\033[01;36menterScope\033[0m");
  node *scope = newNode();

  if (TDS->children != NULL)
    scope->brother = TDS->children;

  scope->father = TDS;

  TDS->children = scope;

  TDS = scope;
}


/* Set the current scope to current one's father
 */
void leaveScope() {
  debug(DEBUG_TDS, "\033[01;36mleaveScope\033[0m");
  TDS = TDS->father;
}


/* Add an entity (var, param or func) to the current scope
 */
void addEntity(ANTLR3_BASE_TREE *node) {
  entity *e;

  debug(
    DEBUG_TDS,
    "\033[01;36mentity\033[0m %s",
    node->toString(node->getChild(node, 0))->chars
  );

  switch (node->getType(node)) {
    case VAR_DECLARATION:
    case PARAM:
      e = buildVarEntity(node);
      break;
    case FUNC_DECLARATION:
      e = buildFuncEntity(node);
      break;
  }

  e->brother = NULL;

  if (TDS->entities != NULL)
    e->brother = TDS->entities;

  TDS->entities = e;
}


entity *searchVar(char *name) {
  debug(DEBUG_TDS, "\033[01;36msearchVar\033[0m");
  return search_helper(TDS, name, VAR_DECLARATION);
}

entity *searchFunc(char *name) {
  debug(DEBUG_TDS, "\033[01;36msearchFunc\033[0m");
  return search_helper(TDS, name, FUNC_DECLARATION);
}


void printTDS(node *TDS) {
  if (TDS == NULL) return;

  debug(DEBUG_TDS, "\033[01;36mprintTDS\033[0m");

  printEntities(TDS->entities);

  printTDS(TDS->children);
  printTDS(TDS->brother);
}


// Return the global type of a expression node
// Usefull to know the type of : 1+a+f()
// It parse the tree until it gets to the extrem left bottom
// 1 in our example
// If it's a var declaration, it return the associated type, if not set,
// then the type of the associated expr
int getType(ANTLR3_BASE_TREE *tree) {

	int token = tree->getType(tree);

  debug(DEBUG_TDS, "\033[01;36mgettype\033[0m %d", token);

	if (token == VAR_DECLARATION) {
		if (tree->getChildCount(tree) == 3)
			return typeToInt((char*)tree->toString(tree->getChild(tree, 1))->chars);
		else
			return getType(tree->getChild(tree, 1));
  } else if (token == PARAM) {
    return typeToInt((char*)tree->toString(tree->getChild(tree, 1))->chars);
  }

	switch (token) {
		case INTEGER :
		case STRING  :
			return token;

		case FUNC_CALL:
      debug(DEBUG_TDS, "\033[01;36msearching\033[0m %s", tree->toString(tree->getChild(tree, 0))->chars);
      token = searchFunc((char *)tree->toString(tree->getChild(tree, 0))->chars)->type;
      return token;

		case ID:
			debug(DEBUG_TDS, "\033[01;36msearching\033[0m %s", tree->toString(tree->getChild(tree, 0))->chars);
      token = searchVar((char *)tree->toString(tree->getChild(tree, 0))->chars)->type;
			return token;

		default :
			return getType(tree->getChild(tree, 0));
	}
}
