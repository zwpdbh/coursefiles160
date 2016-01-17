import javax.lang.model.element.*;
import javax.print.attribute.standard.*;
import java.text.*;

public class Triangle {
	private int p1x;
	private int p1y;
	private int p2x;
	private int p2y;
	private int p3x;
	private int p3y;
	private String name;
	
	// constructor
	public Triangle(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y, String nameIn) {
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
		this.p3x = p3x;
		this.p3y = p3y;
		this.name = nameIn;
	}
	
	// support method to calculate the side of two point
	private double calcSide(int x1, int y1, int x2, int y2) {
		double x = x2 - x1;
		double y = y2 - y1;	
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return distance;
	}
	
	// services method to calculate the perimeter
	public double getPerimeter() {
		double side1 = calcSide(p1x, p1y, p2x, p2y);
		double side2 = calcSide(p2x, p2y, p3x, p3y);
		double side3 = calcSide(p3x, p3y, p1x, p1y);
		return side1 + side2 + side3;
	}
	
	// toString
	public String toString() {
		DecimalFormat dfmat = new DecimalFormat("0.##");
		double perimeter = getPerimeter();
		return "Triangle " + this.name + " perimeter is " + dfmat.format(perimeter) + " units";
	}
	
	// constructor for hypotenuse
	public Triangle(int aSide, int bSide, String name) {
		this.p2x = 0;
		this.p2y = 0;
		this.p1x = 0;
		this.p1y = aSide;
		this.p3x = bSide;
		this.p3y = 0;
		this.name = name;
	}
}