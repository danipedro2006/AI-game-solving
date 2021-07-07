
public class GT {

	// return the optimal value a maximiser can obtain
	// h-is maximum height of game tree
	// scores[]-store leaves in game tree
	// isMax- is true if current move is maximiser
	// nodeIndex-is index of current node in scores[]

	public static void main(String[] args) {

		int scores[] = { 3, 5, 2, 9};
		int n = scores.length;
		int h = log2(n);
		int res = minimax(0, 0, true, scores, h);
		System.out.println("Optimal value: "+res);

	}

	private static int minimax(int depth, int nodeIndex, boolean isMax, int[] scores, int h) {

		if (depth == h)
			return scores[nodeIndex];
		// current move is maximiser
		if (isMax) {
			return Math.max(minimax(depth + 1, nodeIndex * 2, false, scores, h),
					minimax(depth + 1, nodeIndex * 2 + 1, false, scores, h));
		}
		// current move is minimiser
		else {
			return Math.min(minimax(depth + 1, nodeIndex * 2, true, scores, h),
					minimax(depth + 1, nodeIndex * 2 + 1, true, scores, h));
		}

	}

	// utility function to find log2(n)

	static int log2(int n) {

		return (n == 1) ? 0 : 1 + log2(n / 2);
	}
}
