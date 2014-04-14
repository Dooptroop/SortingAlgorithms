package SortingAlgorithms;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SortPanel extends JPanel implements ActionListener {
	
	// Radio Buttons for Algorith selection.
	private JPanel algPanel = new JPanel();
	private ButtonGroup algBtnGroup = new ButtonGroup();
	private JRadioButton bubble = new JRadioButton("BubbleSort", true);
	private JRadioButton selection = new JRadioButton("SelectionSort");
	private JRadioButton insertion = new JRadioButton("InsertionSort");
	
	// Radio Buttons for speed selection.
	private JPanel spdPanel = new JPanel();
	private ButtonGroup spdBtnGroup = new ButtonGroup();
	private JRadioButton slow = new JRadioButton("BubbleSort", true);
	private JRadioButton medium = new JRadioButton("SelectionSort");
	private JRadioButton fast = new JRadioButton("InsertionSort");
	
	// buttons for Reset, and Start
	private JPanel funcPanel = new JPanel();
	protected JButton reset = new JButton("Reset");
	protected JButton start = new JButton("start");
	
	SortCanvas canvas = new SortCanvas(500,300);
	private int bars;
	
	public SortPanel() {
		//add to button groups
		algBtnGroup.add(bubble);
		algBtnGroup.add(selection);
		algBtnGroup.add(insertion);
		spdBtnGroup.add(slow);
		spdBtnGroup.add(medium);
		spdBtnGroup.add(fast);
		
		
		// add to selection panel
		algPanel.add(bubble);
		algPanel.add(selection);
		algPanel.add(insertion);
		spdPanel.add(slow);
		spdPanel.add(medium);
		spdPanel.add(fast);
		
		
		funcPanel.add(reset);
		funcPanel.add(start);
		
		
		// add to SortPanel
		add(algPanel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		add(spdPanel, BorderLayout.EAST);
		add(funcPanel, BorderLayout.SOUTH);
		
		
		// add Action Listeners
		reset.addActionListener(this);
		start.addActionListener(this);
		
		
		
	}
	public void start(){
		//int bars = Integer.parseInt(textfield.getText());
	    canvas.setBars(bars);
	    canvas.sort(getSortType(), getDelaySpeed());
	    start.setEnabled(false);
	    reset.setEnabled(false);
	}
	private int getDelaySpeed() {return canvas.getSpeed();}
	private int getSortType() {return canvas.getSortType();}
	
	public void actionPerformed(ActionEvent action) {
		if (action.getSource() == start) {start();}
		else if(action.getSource() == reset) {canvas.reset();}
		
	}
	
	
	// Main method
    public static void main(String[] args) {
	JFrame myApp = new JFrame("Sorting GUI");
	SortPanel myPanel = new SortPanel();
	myApp.add(myPanel);
	myApp.pack();
	myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myApp.setSize(635, 445);
	myApp.setVisible(true);
	myApp.setResizable(false);
	myApp.setLocationRelativeTo(null);
    } // end Main
	
}
