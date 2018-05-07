import java.util.HashSet;

/**
 * Created by christianpetersen on 07/05/2018.
 */
/*

          + 0 - x1
        +
        0
        -
        x2
        */

public class BooleanFunctions {

    public HashSet<String> compareGEQ(String op1, String op2){
        HashSet set = new HashSet<String>();
        if (op1.equals("-")){
            if (op2.equals("-")){
                set.add("tt");
                set.add("ff");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("ff");
            }
        }
        else if (op1.equals("0")){
            if (op2.equals("-")){
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("tt");
            } else {
                set.add("ff");
            }
        }
        else {
            if (op2.equals("-")){
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("tt");
                set.add("ff");
            }
        }
        return set;

    }

    public HashSet<String> compareLEQ(String op1, String op2){
        HashSet set = new HashSet<String>();
        if (op1.equals("-")){
            if (op2.equals("-")){
                set.add("ff");
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("tt");
            } else {
                set.add("ff");
            }
        }
        else if (op1.equals("0")){
            if (op2.equals("-")){
                set.add("ff");
            } else if (op2.equals("0")){
                set.add("tt");
            } else {
                set.add("tt");
            }
        }
        else {
            if (op2.equals("-")){
                set.add("ff");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("tt");
                set.add("ff");
            }
        }
        return set;
    }
    public HashSet<String> compareNotEq(String op1, String op2){
        HashSet set = new HashSet<String>();
        if (op1.equals("-")){
            if (op2.equals("-")){
                set.add("ff");
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("tt");
            } else {
                set.add("tt");
            }
        }
        else if (op1.equals("0")){
            if (op2.equals("-")){
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("tt");
            }
        }
        else {
            if (op2.equals("-")){
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("tt");
            } else {
                set.add("tt");
                set.add("ff");
            }
        }
        return set;
    }
    public HashSet<String> compareEquals(String op1, String op2) {
        HashSet set = new HashSet<String>();
        if (op1.equals("-")) {
            if (op2.equals("-")) {
                set.add("ff");
                set.add("tt");
            } else if (op2.equals("0")) {
                set.add("ff");
            } else {
                set.add("ff");
            }
        } else if (op1.equals("0")) {
            if (op2.equals("-")) {
                set.add("ff");
            } else if (op2.equals("0")) {
                set.add("tt");
            } else {
                set.add("ff");
            }
        } else {
            if (op2.equals("-")) {
                set.add("tt");
            } else if (op2.equals("0")) {
                set.add("tt");
            } else {
                set.add("ff");
                set.add("tt");
            }
        }
        return set;
    }
    public HashSet<String> compareLess(String op1, String op2){
        HashSet set = new HashSet<String>();
        if (op1.equals("-")){
            if (op2.equals("-")){
                set.add("ff");
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("tt");
            } else {
                set.add("ff");
            }
        }
        else if (op1.equals("0")){
            if (op2.equals("-")){
                set.add("ff");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("tt");
            }
        }
        else {
            if (op2.equals("-")){
                set.add("ff");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("tt");
                set.add("ff");
            }
        }
        return set;
    }

    public HashSet<String> compareGreater(String op1, String op2){
        HashSet set = new HashSet<String>();
        if (op1.equals("-")){
            if (op2.equals("-")){
                set.add("ff");
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("ff");
            }
        }
        else if (op1.equals("0")){
            if (op2.equals("-")){
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("ff");
            } else {
                set.add("ff");
            }
        }
        else {
            if (op2.equals("-")){
                set.add("tt");
            } else if (op2.equals("0")){
                set.add("tt");
            } else {
                set.add("tt");
                set.add("ff");
            }
        }
        return set;
    }
}
