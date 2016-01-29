class Recursion {
	public static void main(String[] args) {
		System.out.print(Factorial.factR(4));
		
	}
}

class Factorial {
	static public int factR(int n) {
		if (n == 1) {
			return 1;
		} else {
			return factR(n-1) * n;
		}
	}
}