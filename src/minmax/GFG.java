// A simple java program to find max score for maximizing player

package minmax;

public class GFG {

	// return the optimal value the maximizer player can obtain
	// depth is current depth of game tree, h- maximum height of game tree
	// scores[] stores the game tree
	// isMax- returns true if current move is of maximizing player, else false

	public static int minimax(int depth, int nodeIndex, boolean isMax, int scores[], int h) {
		if (depth == h) {
			return scores[nodeIndex];
		}

		if (isMax) {
			return Math.max(minimax(depth + 1, nodeIndex * 2, false, scores, h),
					minimax(depth + 1, nodeIndex * 2 + 1, false, scores, h));
		} else {
			return Math.min(minimax(depth + 1, nodeIndex * 2, false, scores, h),
					minimax(depth + 1, nodeIndex * 2 + 1, false, scores, h));
		}
		
		// even nodes for maximizer player, odd nodes for minimizer player
	}

	// utility function to calculate Log2N

	static int log2(int n) {
		return (n == 1) ? 0 : 1 + log2(n / 2);
	}

	public static void main(String[] args) {
		// number of elements in score must be a power of 2

		int scores[] = { 3, 5, 2, 9, 12, 5, 23, 23 };
		int n = scores.length;
		int h = log2(n);
		int res = minimax(0, 0, true, scores, h);
		System.out.println("The optimal value is : " + res);

	}
}
