import java.util.*;

/**
 * Created by wzhao on 2/10/16.
 */
public class CalculatorBrain {
    private ArrayList<String> equationList;

    /**Constructor*/
    public CalculatorBrain(String eq) {
        equationList = processStr(eq);
    }

    /**helper method to change string into my equation List*/
    private ArrayList<String> processStr(String equation) {
        ArrayList<String> opStack = new ArrayList<>();
        Scanner scan = new Scanner(equation);
        while (scan.hasNext()) {
            opStack.add(scan.next());
        }

        return opStack;
    }

    /**get the string from my equation List*/
    public String getEquationString() {
        String eq = "";
        for (String str: this.equationList) {
            eq += ( str + " ");
        }

        return eq;
    }

    /**set my equation List from string*/
    public void setEquationList(String eq) {
        this.equationList = processStr(eq);
    }

    /**add one item into my equation List*/
    public void addItem(String str) {
        this.equationList.add(str);
    }

    /**remove the last added item from equationList*/
    public void removeLastOne() {
        this.equationList.remove(equationList.size()-1);
    }

    /**The caller method, use this to call the brain to calculate*/
    public double calculate() {
        Stack<String> evaluationStack = getPostfixStack();

        Stack<String> reverseStack = new Stack<>();
        while (!evaluationStack.isEmpty()) {
            reverseStack.add(evaluationStack.pop());
        }

        double result = evaluate(reverseStack);
        setEquationList(result + "");
        return result;
    }

    /**the helper method who do the real calculate*/
    private double evaluate(Stack<String> operationStack) {
        Stack<Double> tmpStack = new Stack<>();
        Double operand;

        while (!operationStack.isEmpty()) {
            System.out.print(operationStack);
            System.out.print("\t");
            System.out.println(tmpStack);
            String op = operationStack.pop();
            if (!binaryOp(op) && !unaryOp(op)) {
                operand = Double.parseDouble(op);
                tmpStack.add(operand);
            } else if (binaryOp(op)) {
                operationStack.add(Op.binaryOp(op).apply(tmpStack.pop(),tmpStack.pop()).toString());
            } else if (unaryOp(op)) {
                operationStack.add(Op.unaryOp(op).apply(tmpStack.pop()).toString());
            }
        }

        return tmpStack.pop();
    }


    /**return true if a string represents binary operation*/
    private boolean binaryOp(String str) {
        HashSet<String> binary = new HashSet<>();
        binary.add("+");
        binary.add("-");
        binary.add("*");
        binary.add("/");

        if (binary.contains(str)) {
            return true;
        }
        return false;
    }

    /**return true if a string represents unary operation*/
    private boolean unaryOp(String str) {
        HashSet<String> unary = new HashSet<>();
        unary.add("sqr");

        if (unary.contains(str)) {
            return true;
        }
        return false;
    }

    /**from equationList get postfixStack for real calculation*/
    private Stack<String> getPostfixStack() {
        Stack<String> operationStack = new Stack();
        Stack<String> postfixStack = new Stack<>();
        int index=0;
        System.out.println(equationList);
        System.out.println("index" + "\t" + "item" + "\t" + "operationStack" + "\t" + "postfix");
        do { // loop until the infix is empty
            String item = equationList.get(index);
            try {                                   // if it is operand, put in the postfix, if not, put it in the operationStack for processing.
                Double.parseDouble(item);
                postfixStack.add(item);
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
                        postfixStack.add(between);
                    } while (!between.equals("("));
                    index++;
                    continue;
                }

                if (!operationStack.isEmpty()) {    // if the inputting operation is lower than the one on top of stack, pop higher, push lower.
                    if(lower(item, operationStack.peek())) {
                        postfixStack.add(operationStack.pop());
                        operationStack.add(item);
                    } else {
                        operationStack.add(item);
                    }
                }
                else {
                    operationStack.add(item);
                }
            }
            System.out.println(index + "\t" + item + "\t" + operationStack + "\t" + postfixStack);
            index++;
        } while (!equationList.isEmpty() && index<equationList.size());

        // after processing infix array, process the operation left
        while (!operationStack.isEmpty()) {
            postfixStack.add(operationStack.pop());
        }

        // print out the postfixStack for checking
        System.out.println("infix is:\t" + equationList);
        System.out.println("postfix is:\t" + postfixStack);

        return postfixStack;
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


    /**return true, if the equation is valid to calculate*/
    public boolean equationIsValid() {
        int left = 0;
        int right = 0;
        int operation = 0;
        int number = 0;
        if (binaryOp(equationList.get(0)) || binaryOp(equationList.get(equationList.size()-1))) {
            return false;
        }

        for (int i=0; i<equationList.size();i++) {
            String item = equationList.get(i);
            switch (item) {
                case "(":
                    left++;
                    break;
                case ")":
                    right++;
                    if (right>left) {
                        return false;
                    }
                    break;
                default:
                    if (binaryOp(item)) {
                        operation++;
                    } else {
                        number++;
                    }
            }
        }

        return true;
    }

}
