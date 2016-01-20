class TestApp {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.toString());
	}
}

class Test {
	private int x;
	private int y;
	
	public Test() {
		int x;
		x = 3;
		this.x =4;
	}
	
	public String toString() {
		return ("The value of x is " + x);
	}
}