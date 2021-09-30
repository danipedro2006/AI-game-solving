package Hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

class Tower{
	 
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
		for(int i=0;i<numOfDisks;i++) {
			int diskVal=0;
			diskVal=disks.get(i);
			int width=diskVal*20;
			int lastX,lastY;
			lastX=this.xPos-width/2;;
			lastY=this.yPos-i*20;
			g.setColor(Color.BLUE);
			g.fillRoundRect(lastX, lastY, width, 10, 10, 10);
		}
		g.setColor(Color.BLUE);
		g.drawString(this.Name, this.xPos, this.yPos+30);
	}

	public int removeDisk() {
		int lastElem=disks.size();
		int retVal=0;
		if(lastElem>0) {
			retVal=disks.get(lastElem-1);
			disks.remove(lastElem-1);
		}
		return retVal;
	}

	public void addDisk(int diskVal) {
		disks.add(diskVal);
		
	}
}