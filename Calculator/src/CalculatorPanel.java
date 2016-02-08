/**
 * CalculatorPanel.java
 *
 * Lab 19, COMP160,  2016
 *
 * An alternative GUI front end for the Calculator class
 *
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class CalculatorPanel extends JPanel {
    // a data field calc to hold a Calculator object
    private Calculator calc;

    // an array of buttons displayed on the calculator
    private JButton[] digitButtons;

    // output display for the calculator
    //private JTextField display = new JTextField(10);
    private JLabel display = new JLabel("0");

    private String equation = "";                   // the calculation equation
    private void setEquation(String str) {          // use setter method, keep model and UI consistent
        this.equation = str;
        display.setText(str);
    }
    private Calculator brain = new Calculator("");


    /** Constructor -- builds a GUI for a calculator */
    public CalculatorPanel() {
        // create an array of button labels
        String[] buttonLabels =  {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "0",
                "-/+", "=", "+", "-", "*",
                "/", "(", ")", "C", "Back"};

        // Create an array of buttons.
        digitButtons = new JButton[buttonLabels.length];

        // Create an actionListener
        ButtonListener  listener = new ButtonListener();

        // Create a 4 x 3 grid for placement of buttons.
        JPanel buttonGrid = new JPanel();
        buttonGrid.setLayout(new GridLayout(5, 3));

    /* Create a button with each button label, add it to buttonGrid,
   and register the button as a listener. */
        for (int nextBut = 0; nextBut < digitButtons.length; nextBut++) {
            digitButtons[nextBut] = new JButton(buttonLabels[nextBut]);
            buttonGrid.add(digitButtons[nextBut]);
            digitButtons[nextBut].addActionListener(listener);
        }

        // Create a message for the user
        JLabel instruct = new JLabel("-/+ means negative sign");

        // add the components to this JPanel
        setLayout(new BorderLayout());
        add(instruct, BorderLayout.NORTH);
        add(buttonGrid, BorderLayout.CENTER);
        add(display, BorderLayout.SOUTH);
    }


    /** represents a listener for button presses */
    private class ButtonListener implements ActionListener{

        /** what to do when a button has been pressed */
        public void actionPerformed(ActionEvent aE) {
            JButton whichButton = (JButton) aE.getSource(); // the button pressed
            String button = whichButton.getText();
            //display.setText("You pressed " +  whichButton.getText());

            HashSet<String> operation = new HashSet<>();
            operation.add("+");
            operation.add("-");
            operation.add("*");
            operation.add("/");
            operation.add("(");
            operation.add(")");

            if (operation.contains(button)) {
                equation += (" " + button + " ");
                display.setText(equation);
            } else if (button.equals("=")) {
                brain.setEquation(equation);
                display.setText("" + brain.calculate());
            } else if (button.equals("C")) {
                brain.setEquation("");
                display.setText("0");
            } else {
                if (button.equals("-/+")) {
                    equation += "-";
                } else if (button.equalsIgnoreCase("back")) {
                    String errorInput = display.getText().trim();
                    String correctInput = errorInput.substring(0 , errorInput.lastIndexOf(" ")) + " ";
                    setEquation(correctInput);
                } else {
                    equation += button;
                }
                display.setText(equation);
            }
        }
    }

}

