
/**
 * Klasse in der Spielzeuge erschaffen werden und die Spielzeuglade gefüllt wird
 * @author Sebastian Grünewald 
 * @version 12-12-2016
 */

public class Spielzeug {
    /** Attribute für Spielzeuge */
    String name;
    int minAlter;
    int maxAlter;

    /** Spielzeugkonstruktor */
    public Spielzeug (String name, int min, int max) {
        this.name = name;
        this.minAlter = min;
        this.maxAlter = max;
    }

    /** Main-Methode */
    public static void main (String[] args) {
        Spielzeuglade lade = new Spielzeuglade(5);

        Spielzeug s1 = new Spielzeug("Pulli",5,99);
        Spielzeug s2 = new Spielzeug("Auto",2,10);
        Spielzeug s3 = new Spielzeug("Handy",10,70);
        Spielzeug s4 = new Spielzeug("LEGO",5,17);
        Spielzeug s5 = new Spielzeug("Laptop",13,70);

        lade.add(s1);
        lade.add(s2);
        lade.add(s3);
        lade.add(s4);
        lade.add(s5);

        lade.print();
    }
}
