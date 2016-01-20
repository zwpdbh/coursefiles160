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
	private final int TABLE_X = 400;
	private final int TABLE_Y = 420;
	
	/**Constructor*/
	public TablePanel() {
		// this is the center(x, y) of the top circle "David"; 
		int originalX = (int)this.TABLE_X/2;
		int originalY = (int)this.TABLE_Y/5;
		
		diner1 = new Diner(originalX, originalY, "David", 1, Color.GREEN);
		
		
		setPreferredSize(new Dimension(this.TABLE_X, this.TABLE_Y));
		setBackground(Color.lightGray);
	}
	
	/**All the graphics drawing will be handled by this method*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		diner1.draw(g);
	}
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
	public void draw(Graphics g) {
		int radius = (int)this.DIAMETER/2;
		g.setColor(this.colour);
		g.fillOval(this.x - radius, this.y - radius, this.DIAMETER, this.DIAMETER);
	}
}