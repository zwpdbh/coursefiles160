public class MultiplicationTable {
	public static void main(String[] args) {
		int[][] table = new int[12][12];
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = (i+1) * (j+1);
			}
		}
		
		for (int[] rows: table) {
			System.out.println("");
			for (int num: rows) {
				System.out.print(num + "\t");
			}
		}
	}
}