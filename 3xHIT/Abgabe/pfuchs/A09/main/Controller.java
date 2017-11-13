package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * The controller provides the interactions with the user
 * 
 * 
 * @author Peter Fuchs
 * @version 19 Dec 2016
 */
public class Controller implements KeyListener, FocusListener, ActionListener {
	/**
	 * Main-method to start the program
	 * @param args
	 */
	public static void main(String[] args) {
		new Controller();
	}
	
	private Rennen rennen;
	private OptionsPanel op;
	private GamePanel gp;
	private Frame frame;
	
	/**
	 * Constructor
	 */
	public Controller() {
		this.rennen = new Rennen();
		this.op = new OptionsPanel(this, 1);
		
		this.frame = new Frame(this.op, 200, "Starten");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Unused
	}

	/**
	 * When a key gets released, the tfs get checked if they are correct
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		this.op.checkTfs(e.getSource());
		if (this.gp != null)
			this.gp.checkTfs(e.getSource());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * If a tf looses the focus it gets checked if its value is correct
	 */
	@Override
	public void focusLost(FocusEvent e) {
		this.op.checkTfs(e.getSource());
	}

	/**
	 * Repaints the frame with a new optionsPanel
	 * @param optionsPanel the old panel
	 */
	public void repaint(OptionsPanel optionsPanel) {
		this.op = new OptionsPanel(this, optionsPanel.getTeilnehmer());
		this.op.getAnzahlTeilnehmer().setText(optionsPanel.getAnzahlTeilnehmer().getText());
		this.op.getMaxRunden().setText(optionsPanel.getMaxRunden().getText());
		this.frame.dispose();
		this.frame = new Frame(this.op, (this.op.getTeilnehmer()+3)*50, "Starten");
	}

	/**
	 * repaints the panel with a new gamepanel
	 * @param gamePanel the old panel
	 * @param restart true if the program needs to make a new panel
	 * else false
	 */
	public void repaint(GamePanel gamePanel, boolean restart) {
		if (restart)
			this.gp = new GamePanel(this.rennen, this);
		else this.gp = gamePanel;
		this.frame.dispose();
		this.frame = new Frame(this.gp, 500, "Let's play!");
	}

	/**
	 * When a button gets pressed the program checks which one got pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.op.checkButtons(e.getSource());
		if (this.gp != null)
			this.gp.checkButtons(e.getSource());
	}

	/**
	 * Starts a new game with an array of teilnehmer
	 * @param teilnehmer the array of the members of this run
	 */
	public void startGame(JTextField[] teilnehmer) {
		Teilnehmer[] pers = new Teilnehmer[teilnehmer.length];
		for (int i = 0; i < teilnehmer.length; i++)
			pers[i] = new Teilnehmer(teilnehmer[i].getText());
		
		this.rennen.setMaxRunden(Integer.parseInt(this.op.getMaxRunden().getText()));
		this.rennen.addTeilnehmer(pers);
		
		this.gp = new GamePanel(this.rennen, this);
		
		this.frame.dispose();
		this.frame = new Frame(this.gp, 500, "Let's play!");
	}

	/**
	 * When a game is over
	 */
	public void over() {
		this.frame.dispose();
		this.frame = new Frame(new EndPanel(this.rennen), 500, "It's over!");
	}
}
