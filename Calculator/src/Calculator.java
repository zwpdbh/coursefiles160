import java.lang.invoke.SwitchPoint;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;


/**
 * Created by zw on 2/7/16.
 * 1. Parse infix -> postfix equation
 * 2. postfix equation -> Operation stack
 * 3. use recursion on Operation stack
 */
public class Calculator {
    private String equation;

    public Calculator(String str) {
        this.equation = str;
    }


    public String getEquation() {  // getter
        return this.equation;
    }

    public void setEquation(String str) {// setter
        this.equation = str;
        System.out.println("After setEquation, the equation is " + equation);
    }





    public double calculate() {                                                     // the caller method
        Postfix evaluationString = new Postfix(getEquation());
        Stack<String> evaluationStack = evaluationString.getPostfixStack();

        Stack<String> reverseStack = new Stack<>();
        while (!evaluationStack.isEmpty()) {
            reverseStack.add(evaluationStack.pop());
        }
        return evaluate(reverseStack);
    }

    private double evaluate(Stack<String> operationStack) {                     // the helper method who do the real calculate
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

    private boolean unaryOp(String str) {
        HashSet<String> unary = new HashSet<>();
        unary.add("sqr");

        if (unary.contains(str)) {
            return true;
        }
        return false;
    }

}
