class TriangleApp {
	public static void main(String[] args) {
		Triangle triagle1 = new Triangle(0, 0, 3, 0, 3, 4, "B");
		System.out.println(triagle1);
		
		Triangle triagle2 = new Triangle(0, 3, 3, 4, 1, 9, "A");
		System.out.println(triagle2);
		
		Triangle triagle3 = new Triangle(3, 4, "hypotnuse");
		System.out.println(triagle3);
	}
}