//
//  main.c
//
//
//  Created by Louis Chemineau on 30/03/16.
//
//

#include "main.h"

void dispatch(ANTLR3_BASE_TREE *tree);


//commentaire gentil
int ANTLR3_CDECL main (int argc, char *argv[]) {

	pANTLR3_UINT8                   fName;
	pANTLR3_INPUT_STREAM            input;
	pTigerLexer                     lxr;
	pANTLR3_COMMON_TOKEN_STREAM			tstream;
	pTigerParser                    psr;
	TigerParser_program_return      langAST;


	if (argc < 2 || argv[1] == NULL) {
		fName =(pANTLR3_UINT8)argv[1]; // Note in VS2005 debug, working directory must be configured
	} else {
		// TODO - handle no file passed
		fName = (pANTLR3_UINT8)argv[1];
	}

	input = antlr3FileStreamNew((pANTLR3_UINT8)fName, ANTLR3_ENC_8BIT);
	if (input == NULL) {
		ANTLR3_FPRINTF(stderr, "Unable to open file %s due to malloc() failure1\n", (char *)fName);
	}

	lxr = TigerLexerNew(input);      // CLexerNew is generated by ANTLR
	if (lxr == NULL) {
		ANTLR3_FPRINTF(stderr, "Unable to create the lexer due to malloc() failure1\n");
		exit(ANTLR3_ERR_NOMEM);
	}

	tstream = antlr3CommonTokenStreamSourceNew(ANTLR3_SIZE_HINT, TOKENSOURCE(lxr));
	if (tstream == NULL) {
		ANTLR3_FPRINTF(stderr, "Out of memory trying to allocate token stream\n");
		exit(ANTLR3_ERR_NOMEM);
	}

	psr = TigerParserNew(tstream);  // CParserNew is generated by ANTLR3
	if (psr == NULL) {
		ANTLR3_FPRINTF(stderr, "Out of memory trying to allocate parser\n");
		exit(ANTLR3_ERR_NOMEM);
	}


	langAST = psr->program(psr);


	// Init new global TDS
	newTDS();

	// Check program's semantic
	dispatch(langAST.tree);

	// Display TDS
	printTDS(TDS);


	// TODO - free TDS memory
	psr    ->free (  psr  );     psr = NULL;
	tstream->free (tstream); tstream = NULL;
	lxr    ->free (  lxr  );     lxr = NULL;
	input  ->close( input );   input = NULL;

	return 0;
}


// Dispatch each node to the correct function
void dispatch(ANTLR3_BASE_TREE *tree) {

	pANTLR3_COMMON_TOKEN token = tree->getToken(tree);
	ANTLR3_UINT32        count = tree->getChildCount(tree);
	int i;

	debug(DEBUG_MAIN, "\033[22;32mdispatch\033[0m %s", (char *)tree->toString(tree)->chars);

	switch (token->type) {

		case VAR_DECLARATION:
			checkVarDeclaration(tree);

			addEntity(tree);

			dispatch(tree->getChild(tree, count-1)); // dispatch expr
			break;

		case FUNC_DECLARATION:
			checkFuncDeclaration(tree);

			addEntity(tree);

			enterScope();

			dispatch(tree->getChild(tree, 1));       // dispatch params
			dispatch(tree->getChild(tree, count-1)); // dispatch expr

			leaveScope();
			break;

		case PARAM:
			checkParam(tree);
			break;


		case LET:
			enterScope();

			dispatch(tree->getChild(tree, 0)); // dispatch declarations
			dispatch(tree->getChild(tree, 1)); // dispatch instructions

			leaveScope();
			break;

		case IF:
			dispatch(tree->getChild(tree, 0)); // dispatch expr
			dispatch(tree->getChild(tree, 1)); // dispatch instructions1
			if (count == 3) {
				dispatch(tree->getChild(tree, 2)); // dispatch instructions2
			}
			break;

		case WHILE:
			dispatch(tree->getChild(tree, 0)); // dispatch expr
			dispatch(tree->getChild(tree, 1)); // dispatch instructions
			break;

		case FOR:
			dispatch(tree->getChild(tree, 1)); // dispatch expr1
			dispatch(tree->getChild(tree, 2)); // dispatch expr2
			dispatch(tree->getChild(tree, 3)); // dispatch instructions
			break;

		case BREAK:
			checkBreak(tree);
			break;

		case RETURN:
			checkReturn(tree);
			dispatch(tree->getChild(tree, 0)); // dispatch expr
			break;


		case ASSIGNE:
			checkAssigne(tree);
			dispatch(tree->getChild(tree, 1)); // dispatch right operand
			break;

		case OR:
			checkOr(tree);
			dispatch(tree->getChild(tree, 0)); // dispatch left operand
			dispatch(tree->getChild(tree, 1)); // dispatch right operand
			break;

		case SUP    :
		case INF    :
		case SUP_EQ :
		case INF_EQ :
		case EQ     :
		case DIFF   :
			checkComp(tree);
			dispatch(tree->getChild(tree, 0)); // dispatch left operand
			dispatch(tree->getChild(tree, 1)); // dispatch right operand
			break;

		case AND:
			checkAnd(tree);
			dispatch(tree->getChild(tree, 0)); // dispatch left operand
			dispatch(tree->getChild(tree, 1)); // dispatch right operand
			break;

		case MINUS :
		case PLUS  :
			checkAdd(tree);
			dispatch(tree->getChild(tree, 0)); // dispatch left operand
			dispatch(tree->getChild(tree, 1)); // dispatch right operand
			break;

		case DIV  :
		case MULT :
			checkMult(tree);
			dispatch(tree->getChild(tree, 0)); // dispatch left operand
			dispatch(tree->getChild(tree, 1)); // dispatch right operand
			break;


		case FUNC_CALL:
			checkFuncCall(tree);
			dispatch(tree->getChild(tree, 0)); // dispatch args
			break;

		case ARGS:
			checkArgs(tree);
			break;


		default:
			// Dispatch all children
			for (i = 0; i < count; i++) dispatch(tree->getChild(tree, i));
			break;
	}

	debug(DEBUG_MAIN, "");
}
