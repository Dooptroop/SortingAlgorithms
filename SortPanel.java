package SortingAlgorithms;

import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortPanel extends JPanel {

	
	public SortPanel() {
		
		SortCanvas canvas = new SortCanvas(500,300);
		add(canvas);
		
	}
	// Main method
    public static void main(String[] args) {
	JFrame myApp = new JFrame("Sorting GUI");
	SortPanel myPanel = new SortPanel();
	myApp.add(myPanel);
	myApp.pack();
	myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myApp.setSize(635, 385);
	myApp.setVisible(true);
	myApp.setResizable(false);
	myApp.setLocationRelativeTo(null);
    } // end Main
}
