package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Michael Ebenstein
 * @version 1.0
 * 
 * Creates Model, View and Panel and sets them up. 
 * Provides functionality for ActionListener
 * 
 */
public class Controller implements ActionListener{
	private Quiz m;
	private View v;
	private Panel currentPanel;
	
	/**
	 * Instantiates attributes and sets them up. 
	 */
	public Controller(){
		this.m = new Quiz("quiz.txt");
		this.v = new View(m,this);
		this.currentPanel = new Panel(m,this);
		
		this.v.add(this.currentPanel);
		this.v.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == currentPanel.getEnd()){
			currentPanel.end();
		}else{
			currentPanel.nextQuestion(source);
		}
		
		v.repaint();
		v.pack();
	}
	
	
	
}
