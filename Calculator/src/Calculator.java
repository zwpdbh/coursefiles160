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

    // getter
    public String getEquation() {
        return this.equation;
    }
    // setter
    public void setEquation(String str) {
        this.equation = str;
    }

//    public static void main(String[] args) {
//        Postfix opstack = new Postfix("");
//
//        opstack.setInfixArray("3 * 5 - 2 + 5 * 33 ");
//        opstack.getPostfixStack();
//        opstack.setInfixArray("2 * ( 2 - 5 * ( 6 - 7 ) )");
//        opstack.getPostfixStack();
//        opstack.setInfixArray("( 3 * 4 - ( 2 + 5 ) ) * 4 / 2");
//        opstack.getPostfixStack();
//
//    }

    public double calculate() {
        Postfix evaluationString = new Postfix(getEquation());
        Stack<String> evaluationStack = evaluationString.getPostfixStack();

        Stack<String> reverseStack = new Stack<>();
        while (!evaluationStack.isEmpty()) {
            reverseStack.add(evaluationStack.pop());
        }
        return evaluate(reverseStack);
    }

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
