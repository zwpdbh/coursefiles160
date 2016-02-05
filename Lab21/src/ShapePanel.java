import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

/**
 * Created by wzhao on 2/5/16.
 */
public class ShapePanel extends JPanel {
    private Shape[] shapes = new Shape[20];
    private DrawingPanel drawingPanel;
    private JPanel controlPanel;
    private JButton addShape = new JButton("Add Shape");
    private JTextField showNum;
    private JLabel countLabel = new JLabel("Count");
    private int count;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab Drawing");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.getContentPane().add(new ShapePanel());
        frame.pack();
        frame.setVisible(true);

    }

    /**Constructor*/
    public ShapePanel() {
        JPanel controlPanel = new JPanel();
        addShape = new JButton("Add Shape");
        showNum = new JTextField(2);
        countLabel = new JLabel("Count");

        addShape.addActionListener(new ButtonListener());

        controlPanel.add(addShape);
        controlPanel.add(countLabel);
        controlPanel.add(showNum);

        controlPanel.setPreferredSize(new Dimension(100, 400));
        add(controlPanel);

        drawingPanel = new DrawingPanel();  // Add draw panel
        add(drawingPanel);
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setPreferredSize(new Dimension(400, 400));
            setBackground(Color.pink);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

        }
    }

}
