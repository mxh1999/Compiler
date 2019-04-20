grammar mx;

program
	: (definition)+
	;

definition
    : functionDefinition    #funcdef
    | classDefinition       #classdef
    | variableDefinition    #vardef
    ;

classDefinition
	: CLASS className classBody
	;

className
    : Identifier
    ;
classBody
	: '{' (variableDefinition | functionDefinition | constructionDefinition)* '}'
	;

variableDefinition
	: type variableName ';'
	| type variableName '=' expression ';'
	;

type
	: basicType ('[' empty ']')*
	;

empty:;

basicType
	: BOOL              #bool
	| INT               #int
	| STRING            #string
	| VOID              #void
	| NULL              #null
	| Identifier        #others
	;

constructionDefinition
	: functionName '(' list? ')' functionBody
	;

functionDefinition
	: type functionName '(' list? ')' functionBody
	;

functionName
    : Identifier
    ;

list
	: parameter (',' parameter)*
	;

parameter
    : type variableName
    ;

variableName
	: Identifier
	| THIS
	;

functionBody
	: '{' statement* '}'
	;

statement
	: functionBody			# block
	| variableDefinition	# def
	| expression ';'		# expr
	| ifStatement			# ifst
	| whileStatement		# whilest
	| forStatement			# forst
	| BREAK ';'				# breakst
	| RETURN expression? ';'# returnst
	| CONTINUE ';'			# continuest
	| empty ';'             # emptyst
	;

ifStatement
	: IF '(' expression ')' A=statement (ELSE B=statement)?
	;

whileStatement
	: WHILE '(' expression ')' statement
	;

forStatement
	: FOR '(' A=expression? ';' B=expression? ';' C=expression? ')' statement
	;

expression
	: variableName								    	# var
	| function                                          # functioncall
	| expression '.' variableName                       # member
	| expression '.' function                           # method
	| A=expression '[' B=expression ']'                 # index
	| malloc                                            # new
	| op=('--'|'++'|'-'|'!'|'~') expression		    	# prefix
	| expression op=('--'|'++')					    	# suffix
	| A=expression op=('*'|'/'|'%') B=expression	    # mul
	| A=expression op=('+'|'-') B=expression	    	# add
	| A=expression op=('>>'|'<<') B=expression			# shift
	| A=expression op=('>'|'<'|'<='|'>=') B=expression	# relation
	| A=expression op=('=='|'!=')	B=expression	   	# equal
	| A=expression '&' B=expression					   	# and
	| A=expression '^' B=expression					   	# xor
	| A=expression '|' B=expression					   	# or
	| A=expression '&&' B=expression				   	# and2
	| A=expression '||' B=expression				   	# or2
	| <assoc=right> left=expression '=' right=expression# assign
	| '(' pre=expression ')'                    	    # parentheses
	| constant									    	# const
	;

malloc
    : NEW creator
    ;

creator
    : basicType ('[' expression ']')+ ('['empty']')*# newarray
    | basicType '(' ')'                             # newvarhas
    | basicType                                     # newvar
    ;

function
    : variableName '(' expressionList? ')'
    ;

expressionList
	: expression (',' expression)*
	;

constant
	: ConstNumber   #numberconst
	| ConstString   #stringconst
	| TRUE          #trueconst
	| FALSE         #falseconst
	| NULL          #nullconst
	;

BOOL	: 'bool';
INT		: 'int';
STRING	: 'string';
NULL	: 'null';
VOID	: 'void';
TRUE	: 'true';
FALSE	: 'false';
IF		: 'if';
ELSE	: 'else';
FOR		: 'for';
WHILE	: 'while';
BREAK	: 'break';
CONTINUE: 'continue';
RETURN	: 'return';
NEW		: 'new';
CLASS	: 'class';
THIS	: 'this';


ConstNumber
	: [0-9]+
	;

ConstString
	: '"' (~'"' | '\\"')* '"'
	;

Identifier
	: [a-zA-Z_][a-zA-Z_0-9]*
	;

Whitespace
	: [ \t]+
	-> skip
	;

Newline
	: ('\r' '\n'?
	| '\n'
	)
	-> skip
	;

BlockComment
	: '/*' .*? '*/'
	-> skip
	;

LineComment
	: '//' ~[\r\n]*
	-> skip
	;