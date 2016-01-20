/**represent the seat aroud the table*/
import java.awt.*;

public class Diner {
	private int x;
	private int y;
	private String name;
	private int seatNumber;
	private Color colour;
	private final int DIAMETER = 70;
	
	/**constructor to initialize */
	public Diner(double x, double y, String name, int seatNumber, Color colour) {
		this.x = (int)x;
		this.y = (int)y;
		this.name = name;
		this.seatNumber = seatNumber;
		this.colour = colour;
	}
	
	/**draw*/
	public void draw(Graphics g) {
		int radius = (int)this.DIAMETER/2;
		g.setColor(this.colour);
		g.fillOval(this.x - radius, this.y - radius, this.DIAMETER, this.DIAMETER);
		
		// draw name
		g.setColor(Color.black);
	 	g.setFont(new Font("Helvetica", Font.BOLD, 16));
		g.drawString(this.name, x-radius+(radius/5), y+radius/9);
		
		// draw number
		g.setFont(new Font("Courier", Font.PLAIN, 12));
		g.drawString(Integer.toString(this.seatNumber), x, y-radius/2);
	}
}
