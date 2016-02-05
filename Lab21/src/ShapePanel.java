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
    private JPanel controlPanle;
    private JButton addShape = new JButton("Add Shape");
    private JTextField showNum;
    private JLabel countLabel = new JLabel("Count");
    private int count;

    /**Constructor*/
    public ShapePanel() {
        JPanel controlPanel = new JPanel();
        addShape = new JButton("Add Shape");
        showNum = new JTextField(2);
        countLabel = new JLabel("Count");

        addShape.addActionListener(new ButtonListener());

        controlPanel.add(addShape);
        controlPanel.add(showNum);
        controlPanel.add(countLabel);
        add(controlPanel);
        setPreferredSize(new Dimension(100, 400));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab Drawing");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.getContentPane().add(new ShapePanel());
        frame.pack();
        frame.setVisible(true);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

}
