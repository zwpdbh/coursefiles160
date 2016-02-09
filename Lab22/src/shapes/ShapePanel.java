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
    private JButton addShape = new JButton("Add Shape");
    private JTextField showNum;
    private JLabel countLabel = new JLabel("Count");
    private int count = 0;

    private JButton start, stop;
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
        addShape = new JButton("Add Shape");    // button
        showNum = new JTextField(2);            // textField
        countLabel = new JLabel("Count");       // label
        drawingPanel = new DrawingPanel();      // the drawing panel
        start = new JButton("Start");           // start button
        stop = new JButton("Stop");             // stop button

        controlPanel.add(addShape);             // add button, textField, label into the control panel
        controlPanel.add(countLabel);
        controlPanel.add(showNum);

        controlPanel.add(start);
        controlPanel.add(stop);
        controlPanel.setPreferredSize(new Dimension(100, 400)); // set control panel's size

        add(controlPanel);                      // add control panel and drawing panel into Shape panel
        add(drawingPanel);

        ButtonListener actionListener = new ButtonListener();
        addShape.addActionListener(actionListener);
        start.addActionListener(actionListener);
        stop.addActionListener(actionListener);

        // set timer
        timer = new Timer(DELAY,actionListener);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == timer) {                   // first check if it is timer event
                for (int i=0; i<count;i++) {
                    shapes[i].move();
                }
            } else {                                        // otherwise, check the button's text
                String button = ((JButton) e.getSource()).getText();
                if (button.equalsIgnoreCase("start")) {
                    timer.start();
                } else if (button.equalsIgnoreCase("stop")) {
                    timer.stop();
                } else if (button.equalsIgnoreCase("Add Shape") && count < shapes.length) {
                    Shape item = new Shape();
                    System.out.println(item);
                    shapes[count] = item;
                    count++;
                    System.out.println(count);
                }
            }

//      if (e.getSource() == addShape && count < shapes.length) {
//        Shape item = new Shape();
//        System.out.println(item);
//        shapes[count] = item;
//        count++;
//
//      } else if (e.getSource() == stop) {
//        timer.stop();
//      } else if (e.getSource() == start){
//        timer.start();
//        for ( int i = 0; i<count; i++) {
//          shapes[i].move();
//        }
//      }

            showNum.setText(""+count);
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

            for (int i=0; i<count; i++) {
                shapes[i].display(g);
            }

        }
    }



}
