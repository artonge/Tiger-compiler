grammar Arbre_List;


INT : ('0'..'9')+ ;


program
	: arbre
	;

arbre
	: terminal
	| '(' arbre x
	;

x
	: '.' arbre ')'
	| list ')'
	;

list
	: ',' arbre list
	|
	;

terminal
	: INT
	| 'nil'
	;
