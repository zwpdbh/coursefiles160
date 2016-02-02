/**Design and implement a recursive program that solves the Non- Attacking Queens problem. 
That is, write a program to deter- mine how eight queens 
can be positioned on an eight-by-eight chessboard so that none of them is in the same row, column, or diagonal as any other queen. 
There are no other chess pieces on the board.*/

class EightQueenProblem {
	public static void main(String[] args) {
		
		Chessboard queenBoard = new  Chessboard(8, 8);
		queenBoard.showBoard();
		
		queenBoard.queenPostion(8);
		queenBoard.showTrack();
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
		this.track = new int[row][2];
		this.row = row;
		this.col = col;
	}
	
	// the method to position a queen, do recursion on itself
	public void queenPostion(int queenToPut) {
		if (queenToPut == 0) {
			System.out.println("Done");
			
			// put mark in the position according to track
			for (int[] coordinate: this.track) {
				this.board[coordinate[0]][coordinate[1]] = 1;
			}
		} else {
			// find a valid postion at current row
			int indexRow = board.length - queenToPut;
			System.out.format("There are %d queen left, need to put queen at row: %d \n", queenToPut, indexRow);
			for (int col=0; col<board[indexRow].length; col++) {
				if (isValid(indexRow, col)) {
					System.out.format("The valid coordinate are: %d, %d\n", indexRow, col);
					board[indexRow][col] = 7;
					track[indexRow][0] = indexRow;
					track[indexRow][1] = col;
					break; 
				} else {
					System.out.format("Coordinate: %d, %d is not valid\n", indexRow, col);
					continue;
				}
			}
//			for (int col: this.board[indexRow]) {
//				if (isValid(indexRow, col)) {
//					System.out.format("The valid coordinate are: %d, %d\n", indexRow, col);
//					board[indexRow][col] = 7;
//					track[indexRow][0] = indexRow;
//					track[indexRow][1] = col; 
//					break;
//				} else {
//					System.out.format("Coordinate: %d, %d is not valid\n", indexRow, col);
//					continue;
//				}
//			}
			System.out.format("Try to queenPostion(%d) \n", queenToPut-1);
			queenPostion(queenToPut-1);
		}
	}
	
	/**run through the recored track, and set their blocking postion, then check to see if the input position is valid or not*/
	private boolean isValid(int indexRow, int indexCol) {
		int[][] chessCopy = new int[this.row][this.col];

		for (int row=0; row<=indexRow; row++) {
			blockQueenPostion(track[row][0], track[row][1], chessCopy);
			System.out.format("Blocking postion: %d, %d\n", track[row][0], track[row][1]);
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
	
	public void showTrack() {
		for (int[] corrdinate: track) {
			//System.out.format("%d, %d\n", corrdinate[0], corrdinate[1]);
		}
	}
		
}
