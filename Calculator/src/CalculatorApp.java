import javax.swing.*;
import java.awt.*;

/**
 * Created by wzhao on 2/8/16.
 */
public class CalculatorApp {
    public static void main(String[] args) {

//        String eq = "( 3 * 4 - ( 2 + 5 ) ) * 4 / 2";
//
//        Calculator brain = new Calculator("");
//        brain.setEquation(eq);
//        System.out.println(brain.calculate());
//
//        brain.setEquation("2 * ( 2 - 5 * ( 6 - 7 ) )");
//        System.out.println(brain.calculate());
//
//        brain.setEquation("-4 * ( ( 2 - 4 ) * ( 6 - 3 ) ) - 3");
//        System.out.println(brain.calculate());

        JFrame frame = new JFrame("Calculator");
        frame.getContentPane().add(new CalculatorPanel());
        frame.pack();
        frame.setVisible(true);
    }


}
