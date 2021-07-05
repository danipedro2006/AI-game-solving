package diverse;

public class Queens {

	static int N = 8;

	static int[][] table = new int[8][8];

	static // queen position i, queen[i]

//	void solve(int N) {
//		if(placequeen(0,N)) {
//			display(table);
//		}
//		else {
//			System.out.println("No solution");
//		}
//	}

	void init(int[][] table) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				table[i][j] = 0;
			}
		}
	}

	static boolean issafe(int row, int col) {

		// check if row is ok

		for (int i = 0; i < col; i++) {
			if (table[row][i] == 1)
				return false;
		}

		// check first diagonal, toward up=left corner

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (table[i][j] == 1)
				return false;
		}
		// check second diagonal toward left down corner

		for (int i = row, j = col; i < N && j >= 0; i++, j--) {
			if (table[i][j] == 1)
				return false;

		}

		return true;
	}

	static boolean placequeen(int queen, int N) {
		if (queen == N) {
			return true;
			// if we are here problem solved
		}
		for (int row = 0; row < N; row++) {

			if (issafe(row, queen)) {
				table[row][queen] = 1;

				if (placequeen(queen + 1, N)) {
					return true;
				}
				table[row][queen] = 0;
			}

		}

		return false;
		// if we are here no solution;
	}

	public static void display(int[][] table) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (table[i][j] == 1) {
					System.out.print(" Q ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}

	};

	public static void main(String[] args) {

		init(table);
		// solve(N);
		placequeen(0, N);
		display(table);

	};
}