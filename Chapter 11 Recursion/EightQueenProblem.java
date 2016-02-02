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
		queenBoard.showBoard();
		
	}
}


class Chessboard {
	private int[][] board;
	private int[][] track;
	private int row, col;
	
	/**Constructor */
	public Chessboard(int row, int col) {
		this.board = new int[row][col];
		this.track = new int[6][2];
		this.row = row;
		this.col = col;
	}
	
	// the method to position a queen, do recursion on itself
	public void queenPostion(int queenToPut) {
		if (queenToPut == 0) {
			System.out.println("Done");
		} else {
			// find a valid postion at current row
			int indexRow = board.length - queenToPut;
			System.out.format("There are %d queen left, need to put queen at row: %d \n", queenToPut, indexRow);
			for (int col: this.board[indexRow]) {
				if (isValid(indexRow, col)) {
					board[indexRow][col] = 7;
					track[indexRow][0] = indexRow;
					track[indexRow][1] = col; 
					break;
				}
			}
			System.out.format("Try to queenPostion(%d) \n", queenToPut-1);
			queenPostion(queenToPut-1);
		}
	}
	
	/**run through the recored track, and set their blocking postion, then check to see if the input position is valid or not*/
	private boolean isValid(int indexRow, int indexCol) {
		int[][] chessCopy = new int[row][col];
		for (int[] getTrack: track) {
			blockQueenPostion(getTrack[0], getTrack[1], chessCopy);
		}
		
		if (chessCopy[indexRow][indexCol] == 1) {
			return false;
		} else {
			return true;
		}	
	}
	
	
	// put a queen at select position and set associated postion invalid
	public void blockQueenPostion(int indexOfRow, int indexOfCol, int[][] copyBorad) {
		copyBorad[indexOfRow][indexOfCol] = 1;			
		//System.out.format("Row: %d\tCol: %d\n", indexOfRow, indexOfCol);
		// calculate those invalid postion and set them into 1;
		int row = 0;
		int col = 0;
		try {
			for (row=0; row<=copyBorad.length-1; row++) {
				for (col=0; col<=copyBorad[row].length-1; col++) {
					if (row == indexOfRow || col == indexOfCol) {
						copyBorad[row][col] = 1;
					}
					if (Math.abs(row - indexOfRow) == Math.abs(col - indexOfCol)) {
						copyBorad[row][col] = 1;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.format("indexOfRow: %d\tindexOfCol: %d\trow: %d\tcol: %d\n", indexOfRow, indexOfCol, row, col);
		}

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
		
}
