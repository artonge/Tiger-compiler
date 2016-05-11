//
//  main.c
//
//
//  Created by Louis Chemineau on 30/03/16.
//
//

#include "main.h"

void parse(ANTLR3_BASE_TREE *tree);
void dispatch(ANTLR3_BASE_TREE *tree);

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


	// tokens = antlr3CommonTokenStreamSourceNew  (ANTLR3_SIZE_HINT, TOKENSOURCE(lex));
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

	// Check program's semantic
	parse(langAST.tree);


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

	switch (token->type) {

		case VAR_DECLARATION:
			checkVarDeclaration(tree);
			parse(tree->getChild(tree, count-1)); // parse expr
			break;

		case FUNC_DECLARATION:
			checkFuncDeclaration(tree);
			parse(tree->getChild(tree, 1));     // parse params
			parse(tree->getChild(tree, count-1)); // parse expr
			break;

		case PARAM:
			checkParam(tree);
			break;


		case LET:
			parse(tree->getChild(tree, 0)); // parse declarations
			parse(tree->getChild(tree, 1)); // parse instructions
			break;

		case IF:
			parse(tree->getChild(tree, 0)); // parse expr
			parse(tree->getChild(tree, 1)); // parse instructions1
			if (count == 3) {
				parse(tree->getChild(tree, 2)); // parse instructions2
			}
			break;

		case WHILE:
			parse(tree->getChild(tree, 0)); // parse expr
			parse(tree->getChild(tree, 1)); // parse instructions
			break;

		case FOR:
			parse(tree->getChild(tree, 1)); // parse expr1
			parse(tree->getChild(tree, 2)); // parse expr2
			parse(tree->getChild(tree, 3)); // parse instructions
			break;

		case BREAK:
			checkBreak(tree);
			break;

		case RETURN:
			checkReturn(tree);
			parse(tree->getChild(tree, 0)); // parse expr
			break;


		case ASSIGNE:
			checkAssigne(tree);
			parse(tree->getChild(tree, 1)); // parse right operand
			break;

		case OR:
			checkOr(tree);
			parse(tree->getChild(tree, 0)); // parse left operand
			parse(tree->getChild(tree, 1)); // parse right operand
			break;

		case COMP:
			checkComp(tree);
			parse(tree->getChild(tree, 0)); // parse left operand
			parse(tree->getChild(tree, 1)); // parse right operand
			break;

		case AND:
			checkAnd(tree);
			parse(tree->getChild(tree, 0)); // parse left operand
			parse(tree->getChild(tree, 1)); // parse right operand
			break;

		case ADD:
			checkAdd(tree);
			parse(tree->getChild(tree, 0)); // parse left operand
			parse(tree->getChild(tree, 1)); // parse right operand
			break;

		case MULT:
			checkMult(tree);
			parse(tree->getChild(tree, 0)); // parse left operand
			parse(tree->getChild(tree, 1)); // parse right operand
			break;


		case ID:
			if (count == 1) checkArgs(tree->getChild(tree, 0));
			break;


		default:
			parse(tree);
			break;
	}
}

// Loop over each children and send them to dispatch
void parse(ANTLR3_BASE_TREE *tree) {

	ANTLR3_UINT32 count = tree->getChildCount(tree);
	int i;

	for (i = 0; i < count; i++) dispatch(tree->getChild(tree, i));
}
