/**Design and implement a recursive program to determine and print the Nth line of Pascal’s Triangle, as shown on page 22. Each interior value is the sum of the two values above it. Hint: Use an array to store the values on each line.*/

public class TriangleNumber {
	public static void main(String[] args) {
		PascalsTriangle triangle = new  PascalsTriangle(5);
		triangle.printTriangle();
	}
}


class PascalsTriangle {
	private int line;
	
	public PascalsTriangle(int line) {
		this.line = line;
	}
	
	public void printTriangle() {
		getNumber(line);
	}
	
	public void getNumber(int indexOfRow) {
		int[] row = new int[indexOfRow];
		for (int index=0; index<indexOfRow; index++) {
			if (index == 0 || index==indexOfRow-1) {
				row[index]=1
			} else {
				row[index] = getNumber(indexOfRow-1)
			}
		}
	}
}

/** to get the Nth line of number -> to get Nth - 1 line of number ->
	-> to get the 1th line of number(done.)
*/
