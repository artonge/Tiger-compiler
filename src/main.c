//
//  main.c
//
//
//  Created by Louis Chemineau on 30/03/16.
//
//

#include "main.h"

int ANTLR3_CDECL main (int argc, char *argv[])
{
	pANTLR3_UINT8						fName;
	pANTLR3_INPUT_STREAM				input;
	pTigerLexer							lxr;
	pANTLR3_COMMON_TOKEN_STREAM			tstream;
	pTigerParser							psr;
	TigerParser_decl_return03langAST;
	pANTLR3_COMMON_TREE_NODE_STREAM		nodes;
	pTigerDumpDecl						treePsr;


	if (argc < 2 || argv[1] == NULL) {
		fName =(pANTLR3_UINT8)"./input"; // Note in VS2005 debug, working directory must be configured
	} else {
		fName = (pANTLR3_UINT8)argv[1];
	}


	input = antlr38BitFileStreamNew(fName);
	if (input == NULL) {
		ANTLR3_FPRINTF(stderr, "Unable to open file %s due to malloc() failure1\n", (char *)fName);
	}


 	lxr = TigerLexerNew(input);      // CLexerNew is generated by ANTLR
	if (lxr == NULL) {
		ANTLR3_FPRINTF(stderr, "Unable to create the lexer due to malloc() failure1\n");
		exit(ANTLR3_ERR_NOMEM);
	}


	tstream = antlr3CommonTokenStreamSourceNew(ANTLR3_SIZE_HINT, lxr->pLexer->tokSource);
	if (tstream == NULL) {
		ANTLR3_FPRINTF(stderr, "Out of memory trying to allocate token stream\n");
		exit(ANTLR3_ERR_NOMEM);
	}


	psr = TigerParserNew(tstream);  // CParserNew is generated by ANTLR3
	if (psr == NULL) {
		ANTLR3_FPRINTF(stderr, "Out of memory trying to allocate parser\n");
		exit(ANTLR3_ERR_NOMEM);
	}



	langAST = psr->decl(psr);



	if (psr->pParser->rec->errorCount > 0) {
		ANTLR3_FPRINTF(stderr, "The parser returned %d errors, tree walking aborted.\n", psr->pParser->rec->errorCount);
	} else {
		nodes   = antlr3CommonTreeNodeStreamNewTree(langAST.tree, ANTLR3_SIZE_HINT); // sIZE HINT WILL SOON BE DEPRECATED!!

		treePsr = TigerDumpDeclNew(nodes);

		treePsr->decl(treePsr);
		nodes  ->free( nodes ); nodes   = NULL;
		treePsr->free(treePsr); treePsr = NULL;
	}

	psr    ->free (  psr  );     psr = NULL;
	tstream->free (tstream); tstream = NULL;
	lxr    ->free (  lxr  );     lxr = NULL;
	input  ->close( input );   input = NULL;

	return 0;
}
