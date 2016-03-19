grammar Tiger;

options {
  language = C;
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
  | '(' i1=instruction (';' i2=instruction)* ')'                                -> $i1 $i2*
  ;


params
  : '(' ( p1=param (',' p2=param)*)? ')'                                        -> ^(PARAMS ($p1 $p2*)?)
  ;
param
  : id1=ID ':' id2=ID                                                           -> ^(PARAM $id1 $id2)
  ;


declararion
  : 'var' name=ID (':' type=ID)? ':=' value                                     -> ^(VAR $name $type? value)
  | 'function' name=ID params (':' return_type=ID)? '=' instructions            -> ^(FUNC $name params $return_type? instructions)
  ;




instruction
  : 'let' declararion+ 'in' instructions* 'end'                                 -> ^(LET declararion+ instructions*)

  | ID ':=' value                                                               -> ^(ASSIGNE ID value)

  | 'if' value 'then' i1=instructions
    (options {greedy=true;} : 'else' i2=instructions)?                          -> ^(IF value $i1 $i2?)
  | 'while' value 'do' instructions                                             -> ^(WHILE value instructions)
  | 'for' ID ':=' v1=value 'to' v2=value 'do' instructions                      -> ^(FOR ID $v1 $v2 instructions)
  | 'break'

  | value
  ;



atom
  : ID

  | name=ID '(' (p1=ID (',' p2=ID)*)? ')' ';'                                   -> ^(FUNC_CALL $name ($p1 $p2*)?)

  | STRING
  | INTEGER
  | 'nil'
  ;



value
  : or
  ;

or
  : a1=and ('|' a2=and)*                                                        -> ^(OR $a1 $a2*)
  ;

and
  : c1=comparison ('&' c2=comparison)*                                          -> ^(AND $c1 $c2*)
  ;

comparison
  : a1=addition (('='|'<>'|'<'|'>'|'<='|'>=') a2=addition)?                     -> ^(COMP $a1 $a2*)
  ;

addition
  : m1=multiplication (('+'|'-') m2=multiplication)*                            -> ^(ADD $m1 $m2*)
  ;
multiplication
  : a1=atom (('*'|'/') a2=atom)*                                                -> ^(MULT $a1 $a2*)
  ;



/*@members
{

 #include "SimpleCalcLexer.h"

 int main(int argc, char * argv[])
 {

    pANTLR3_INPUT_STREAM           input;
    pSimpleCalcLexer               lex;
    pANTLR3_COMMON_TOKEN_STREAM    tokens;
    pSimpleCalcParser              parser;

    input  = antlr3AsciiFileStreamNew          ((pANTLR3_UINT8)argv[1]);
    lex    = SimpleCalcLexerNew                (input);
    tokens = antlr3CommonTokenStreamSourceNew  (ANTLR3_SIZE_HINT, TOKENSOURCE(lex));
    parser = SimpleCalcParserNew               (tokens);

    parser  ->expr(parser);

    // Must manually clean up
    //
    parser ->free(parser);
    tokens ->free(tokens);
    lex    ->free(lex);
    input  ->close(input);

    return 0;
 }

}*/
