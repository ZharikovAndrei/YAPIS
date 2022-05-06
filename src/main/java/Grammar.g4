grammar Grammar;

program : (functionDeclare)* (statement)* ;

functionDeclare :  type? NAME OPENING_BRACE type NAME ( COMMA type NAME )* CLOSING_BRACE ( OPENING_CURLY_BRACE ( statement )+ CLOSING_CURLY_BRACE )* ;

type : VOID | NODE | ARC | GRAPH ;

statement : (variableDeclare | assign | functionCall | ifBlock | forCycle | print | addNode | addArc | getNode | getArc | remoteNode | remoteArc | checkIsEmpty | OPENING_CURLY_BRACE ( statement )+ CLOSING_CURLY_BRACE) (DOT_COMMA)* ;

variableDeclare : type NAME ( ASSIGN expr )? ;

assign : NAME ASSIGN expr ;

functionCall : NAME OPENING_BRACE argumentList CLOSING_BRACE ;

ifBlock : IF OPENING_BRACE expr CLOSING_BRACE statement ( ELSE statement )? ;

forCycle : FOR OPENING_BRACE NAME COMMA NAME CLOSING_BRACE statement ;

argumentList : expr ( COMMA expr )* ;

expr : NAME | STRING | NUMBER | getNode | getArc | functionCall | NAME DOT expr | NAME PLUS expr | NAME LESS expr ;

print : PRINT OPENING_BRACE (NAME | STRING | size ) CLOSING_BRACE ;
addNode : ADD_NODE OPENING_BRACE NAME COMMA NAME CLOSING_BRACE ;
addArc : ADD_ARC OPENING_BRACE NAME COMMA NAME COMMA NAME COMMA NAME CLOSING_BRACE ;
remoteNode : REMOTE_NODE OPENING_BRACE NAME COMMA NAME CLOSING_BRACE ;
remoteArc : REMOTE_ARC OPENING_BRACE (NAME COMMA NAME COMMA NAME) | (NAME COMMA NAME) CLOSING_BRACE ;
getNode : GET_NODE OPENING_BRACE NAME COMMA NUMBER CLOSING_BRACE ;
getArc : GET_ARC OPENING_BRACE NAME COMMA NUMBER COMMA NUMBER CLOSING_BRACE ;
size : SIZE OPENING_BRACE NAME CLOSING_BRACE ;
checkIsEmpty : IS_EMPTY OPENING_BRACE NAME CLOSING_BRACE;

OPENING_CURLY_BRACE : '{' ;
CLOSING_CURLY_BRACE : '}' ;
OPENING_BRACE       : '(' ;
CLOSING_BRACE       : ')' ;
COMMA               : ',' ;
DOT                 : '.' ;
DOT_COMMA           : ';' ;

ASSIGN  : '=' ;
PLUS    : '+' ;
MINUS   : '-' ;
LESS    : '<' ;

PRINT       : 'print' ;
ADD_NODE    : 'addNode' ;
ADD_ARC     : 'addArc' ;
REMOTE_NODE : 'remoteNode' ;
REMOTE_ARC  : 'remoteArc' ;
GET_NODE    : 'getNode' ;
GET_ARC     : 'getArc' ;
SIZE        : 'size' ;
IS_EMPTY    : 'IsEmpty' ;

FOR     : 'For' ;
IF      : 'If' ;
ELSE    : 'Else' ;

VOID    : 'Void' ;
GRAPH   : 'Graph' ;
ARC     : 'Arc' ;
NODE    : 'Node' ;

STRING  :	'"' (.)+? '"' ;
NUMBER  :	[0-9]+ ;
NAME    : [a-z][a-zA-Z0-9]* ;

WS              : (' ' | '\t' | '\n' | '\r') -> skip ;
COMMENT         : ('/*' ~('\n'|'\r')* '\r'? '\n' '*/') -> skip ;
LINE_COMMENT    : ('//' ~('\n'|'\r')* '\r'? '\n') -> skip ;