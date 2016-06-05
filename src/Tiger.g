grammar Tiger;

options {
  k = 1;
  output = AST;
}

tokens {
  INSTRUCTIONS; LET; WHILE; FOR; IF; BREAK;
  DECLARATIONS; VAR_DECLARATION; FUNC_DECLARATION; PARAMS; PARAM;

  EXPR;
  PLUS='+';
  MINUS='-';
  MULT='*';
  DIV='/';
  SUP='>';
  INF='<';
  SUP_EQ='>=';
  INF_EQ='<=';
  EQ='=';
  DIFF='<>';
  AND='&';
  OR='|';
  ASSIGNE=':=';

  FUNC_CALL; ARGS; STR; INT; NEG; NIL;
}


WHITESPACE : (' '|'\n'|'\t'|'\r'|'\u000C')+ { $channel = HIDDEN; } ;
COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;} ;

fragment
LETTER     : 'A'..'Z'|'a'..'z' ;

ID         : LETTER (LETTER|INTEGER|'_')* ;

STRING     :  '"' (LETTER|' ')* '"' ;
INTEGER    : '0'..'9'+ ;


program : instructions ;

instructions
  : instruction                                                                 -> ^(INSTRUCTIONS instruction)
  ;


// DECLARATIONS
declaration
  : 'var' name=ID (':' type=ID)? ':=' expr                                      -> ^(VAR_DECLARATION $name $type? expr)
  | 'function' name=ID params (':' return_type=ID)? '=' instructions            -> ^(FUNC_DECLARATION $name params $return_type? instructions)
  ;

params
  : '(' ( param (',' param)*)? ')'                                              -> ^(PARAMS param*)
  ;
param
  : name=ID ':' type=ID                                                         -> ^(PARAM $name $type)
  ;


// INSTRUCTIONS
instruction
  : 'let' declaration+ 'in' instructions 'end'                                  -> ^(LET ^(DECLARATIONS declaration+) instructions)

  | expr

  | 'if' expr 'then' i1=instructions
    (options {greedy=true;} : 'else' i2=instructions)?                          -> ^(IF expr $i1 $i2?)
  | 'while' expr 'do' instructions                                              -> ^(WHILE expr instructions)
  | 'for' v1=expr 'to' v2=expr 'do' instructions                                -> ^(FOR $v1 $v2 instructions)
  | 'break'                                                                     -> BREAK
  | 'return' expr                                                               -> ^(RETURN expr)
  ;

atom
  : ID (args^)?

  | '(' ( instruction (';' instruction)* )? ')'                                 -> instruction*

  | STRING
  | INTEGER
  | '-' atom                                                                    -> ^(NEG atom)
  | 'nil'                                                                       -> ^(NIL)
  ;


args
  : '(' (expr (',' expr)*)? ')'                                                 -> ^(FUNC_CALL ^(ARGS expr*))
  ;


// OPERATIONS
expr : assignExpr ;

assignExpr  : logExpr     (  assign^     logExpr)* ;
logExpr     : andExpr     (      or^     andExpr)* ;
andExpr     : compExpr    (     and^    compExpr)* ;
compExpr    : addMinExpr  (    comp^  addMinExpr)? ;
addMinExpr  : multDivExpr (  addMin^ multDivExpr)* ;
multDivExpr : atom        ( multDiv^        atom)* ;


addMin  : PLUS|MINUS ;
multDiv : MULT|DIV ;
  comp  : SUP|INF|SUP_EQ|INF_EQ|EQ|DIFF ;
   and  : AND ;
    or  : OR ;
assign  : ASSIGNE ;
