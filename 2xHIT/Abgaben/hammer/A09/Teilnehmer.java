/**
 * Diese Klasse speichert Objekte, die die Werte für Teilnehmer eines Rennen speichern.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-18
 */
public class Teilnehmer {
    private int punkteges;  //Gesamte Punkteanzahl
    private int[] punkte;  //Punkte pro Runde
    int nr; //Teilnehmer Nummer
    
    /**
     * Konstruktor, der vor allem die Länge des Punkte-Arrays zum Speichern der einzelenen Runden-Punkte.
     * 
     * @param nr Nummer des Teilnehmers
     * @param runden die Anzahl der Runden
     */
    public Teilnehmer (int nr, int runden) {
        this.nr = nr;
        punkteges = 0;
        punkte = new int[runden];
    }
    
    /**
     * Diese Methode setzt eine Stelle des Punktearrays auf einen Wert
     * 
     * @param runde die jeweilige Runde (das Index bei 0 beginnt, wird in der Methode berücksichtigt)
     * @param p die Punktanzahl
     */
    public void setPunkte(int runde, int p) {
        punkte[runde-1] = p;
    }
    
    /**
     * Diese Methode gibt die Punkteanzahl von einer bestimmten Runde zurück.
     * 
     * @param runde die jeweilige Runde
     * @return die Punkteanzahl in dieser Runde
     */
    public int getPunkte(int runde) {
        return punkte[runde-1];
    }
    
    /**
     * Diese Methode berechnet und gibt die Gesamtpunktanzahl zurück.
     * 
     * @return die Gesamtpunktzahl
     */
    public int getPunkteges() {
        for (int i = 0; i < punkte.length; i++) {
            punkteges = punkteges + punkte[i];
        }
        return punkteges;
    }
}
