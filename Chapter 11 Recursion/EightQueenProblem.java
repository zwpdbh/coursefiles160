/**Design and implement a recursive program that solves the Non- Attacking Queens problem. 
That is, write a program to deter- mine how eight queens 
can be positioned on an eight-by-eight chessboard so that none of them is in the same row, column, or diagonal as any other queen. 
There are no other chess pieces on the board.*/

class EightQueenProblem {
	public static void main(String[] args) {
		
		Chessboard queenBoard = new  Chessboard(4);
		queenBoard.callPutQueensAt();
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
		this.track = new int[size];
	}
	
	/** helper method to call the recursive function*/
	public void callPutQueensAt() {
		putQueensAt(0);
	}
	
	
	/**at current row put queen*/
	public void putQueensAt(int currentRow) {
		for (int col=0; col<size; col++) {
			if (isOK(currentRow, col)) {
				track[currentRow] = col;
				putQueensAt(currentRow+1);
				if (currentRow==size-1) {
					printOutTrack(track);
				}
			}
		}
	}
	
	/**run through previous track, use coordinate to make compare, return true if available*/
	public boolean isOK(int indexOfRow, int indexOfCol) {
		try {
			for (int row=0; row<indexOfRow; row++) {
				if (track[row]==indexOfCol || (Math.abs(indexOfRow-row) == Math.abs(track[row]-indexOfCol))) {
					return false;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("indexOfRow: " + indexOfRow + " indexOfCol: " + indexOfCol);
		}
//		for (int row=0; row<indexOfRow; row++) {
//			if (track[row]==indexOfCol || (Math.abs(indexOfRow-row) == Math.abs(track[row]-indexOfCol))) {
//				return false;
//			}
//		}
		return true;
	}
	
	/**run through track, print out a chessboard and with track postion on it*/
	public void printOutTrack(int[] track) {
		for (int col=0; col<size; col++) {
			for (int row=0; row<size; row++) {
				if (track[col] == row) {	
					System.out.print("Q ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
		
}



