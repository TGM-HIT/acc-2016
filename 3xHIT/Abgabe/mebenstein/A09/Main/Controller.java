package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Michael Ebenstein
 * @version 17-12-2016
 * 
 * Creates Model, View and Panel and sets them up. 
 * Provides functionality for ActionListener
 * 
 */
public class Controller implements ActionListener{
	private Race m;
	private View v;
	private Panel currentPanel;
	
	/**
	 * Instantiates attributes and sets them up. 
	 */
	public Controller(){
		this.m = new Race(3,2,"eq.txt");
		System.out.println("New race with "+m.getMaxRounds()+" rounds and "+m.getParticipants()+" participants");
		this.v = new View(m,this);
		this.currentPanel = new Panel(m,this);
		
		this.v.add(this.currentPanel);
		this.v.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == currentPanel.getNext()){
			currentPanel.next();
		}
		
	}
	
	
	
}
