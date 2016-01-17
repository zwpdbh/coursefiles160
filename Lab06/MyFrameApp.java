import java.awt.*;

class MyFranmeApp {
	public static void main(String[] args) {
		MyFrame m1 = new MyFrame();
		m1.setSize(300, 150);
		m1.setVisible(true);
		
		// Create second instance of MyFranme
		MyFrame m2 = new MyFrame();
		m2.setSize(300, 400);
		m2.setVisible(true);
		// m2.setLocation(0, 180);
		
		m2.decorator(Color.lightGray, "Set background color to gray", 180);
		
		MyFrame m3 = new  MyFrame();
		m3.setSize(200, 200);
		m3.setVisible(true);
		m3.decorator(Color.red, "the blue one", 280);
	}
}