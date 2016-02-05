package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

/**
 * Created by wzhao on 2/5/16.
 */


public class ShapePanel extends JPanel {
    private Shape[] shapes;
    private DrawingPanel drawingPanel;
    private JPanel controlPanel;
    // private JButton addShape = new JButton("Add Shape");
    private JButton[] buttons = {new JButton("Circle"), new JButton("Square"), new JButton("Oval"), new JButton("Smile"), new JButton("Start"), new JButton("Stop")};
    private JTextField showNum;
    private JLabel countLabel = new JLabel("Count");
    private int count = 0;

    // private JButton start, stop;
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
        shapes = new Shape[20];
        JPanel controlPanel = new JPanel();     // control panel
        showNum = new JTextField(2);            // textField
        countLabel = new JLabel("Count");       // label
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

            if (e.getSource() == timer) {
                try {
                    for (Shape item: shapes) {
                        item.move();
                    }
                } catch (NullPointerException event) {
                    System.out.println("There is no object to move");
                }
            } else {
                JButton button = (JButton) e.getSource();
                String str = button.getText().toLowerCase();
                if (str.equals("stop")) {
                    timer.stop();
                } else if (str.equals("start")) {
                    timer.start();
                } else {
                    if (count<20) {
                        Shape item = new Circle();
                        System.out.println(item);
                        shapes[count] = item;
                        count++;
                    } else {
                        System.out.println("You reached 20 limit");
                    }
                }

                showNum.setText(""+count);
            }

            repaint();
        }
    }

    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setPreferredSize(new Dimension(400, 400));
            setBackground(Color.pink);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            try {
                for (int i=0; i<shapes.length; i++) {
                    shapes[i].display(g);
                }
            } catch (NullPointerException e) {
                System.out.println("There is no Shape object to draw");
            }

        }
    }

//    public Shape[] getShapes() {
//        return shapes;
//    }

}
