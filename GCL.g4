grammar GCL;
SEP : ';';

start : exprC EOF
      | exprGC EOF
      | a EOF
      | b EOF
      ;


exprC : VAR ':=' a                        #CAssign
      | 'skip'                            #CSkip
      | IF exprGC FI                      #CIf
      | DO exprGC OD                      #CDo
      | <assoc=right> exprC SEP exprC     #CSep

      ;

exprGC: lhs = b '->' rhs = exprC         #GCOnCondtion
      | lhs = exprGC '[]' rhs = exprGC   #GCOnCondition
      ;

a     : DIG                     #AritDig
      | <assoc=right> '-' a     #AritNeg
      | VAR                     #AritVar
      | a '/' a                 #AritDiv
      | a '*' a                 #AritDouble
      | a '+' a                 #AritDouble
      | a '-' a                 #AritDouble
      | <assoc=right> a '^' a   #AritPower
      | '(' a ')'               #AritParentheses
      ;

b     : 'true'                #True
      | 'false'               #False
      | b '&' b               #BoolDouble
      | b '|' b               #BoolDouble
      | b '&&' b              #BoolDouble
      | b '||' b              #BoolDouble
      | <assoc=right> '!' b   #BoolNot
      | a '=' a               #BoolCompare
      | a '!=' a              #BoolCompare
      | a '>' a               #BoolCompare
      | a '>=' a              #BoolCompare
      | a '<' a               #BoolCompare
      | a '<=' a              #BoolCompare
      | '(' b ')'             #BoolBracket
      ;



DIG : ('0'..'9')+; // Digits
BAD : 'if' | 'fi' | 'do' |'od'; // This way the keyword statements gets assigned to BAD not VAR
VAR : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*; // Variable
IF : 'if'WS+;
FI : WS'fi';
DO : 'do'WS;
OD : WS'od';


// White spaces
WS    : [ \t\r\n]+ -> skip;