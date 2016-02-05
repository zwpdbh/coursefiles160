/**Lab18*/
import javax.swing.*;
import java.awt.*;

public class TrafficLightApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Traffic Lights");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TrafficLightPanel panel = new TrafficLightPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}