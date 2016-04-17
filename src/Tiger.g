grammar Tiger;

options {
  k = 1;
  output = AST;
}

tokens {
  INSTRUCTIONS; LET; WHILE; FOR; IF;
  DECLARATION; VAR; FUNC; PARAMS; PARAM; TYPE;
  EXPR; ASSIGNE; OR; AND; COMP; MULT; ADD;
  VARIABLE; FUNC_CALL; ARGS; STR; INT; NEG; NIL;
}


WHITESPACE : (' '|'\n'|'\t'|'\r'|'\u000C')+ { $channel = HIDDEN; } ;
COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;} ;

fragment
LETTER     : 'A'..'Z'|'a'..'z';

ID         : LETTER (LETTER|INTEGER|'_')* ;

STRING     :  '"' LETTER* '"' ;
INTEGER    : '0'..'9'+ ;


program : instructions ;

instructions
  : instruction                                                                 -> ^(INSTRUCTIONS instruction)
  ;


// DECLARATIONS
declararion
  : 'var' name=ID (':' type=ID)? ':=' expr                                      -> ^(VAR $name $type? expr)
  | 'function' name=ID params (':' return_type=ID)? '=' instructions            -> ^(FUNC $name params ^(TYPE $return_type?) instructions)
  ;

params
  : '(' ( param (',' param)*)? ')'                                              -> ^(PARAMS param*)
  ;
param
  : name=ID ':' type=ID                                                         -> ^(PARAM $name $type)
  ;


// INSTRUCTIONS
instruction
  : 'let' declararion+ 'in' instructions 'end'                                  -> ^(LET ^(DECLARATION declararion+) instructions)

  | expr

  | 'if' expr 'then' i1=instructions
    (options {greedy=true;} : 'else' i2=instructions)?                          -> ^(IF expr $i1 $i2?)
  | 'while' expr 'do' instructions                                              -> ^(WHILE expr instructions)
  | 'for' ID ':=' v1=expr 'to' v2=expr 'do' instructions                        -> ^(FOR ID $v1 $v2 instructions)
  | 'break'
  ;

atom
  : ID ('(' (expr (',' expr)*)? ')')?                                           -> ^(ID ^(ARGS expr*)?)

  | '(' instruction (';' instruction)* ')'                                      -> instruction+

  | STRING                                                                      -> ^(STR STRING)
  | INTEGER                                                                     -> ^(INT INTEGER)
  | '-' INTEGER                                                                 -> ^(NEG INTEGER)
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
   comp : '<'|'>'|'=<'|'>='|'='|'<>' ;
    and : '&' ;
    or  : '|' ;
assign  : ':=' ;
