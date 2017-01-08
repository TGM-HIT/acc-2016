/**
 * Spielzeug ist die Klasse für Objekte des Typs Spielzeug.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-12
 */
public class Spielzeug {
    //ATTRIBUTE
    private String name = "";
    private int minalter;
    private int maxalter;
    
    //KONSTRUKTOR
    /**
     * Dieser Konstruktor erzeugt ein Spielzeug Objekt.
     * 
     * @param name der Name des Spielzeugs
     * @param minalter das Mindestalter des Spielzeugs
     * @param maxalter das Alterslimit des Spielzeugs
     */
    public Spielzeug (String name, int minalter, int maxalter) {
        this.name = name;
        
        //falls die Werte der Parameter ungültig sind, damit die Attribute dennoch zugewiesen wurden.
        this.minalter = 0;  
        this.maxalter = 100;
        
        //Wenn das Mindestalter im gültigen Bereich liegt und außerdem kleiner ist als das Alterslimit...
        if (minalter >= 0 && minalter <= 100 && minalter < maxalter) {
            this.minalter = minalter;   //... Wert dem Attribut zuweisen
        }
        
        //Wenn das Alterslimit im gültigen Bereich liegt und außerdem größer ist als das Mindestalter...
        if (maxalter >= 0 && maxalter <= 100 && maxalter > minalter) {
            this.maxalter = maxalter;   //... Wert dem Attribut zuweisen
        }
    }
    
    //METHODEN
    /**
     * Diese Methode wandelt die Information über die Spielzeuge in ein String um.
     * 
     * @return Text mit Name und Mindestalter-Alterslimit.
     */
    public String toString () {
        String text = name + " (" + minalter + "-" + maxalter + " Jahre)";
        return text;
    }
}
