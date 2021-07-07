import java.lang.Math.*;
import java.util.*;


public class Chessboard {

	private int board[][];
	private int numOfQueens = 0, queenArrayIndex = 0, rows, columns;
	private ArrayList < Queen > queens = new ArrayList < Queen > ();
	private ArrayList < Queen > fixedQueens = new ArrayList < Queen > ();

	
	public Chessboard(int r, int c) {
		rows = r;
		columns = c;
		if (r > c) {
			rows = c;
			columns = r;
		}
		board = new int[rows][columns];
	}

	
	public int[][] getBoard() {
		return board;
	}

	
	public boolean checkIfPlace(int r, int c) {
		boolean canPlace = true;
		if ((r >= rows) || (c >= columns)) {
			canPlace = false;
		} else if ((board[r][c] < 0)) {
			canPlace = false;
		}
		return canPlace;
	}

	
	public boolean isQueenHere(int r, int c) {
		boolean isHere = false;
		if (numOfQueens != 0) {
			for (int i = 0; i < numOfQueens; i++) {
				if ((queens.get(i).getRow() == r) && (queens.get(i).getColumn() == c)) {
					isHere = true;
				}
			}
		}
		return isHere;
	}

	
	public boolean isBoardEmpty() {
		boolean empty = true;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (isQueenHere(r, c)) {
					empty = false;
				}
			}
		}
		return empty;
	}

	
	public void placeOrRemoveQueen(int r, int c, int incOrDec) { //Variable x is either -1 for Remove or 1 for Insert
		if (incOrDec == -1) {
			Queen queen = new Queen(r, c);
			queens.add(queenArrayIndex, queen);
			numOfQueens++;
			queenArrayIndex++;
		} else if (incOrDec == 1) {
			numOfQueens--;
			queenArrayIndex--;
			queens.remove(queenArrayIndex);
		}

		board[r][c] += incOrDec;

		for (int i = 0; i < columns; i++) {
			if (i != c) {
				board[r][i] += incOrDec;
			}
		}

		for (int i = 0; i < rows; i++) {
			if (i != r) {
				board[i][c] += incOrDec;
			}
		}

		int tempR = r + 1;
		int tempC = c + 1;

		while ((tempR < rows) && (tempC < columns)) {
			board[tempR][tempC] += incOrDec;
			tempR++;
			tempC++;
		}

		tempR = r - 1;
		tempC = c - 1;

		while ((tempR < rows) && (tempC < columns) && (0 <= tempR) && (0 <= tempC)) {
			board[tempR][tempC] += incOrDec;
			tempR--;
			tempC--;
		}

		tempR = r + 1;
		tempC = c - 1;

		while ((tempR < rows) && (tempC < columns) && (0 <= tempR) && (0 <= tempC)) {
			board[tempR][tempC] += incOrDec;
			tempR++;
			tempC--;
		}

		tempR = r - 1;
		tempC = c + 1;

		while ((tempR < rows) && (tempC < columns) && (0 <= tempR) && (0 <= tempC)) {
			board[tempR][tempC] += incOrDec;
			tempR--;
			tempC++;
		}
	}

	
	public void removeAllQueens() {
		if (numOfQueens != 0) {
			fixedQueens.clear();
			for (int i = (numOfQueens - 1); i >= 0; i--) {
				placeOrRemoveQueen(queens.get(i).getRow(), queens.get(i).getColumn(), 1);
			}
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < columns; c++) {
					board[r][c] = 0;
				}
			}
		}
	}

	
	public boolean solve(int r) {
		boolean ans = false;
		if (isSolution()) {
			ans = true;
		} else if (!areQueensAttacked()) {
			for (int c = 0;
			(c < columns) && (ans == false); c++) {
				if (isFixedQueenOnRow(r)) {
					ans = solve((r + 1));
				} else if (board[r][c] == 0) {
					placeOrRemoveQueen(r, c, -1);
					ans = solve((r + 1));
					if (!ans) {
						placeOrRemoveQueen(r, c, 1);
					}
				}
			}
		}
		return ans;
	}

	
	public String boardToString() {
		String boardString = "\n";
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (board[r][c] == 0) {
					boardString += "00 ";
				} else {
					if (isQueenHere(r, c)) {
						boardString += ("Qn ");
					} else {
						boardString += (String.valueOf(board[r][c]) + " ");
					}
				}
			}
			boardString += "\n";
		}
		return boardString;
	}

	
	public boolean isFixedQueenOnRow(int r) {
		boolean fixedQueenOnRow = false;
		if (fixedQueens.size() != 0) {
			for (int i = 0;
			(i < fixedQueens.size()) && (!fixedQueenOnRow); i++) {
				if (fixedQueens.get(i).getRow() == r) {
					fixedQueenOnRow = true;
				}
			}
		}
		return fixedQueenOnRow;
	}

	
	public Queen getQueenAt(int r, int c) {
		Queen desiredQueen = null;
		if (numOfQueens != 0) {
			for (int i = 0; i < numOfQueens; i++) {
				if ((queens.get(i).getRow() == r) && (queens.get(i).getColumn() == c)) {
					desiredQueen = queens.get(i);
				}
			}
		}
		return desiredQueen;
	}

	
	public Queen getFixedQueenAt(int r, int c) {
		Queen desiredQueen = null;
		if (numOfQueens != 0) {
			for (int i = 0; i < fixedQueens.size(); i++) {
				if ((fixedQueens.get(i).getRow() == r) && (fixedQueens.get(i).getColumn() == c)) {
					desiredQueen = fixedQueens.get(i);
				}
			}
		}
		return desiredQueen;
	}

	
	public boolean areQueensAttacked() {
		boolean areQueensAttacked = false;
		if (numOfQueens != 0) {
			for (int i = 0;
			(i < numOfQueens) && (!areQueensAttacked); i++) {
				if (board[queens.get(i).getRow()][queens.get(i).getColumn()] < -1) {
					areQueensAttacked = true;
				}
			}
		}
		return areQueensAttacked;
	}

	
	public void addFixedQueen(Queen queen) {
		queen.setFixed(true);
		fixedQueens.add(queen);
	}

	
	public void removeFixedQueen(int r, int c) {
		if (fixedQueens.size() != 0) {
			for (int i = 0; i < fixedQueens.size(); i++) {
				Queen currentQueen = fixedQueens.get(i);
				if ((currentQueen.getRow() == r) && (currentQueen.getColumn() == c)) {
					fixedQueens.remove(i);
				}
			}
		}
	}

	
	public int tooFewManyOrMax() {
		int howMany = 0;
		if (numOfQueens != rows) {
			if (numOfQueens > rows) {
				howMany = 1;
			} else if (numOfQueens < rows) {
				howMany = -1;
			}
		}
		return howMany;
	}

	
	public boolean isSolution() {
		boolean solution = false;
		if ((!areQueensAttacked()) && (numOfQueens == rows)) {
			solution = true;
		}
		return solution;
	}

	
	public ArrayList < Queen > getQueens() {
		return queens;
	}

	
	public int getNumOfQueens() {
		return numOfQueens;
	}

	
	public int getRows() {
		return rows;
	}

	
	public int getColumns() {
		return columns;
	}


	public void setAllQueensToFixed() {
		if (numOfQueens != 0) {
			for (int i = 0; i < numOfQueens; i++) {
				queens.get(i).setFixed(true);
				addFixedQueen(queens.get(i));
			}
		}
	}

}