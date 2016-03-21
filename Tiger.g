grammar Tiger;

options {
  language = C;
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
  | '(' i1=instruction (';' i2=instruction)* ')'                                -> $i1 $i2*
  ;


params
  : '(' ( p1=param (',' p2=param)*)? ')'                                        -> ^(PARAMS ($p1 $p2*)?)
  ;
param
  : id1=ID ':' id2=ID                                                           -> ^(PARAM $id1 $id2)
  ;


declararion
  : 'var' name=ID (':' type=ID)? ':=' expr                                      -> ^(VAR $name $type? expr)
  | 'function' name=ID params (':' return_type=ID)? '=' instructions            -> ^(FUNC $name params $return_type? instructions)
  ;




instruction
  : 'let' declararion+ 'in' instructions 'end'                                  -> ^(LET declararion+ instructions)

  | expr

  | 'if' expr 'then' i1=instructions
    (options {greedy=true;} : 'else' i2=instructions)?                          -> ^(IF expr $i1 $i2?)
  | 'while' expr 'do' instructions                                              -> ^(WHILE expr instructions)
  | 'for' ID ':=' v1=expr 'to' v2=expr 'do' instructions                        -> ^(FOR ID $v1 $v2 instructions)
  | 'break'
  ;



atom
  : ID after_ID?                                                                -> ^(VARIABLE ID after_ID)

  | STRING
  | INTEGER
  | 'nil'
  ;

after_ID
  : ':='                                                                        -> ^(ASSIGNE)
  | '(' (p1=ID (',' p2=ID)*)? ')'                                               -> ^(FUNC_CALL ($p1 $p2*)?)
  ;


expr
  : atom or*
  ;

or
  : '|' and                                                                     -> ^(OR and*)
  ;

and
  : ('&' comparison)*                                                           -> ^(AND comparison*)
  ;

comparison
  : (('='|'<>'|'<'|'>'|'<='|'>=') addition)*                                    -> ^(COMP addition*)
  ;

addition
  : (('+'|'-') multiplication)*                                                 -> ^(ADD multiplication*)
  ;
multiplication
  : (('*'|'/') atom)*                                                           -> ^(MULT atom)
  ;
