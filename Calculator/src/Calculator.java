import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;


/**
 * Created by zw on 2/7/16.
 * 1. Parse infix -> postfix equation
 * 2. postfix equation -> Operation stack
 * 3. use recursion on Operation stack
 */
public class Calculator {
    private String equation;        // (3+5)/4
    private ArrayList<String> postfixEq;

    public Calculator(String inputEq) {
        this.equation = inputEq;
        this.postfixEq = new ArrayList<String>();
    }

    public static void main(String[] args) {


    }

    public ArrayList<String> getPostfixEq() {
        Stack tmpStack = new Stack();

        return postfixEq;
    }



}
