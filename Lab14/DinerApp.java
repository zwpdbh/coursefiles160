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
	
	private static final int SIZE = 70;
	private static final int PANEL_X = SIZE * 8;
	private static final int PANEL_Y = PANEL_X + 20;
	private Table table;
	
	/**Constructor*/
	public TablePanel() {
		// a black rectangle as table
		table = new Table(PANEL_X/2 - SIZE/2, PANEL_Y/2 - SIZE, SIZE, SIZE*2.5, Color.black);
		
		// 6 circle as dinner, use table'4 corner as coordinate
		Point p = new Point();
		p = table.upCenter();
		diner1 = new Diner(p.getX(), p.getY()-SIZE/2-10 , "David", 1, Color.yellow);
		
		p = table.downCenter();
		diner4 = new Diner(p.getX(), p.getY()+SIZE/2+10, "Metrila", 4, Color.cyan);
		
		p = table.upLeft();
		diner6 = new Diner(p.getX()-SIZE, p.getY()+SIZE/2, "Jacqul", 6, Color.lightGray);
		
		p = table.upRight();
		diner2 = new Diner(p.getX()+SIZE, p.getY()+SIZE/2, "Clare", 2, Color.red);
		
		p = table.downLeft();
		diner5 = new Diner(p.getX()-SIZE, p.getY()-SIZE/2, "Todd", 5, Color.pink);
		
		p = table.downRight();
		diner3 = new Diner(p.getX()+SIZE, p.getY()-SIZE/2, "Michael", 4, Color.green);
	
		
		setPreferredSize(new Dimension(this.PANEL_X, this.PANEL_Y));
		setBackground(Color.white);
	}
	
	/**All the graphics drawing will be handled by this method*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		table.draw(g);
		diner1.draw(g);
		diner4.draw(g);
		diner6.draw(g);
		diner2.draw(g);
		diner5.draw(g);
		diner3.draw(g);

	}
}


