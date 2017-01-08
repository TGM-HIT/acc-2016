package Main;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * 
 * @author Michael Ebenstein
 * @version 17-12-2016
 *
 * Functions as Frame for Panel class
 */
public class View extends JFrame{
	private Quiz m;
	private Controller c;
	
	/**
	 * Sets attributes to shared objects. Makes default Frame operations
	 * @param m	shared Model
	 * @param c shared Controller
	 */
	public View(Quiz m,Controller c){
		super();
		this.m = m;
		this.c = c;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("View");
		
		this.setPreferredSize(new Dimension(600, 800));
		
		this.setVisible(true);
	}
	
}
