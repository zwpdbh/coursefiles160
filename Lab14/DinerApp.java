import javax.swing.*;
import java.awt.print.*;
import java.awt.*;

public class DinerApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Dinner table");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new TablePanel());
		
		frame.pack();
		frame.setVisible(true);
	}
}


class TablePanel extends JPanel {
	private Diner diner1, diner2, diner3, diner4, diner5, diner6;
	
	/**Constructor*/
	public TablePanel() {
		diner1 = new Diner(int x, int y, String name, int seatNumber, Color colour)
	}
	
	/**set the backgroud color*/
}

/**represent the seat aroud the table*/
class Diner {
	private int x;
	private int y;
	private String name;
	private int seatNumber;
	private Color colour;
	private final int DIAMETER = 50;
	
	/**constructor to initialize */
	public Diner(int x, int y, String name, int seatNumber, Color colour) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.seatNumber = seatNumber;
		this.colour = colour;
	}
	
	/**draw*/
	public draw(Graphics g) {
		
	}
}