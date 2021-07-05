package tictactoe;

import Lifegame.Board;

public class OptimalMove {
	static class Move{
		int row, col;
	}
	
	static char player='X', opponent='O';
	
	//return false if there are no moves left to play
	
	static boolean isMovesLeft(char[][] board) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]=='-')
					return true;
			}
		}
		return false;
	}
	
	
	//evaluation funtion
	
	private static int evaluate(char[][] board) {

		// check for row victory x or o

		for (int r = 0; r < 3; r++) {

			if (board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
				if (board[r][0] == 'X') {
					return +10;
				} else if (board[r][0] == 'O') {
					return -10;
				}
			}
		}

		// check for col victory for x or o

		for (int c = 0; c < 3; c++) {

			if (board[0][c] == board[1][c] && board[1][c] == board[2][c]) {

				if (board[0][c] == 'X') {
					return +10;
				} else if (board[0][c] == 'O') {
					return -10;
				}
			}
		}

		// check for diagonals victory for x or o

		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {

			if (board[0][0] == 'X') {
				return +10;
			} else if (board[0][0] == 'O') {
				return -10;
			}
		}

		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {

			if (board[0][2] == 'X') {
				return +10;
			} else if (board[0][2] == 'O') {
				return -10;
			}
		}

		// if non of them return 0
		return 0;

	}
	
	
	static int minimax(char[][] board, int depth, Boolean isMax){
		
		int score=evaluate(board);
		
		//maximiser win the game
		if(score==10)
		return score;
		
		//minimiser win the game
		if(score==-10)
			return score;
		
		//no winner; tie
		if (isMovesLeft(board)==false)
			return 0;
		
		
		//if this is maximiser move
		
		if(isMax) {
			int best=-1000;
			for(int i=0;i<3;i++) {
				for(int j=0; j<3;j++) {
					
					if (board[i][j]=='-') {
						//make a move
						board[i][j]=player;// place X on the board
						//call minimax recursively and choose best value
						best=Math.max(best, minimax(board, depth+1, !isMax));
						//undo the move
						board[i][j]='-';
					}
					
				}
			}
			return best;
		}
		else {
			int best=1000;
			for(int i=0;i<3;i++) {
				for(int j=0; j<3;j++) {
					
					if (board[i][j]=='-') {
						//make a move
						board[i][j]=opponent;// place X on the board
						//call minimax recursively and choose best value
						best=Math.min(best, minimax(board, depth+1, !isMax));
						//undo the move
						board[i][j]='-';
					}
					
				}
			}
			return best;
		}
		}
	
	private static Move findBestMove(char[][] board) {
		int bestVal=-1000;
		Move bestMove=new Move();
		bestMove.row=-1;
		bestMove.col=-1;
		
		//travers all board and evaluate minimax function for all empthy cells;
		// return cell optimal value
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				 if(board[i][j]=='-') {
					 board[i][j]=player;
					 //compute evaluation function for this move
					 
					 int moveVal=minimax(board,0,false);
					 
					 //undo the move
					 board[i][j]='-';
					 
					 // if the current move value is more than bestValue then apdate the bestVal
					 if(moveVal>bestVal) {
						 bestMove.row=i;
						 bestMove.col=j;
						 bestVal=moveVal;
					 }
				 }
			}
			
		}
		
		System.out.println("The value for the best move is: "+bestVal);
		
		return bestMove;
	}

	private static void print(char[][] board) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	
	public static void main(String[] args) {
		char board[][] = { 
				{ 'X', 'X', 'O' }, 
				{ '-', 'O', 'X' }, 
				{ 'X', '-', '-' } };
		print(board);
		Move bestMove=findBestMove(board);
		
		System.out.println("Row:"+bestMove.row);
		System.out.println("Col:"+bestMove.col);

	}
}
