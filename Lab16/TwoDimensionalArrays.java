class TwoDimensionalArrays {
	public static void main(String[] args) {
		int cols = 4;
		int rows= 5;
		
		int[][] table = new int[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				table[row][col] = row * col;
			}
		}
		
//		for (int row = 0; row < table.length; row++) {
//			System.out.println("\n");
//			for (int col = 0; col < table[row].length; col++) {
//				System.out.print(table[row][col]);
//			}
//		}
		
		for (int[] level: table) {
			System.out.println("\n");
			for (int num: level) {
				System.out.print(num + "\t");
			}
		}
	}
}