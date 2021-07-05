package tictactoe;
//Java program to compute evaluation function for Tic-Tac-Toe

public class EvalFunction {
	// Return a value based on who is winning
	// b[3][3]

	public static void main(String[] args) {
		char board[][] = { { 'O', 'X', 'X' }, { '-', 'O', 'O' }, { '-', '-', 'O' } };
		print(board);
		int val = evaluate(board);
		System.out.printf("The value of this board is %d",val);

	}

	private static void print(char[][] board) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int evaluate(char[][] board) {

		// check for row victory x or o

		for (int r = 0; r < 3; r++) {

			if (board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
				if (board[r][0] == 'X') {
					return +10;
				} else if (board[r][0] == 'O') {
					return -10;
				}
			}
		}

		// check for col victory for x or o

		for (int c = 0; c < 3; c++) {

			if (board[0][c] == board[1][c] && board[1][c] == board[2][c]) {

				if (board[0][c] == 'X') {
					return +10;
				} else if (board[0][c] == 'O') {
					return -10;
				}
			}
		}

		// check for diagonals victory for x or o

		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {

			if (board[0][0] == 'X') {
				return +10;
			} else if (board[0][0] == 'O') {
				return -10;
			}
		}

		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {

			if (board[0][2] == 'X') {
				return +10;
			} else if (board[0][2] == 'O') {
				return -10;
			}
		}

		// if non of them return 0
		return 0;

	}
}