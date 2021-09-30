package Hanoi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hannoi {
	JFrame frame;
	DrawPanel drawPanel;
	int numdisks;
	Tower t1;
	Tower t2 = new Tower(0, "B");
	Tower t3 = new Tower(0, "C");
	private int depth;
	private int speed;

	public Hannoi(int depth, int speed) {
		t1 = new Tower(depth, "A");
		this.depth = depth;
		this.speed = speed;
		frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel=new DrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.setVisible(true);
		frame.setSize(600, 300);
		frame.setLocation(375, 55);
		t1.setPosition(100, 200);
		t2.setPosition(250, 200);
		t3.setPosition(400, 200);
		solve(this.depth, 'A','B','C');
		
		
	}
	class DrawPanel extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.BLUE);
			t1.paint(g);
			t2.paint(g);
			t3.paint(g);
		}
	}
	private int removeDisks(char tower) {

		int retval;
		switch (tower) {
		case 'A':
			retval = this.t1.removeDisk();
			break;
		case 'B':
			retval = this.t2.removeDisk();
			break;
		case 'C':
			retval = this.t3.removeDisk();
			break;
		default:
			retval = -1;
			break;
		}
		return retval;
	}

	private void addDisks(char tower, int val) {
		switch (tower) {
		case 'A':
			this.t1.addDisk(val);
			break;
		case 'B':
			this.t2.addDisk(val);
			break;
		case 'C':
			this.t3.addDisk(val);
			break;
		default:
			break;
		}
	}
	
	public void solve(int top, char start, char aux, char end) {
		int val=0;
		try {
			Thread.sleep(300/this.speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(top==1) {
			val=this.removeDisks(start);
			this.addDisks(end, val);
			frame.repaint();
		}
		else {
			solve(top-1, start, end, aux);
			val=this.removeDisks(start);
			this.addDisks(end, val);
			frame.repaint();
			solve(top-1, aux, start, end);
		}
	}
	

	

	public static void main(String[] args) {
		
		int numdisks = 7;
		int speed = 1;
		Hannoi game = new Hannoi(numdisks, speed);
		
		
	}
}
