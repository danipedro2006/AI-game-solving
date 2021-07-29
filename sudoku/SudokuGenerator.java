package sudoku;

import java.util.Random;

public class SudokuGenerator {
	// generate Sudoku matrix
	public static void generate(int[][] board) {
		int n = 1, k = 1;
		for (int i = 0; i < 9; i++) {
			k = n;
			for (int j = 0; j < 9; j++) {
				if (k <= 9) {
					board[i][j] = k;
					k++;

				} else {
					k = 1;
					board[i][j] = k;
					k++;
				}
			}
			n = k + 3;
			if (k == 10)
				n = 4;
			if (n > 9)
				n = (n % 9) + 1;
		}
	}
	

	// permute 2 columns from same block
	public static void permutationCol(int[][] board, int c1, int c2) {
		int temp;
		for (int i = 0; i < 9; i++) {
			temp = board[i][c1];
			board[i][c1] = board[i][c2];
			board[i][c2] = temp;
		}
	}

	// permute 2 rows from the same block
	public static void permutationRow(int[][] board, int r1, int r2) {
		int temp;
		for (int i = 0; i < 9; i++) {
			temp = board[r1][i];
			board[r1][i] = board[r2][i];
			board[r2][i] = temp;
		}
	}
	
	// interchange 2 row groups
	public static void rowchange(int[][] board, int r1, int r2) {

		int temp;
		for (int n = 0; n < 3; n++) {
			for (int i = 0; i < 9; i++) {
				temp = board[r1][i];
				board[r1][i] = board[r2][i];
				board[r2][i] = temp;
			}
			r1++;
			r2++;
		}
	}

	// Interchange 2 columns blocks

	public static void columnchange(int[][] board, int c1, int c2) {
		int temp;
		for (int n = 0; n < 3; n++) {

			for (int i = 0; i < 9; i++) {
				temp = board[i][c1];
				board[i][c1] = board[i][c2];
				board[i][c2] = temp;
			}
			c1++;
			c2++;
		}
	}

	public static void randomgen(int[][] board, int check) {
		int k1, k2, max = 2, min = 0;
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			k1 = r.nextInt(max - min + 1) + min;
			// this is to ensure k1 is not equal to k2
			do {
				k2 = r.nextInt(max - min + 1) + min;
			} while (k1 == k2);
			max = max + 3;
			min = min + 3;
			// now we are calling randomgen 2 times once for col and once for row
			if (check == 1) {
				permutationRow(board, k1, k1);
			} else if (check == 0) {
				permutationCol(board, k1, k2);
			}
		}
	}

	public static void strikeout(int[][] board, int k1, int k2) {
		int rowfrom;
		int rowto;
		int colfrom;
		int colto;
		int i, j, b, c;
		int rem1, rem2;
		int flag;
		int temp = board[k1][k2];
		int count = 9;
		
		for (i = 1; i < 9; i++) {
			flag = 1;
			for (j = 1; j < 9; j++) {
				if (j != k2) {
					if (i != board[k1][j]) {
						continue;
					} else {
						flag = 0;
						break;
					}
				}
			}

			if (flag == 1) {
				for (c = 0; c < 9; c++) {
					if (c != k1) {
						if (i != board[c][k2]) {
							continue;
						} else {
							flag = 0;
							break;
						}
					}
				}
			}

			if (flag == 1) {

				rem1 = k1 % 3;
				rem2 = k2 % 3;
				rowfrom = k1 - rem1;
				rowto = k1 + (2 - rem1);
				colfrom = k2 - rem2;
				colto = k2 + (2 - rem2);

				for (c = rowfrom; c <= rowto; c++) {
					for (b = colfrom; b <= colto; b++) {
						if (c != k1 && b != k2) {
							if (i != board[c][b])
								continue;
							else {
								flag = 0;
								break;
							}
						}
					}

				}

			}

			if (flag == 0)
				count--;
		}

		if (count == 1) {
			board[k1][k2] = 0;
			count++;

		}
	}

	// print Sudoku matrix
	private static void print(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] board = new int[9][9];
		generate(board);
		randomgen(board, 1);
		randomgen(board, 0);

		// striking out
		for (int k1 = 0; k1 < 9; k1++) {
			for (int k2 = 0; k2 < 9; k2++) {
				strikeout(board, k1, k1);
			}
		}

		print(board);

	}
}
