package diverse;

public class Hanoi {
	
	public static void move(int discs, int source, int auxiliary, int destination) {
		if(discs>0) {
			move(discs-1, source, destination, auxiliary);
			System.out.println("move disk "+discs+ " from "+ source+" to "+destination);
			move(discs-1, auxiliary, source, destination);
		}
		
		
	}

	public static void main(String[] args) {
		int n=4;
		move(n,1,2,3);

	}

}
