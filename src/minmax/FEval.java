package minmax;

public class FEval {

	// Java program to compute evaluation function for Tic-Tac-Toe game
	// b[3][3] is the Tic-Tac-Toe board

	static int evalPos(char[][] b) {
		
		// Check for rows X or O victory

		for (int row = 0; row < 3; row++) {

			if (b[row][0] == b[row][1] && b[row][0] == b[row][2]) {

				if (b[row][0] == 'X') {
					return +10;
				}

				else if (b[row][0] == 'O') {
					return -10;
				}
			}
		}

		// check for columns X or O victory

		for (int col = 0; col < 3; col++) {

			if (b[0][col] == b[1][col] && b[1][0] == b[2][col]) {

				if (b[0][col] == 'X') {
					return +10;
				}

				else if (b[0][col] == 'O') {
					return -10;
				}
			}
		}

		// check for diagonals of X or O victory

		if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {

			if (b[0][0] == 'X') {
				return +10;
			}

			else if (b[0][0] == 'O') {
				return -10;
			}

			if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {

				if (b[0][2] == 'X') {
					return +10;
				}

				else if (b[0][2] == 'O') {
					return -10;
				}

			}
		}
		return 0;
	}

	public static void main(String[] args) {

		char[][] b = { { 'O', 'O', 'O' }, { '_', 'X', 'O' }, { '_', '_', 'X' } };

		// print board

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}

		int val = evalPos(b);
		System.out.println("Board's position value is: " + val);
	}

}
