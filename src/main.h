//
//  main.h
//
//
//  Created by Louis Chemineau on 30/03/16.
//
//

#ifndef main_h
#define main_h

#include <stdio.h>
#include "TigerLexer.h"
#include "TigerParser.h"
#include "checkers.h"

void parse(ANTLR3_BASE_TREE *tree);
void dispatch(ANTLR3_BASE_TREE *tree);

#endif /* main_h */
