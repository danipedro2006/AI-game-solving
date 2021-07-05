
public class TicTacToeStateSpace {

	public static void main(String[] args) {
		char[][] board=new char[3][3];
		
		int counter=0;
		for(int i1=0;i1<=2;i1++) {
			for(int i2=0;i2<=2;i2++) {
				for(int i3=0;i3<=2;i3++) {
					for(int i4=0;i4<=2;i4++) {
						for(int i5=0;i5<=2;i5++) {
							for(int i6=0;i6<=2;i6++) {
								for(int i7=0;i7<=2;i7++) {
									for(int i8=0;i8<=2;i8++) {
										for(int i9=0;i9<=2;i9++) {
											counter++;
											board[0][0]=translate(i1);
											board[0][1]=translate(i2);
											board[0][2]=translate(i3);
											board[1][0]=translate(i4);
											board[1][1]=translate(i5);
											board[1][2]=translate(i6);
											board[2][0]=translate(i7);
											board[2][1]=translate(i8);
											board[2][2]=translate(i9);
											print(board);
											System.out.println("------------------");
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	private static void print(char[][] board) {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static char translate(int i) {
		if(i==0) return '-';
		else if(i==1) return 'X';
		else if(i==2) return 'O';
		else
		return 0;
			
		
	}

}
