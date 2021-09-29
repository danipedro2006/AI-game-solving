package Hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

class Tower extends JPanel{
	JPanel panel=new JPanel();
	private String Name="";
	private  ArrayList<Integer> disks;
	private int xPos=0;
	private int yPos=0;

	public Tower(int numOfDisks,String name) {
		this.Name = name;
		this.disks =new ArrayList();
		
		while(numOfDisks>0) {
			this.addDisks(numOfDisks);
			numOfDisks--;
		}
		this.setPosition(300, 300);
	}
	
	public void setPosition(int xPos, int yPos) {
		this.xPos=xPos;
		this.yPos=yPos;
	}

	public void addDisks(int discVal) {
		disks.add(discVal);
	}

	public void paint(Graphics g) {
		int numOfDisks=disks.size();
		for(int i=0;i<numOfDisks-2;i++) {
			
			int diskVal=disks.get(i);
			int lastX=this.xPos+i*5;
			int lastY=this.yPos-i*20;
			int height=diskVal*10;
			g.setColor(Color.BLUE);
			g.fillRoundRect(lastX, lastY, height, 10, 10, 10);
			
		}
	}
}