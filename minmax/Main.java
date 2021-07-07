package minmax;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Bones game");
		
		/*take 3, 4 or five objects from the pile, 
		the player who  can't move already loss the game  
		 */		
		
		boolean end=false;
		int val=10;
		boolean first=true;
		while(!end) {
			System.out.println("Current position =" +val+", Player one: "+first);
			State s=new State(val, true);
			State decision=Minimax.minimaxDecision(s);
			val=decision.state;
			if(decision.isTerminal()) {
				end=true;
				System.out.println("Current position= "+val+", Player one won: "+first);
				System.out.println("Game over");
			}
			first=!first;
		}
	}

}
