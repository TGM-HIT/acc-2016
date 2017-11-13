package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Provides the game for the user!
 * 
 * 
 * @author Peter Fuchs
 * @version 19 Dec 2016
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	private Rennen rennen;
	private Controller c;
	
	private JLabel aktTeilnehmer;
	private JButton start;
	private Teilnehmer akt;
	
	private JTextArea stats;
	
	private JTextField ergebnis;
	private JButton solve;
	private long startTime;
	private long endTime;
	
	private JPanel south;
	
	/**
	 * Constructor<br>
	 * Creates a Panel where the user can play
	 * 
	 * @param rennen the model
	 * @param controller the controller
	 */
	public GamePanel(Rennen rennen, Controller controller) {
		this.rennen = rennen;
		this.c = controller;
		
		setLayout(new BorderLayout());
		
		this.akt = rennen.getAktTeilnehmer();
		this.aktTeilnehmer = new JLabel("Aktueller Teilnehmer ist: " + akt.getName(), SwingConstants.CENTER);
		add(aktTeilnehmer, BorderLayout.NORTH);
		
		this.stats = new JTextArea();
		this.stats.setEditable(false);
		HashSet<Teilnehmer> teilnehmer = this.rennen.getTeilnehmer();
		String stats = "Aktueller Stand:\n";
		for (Teilnehmer t : teilnehmer)
			stats += t.getName() + ": " +t.getPunkte()+"\n\n";
		this.stats.setText(stats);
		add(this.stats);
		
		south = new JPanel();
		south.setLayout(new BorderLayout());
		this.start = new JButton("Runde starten");
		start.addActionListener(this.c);
		south.add(this.start);
		add(south, BorderLayout.SOUTH);
	}

	/**
	 * Checks if one of the buttons got activated
	 * @param source the source to compare
	 */
	public void checkButtons(Object source) {
		if (source.equals(this.start)) {
			south.removeAll();
			south.setLayout(new FlowLayout());
			south.add(new JLabel("Die Rechnung ist "+rennen.rechnung()+": "));
			this.ergebnis = new JTextField(10);
			this.ergebnis.addKeyListener(this.c);
			south.add(this.ergebnis);
			this.solve = new JButton("Solve");
			this.solve.addActionListener(this.c);
			south.add(this.solve);
			startTime = System.currentTimeMillis();
			add(south, BorderLayout.SOUTH);
			
			this.c.repaint(this, false);
		} else if (source.equals(this.solve)) {
			checkResult();
			if (this.rennen.exit) {
				this.c.over();
				return;
			}
		}
	}

	/**
	 * Checks if the input of the user is the result
	 */
	private void checkResult() {
		try {
			int result = Integer.parseInt(this.ergebnis.getText());
			if (result == rennen.getResult()) {
				endTime = System.currentTimeMillis();
				double time = (endTime-startTime)/1000.0;
				this.rennen.addPunkte(time);
			} else this.rennen.addPunkte(30);
		} catch (NumberFormatException e) {
			this.rennen.addPunkte(30);
		}
		this.c.repaint(this, true);
	}

	/**
	 * Checks if one of the TextFields was written
	 * @param source the Object to compare
	 */
	public void checkTfs(Object source) {
		if (source.equals(this.solve)) {
			checkResult();
		}
	}
}
