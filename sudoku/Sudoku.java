package sudoku;

public class Sudoku {

	static int[][] sudoku;
	private static final int UNASSIGNED = 0;

	public Sudoku() {
		sudoku = new int[9][9];

	}

	public Sudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}

	public void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean checkrow(int[][] board, int row, int number) {
		for (int col = 0; col < board.length; col++) {
			if (sudoku[row][col] == number) {
				return true;

			}
		}
		return false;

	}

	private boolean checkcol(int[][] board, int col, int number) {
		for (int row = 0; row < board.length; row++) {
			if (sudoku[row][col] == number) {
				return true;
			}
		}
		return false;

	}

	private boolean checkbox(int[][] board, int row, int col, int number) {

		int i = row - row % 3;
		int j = col - col % 3;
		for (i = row; i < row + 3; i++) {
			for (j = col; j < col + 3; j++) {
				if (sudoku[row][col] == number)
					return true;
			}
		}
		return false;
	}

	private boolean isAllowed(int[][] board, int row, int col, int number) {
		
		return !(checkrow(board, row, number) || checkcol(board, col, number) || checkbox(board, row, col, number));
			
	}
	
	private boolean isCorrectSolution(int[][] board, int row, int col, int number){
		if(!isAllowed (board, row, col, number) || board[row][col]==UNASSIGNED) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {

		int[][] board = { 
				{3, 2, 1, 6, 5, 4, 7, 9, 8},
				{6, 5, 4, 9, 8, 7, 1, 3, 2},
				{9, 8, 7, 3, 2, 1, 4, 6, 5},
				{4, 3, 2, 7, 6, 5, 8, 1, 9},
				{7, 6, 5, 1, 0, 8, 2, 4, 3},
				{1, 9, 8, 4, 3, 2, 5, 7, 6},
				{5, 4, 3, 8, 7, 6, 0, 2, 1},
				{8, 7, 6, 2, 1, 9, 3, 5, 4},
				{2, 1, 9, 5, 4, 3, 6, 8, 7}
				};

		Sudoku sudoku = new Sudoku(board);
		// sudoku.print(board);
		
		System.out.println(sudoku.isCorrectSolution(board, 0, 0, 0));
	}

}