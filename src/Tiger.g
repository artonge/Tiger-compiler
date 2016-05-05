grammar Tiger;

options {
  k = 1;
  output = AST;
}

tokens {
  INSTRUCTIONS; LET; WHILE; FOR; IF; BREAK; RETURN;
  DECLARATIONS; VAR_DECLARATION; FUNC_DECLARATION; PARAMS; PARAM;
  EXPR; ASSIGNE; OR; AND; COMP; MULT; ADD;
  ARGS; STR; INT; NEG; NIL;
}


WHITESPACE : (' '|'\n'|'\t'|'\r'|'\u000C')+ { $channel = HIDDEN; } ;
COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;} ;

fragment
LETTER     : 'A'..'Z'|'a'..'z' ;

ID         : LETTER (LETTER|INTEGER|'_')* ;

STRING     :  '"' LETTER* '"' ;
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
  | 'for' ID ':=' v1=expr 'to' v2=expr 'do' instructions                        -> ^(FOR ID $v1 $v2 instructions)
  | 'break'                                                                     -> BREAK
  | 'return' expr                                                               -> ^(RETURN expr)
  ;

atom
  : ID ('(' (expr (',' expr)*)? ')')?                                           -> ^(ID ^(ARGS expr*)?)

  | '(' instruction (';' instruction)* ')'                                      -> ^(INSTRUCTIONS instruction+)

  | STRING                                                                      -> ^(STR STRING)
  | INTEGER                                                                     -> ^(INT INTEGER)
  | '-' atom                                                                    -> ^(NEG atom)
  | 'nil'                                                                       -> ^(NIL)
  ;


// OPERATIONS
expr : assignExpr ;

assignExpr  : logExpr     (  assign^     logExpr)* ;
logExpr     : andExpr     (      or^     andExpr)* ;
andExpr     : compExpr    (     and^    compExpr)* ;
compExpr    : addMinExpr  (    comp^  addMinExpr)? ;
addMinExpr  : multDivExpr (  addMin^ multDivExpr)* ;
multDivExpr : atom        ( multDiv^        atom)* ;


 addMin : '+'|'-' ;
multDiv : '*'|'/' ;
   comp : '<'|'>'|'<='|'>='|'='|'<>' ;
    and : '&' ;
     or : '|' ;
 assign : ':=' ;
