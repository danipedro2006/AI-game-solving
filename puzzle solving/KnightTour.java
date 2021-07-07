package diverse;

public class KnightTour {

	static final int N = 8;

	public static boolean isValid(int row, int col, int[][] sol) {

		if (row >= 0 && row < N && col >= 0 && col < N) {

			if (sol[row][col] == -1)
				return true;
		}
		
		return false;
	}

	public static boolean KnightTour(int[][] sol, int row, int col, 
			
			int step, int[] xMove, int[] yMove) {
		
		if (step == N * N) {
			return true;
		}

		for (int count = 0; count < N; count++) {

			int next_row = row + xMove[count];
			int next_col = col + yMove[count];
			
			if(isValid(next_row, next_col, sol)) {
				
				sol[next_row][next_col]=step;
				
				// recursive call 
				
				if(KnightTour(sol, next_row, next_col, step+1, xMove, yMove)) {
					return true;
				}
				
				sol[next_row][next_col]=-1;//backtrack
			}
		}
		return false;

	}

	public static boolean solve() {

		int[][] sol = new int[N][N];
		
		//Initialise board values with -1;
		
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				sol[i][j] = -1;
			}
		}

		int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
		
		int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// Place the knight at cell 0,0

		sol[0][0] = 0;

		if (KnightTour(sol, 0, 0, 1, xMove, yMove)) {

			for (int i = 0; i < N; i++) {
				
				for (int j = 0; j < N; j++) {
					
					System.out.print(sol[i][j]+"\t");
				}
				System.out.println();
			}
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		solve();

	}

}
