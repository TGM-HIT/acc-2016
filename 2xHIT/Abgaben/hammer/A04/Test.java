import java.util.*;
/**
 * Diese Klasse testet die Klassen Spielzeug und Spielzeuglade und deren Objekte.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-12
 */
public class Test {
    public static void main (String[] args) {
        //Spielzeugobjekte
        Spielzeug sz1 = new Spielzeug("Mr. Teddy", 0, 99);
        Spielzeug sz2 = new Spielzeug("Barbie", 6, 20);
        Spielzeug sz3 = new Spielzeug("Rennauto", 6, 40);
        
        //Spielzeuglade
        Spielzeuglade szl = new Spielzeuglade(2);   //Testen von bereits vollen Schubladen
        //Spielzeuglade sz1 = new Spielzeuglade(4); //zum Testen von nicht vollen Schubladen
        
        //Hinzufügen der Spielzeuge zur Schublade
        szl.hinzufuegen(sz1);
        szl.hinzufuegen(sz2);
        szl.hinzufuegen(sz3);
        
        //Ausgabe
        System.out.println("\n" + szl.toString());
    }
}
