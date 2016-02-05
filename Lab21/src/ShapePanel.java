import com.sun.org.apache.bcel.internal.classfile.InnerClass;

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

        controlPanel.add(addShape);             // add button, textField, label into the control panel
        controlPanel.add(countLabel);
        controlPanel.add(showNum);
        controlPanel.setPreferredSize(new Dimension(100, 400)); // set control panel's size

        add(controlPanel);                      // add control panel and drawing panel into Shape panel
        add(drawingPanel);

        addShape.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Shape item = new Shape();
            if (e.getSource() == addShape) {
                if (count<20) {
                    System.out.println(item);
                    shapes[count] = item;
                    count++;
                } else {
                    System.out.println(count);
                }
            }
            countLabel.setText(""+count);
        }
    }

    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setPreferredSize(new Dimension(400, 400));
            setBackground(Color.pink);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i=0; i<shapes.length; i++) {
                try {
                    shapes[i].display(g);
                }
                catch (NullPointerException e) {
                    System.out.println("There is no Shape object to draw");
                }
            }
        }
    }

//    public Shape[] getShapes() {
//        return shapes;
//    }

}
