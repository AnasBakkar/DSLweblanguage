parser grammar HTMLParser;

options { tokenVocab=HTMLLexer; }

program : lang_Misc* program_structure*;

program_structure : pages lang_Misc* controllers lang_Misc*;

pages : page (lang_Misc* page)*;

controllers : controller (lang_Misc* controller)*;

page : PAGE_DEFINITION PAGE_ID (EXTENDS PAGE_ID(COMMA PAGE_ID)*)? page_header PAGE_OPEN page_body* PAGE_CLOSE;

page_header : HEADER_OPEN HEADER PARENTHESE_OPEN (HEADER_TYPE COLON STRING_VALUE SEMICOLON)* PARENTHESE_CLOSE HEADER_CLOSE;

page_body : input_rules | output_rules | link;

input_rules : IN (PARENTHESE_OPEN PAGE_ID PARENTHESE_CLOSE)? COLON (nested_input)+;

nested_input : INPUT_TYPES PARENTHESE_OPEN attribute(COMMA attribute)* PARENTHESE_CLOSE COMMA;

output_rules : OUT COLON OUTPUT_TYPES PARENTHESE_OPEN attribute(COMMA attribute)* PARENTHESE_CLOSE;

link : LINK PARENTHESE_OPEN attribute(COMMA attribute)* PARENTHESE_CLOSE;

attribute:  ATTRIBUTE PARENTHESE_OPEN (STRING_VALUE | NUMERIC_VALUE1) PARENTHESE_CLOSE ;

controller : CONTROLLER_DEFINITION CONTROLLER_ID CONTROLS CONTROLLER_ID CONTROLLER_OPEN (code | C_COMMENT)* CONTROLLER_CLOSE;

code : ((if_rule | for_rule | function | while_rule) nested_code) | (variable_declaration | variable_assignment | print | function_call | list | list_operations) C_SEMICOLON;

if_rule : IF C_PARENTHESE_OPEN if_while_condition(CONDITIONAL_OPERATORS_CONCAT if_while_condition)* C_PARENTHESE_CLOSE;

if_while_condition : value CONDITIONAL_OPERATORS_TWO_OPERAND value;

for_rule : FOR C_PARENTHESE_OPEN VARIABLE_NAME EQUALS NUMERIC_VALUE C_COLON NUMERIC_VALUE C_COMMA NUMERIC_VALUE C_PARENTHESE_CLOSE ;

while_rule : WHILE C_PARENTHESE_OPEN if_while_condition(CONDITIONAL_OPERATORS_CONCAT if_while_condition)* C_PARENTHESE_CLOSE;

function : FUNCTION VARIABLE_NAME C_PARENTHESE_OPEN (VARIABLE_NAME (C_COMMA VARIABLE_NAME)*)? C_PARENTHESE_CLOSE;

variable_declaration : VAR (VARIABLE_NAME | variable_assignment);

variable_assignment : (VARIABLE_NAME|session_rule|post_rule) EQUALS value (OPERAND value)*;

print : PRINT C_PARENTHESE_OPEN value (C_COMMA value)* C_PARENTHESE_CLOSE;

function_call : VARIABLE_NAME C_PARENTHESE_OPEN (value (C_COMMA value)*)? C_PARENTHESE_CLOSE;

list : LIST VARIABLE_NAME EQUALS C_PARENTHESE_OPEN (value (C_COMMA value)*)? C_PARENTHESE_CLOSE;

list_operations: VARIABLE_NAME DOT (list_add|list_remove|list_length|list_get);

list_add : LIST_ADD C_PARENTHESE_OPEN value C_PARENTHESE_CLOSE;

list_remove : LIST_REMOVE C_PARENTHESE_OPEN NUMERIC_VALUE C_PARENTHESE_CLOSE;

list_length : LIST_LENGTH C_PARENTHESE_OPEN C_PARENTHESE_CLOSE;

list_get : LIST_GET C_PARENTHESE_OPEN NUMERIC_VALUE C_PARENTHESE_CLOSE;

post_rule: POST DOT VARIABLE_NAME;

session_rule: SESSION DOT VARIABLE_NAME;

value :(VARIABLE_NAME |  NUMERIC_VALUE | C_STRING_VALUE | BOOLEAN_VALUE | post_rule | list_operations | session_rule);

nested_code : CODE_OPEN (code|C_COMMENT)* CODE_CLOSE;

lang_Misc
    : COMMENT
    | SEA_WS
    ;