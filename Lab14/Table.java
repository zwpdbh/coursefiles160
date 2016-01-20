/**represent the table*/
import java.awt.*;

public class Table {
	private int x;
	private int y;
	private Color colour;
	private int width;
	private int height;
	
	public Table(double x, double y, double width, double height, Color colour) {
		this.x = (int)x;
		this.y = (int)y;
		this.width = (int)width;
		this.height = (int)height;
		this.colour = colour;
	}
	
	/**draw it self*/
	public void draw(Graphics g) { 
		g.setColor(this.colour);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public Point upLeft() {
		return new Point(x, y);
	}
	
	public Point upRight() {
		return new Point(x + width, y);
	}
	
	public Point downLeft() {
		return new Point(x, y + height);
	}
	
	public Point downRight() {
		return new Point(x + width, y + height);
	}
	
	public Point upCenter() {
		return new Point(x + width/2, y);
	}
	
	public Point downCenter() {
		return new Point(x + width/2, y + height);
	}
}