grammar Tiger;

options {
  language = C;
}

tokens {
  LET       = 'let' ;
  VAR       = 'var' ;

  DIGIT     = '0'..'9' ;
  ID        = ('a'..'z'|'A'..'Z'|'_')+ ;

  ARRAY     = 'array' ;
  OF        = 'of' ;
  TYPE      = 'type' ;

  VAR_TYPE  = 'INT' | 'STRING' ;

  WHILE     = 'while' ;
  FOR       = 'for';
  IN        = 'in' ;
  TO        = 'to' ;
  DO        = 'do' ;
  BREAK     = 'break' ;

  IF        = 'if' ;
  ELSE      = 'else' ;
  THEN      = 'then' ;

  FUNCTION  = 'function' ;
  END       = 'end' ;
  NIL       = 'nil' ;

  PLUS      = '+' ;
  MINUS     = '-' ;
  MULT      = '*' ;
  DIV       = '/' ;

  EQUAL     = '=' ;
  NOT_EQUAL = '<>' ;
  SUB       = '<' ;
  SUP       = '>' ;
  SUB_EQUAL = '<=' ;
  SUP_EQUAL = '>=' ;

  AND       = '&' ;
  OR        = '|' ;

  END_INST  = ';' ;
}



INTEGER    : (DIGIT)+ ; // 42
ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' ; // /* a comment */
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
STRING     : '"' ( options {greedy=false;} : . )* '"' ;
BINARY_OP  : PLUS | MINUS | MULT | DIV | EQUAL | NOT_EQUAL | SUB | SUP | SUB_EQUAL | SUP_EQUAL | AND | OR ;


program	:	expr;

expr
  :	STRING
  | INTEGER
  | NIL

  | variable

  | negation

  |	assignment

	|	INT_LIT
	|	STRING_LIT
	|	seqExp
	|	callExp
	|	infixExp
	|	arrayCreate
	|	recCreate
	|	if
	|	while
	|	for
	|	BREAK
	|	letExp
	;


variable
  :	ID            // my_Var
	|	index         // my_var[i]
	|	sub_variable  // my_var.sub_var
	;

index
  : variable ‘[‘ exp ‘]’
  ;

sub_variable
  : variable ‘.’ ID
  ;


negation
  : '-' NUMBER
  ;


dec
  : tyDec
	|	declararion
	|	function
	;


tyDec :	‘type’ VAR_TYPE ‘=’ ty ;

ty
  :	VAR_TYPE
	|	arrayTy
	|	recTy
	;

arrayTy :	‘array of‘ VAR_TYPE ;

recTy :	‘{‘ fieldDec* ‘}’ ;

fieldDec :	ID ‘:’ VAR_TYPE ;

function
  : FUNCTION ID PARAMS EQUAL exp
	| FUNCTION ID PARAMS ’:’ VAR_TYPE EQUAL exp
	;

declararion
  :	VAR ID ‘:=’ exp
	|	VAR ID ‘:’ VAR_TYPE ‘:=’ exp
	;



seqExp
  : ‘(‘ exp* ‘)’
  ;


callExp
  : ID ‘(‘ exp* ‘)’
  ;

infixExp
  : exp INFIX_OP exp
  ;

arrayCreate
  : VAR_TYPE ‘[‘ exp ‘] of’ exp
  ;

recCreate
  : VAR_TYPE ‘{‘ fieldCreate* ‘}’
  ;

fieldCreate
  : ID ‘=’ exp
  ;

assignment
  : variable ‘:=’ exp
  ;

if
  : ‘if’ exp ‘then’ exp (‘else’ exp)?
  ;

while
  : ‘while’ exp ‘do’ exp
  ;

for
  : ‘for’ ID ‘:=’ exp ‘to’ exp ‘do’ exp
  ;

letExp
  : ‘let’ dec+ ‘in’ exp* ‘en
  ’




  @members {

   #include "TigerLexer.h"

   int main(int argc, char * argv[])
   {

      pANTLR3_INPUT_STREAM           input;
      pTigerLexer               lex;
      pANTLR3_COMMON_TOKEN_STREAM    tokens;
      pTigerParser              parser;

      input  = antlr3AsciiFileStreamNew          ((pANTLR3_UINT8)argv[1]);
      lex    = TigerLexerNew                (input);
      tokens = antlr3CommonTokenStreamSourceNew  (ANTLR3_SIZE_HINT, TOKENSOURCE(lex));
      parser = TigerParserNew               (tokens);

      parser  ->expr(parser);

      // Must manually clean up
      //
      parser ->free(parser);
      tokens ->free(tokens);
      lex    ->free(lex);
      input  ->close(input);

      return 0;
   }

  }
