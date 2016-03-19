grammar Tiger;

options {
  language = C;
}


fragment
DIGIT    : '0'..'9' ;
fragment
LETTER   : 'a'..'z'|'A'..'Z' ;
fragment
ESC_WS   : ' '|'\n'|'\t'|'\r' ;
fragment
ESC_CHAR : '\\' ('a'|'b'|'f'|'v'|'n'|'r'|'t'|'\\'|'\"') ;


WHITESPACE : (ESC_WS|'\u000C')+ { $channel = HIDDEN; } ;
COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;} ;

fragment
ID         : LETTER (LETTER|DIGIT|'_')* ;

fragment
STRING     :  '"' ( ESC_CHAR | ~('\\'|'"') )* '"' ;
fragment
INTEGER    : DIGIT+ ;


program : instructions ;


instructions
  : instruction
  | '(' instruction (';' instruction)* ')'
  ;


params : '(' ( param (',' param)*)? ')' ;
param  : ID ':' ID ;



declararion
  : 'var' ID (':' ID)? ':=' value
  | 'function' ID params (':' ID)? '=' instructions
  ;




instruction
  : 'let' declararion+ 'in' instructions* 'end'

  | ID ':=' value

  | 'if' value 'then' instructions (options {greedy=true;} : 'else' instructions)?
  | 'while' value 'do' instructions
  | 'for' ID ':=' value 'to' value 'do' instructions
  | 'break'

  | value
  ;



atom
  : ID

  | ID '(' (ID (',' ID)*)? ')' ';'

  | STRING
  | INTEGER
  | 'nil'
  ;



value
  : or
  ;

addition
  : multiplication (('+'|'-') multiplication)*
  ;
multiplication
  : atom (('*'|'/') atom)*
  ;

or
  : and ('|' and)*
  ;
and
  : comparison ('&' comparison)*
  ;
comparison
  : addition (('='|'<>'|'<'|'>'|'<='|'>=') addition)?
  ;
