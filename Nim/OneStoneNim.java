package nim;


/*In this Game of Nim two players take only one stone from the pile
 * The player who picks the last stone win the game
 * A play first
 * Given N stones in the pile, find the winner
 */
public class OneStoneNim {
	
	static int findWinner(int N) {
		
		return N%2;
		
		// similar 
		//return N & 1
	}
		
				
	public static void main(String[] args) {

		int N=4;
		
		if(findWinner(N)==0)
			
			System.out.println("Player B");
		else
			System.out.println("Player A");

	}

}
