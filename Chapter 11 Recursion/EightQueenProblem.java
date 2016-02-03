/**Design and implement a recursive program that solves the Non- Attacking Queens problem. 
That is, write a program to deter- mine how eight queens 
can be positioned on an eight-by-eight chessboard so that none of them is in the same row, column, or diagonal as any other queen. 
There are no other chess pieces on the board.*/

class EightQueenProblem {
	public static void main(String[] args) {
		
		Chessboard queenBoard = new  Chessboard(8);
	
	}
}


class Chessboard {
	private int[][] board;
	private int size;
	private int[] track;
	
	/**Constructor */
	public Chessboard(int size) {
		this.board = new int[size][size];
		this.size = size;
	}
	
	/** helper method to call the recursive function*/
	public callPutQueensAt() {
		putQueens(0, 8);
	}
	
	public void putQueensAt(int currentRow, int queensLeft) {
		if (queensLeft == 0) {
			System.out.println("Find a solution");
			return
		}

		// run through every column on current row
		for (int col=0; col<size; col++) {
			// if find valid postion on current row, put queen there, call method on next row, queens number - 1
			if (isOK(currentRow, col)) {
				code
			}
		}
		// after run through current column, there is no available postion, we need go back to previous row and try its next available postion.
		putQueensAt(currentRow+1, queensLeft-1);

	}
	
	
	public boolean isOK(int indexOfRow, indexOfCol) {
		
		return false;
	}
	
		
}



