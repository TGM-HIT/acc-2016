
/**
 * Spielzeuglade in der die Spielzeuge gefüllt werden
 * @author Sebastian Grünewald 
 * @version 12-12-2016
 */

public class Spielzeuglade {
    /** Attribut für Spielzeuglade */
    Spielzeug[] liste;

    /** statische Variable zum mitzählen, um zu wissen welches Array Element gefüllt werden muss */
    static int mitzählen = 0;

    /** Spielzeugladenkonstruktor */
    public Spielzeuglade (int maximalWert) {
        liste = new Spielzeug[maximalWert];
    }

    /** Ausgabemethode */
    public void print () {
        for (int i = 0; i < this.liste.length; i++) {
            System.out.println("Name: "+this.liste[i].name);
            System.out.println("Mindestalter: "+this.liste[i].minAlter);
            System.out.println("Alterslimit: "+this.liste[i].maxAlter+"\n");
        }
    }

    /**
     * Funktion um Spielzeugobjekt zu Spielzeugladenliste hinzuzufügen
     * @param s  Spielzeug welches hinzugefügt werden soll
     */
    public void add (Spielzeug s) { 
        try {
            liste[mitzählen] = s;
            mitzählen++;
        }
        catch (ArrayIndexOutOfBoundsException n) {
            System.out.println("Spielzeuglade zu klein");
        }
    }
}

