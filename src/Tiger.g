grammar Tiger;

options {
  k = 1;
  output = AST;
}



tokens {
  PARAMS;
  PARAM;
  FUNC;
  FUNC_CALL;
  WHILE;
  IF;
  FOR;
  AND;
  OR;
  MULT;
  ADD;
  VAR;
  LET;
  ASSIGNE;
  COMP;
  VARIABLE;
  DECLARATION;
  STR;
  INT;
  NIL;
  ARGS;
  EXPR;
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
  : instruction
  ;





// DECLARATIONS
declararion
  : 'var' name=ID (':' type=ID)? ':=' expr                                      -> ^(VAR $name $type? expr)
  | 'function' name=ID params (':' return_type=ID)? '=' instructions            -> ^(FUNC $name params $return_type? instructions)
  ;

params
  : '(' ( param (',' param)*)? ')'                                              -> ^(PARAMS param*)
  ;
param
  : name=ID ':' type=ID                                                         -> ^(PARAM $name $type)
  ;





// INSTRUCTIONS
instruction
  : 'let' declararion+ 'in' instructions 'end'                                   -> ^(LET ^(DECLARATION declararion+) instructions)

  | expr

  | 'if' expr 'then' i1=instructions
    (options {greedy=true;} : 'else' i2=instructions)?                           -> ^(IF expr $i1 $i2?)
  | 'while' expr 'do' instructions                                               -> ^(WHILE expr instructions)
  | 'for' ID ':=' v1=expr 'to' v2=expr 'do' instructions                         -> ^(FOR ID $v1 $v2 instructions)
  | 'break'
  ;

atom
  : ID (options{greedy=true;}: after_ID)?                                                                -> ^(VARIABLE ID after_ID?)

  | STRING                                                                      -> ^(STR STRING)
  | INTEGER                                                                     -> ^(INT INTEGER)
  | 'nil'                                                                       -> ^(NIL)
  ;

after_ID
  : ':='                                                                        -> ^(ASSIGNE)
  | '(' (atom (',' atom)*)? ')'                                                 -> ^(FUNC_CALL atom*)
  ;





// OPERATIONS
expr
: sub_expr
;


 sub_expr : mult_expr (options{greedy=true;}:    add_min^ mult_expr)* ;
mult_expr : comp_expr (options{greedy=true;}:   mult_div^ comp_expr)* ;
comp_expr : or_expr   (options{greedy=true;}: comparison^ or_expr)* ;
  or_expr : and_expr  (options{greedy=true;}:         or^ and_expr)* ;
 and_expr : end_expr  (options{greedy=true;}:        and^ end_expr)* ;


end_expr
  : atom
  | '(' instruction (';'? instruction)* ')'
  ;


   add_min : '+'|'-' ;
  mult_div : '*'|'/' ;
comparison : '<'|'>'|'=<'|'>='|'='|'<>' ;
       and : '&' ;
       or  : '|' ;
