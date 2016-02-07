import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Created by zw on 2/7/16.
 */
public class Op {
    public static double operand(String str) {
        try {
            return Double.parseDouble(str);
        }
        catch (Exception parseDouble) {
            System.out.println("Can not parse String to Double");
        }
        return 0.0;
    }

    /**UnaryOperation */
    public static UnaryOperator<Double> unaryOp(String op) {
        if (op.equals("-")) {
            return (n) -> -n;
        } else if (op.equals("sqr")) {
            return (n) -> Math.sqrt(n);
        } else {
            System.out.println("Matched Unary Operator Not Found: " + op);
            return (n) -> n;
        }
    }
    /**BinaryOperation*/
    public static BinaryOperator<Double> binaryOp(String op) {
        switch (op) {
            case "+":
                return (n1, n2) -> n1 + n2;
            case "-":
                return (n1, n2) -> n1 - n2;
            case "*":
                return (n1, n2) -> n1 * n2;
            case "/":
                return (n1, n2) -> n1 / n2;
            default:
                System.out.println("Matched Binary Operator Not Found: " + op);
                return (n1, n2) -> n1 * n2;
        }
    }
}
