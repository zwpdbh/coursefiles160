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
    public static void main(String[] args) {
        //Postfix opStack = new Postfix("3 * 5 - 2 + 5 * 33 ");
        Postfix opStack = new Postfix("2 * ( 2 - 5 * ( 6 - 7 ) )");
        // the result should be 2 2 5 6 7 - * - *

        ArrayList<String> postfix = opStack.getpostfixArray();

    }

}
