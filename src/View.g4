grammar View;


/*
TODO: (n:Person { attributes here } )
*/

root : COMMAND NAME viewuse query |
        'CG' query |
        changegraph |
        viewuse query
        ;

query :  KEYWORD expr conditions returnstmt |
         KEYWORD path conditions returnstmt
        ;

changegraph : KEYWORD expr conditions 'SET' setattr
            | KEYWORD expr conditions 'DELETE' NAME
            | KEYWORD expr conditions 'REMOVE' attribute
            | KEYWORD expr conditions 'CREATE' expr
            | 'CREATE' viewatom
;

viewuse  : 'WITH VIEWS' usedviews | ;
usedviews : NAME*;

viewatom : variable | // for early version, this line was '(' NAME ':' MNAME ')'
             viewatom '-[' relation ']-' viewatom |
             viewatom '-[' relation ']-' variable |
             variable '-[' relation ']-' viewatom |
             variable '-[' relation ']-' variable
             ;
returnstmt : RETURN retval;
retval : 'NODES(' NAME ')' |
         attribute
         ;

expr : viewatom | variable ;
variable :  '('nodeName')' | '('nodeName':'type')'; // nodeName
type    : NAME ;
nodeName : NAME ;
relation : relationValue?(':'type)? ;
relationValue : NAME ;
path    : NAME '=' expr ;
conditions  : 'WHERE' boolexpr | ;
boolexpr    :
              attribute COMPARISON attribute |
              attribute COMPARISON val |
              attribute '=' attribute |
              attribute '=' val |
              boolexpr 'AND' boolexpr |
              boolexpr 'OR' boolexpr |
              VALUE OPERATOR attribute | //not supported
              NAME 'IN' NAME | //viewUse
              '(' boolexpr ')' ;
attribute   : NAME('.'NAME)? ;
val         : VALUE | NAME | CONSTANTS;
test : attribute COMPARISON attribute;
setattr:  attribute '=' attribute |
          attribute '=' val;

/*
Lexer rules
*/


KEYWORD   : 'MATCH' | 'MERGE' ;
RETURN  : 'RETURN' ;
COMMAND : 'CREATE VIEW AS';
COMPARISON : '>' | '<' | '>=' |'<=' ;
OPERATOR : 'CASE'|'CONTAINS'|'ELSE'|'END'|
           'ENDS WITH'|'IN'|'IS NOT NULL'|'IS NULL'|'NOT'|'STARTS WITH'|'THEN'|'WHEN'|'XOR';
CONSTANTS : 'true' | 'false' | 'null';

VALUE   : [0]|[1-9][0-9]* | [0]'.'[0-9]*[1-9]
            | '"'[a-zA-Z_ ]+[0-9]*'"';
NAME    : [a-zA-Z_]+[0-9]* ;
WHITESPACE : ' '-> skip ;
ANY     : . ;


