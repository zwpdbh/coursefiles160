/**Design and implement a recursive program to determine and print the Nth line of Pascal’s Triangle, as shown on page 22. Each interior value is the sum of the two values above it. Hint: Use an array to store the values on each line.*/

public class TriangleNumber {
	public static void main(String[] args) {
		PascalsTriangle triangle = new  PascalsTriangle(9);
		triangle.printTriangle();
	}
}


class PascalsTriangle {
	private int line;
	//private int[][] triangle;
	
	/**Constructor*/
	public PascalsTriangle(int line) {
		this.line = line;
		//triangle = new int[line][line];
	}
	
	/**print all lines*/ 
	public void printTriangle() {
		for (int row=1; row<=line; row++) {
			int[] numArray = getNumber(row);
			String whitespace = returnBlank(line-row);
			System.out.print(whitespace);
			printArray(numArray);
		}
	}
	
	/** get numbers from current row, as int[]*/
	private int[] getNumber(int indexOfRow) {
		if (indexOfRow == 1) {
			int[] one = new int[1];
			one[0] = 1;
			return one;
		}
		int[] row = new int[indexOfRow];
		for (int index=0; index<indexOfRow; index++) {
			if (index == 0 || index==indexOfRow-1) {
				row[index]=1;
			} else {
				int[] previousRow = getNumber(indexOfRow-1);
				row[index] = previousRow[index-1] + previousRow[index];
			}
		}// end loop

		return row;
	}
	
	/**print the numbers in the int[]*/
	private void printArray(int[] numArray) {
		//System.out.print(numArray.length + ": ");
		for (int index=0; index<numArray.length; index++) {
			System.out.print(numArray[index] + "   ");
		}
		System.out.println();
	}
	
	private String returnBlank(int num) {
		String whitespace = " ";
		for (int i=0; i<num; i++) {
			whitespace += "   ";
		}
		return whitespace;
	}
}

/** to get the Nth line of number -> to get Nth - 1 line of number ->
	-> to get the 1th line of number(done.)
*/
