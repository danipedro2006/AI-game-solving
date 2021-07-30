package sudoku;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Board extends JPanel{
	
	private static JTextField[][] cells;
	
	
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Sudoku Board");
				
		JPanel board=new JPanel();
		frame.add(board);
		JPanel panel=new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel grid=new JPanel();
		panel.add(grid);
		grid.setLayout(new GridLayout(9,9));
		board.add(grid);
		
		
		cells=new JTextField[9][9];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				cells[i][j]=new JTextField(2);
				cells[i][j].setHorizontalAlignment(JTextField.CENTER);
				grid.add(cells[i][j]);
			}
		}
		
		
		
		
		
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
