package SortingAlgorithms;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferStrategy;


public class SortCanvas extends Canvas implements Runnable {
	private Thread thread;
	private Graphics g;
	private int height, width;
	private int bars = 15;
	private int[] barsArray;
	private int space=2;
	private int sortType=0;
	private int delay=75;
	private Color BAR_COLOR;
	
	public SortCanvas(int w, int h, SortPanel panel) {
		this.height=h; this.width=w;
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		createBarArray();
		BAR_COLOR=Color.green;
		repaint();
	}
	public void sort() {
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(BAR_COLOR);
		paintBars(g, bars);
		
	}

	public void paintBars(Graphics g, int bars) {
		System.out.println("paintbars");
		g.setColor(BAR_COLOR);
		
		for(int x=5, index=0; x<getWidth(); x+=getWidth()/bars, index++){
				g.fillRect(x, getHeight()-barsArray[index],
						getWidth()/bars-space, getHeight());
		}
		
		
	}
	public void draw(int index1, int index2, int index3) {
		BufferStrategy buffer = getBufferStrategy();
		System.out.println("draw");
		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}
		g = buffer.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(BAR_COLOR);
		for (int i = 0, k = 0; i < barsArray.length; i++, 
				k += getWidth()/ barsArray.length) {
			if (index1 == i) {
				this.BAR_COLOR=(Color.RED);
				System.out.println("RED");
			}
			if (index2 == i) {
				this.BAR_COLOR=(Color.GREEN);
				System.out.println("GREEN");
			}
			if (index3 == i) {
				this.BAR_COLOR=(Color.BLUE);
				System.out.println("BLUE");
			}
			g.fillRect(k + 5, getHeight() - barsArray[i] * 15,
					getWidth() / barsArray.length - 1, getHeight() * 2);
			this.BAR_COLOR=(Color.green);
		}
		g.dispose();
		buffer.show();
		repaint();
	}
	public void createBarArray(){
		barsArray = new int[bars];
		for(int i=0; i<barsArray.length; i++){
			barsArray[i]=(int)(Math.random()*height);
			System.out.println(barsArray[i]);
		}
	}

	@Override
	public void run() {
		
		try {
		    switch (sortType) {
			    case 0:
			    	(new Sorting()).bubbleSort(barsArray, delay, this);
			    	break;
			    case 1:
			    	(new Sorting()).quickSort(barsArray, 0,
					barsArray.length - 1, delay, this);
			    	break;
			    case 2:
			    	(new Sorting()).insertionSort(barsArray, delay, this);
			    	break;
			    case 3:
			    	(new Sorting()).selectionSort(barsArray, delay, this);
			    	break;
		    }
		} catch (InterruptedException ie) {
		    ie.printStackTrace();
		}
		SortPanel.start.setEnabled(true);
		SortPanel.reset.setEnabled(true);
		
	}
	public void setBars(int bars) {this.bars=bars;}
	public int getSortType() {return sortType;}
	public void setSortType(int sort) {this.sortType=sort;}
	public int getSpeed() {return delay;}
	public void setSpeed(int speed) {delay = speed;} 
	public void reset() {
		createBarArray();
		repaint();
	}
	public int getBars() { return bars; }

	
	
}
