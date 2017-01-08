package main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A panel for the user input at the beginning
 * 
 * 
 * @author Peter Fuchs
 * @version 19 Dec 2016
 */
@SuppressWarnings("serial")
public class OptionsPanel extends JPanel {
	private Controller c;
	
	private JTextField anzahlTeilnehmer, maxRunden;
	private JTextField[] teilnehmerTf;
	private JButton startGame;
	
	private int teilnehmer;
	
	/**
	 * Constructor
	 * 
	 * @param c - {@linkplain Controller}
	 * @param teilnehmer the number of teilnehmer
	 */
	public OptionsPanel(Controller c, int teilnehmer) {
		this.c = c;
		this.teilnehmer = teilnehmer;
		
		this.setLayout(new GridLayout(0, 2));
		
		add(new JLabel("Anzahl der Teilnehmer:"));
		this.anzahlTeilnehmer = new JTextField();
		this.anzahlTeilnehmer.addKeyListener(this.c);
		this.anzahlTeilnehmer.addFocusListener(this.c);
		add(anzahlTeilnehmer);
		
		teilnehmerTf = new JTextField[this.teilnehmer];
		for (int i = 0; i < this.teilnehmer; i++) {
			add(new JLabel("Teilnehmer " +(i+1)));
			teilnehmerTf[i] = new JTextField();
			teilnehmerTf[i].addKeyListener(this.c);
			teilnehmerTf[i].addFocusListener(this.c);
			add(teilnehmerTf[i]);
		}
		
		add(new JLabel("Maximale Runden: "));
		this.maxRunden = new JTextField();
		this.maxRunden.addKeyListener(this.c);
		this.maxRunden.addFocusListener(this.c);
		add(maxRunden);
		
		startGame = new JButton("Starten");
		startGame.addActionListener(this.c);
		startGame.setEnabled(false);
		add(startGame);
	}

	/**
	 * Checks if one of the TextFields has an incorrect input
	 * @param source the Object to compare
	 */
	public void checkTfs(Object source) {		
		if (source.equals(this.anzahlTeilnehmer))
			try {
				int teilnehmer = Integer.parseInt(anzahlTeilnehmer.getText());
				if (this.teilnehmer == teilnehmer)
					return;
				if (teilnehmer < 1 || teilnehmer > 10)
					throw new NumberFormatException();
				
				this.teilnehmer = teilnehmer;
				this.c.repaint(this);
			} catch (NumberFormatException e) {
				this.anzahlTeilnehmer.setText("");
			}
		else if (source.equals(this.maxRunden))
			try {
				int maxRunden = Integer.parseInt(this.maxRunden.getText());
				if (maxRunden < 1 || maxRunden > 10)
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				this.maxRunden.setText("");
			}
		for (JTextField tf : teilnehmerTf)
			if (tf.getText().equals("") || this.maxRunden.getText().equals("") || this.anzahlTeilnehmer.equals(""))
				this.startGame.setEnabled(false);
			else this.startGame.setEnabled(true);
	}
	
	/**
	 * @return the teilnehmer
	 */
	public int getTeilnehmer() {
		return this.teilnehmer;
	}
	
	/**
	 * @return the anzahlTeilnehmer
	 */
	public JTextField getAnzahlTeilnehmer() {
		return anzahlTeilnehmer;
	}

	/**
	 * @param anzahlTeilnehmer the anzahlTeilnehmer to set
	 */
	public void setAnzahlTeilnehmer(JTextField anzahlTeilnehmer) {
		this.anzahlTeilnehmer = anzahlTeilnehmer;
	}

	/**
	 * @return the maxRunden
	 */
	public JTextField getMaxRunden() {
		return maxRunden;
	}

	/**
	 * @param maxRunden the maxRunden to set
	 */
	public void setMaxRunden(JTextField maxRunden) {
		this.maxRunden = maxRunden;
	}

	/**
	 * Checks if one of the buttons got activated
	 * @param source the Object to compare
	 */
	public void checkButtons(Object source) {
		if (source.equals(this.startGame))
			this.c.startGame(this.teilnehmerTf);
	}
}
