/**Design and implement a recursive program that solves the Non- Attacking Queens problem. 
That is, write a program to deter- mine how eight queens 
can be positioned on an eight-by-eight chessboard so that none of them is in the same row, column, or diagonal as any other queen. 
There are no other chess pieces on the board.*/

class EightQueenProblem {
	public static void main(String[] args) {
		
		Chessboard queenBoard = new  Chessboard(8, 8, 8);
		queenBoard.showBoard();
		
		queenBoard.setQueenTrack(3, 3);
		queenBoard.setQueenTrack(5, 1);
	}
}


class Chessboard {
//	private int row;
//	private int col;
	private int[][] board;
	private int queenLeft;
	
	// Constructor to initialize the chessboard.
	public Chessboard(int row, int col, int numOfQueen) {
//		this.row = row - 1;
//		this.col = col - 1;
		this.board = new int[row][col];
		this.queenLeft = numOfQueen;		// at beginning, there are 8 queen left.
	}
	
	// the method to position a queen, do recursion on itself
	public queenPostion(int indexOfRow, int indexOfCol) {
		if queenLeft == 0 {
			System.out.println("Done");
			return;
		} else {
			int startAtRow = 8 - queenLeft;
			if (startAtRow == 7) {  // 1 queenleft, startAtRow = 7, means just position the queen at last row.
				for (int col: this.board[startAtRow]) {
					if (this.board[startAtRow][col] == 0) {
						setQueenTrack(startAtRow, col);
						queenLeft-1;
					} else {
						continue;
					}
				}
			}
		}
	}
	
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
