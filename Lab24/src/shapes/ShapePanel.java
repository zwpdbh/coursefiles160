package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by wzhao on 2/5/16.
 */


public class ShapePanel extends JPanel {
    private ArrayList<Shape> shapes;
    private DrawingPanel drawingPanel;
    private JPanel controlPanel;
    private JButton[] buttons = {new JButton("Circle"), new JButton("Square"), new JButton("Oval"),
            new JButton("Smiley"), new JButton("Swirl"), new JButton("Start"), new JButton("Stop"),
            new JButton("Remove")};
    private JTextField showNum;
    private JLabel countLabel;
    private Timer timer;
    private final int DELAY = 10;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab Drawing");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.getContentPane().add(new ShapePanel());
        frame.pack();
        frame.setVisible(true);

    }

    /**Constructor*/
    public ShapePanel() {
        shapes = new ArrayList<Shape>();
        JPanel controlPanel = new JPanel();     // control panel
        showNum = new JTextField(2);            // textField
        countLabel = new JLabel("Remove which?");       // label
        drawingPanel = new DrawingPanel();      // the drawing panel

        ButtonListener actionListener = new ButtonListener();
        for (JButton button: buttons) {
            button.addActionListener(actionListener);
            controlPanel.add(button);
        }

        controlPanel.add(countLabel);
        controlPanel.add(showNum);
        controlPanel.setPreferredSize(new Dimension(100, 400)); // set control panel's size

        add(controlPanel);                      // add control panel and drawing panel into Shape panel
        add(drawingPanel);

        // set timer
        timer = new Timer(DELAY,actionListener);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == timer) {                       // event from timer
                try {
                    for (Shape item: shapes) {
                        item.move();
                    }
                } catch (NullPointerException event) {
                    System.out.println("There is no object to move");
                }
            } else {                                            // event from button
                JButton button = (JButton) e.getSource();
                String str = button.getText().toLowerCase();
                if (str.equals("stop")) {
                    timer.stop();
                } else if (str.equals("start")) {
                    timer.start();
                } else {                                    // add shapes on panel
                    if (shapes.size() < 20) {
                        if (str.equals("circle")) {
                            shapes.add(new Circle());
                        } else if (str.equals("oval")) {
                            shapes.add(new Oval());
                        } else if (str.equals("square")) {
                            shapes.add(new Square());
                        } else if (str.equals("smiley")) {
                            shapes.add(new Smiley());
                        } else if (str.equals("swirl")) {
                            shapes.add(new Swirl());
                        } else if (str.equals("remove")) {
                            int index = -1;
                            try {
                                index = Integer.parseInt(showNum.getText());
                                System.out.println("The value in TextField is : " + index);
                                shapes.remove(index);
                            }
                            catch (NumberFormatException errorNumber) {
                                System.out.println("Can not get a valid index number");
                            }
                            catch (IndexOutOfBoundsException errorIndex) {
                                System.out.println("Invalid index number, you are trying to remove index = " + index);
                            }
                        }
                    } else {
                        System.out.println("You reached 20 limit");
                    }
                }
                if (shapes.isEmpty()) {
                    showNum.setText("");
                } else {
                    showNum.setText(""+(shapes.size() - 1));
                }
            }

            repaint();
        }
    }

    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setPreferredSize(new Dimension(400, 400));
            setBackground(Color.pink);
        }

        public void paintComponent(Graphics g) {            // the drawing work
            super.paintComponent(g);
            try {
                for (int i=0; i<shapes.size(); i++) {
                    shapes.get(i).display(g);
                    shapes.get(i).showIndex(g, i);
                    //shapes[i].display(g);
                }
            } catch (NullPointerException e) {
                System.out.println("There is no Shape object to draw");

            }

        }
    }

}
