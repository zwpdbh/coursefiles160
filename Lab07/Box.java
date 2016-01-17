public class Box {
	// instance varaibles
	private int height;
	private int width;
	private int length;
	
	// setter
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	// getter
	public int getSurfaceArea() {
		return (length * width + length * height + height * width) * 2;
	}
	
	public int getVolume() {
		return width * length * height;
	}
	
	// toString
	public String toString() {
		String boxInfo = new String("Height is: " + height + ", ");
		boxInfo += ("Lenght is: " + length + ", ");
		boxInfo += ("Width is: " + width + ", ");
		boxInfo += ("Volume is: " + getVolume() + ", ");
		boxInfo += ("Surface Arear is: " + getSurfaceArea());
		return boxInfo;
	}
	
	// constructor
	public Box(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
	
	// constructor for cube
	public Box(int side) {
		this.height = side;
		this.width = side;
		this.length = side;
	}
	
	// replace default constructor
	public Box() {
		
	}
}