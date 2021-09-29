package Hanoi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hannoi{
	int numdisks;
	Tower t1,t2,t3;
	JFrame frame;
	JPanel panel=new JPanel();
	private int depth;
	private int speed;
	
	public Hannoi(int depth, int speed) {
		t1=new Tower(depth,"A");
		this.depth = depth;
		this.speed = speed;
		 
	}

	public void paintComponent(Graphics g) {
		 
		g.setColor(Color.BLUE);
		t1.addDisks(depth);
		t1.paint(g);
	}
	private void start() {
		Hannoi panel=new Hannoi(numdisks,3); 
		frame=new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(t1);
		
		
		frame.setVisible(true);
		frame.setSize(500,300);
		frame.setLocation(375,55);
		t1.setPosition(100, 200);
		frame.repaint();
	}
	
	public static void main(String[] args) {
		int numdisks=7;
		int speed=1;
		Hannoi game=new Hannoi(numdisks,3);
		game.start();
	}
}
