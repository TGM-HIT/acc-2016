import java.util.Random;

/**
 * Es sollen Rechen Rennen durchgefuehrt werden und pro Benutzer sollen seine erreichten Punkte gespeichert werden.
 * 
 * @author David Maniak
 * @version 19.12.2016
 */
public class Rennen {
	private int currentRounds, maxPeople, maxRounds;
	private int[][] spieler;
	private RennenUI ui;
	
	/**
	 * Konstruktor bei dem die Spieler-&Rundenanzahl gesetzt werden kann.
	 * 
	 * @param maxPeople die Spieleranzahl
	 * @param maxRounds die Rundenanzahl
	 * @param ui die zugehoerige UI
	 */
	public Rennen(int maxPeople, int maxRounds, RennenUI ui) {
		this.ui = ui;
		this.maxPeople = maxPeople;
		this.maxRounds = maxRounds;
		currentRounds = 0;
		
		ui.restart.setEnabled(true);
		ui.nextRound.setEnabled(true);
		ui.start.setEnabled(false);
		
		spieler = new int[maxPeople][1];
		//Punktestand wird auf 0 gesetzt
		for (int i = 0; i < spieler.length; i++) {
			spieler[i][0] = 0;
		}
		
		nextRound();
	}
	
	/**
	 * Es wird ein Beispiel fuer die naechste Runde ausgerechnet und die Spieler werden mit ihren Punkten angezeigt.
	 */
	public void nextRound() {
		ui.score.setText("");
		ui.nextRound.setEnabled(false);
		
		if(currentRounds == maxRounds) {
			ui.score.append("====================\nAlle Runden vorbei\n====================\n");
			finalScore();
			return;
		}
		
		ui.score.append(generate() + "\n====================\n");
		
		for (int i = 0; i < maxPeople; i++) {
			int points = randNum(maxPeople * 2);
			
			ui.score.append("Spieler " + (i + 1) + " hat es geloest. (" + points + " Punkte)\n");
			spieler[i][0] += points;
		}
		
		ui.score.append("====================\nAlle Teilnehmer sind fertig.\n====================\n");
		ui.nextRound.setEnabled(true);
		currentRounds++;
	}
	
	/**
	 * Wenn alle Runden fertig sind, dann werden die Endergebnisse angezeigt
	 */
	public void finalScore() {
		for (int i = 0; i < spieler.length; i++) {
			ui.score.append("Teilnehmer " + (i + 1) + " hat " + spieler[i][0] + " Punkt(e).\n");
		}
	}
	
	/**
	 * Setzt alle Knoepfe und Textfelder zurueck.
	 */
	public void reset() {
		ui.score.setText("");
		
		ui.player.setText("");
		ui.maxRounds.setText("");
		
		ui.multi.setSelected(true);
		ui.divi.setSelected(true);
		ui.plus.setSelected(true);
		ui.minus.setSelected(true);
		ui.modulo.setSelected(true);
		
		ui.start.setEnabled(true);
		ui.nextRound.setEnabled(false);
		ui.restart.setEnabled(false);
	}
	
	/**
	 * Die zu loesende Rechnung wird erstellt.
	 * 
	 * @return die Rechenaufgabe
	 */
	public String generate() {
		String x = "";
		
		//Ueberprueft welche Rechenoperatoren gewaehlt wurden
		if(ui.multi.isSelected())
			x += "*";
		if(ui.divi.isSelected())
			x += "/";
		if(ui.plus.isSelected())
			x += "+";
		if(ui.minus.isSelected())
			x += "-";
		if(ui.modulo.isSelected())
			x += "%";
		
		if(x.equals(""))
			new InvalidCalculationException("Es muss mindestens 1 Operator ausgaehlt sein");
		
		char[] operators = x.toCharArray();
		
		
		return "Rechnung: " + solve(randNum(100), randNum(100), operators[randNum(operators.length)]);
	}
	
	/**
	 * Rechnet die Aufgabe aus.
	 * 
	 * @param x erster Wert
	 * @param y zweiter Wert
	 * @param operator der Operator der verwendet wird
	 * 
	 * @return das Ergebnis der Rechnung
	 */
	public String solve(int x, int y, char operator) {
		switch(operator) {
		case '*':
			return x + " " + operator + " " + y + " = " + (x * y);
		case '/':
			return x + " " + operator + " " + y + " = " + ((x * 1.0) / y); //mit 1.0 multipliziert um eine Kommazahl zu bekommen
		case '+':
			return x + " " + operator + " " + y + " = " + (x + y);
		case '-':
			return x + " " + operator + " " + y + " = " + (x - y);
		case '%':
			return x + " " + operator + " " + y + " = " + (x % y);
		}
		
		throw new InvalidCalculationException("Ungueltiger Rechnung! Konnte nicht berechnet werden!");
	}
	
	/**
	 * Erzeugt eine zufaellige Zahl in einem bestimmten Bereich.
	 * 
	 * @param max der Maximalwert der Zufallszahl
	 * @return die Zufallszahl
	 */
	public int randNum(int max) {
		return new Random().nextInt(max);
	}
}
