grammar Tiger;

options {
	language=C;
}

program	:	exp
		;

dec		:	tyDec
		|	varDec
		|	funDec
		;

tyDec		:	‘type’ TY_ID ‘=’ ty
		;

ty		:	TY_ID
		|	arrTy
		|	recTy
		;

arrTy		:	‘array of‘ TY_ID
		;

recTy		:	‘{‘ fieldDec* ‘}’
		;

fieldDec	:	ID ‘:’ TY_ID
		;

funDec		:	‘function’ ID ‘(‘ fieldDec* ‘) =’ exp
		|	‘function’ ID ‘(‘ fieldDec* ‘) :’ TY_ID ‘=’ exp
		;

varDec		:	‘var’ ID ‘:=’ exp
		|	‘var’ ID ‘:’ TY_ID ‘:=’ exp
		;

lValue		:	ID
		|	subscript
		|	fieldExp
		;

subscript	:	lValue ‘[‘ exp ‘]’
		;

fieldExp	:	lValue ‘.’ ID
		; 

exp		:	lValue
		|	‘nil’
		|	INT_LIT
		|	STRING_LIT
		|	seqExp
		| 	negation
		|	callExp
		|	infixExp
		|	arrCreate
		|	recCreate
		|	assignment
		|	ifThenElse
		|	ifThen
		|	whileExp
		|	forExp
		|	‘break’
		|	letExp
		;

seqExp		:	‘(‘ exp* ‘)’
		;

negation	:	‘-’ exp
		;

callExp		:	ID ‘(‘ exp* ‘)’
		;

infixExp	:	exp INFIX_OP exp
		;

arrCreate	:	TY_ID ‘[‘ exp ‘] of’ exp
		;

recCreate	:	TY_ID ‘{‘ fieldCreate* ‘}’
		;

fieldCreate	:	ID ‘=’ exp
		;

assignment	:	lValue ‘:=’ exp
		;

ifThenElse	:	‘if’ exp ‘then’ exp ‘else’ exp
		;

ifThen		:	‘if’ exp ‘then’ exp
		;

whileExp	:	‘while’ exp ‘do’ exp
		;

forExp		:	‘for’ ID ‘:=’ exp ‘to’ exp ‘do’ exp
		;

letExp		:	‘let’ dec+ ‘in’ exp* ‘end’
		;
