package SortingAlgorithms;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

public class SortCanvas extends Canvas implements Runnable {

	private Graphics g;
	private int bars = 15;
	private int[] barsArray;
	private int space=2;
	private int sortType;
	private int delay;
	
	public SortCanvas(int w, int h) {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(w, h));
	}
	public void sort(int sortType, int delay) {
		this.sortType = sortType;
		this.delay = delay;
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		createBarArray();
		paintBars(g,bars);
	}

	private void paintBars(Graphics g, int bars) {
		g.setColor(Color.GREEN);
		for(int x=5, index=0; x<getWidth(); x+=getWidth()/bars, index++){
				g.fillRect(x, getHeight()-barsArray[index], getWidth()/bars-space, getHeight());
		}
		
	}
	private void createBarArray(){
		barsArray = new int[bars];
		for(int i=0; i<barsArray.length; i++){
			barsArray[i]=(int)(Math.random()*getHeight());
			System.out.println(barsArray[i]);
		}
	}

	@Override
	public void run() {
		
		repaint();//repaints the screen
		try { // try to sleep. if not throw exception to stack trace.
			Thread.sleep(17);// try sleep for 17 milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();// print to stack
		}
		
		
	}
	public void setBars(int bars) {
		this.bars=bars;
	}
	public int getSortType() {
		return sortType;
		
	}
	public int getSpeed() {
		return delay;
	}
	public void reset() {
		createBarArray();
		repaint();
	}
	
}
