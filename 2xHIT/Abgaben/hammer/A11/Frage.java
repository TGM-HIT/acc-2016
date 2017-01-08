/**
 * Diese Klasse ist die Vorlage für Frage-Objekte.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-22
 */
public class Frage {
    //ATTRIBUTE
    private String frage;   //Frage
    private String[] antworten; //String-Array mit den Antworten
    private int a;  //der Index des String-Arrays mit der richtigen Antwort
    
    //KONSTRUKTOR
    /**
     * Konstruktor mit allen drei Attributen-Werten als Parameter.
     * 
     * @param frage die Frage
     * @param antworten die Antworten in einem Array
     * @param a der Index der richtigen Antwort (0-index wird in der set-Methode berücksichtigt)
     */
    public Frage (String frage, String[] antworten, int a) {
        this.setFrage(frage);
        this.setAntworten(antworten);
        this.setA(a);
    }
    
    //SETTER UND GETTER
    /**
     * Diese Methode setzt die Frage auf die übergebene.
     * 
     * @param frage die Frage, die gespeichert werden soll.
     */
    public void setFrage (String frage) {
        this.frage = frage;
    }
    
    /**
     * Diese Methode weist das übergebene Array dem Attribut zu.
     * 
     * @param antworten die Antworten in einem Array
     */
    public void setAntworten (String[] antworten) {
        this.antworten = antworten;
    }
    
    /**
     * Diese Methode setzt den Index der Antwort, die richtig ist.
     * 
     * @param a der Index der richtigen Antwort (0-index wird in der Methode berücksichtigt)
     */
    public void setA (int a) {
        if (a >= 0 && a < 4) {
            this.a = a-1;
        } 
    }
    
    /**
     * Diese Methode gibt die Frage als String zurück.
     * 
     * @return Frage im Stringformat
     */
    public String getFrage () {
        if (this.frage != null) {
            return this.frage;
        }
        return null;
    }
    
    /**
     * Diese Methode gibt die Antwortenmöglichkeiten formatiert als String zurück.
     * 
     * @return Antworten als String, durchnummeriert
     */
    public String getAntworten () {
        String text = "";
        if (this.antworten != null) {
            for (int i = 0; i < 4; i++) {
                if (this.antworten[i] != null) {
                    text = text+""+(i+1)+".) "+antworten[i]+"\n";
                }
            }
        }
        return text;
    }
    
    /**
     * Diese Methode gibt den Index der richtigen Frage zurück und zählt dabei plus 1, um das Anwenden
     * im Quiz zu erleichtern.
     * 
     * @return der Index der richtigen Antwort+1
     */
    public int getA() {
        return a+1;
    }
    
    //METHODEN
    public String toString() {
        String text = frage+"\n";
        text = text + this.getAntworten();
        return text;
    }
}
