lexer grammar  HTMLLexer;

PAGE_DEFINITION: 'page'->pushMode(page);

CONTROLLER_DEFINITION: 'controller'->pushMode(controller);

SEA_WS
    :  (' '|'\t'|'\r'? '\n')+
    ;

COMMENT
    : '/*' .*? '*/'
    ;

mode page;

EXTENDS: 'extends';

COMMA :',';

SEMICOLON : ';';

PAGE_OPEN: '{';

PAGE_CLOSE: '}'->popMode;

PARENTHESE_OPEN: '(';

PARENTHESE_CLOSE: ')';

IN : 'in';

OUT : 'out';

COLON : ':';

HEADER_OPEN : '[';

HEADER_CLOSE : ']';

HEADER : 'header';

HEADER_TYPE : 'pageTitle'|'language'|'author';

STRING_VALUE
    : '"' .*? '"'
    ;

INPUT_TYPES : 'RadioButton' | 'CheckBox' | 'SubmitButton' | 'TextField' | 'PasswordField' | 'EmailField' | 'NumberField';

OUTPUT_TYPES : 'Paragraph' | 'Image' | 'Header';

LINK : 'Link';

ATTRIBUTE : 'title'|'value'|'width'|'height'|'source'|'groupValue';

PAGE_ID
    : VARIABLE_NameStartChar VARIABLE_NameChar*
    ;

NUMERIC_VALUE1
    : '-'? DIGIT+ ('.' DIGIT+)?
    ;

PAGE_WHITESPACE
    : [ \t\r\n] -> channel(HIDDEN)
    ;

mode controller;

CONTROLLER_OPEN: '{'->pushMode(code);

CONTROLS: 'controls';

CONTROLLER_WHITESPACE
    : [ \t\r\n] -> channel(HIDDEN)
    ;

CONTROLLER_ID
    : VARIABLE_NameStartChar VARIABLE_NameChar*
    ;

mode code;

CODE_WHITESPACE
    : [ \t\r\n] -> channel(HIDDEN)
    ;

C_COMMA :',';

C_SEMICOLON : ';';

CODE_OPEN : '[';

CODE_CLOSE : ']';

CONTROLLER_CLOSE: '}'->popMode,popMode;

C_PARENTHESE_OPEN: '(';

C_PARENTHESE_CLOSE: ')';

IF : 'if';

ELSE_IF: 'else if';

ELSE : 'else';

WHILE : 'while';

SWITCH : 'switch';

FOR : 'for';

FUNCTION : 'function';

C_COMMENT :
    '/*' .*? '*/'
    ;

PRINT : 'print';

VAR : 'var';

LIST : 'list';

POST : 'post';

SESSION : 'session';

EQUALS: '=';

OPERAND : '-' | '+' | '/' | '*' | '%';

BOOLEAN_VALUE
    : 'true' | 'TRUE' | 'false' | 'FALSE';

LIST_ADD : 'add';

LIST_LENGTH : 'length';

LIST_REMOVE : 'remove';

LIST_GET : 'get';

DOT : '.';

VARIABLE_NAME
    : VARIABLE_NameStartChar VARIABLE_NameChar*
    ;

NUMERIC_VALUE
    : ('-')? DIGIT+ ('.' DIGIT+)?
    ;

C_COLON : ':';

C_STRING_VALUE
    : '"' .*? '"'
    ;

CONDITIONAL_OPERATORS_CONCAT
    : '||'
    | '&&'
    ;

CONDITIONAL_OPERATORS_TWO_OPERAND
    : '<'
    | '>'
    | '=='
    | '>='
    | '<='
    | '!='
    ;

fragment
VARIABLE_NameChar
    : VARIABLE_NameStartChar
    | DIGIT
    | '_'
    | '\u00B7'
    | '\u0300'..'\u036F'
    | '\u203F'..'\u2040'
    ;

fragment
VARIABLE_NameStartChar
    : [a-zA-Z]
    | '_'
    | '\u2070'..'\u218F'
    | '\u2C00'..'\u2FEF'
    | '\u3001'..'\uD7FF'
    | '\uF900'..'\uFDCF'
    | '\uFDF0'..'\uFFFD'
    ;


fragment
DIGIT
    : [0-9]
    ;

