package SortingAlgorithms;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

public class SortCanvas extends Canvas {

	private Graphics g;
	private int bars = 15;
	private int[] barsArray;
	
	public SortCanvas(int w, int h) {
		setPreferredSize(new Dimension(w, h));
		createBarArray();
	}

	public void paint(Graphics g){
		super.paint(g);
		paintBars(g,bars);
	}

	private void paintBars(Graphics g, int bars) {
		g.setColor(Color.RED);
		for(int x=5, index=0; x<getWidth(); x+=getWidth()/bars, index++){
			g.fillRect(x, getHeight()-barsArray[index], getWidth()/bars, getHeight());
		}
		
	}
	private void createBarArray(){
		barsArray = new int[bars];
		for(int i=0; i<barsArray.length; i++){
			barsArray[i]=(int)(Math.random()*getHeight());
		}
	}
}
