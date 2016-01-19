class Repetition {
	public static void main(String[] args) {
		for (int i = 0; i<=1000; i+=10) {
			System.out.print(i + ", ");
		}
		System.out.println("\n=============");
		for (int i=99; i>=1; i-=2) {
			System.out.print(i + ", ");
		}
		
		System.out.println("\n=============");
		for (char c = 'A'; c<='Z'; c++) {
			System.out.print(c + " ");
		}
	}
}