package gamesolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Boggle {
	
	private Board board;
	private BoggleSolver solver;

	public Boggle(String input) {
		
		board = buildBoard(input);
		solver = new Solver();
	}

	private Board buildBoard(String input) {
		List<Node> nodes = new ArrayList<Node>(input.length());
		int dimension = (int) Math.sqrt(input.length());
		for (int i = 0; i < input.length(); i++) {
			nodes.add(buildNode(input.charAt(i), new Position(i / dimension, i % dimension), dimension));
		}
		return new Board(nodes);
	}

	private Node buildNode(char value, Position position, int dimension) {
		return new Node(value, position, getNeighbours(position, dimension));
	}

	private List<Position> getNeighbours(Position position, int dimension) {
		int[] directions = { -1, 0, 1 };
		List<Position> neighbours = new ArrayList<Position>();
		
		for (int rowDiff : directions) {
			for (int colDiff : directions) {
				
				Position neighbour = new Position(position.getRow() + rowDiff, position.getColumn() + colDiff);
				if (!position.equals(neighbour) && validPosition(neighbour, dimension)) {
					neighbours.add(neighbour);
				}
			}
		}
		
				
		return neighbours;
		}
		

	private boolean validPosition(Position position, int dimension) {
		return inRange(position.getRow(), dimension) && inRange(position.getColumn(), dimension);
	}

	private boolean inRange(int x, int dimension) {
		return x >= 0 && x < dimension;
	}

	public void solve() throws IOException {
		List<String> foundWords = solver.solve(board);
		for (String foundWord : foundWords) {
			System.out.println(foundWord+ " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
				
			new Boggle(args[0]).solve();
		}
	
		
	}


