/**Design and implement a recursive program that solves the Non- Attacking Queens problem. 
That is, write a program to deter- mine how eight queens 
can be positioned on an eight-by-eight chessboard so that none of them is in the same row, column, or diagonal as any other queen. 
There are no other chess pieces on the board.*/

class EightQueenProblem {
	public static void main(String[] args) {
		
		Chessboard queenBoard = new  Chessboard(8, 8);
		queenBoard.showBoard();
		
//		queenBoard.setQueenTrack(3, 3);
//		queenBoard.setQueenTrack(5, 1);
		queenBoard.queenPostion(8);
		//queenBoard.showBoard();
		queenBoard.showTrack();
		
	}
}


class Chessboard {
	private int[][] board;
	private int[][] track;
	// Constructor to initialize the chessboard.
	public Chessboard(int row, int col) {
		this.board = new int[row][col];
		this.track = new int[row][col];
	}
	
	// the method to position a queen, do recursion on itself
	public void queenPostion(int queenToPut) {
		if (queenToPut == 0) {
			System.out.println("Done");
		} else {
			// find a valid postion at last row
			int indexRow = board.length - queenToPut;
			System.out.format("There are %d queen left, need to put queen at row: %d \n", queenToPut, indexRow);
			for (int col: this.board[indexRow]) {
				if (board[indexRow][col] == 0) {
					setQueenTrack(indexRow, col);
					break;
				}
			}
			System.out.format("Try to queenPostion(%d) \n", queenToPut-1);
			queenPostion(queenToPut-1);
		}
	}
	
	// put a queen at select position and set associated postion invalid
	public int[][] setQueenTrack(int indexOfRow, int indexOfCol) {		
		board[indexOfRow][indexOfCol] = 7;			// 1 means invalid, default value is 0, means valid postion
		System.out.format("Row: %d\tCol: %d\n", indexOfRow, indexOfCol);
		track[indexOfRow][indexOfCol] = 7;
		// calculate those invalid postion and set them into 1;
		int row = 0;
		int col = 0;
		try {
			for (row=0; row<=board.length-1; row++) {
				for (col=0; col<=board[row].length-1; col++) {
					if (row == indexOfRow || col == indexOfCol) {
						if (row!=indexOfRow&&col!=indexOfCol) {
							board[row][col] = 1;
						}
					}
					if (Math.abs(row - indexOfRow) == Math.abs(col - indexOfCol)) {
						if (row!=indexOfRow&&col!=indexOfCol) {
							board[row][col] = 1;
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.format("indexOfRow: %d\tindexOfCol: %d\trow: %d\tcol: %d\n", indexOfRow, indexOfCol, row, col);
		}
		
		showBoard();
		return this.board;
	}
	
	// Print out the chessboard.
	public void showBoard() {
		for (int[] row: this.board) {
			for (int col: row) {
				System.out.format("%d ", col);
			}
			System.out.println();
		}
		System.out.println("");
	}
	
	public void showTrack() {
		for (int[] row: this.track) {
			for (int col: row) {
				System.out.format("%d ", col);
			}
			System.out.println();
		}
		System.out.println("");
	}
	
}
