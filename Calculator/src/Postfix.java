import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

import java.time.temporal.Temporal;
import java.util.*;

/**
 * Created by wzhao on 2/8/16.
 */
public class Postfix {
    private ArrayList<String> infixArray;

    // Constructor, for a input string, separated with " ", to set my operation Array
    public Postfix(String equation) {
        this.infixArray = processStr(equation);
    }

    private ArrayList<String> processStr(String equation) {
        ArrayList<String> opStack = new ArrayList<>();
        Scanner scan = new Scanner(equation);
        while (scan.hasNext()) {
            opStack.add(scan.next());
        }

        return opStack;
    }

    // return infixStack
    private ArrayList<String> getInfixArray() {
        return this.infixArray;
    }

    public void setInfixArray(String str) {
        this.infixArray = processStr(str);
    }

    public ArrayList<String> getpostfixArray() {
        Stack<String> operationStack = new Stack();
        ArrayList<String> postfixArray = new ArrayList<>();
        int index=0;
        System.out.println(infixArray);
        System.out.println("index" + "\t" + "item" + "\t" + "operationStack" + "\t" + "postfix");
        do { // loop until the infix is empty
            String item = infixArray.get(index);
            try {                                   // if it is operand, put in the postfix, if not, put it in the operationStack for processing.
                Double.parseDouble(item);
                postfixArray.add(item);
            } catch (Exception isNotOperand) {
                if (item.equals(")")) {             // if there is ) then, it is time to collect the items between ( )
                    String between = "";
                    do {
                        try {
                            between = operationStack.pop();
                        } catch (EmptyStackException emptyOperationStack) {
                            break;
                        }
                        if (between.equals("(") || between.equals(")")) {
                            continue;
                        }
                        postfixArray.add(between);
                    } while (!between.equals("("));
                    index++;
                    continue;
                }

                if (!operationStack.isEmpty()) {    // if the inputting operation is lower than the one on top of stack, pop higher, push lower.
                    if(lower(item, operationStack.peek())) {
                        postfixArray.add(operationStack.pop());
                        operationStack.add(item);
                    } else {
                        operationStack.add(item);
                    }
                }
                 else {
                    operationStack.add(item);
                }
            }
            System.out.println(index + "\t" + item + "\t" + operationStack + "\t" + postfixArray);
            index++;
        } while (!infixArray.isEmpty() && index<infixArray.size());

        // after processing infix array, process the operation left
        while (!operationStack.isEmpty()) {
            postfixArray.add(operationStack.pop());
        }

        // print out the postfixArray for checking
        System.out.println("infix is:\t" + infixArray);
        System.out.println("postfix is:\t" + postfixArray);

        return postfixArray;
    }


    /**return true, if op1 has lower operation precedence than op2*/
    private boolean lower(String op1, String op2) {
        HashSet<String> lower = new HashSet<>();
        lower.add("+");
        lower.add("-");

        HashSet<String> higher = new HashSet<>();
        higher.add("*");
        higher.add("/");

        if (op1.equals("(") || op1.equals(")")) {
            return false;
        }

        if (lower.contains(op1) && higher.contains(op2)) {
            //System.out.println(op1 + " is lower than " + op2);
            return true;
        }
        return false;
    }
 }
