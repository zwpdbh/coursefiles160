import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**Lab18*/
public class TrafficLightPanel extends JPanel{
	private JButton red, green, amber;
	private JLabel buttonLabel, lastPressed;
	private JPanel buttonPanel;
	
	/**constructor: set the GUI*/
	public TrafficLightPanel() {
		red = new JButton("Red");
		green = new JButton("Green");
		amber = new JButton("Amber");
		// create instance of my listener and add it on buttons
		ButtonListener listener = new ButtonListener();
		red.addActionListener(listener);
		green.addActionListener(listener);
		amber.addActionListener(listener);
		
		
		buttonLabel = new JLabel("Button Panel");
		lastPressed = new JLabel("last pressed");
		
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(80, 290));
		buttonPanel.setBackground(Color.white);
		
		buttonPanel.add(buttonLabel);
		buttonPanel.add(red);
		buttonPanel.add(green);
		buttonPanel.add(amber);
//		buttonPanel.add(lastPressed);
		add(buttonPanel);
		
		LightPanel lightsPanel = new LightPanel();
		add(lightsPanel);
		
		setPreferredSize(new Dimension(200, 300));
		setBackground(Color.blue);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			switch (e.getSource()) { 						// why it has the type error, cannot convert objects into int ?
//				case red:
//					lastPressed.setText("Red");
//					break;
//				case green:
//					lastPressed.setText("Gree");
//					break;
//				case amber:
//					lastPressed.setText("Amber");
//					break;
//				default:
//					break;
//			}
			if (e.getSource() == red) {					// cann't set lightspanel's color from listener, so set data field "lastPressed", then use it to set light color
				lastPressed.setText("Red");
//				buttonPanel.setBackground(Color.red);
			} else if (e.getSource() == green) {
				lastPressed.setText("Green");
//				buttonPanel.setBackground(Color.green);
			} else if (e.getSource() == amber) {
				lastPressed.setText("Amber");
//				buttonPanel.setBackground(Color.orange);
			}
			
			repaint();
		}
	}
	
	
	/**trafficlight panel*/
	private class LightPanel extends JPanel {
		public LightPanel() {
			setPreferredSize(new Dimension(80, 290));
			setBackground(Color.cyan);
		}
		
		/**use lastpressed value to set the color*/
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//g.setColor(Color.red);
			g.fillOval(20, 30, 40, 40);
			g.fillOval(20, 80, 40, 40);
			g.fillOval(20, 130, 40, 40);
			if (lastPressed.getText().equalsIgnoreCase("red")) {
				g.setColor(Color.red);
				g.fillOval(20, 30, 40, 40);
			} else if (lastPressed.getText().equalsIgnoreCase("green")) {
				g.setColor(Color.green);
				g.fillOval(20, 80, 40, 40);
			} else if (lastPressed.getText().equalsIgnoreCase("amber")) {
				g.setColor(Color.orange);
				g.fillOval(20, 130, 40, 40);
			} 
		}
	}
}