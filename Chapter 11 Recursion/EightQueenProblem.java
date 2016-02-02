/**Design and implement a recursive program that solves the Non- Attacking Queens problem. 
That is, write a program to deter- mine how eight queens 
can be positioned on an eight-by-eight chessboard so that none of them is in the same row, column, or diagonal as any other queen. 
There are no other chess pieces on the board.*/

class EightQueenProblem {
	public static void main(String[] args) {
		
		Chessboard queenBoard = new  Chessboard(8, 8);
		queenBoard.showBoard();
		
		queenBoard.setQueenTrack(3, 3);
		queenBoard.setQueenTrack(5, 1);
		
	}
}


class Chessboard {
//	private int row;
//	private int col;
	private int[][] board;
	
	// Constructor to initialize the chessboard.
	public Chessboard(int row, int col) {
//		this.row = row - 1;
//		this.col = col - 1;
		this.board = new int[row][col];
	}
	
	// the method to position a queen, do recursion on itself
//	public queenPostion(int indexOfRow) {
//		if (indexOfRow == 0) {
//			setQueenTrack(indexOfRow, 0);
//		} else {
//			if (indexOfRow ) {
//				code
//			}
//			for (int col: board[indexOfRow]) {
//				if (board[indexOfRow][col] != 1) {
//					setQueenTrack(indexOfRow, col);
//				} else {
//					code
//				}
//			}
//		}
//	}
	
	// put a queen at select position and set associated postion invalid
	public int[][] setQueenTrack(int indexOfRow, int indexOfCol) {		
		board[indexOfRow][indexOfCol] = 1;			// 1 means invalid, default value is 0, means valid postion
		// calculate those invalid postion and set them into 1;
		int row = 0;
		int col = 0;
		try {
			for (row=0; row<=board.length-1; row++) {
				for (col=0; col<=board[row].length-1; col++) {
					if (row == indexOfRow || col == indexOfCol) {
						board[row][col] = 1;
					}
					if (Math.abs(row - indexOfRow) == Math.abs(col - indexOfCol)) {
						board[row][col] = 1;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.format("indexOfRow: %d\tindexOfCol: %d\trow: %d\tcol: %d\n", indexOfRow, indexOfCol, row, col);
		}
		
		showBoard();
		return this.board;
	}
	
	public void showBoard() {
		for (int[] row: this.board) {
			for (int col: row) {
				System.out.format("%d ", col);
			}
			System.out.println();
		}
		System.out.println("");
	}	
}
