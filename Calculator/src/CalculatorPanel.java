/**
 * CalculatorPanel.java
 * <p>
 * Lab 19, COMP160,  2016
 * <p>
 * An alternative GUI front end for the Calculator class
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class CalculatorPanel extends JPanel {

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

    // My calculator brain!
    private CalculatorBrain brain = new CalculatorBrain("");


    /**
     * Constructor -- builds a GUI for a calculator
     */
    public CalculatorPanel() {
        display.setPreferredSize(new Dimension(200, 30));

        // create an array of button labels
        String[] buttonLabels = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "0",
                "-/+", "=", "+", "-", "*",
                "/", "(", ")", ".", "Back", "C"};

        // Create an array of buttons.
        digitButtons = new JButton[buttonLabels.length];

        // Create an actionListener
        ButtonListener listener = new ButtonListener();

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


    /**
     * represents a listener for button presses
     */
    private class ButtonListener implements ActionListener {

        /**
         * what to do when a button has been pressed
         */
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

            if (operation.contains(button)) {                       // if it is operation, add white blank
                brain.setEquationList(display.getText());
                brain.addItem(button);
                display.setText(brain.getEquationString());
            } else {
                System.out.println(button);
                switch (button) {
                    case "=":
                        brain.setEquationList(display.getText());
                        double result = brain.calculate();
                        display.setText("" + result);
                        break;
                    case "C":
                        brain.setEquationList("");
                        System.out.println(brain.getEquationString());
                        display.setText("0");
                        break;
                    case "-/+":                                     // treated it like a normal number
                        if (display.getText().equals("0")) {
                            display.setText("-");
                        } else {
                            display.setText(display.getText() + "-");
                        }
                        break;
                    case "Back":
                        brain.setEquationList(display.getText());
                        try {
                            brain.removeLastOne();
                        } catch (ArrayIndexOutOfBoundsException removeError) {
                            System.out.println("There is no item to remove anymore");
                        }
                        // if it is the only item left, display 0 as result
                        if (brain.getEquationString().equals("")) {
                            display.setText("0");
                        } else {
                            display.setText(brain.getEquationString());
                        }
                        break;
                    default:
                        // System.out.println("The equation right now is : " + brain.getEquation());
                        if (display.getText().equals("0")) {
                            display.setText(button);
                        } else {
                            display.setText(display.getText() + button);
                        }
                }
            }
//            display.setText(brain.getEquation());
        }
    }
}



