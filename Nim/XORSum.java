package nim;

import java.util.Arrays;

public class XORSum {
	
	private static int xor(int x, int y) {
		
		return (x|y) & (~x | ~y);
	
}
	
	
	public static void main(String[] args) {
		
		int x=3;
		int y=5;
		
		int[] array= {3,5,7};
		
		subs(array,0,1);
		System.out.println(nimSum(array));
		subs(array,1,2);
		System.out.println(Arrays.toString(array));
	}


	private static int[] subs(int[] array, int pile, int n) {
		
		array[pile]=array[pile]-n;
		
		return array;
		
		
	}


	private static int nimSum(int[] array) {
		
		int  nimsum=0;
		
		for(int i=0;i<array.length;i++) {
			/*
			 * System.out.println("nimsum "+nimsum); System.out.println("i " +array[i]);
			 */
			
			nimsum=xor(nimsum,array[i]);
		}
		return nimsum;
	}

	


}