import java.util.*;
/**
 * Diese Klasse enthält ein Programm zum optischen Drehen von Rastern sowie Methoden dafür.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-20
 */
public class Raster {
    /**
     * Die main-Methode führt das Programm mit dem Drehen des Rasters aus.
     */
    public static void main (String[] args) {
        //Array aus der Angabe
        //char[][] array = { {'-', '-', '-', 'o', '-'}, {'-','o','-','-','-'}, {'-', '-', '-', 'o', '-'}, {'-','o','-','-','-'} };
        System.out.println("Wollen Sie die Werte für Zeilen / Spalten selbst bestimmen? (j/n)");
        Scanner sc = new Scanner (System.in);
        String jn = sc.nextLine();
        jn = jn.toLowerCase();  //Für den Fall dass zB 'Ja'/'J' statt 'ja'/'j' eingegeben wurde
        
        //char Array für das Raster
        char[][] array;
        
        //Je nach Angabe des Benutzers
        if (jn.charAt(0)=='j') {
            //den Benutzer die Zeilen/Spalten angeben lassen
            System.out.println("\nAnzahl Zeilen:");
            sc = new Scanner (System.in);
            int zeilen = sc.nextInt();
            
            System.out.println("\nAnzahl Spalten:");
            sc = new Scanner (System.in);
            int spalten = sc.nextInt();
            
            array = Raster.zufall(zeilen,spalten);
        } else {
            //Oder ein zufälliges Raster erstellen
            array = Raster.zufall();
        }
        
        
        //Array zur Vereinfachung der Ausgabe
        String[] ausgaben = {"Start:", "90°:", "180°:", "270°:", "360° (Ausgangsposition):"};
        
        //Ausgabe
        for (int i = 0; i < ausgaben.length; i++) {
            if (i!=0) {     //Beim ersten Durchlauf soll mal das eingebene Array/Ursprung ausgegeben werden
                array = Raster.drehung(array);
            }
            
            System.out.println("\n\n"+ausgaben[i]); 
            for (int ze = 0; ze < array.length; ze++) {     //Ausgabe des Arrays
                for (int sp = 0; sp < array[ze].length; sp++) {
                    System.out.print(" | "+array[ze][sp]);
                }
                System.out.print(" |\n");   //Raster schließen und nächste Zeile
            }
        }
    }

    /**
     * Diese Methode dreht das Array optisch um 90° nach rechts.
     * 
     * @param array1 das Array das gedreht werden soll
     * @return array2 das gedrehte Array
     */
    public static char[][] drehung (char[][] array1) {
        char[][] array2 = new char[array1[0].length][array1.length];    //für den Fall, dass es kein gleichmäßiges Array ist
        int sp1 = array2[0].length-1;   //Variable die runter zählt, da die erste Zeile von array1 
        //in die letzte Spalte von array2 kommt
       
        for (int ze = 0; ze < array1.length; ze++) {    //Durchgehen des Arrays und speichern der jeweiligen Werte in ihrer Postion im array2
            for (int sp2 = 0; sp2 < array1[ze].length; sp2++) {
                array2[sp2][sp1] = array1[ze][sp2];
            }
            sp1--;  //Spalte von array2 runterzählen
        }
        
        //Zurückgeben des gedrehten Arrays
        return array2;
    }
    
    
    /**
     * Erzeugt ein Array mit zufälligen Spalten und Zeilen und Werten.
     * 
     * @return das erstellte/befüllte Array
     */
    public static char[][] zufall () {
        //Zufallszahlen
        Random r = new Random();
        int ze = r.nextInt(10)+1;    //0-9 -> 1-10
        r = new Random();
        int sp = r.nextInt(10)+1;    //0-9 -> 1-10
        
        char[][] array = Raster.zufall(ze,sp);  //Nutzen der anderen Methode hierfür
        return array;
    }
    
    /**
     * Erzeugt ein zufälliges Array mit gegebener Spalten/Zeilenanzahl, aber zufälligen Werten.
     * 
     * @param ze Zeilenanzahl
     * @param sp Spaltenanzahl
     * @return das erstellte/befüllte Array
     */
    public static char[][] zufall (int ze, int sp) {
        //Zufallszahlen variablen
        Random rn = new Random();
        int i; 
        //Zeichenarray für die beiden verfügbaren Zeichen
        char[] zeichen = {'-', 'o'};
        char[][] array = new char[ze][sp];  //Erzeugung des Arrays
        
        //Zuweisung der Werte
        for (int z = 0; z < ze; z++) {
            for (int s = 0; s < sp; s++) {
                i = rn.nextInt(2); //2 exklusive -> 0-1
                array[z][s] = zeichen[i];
            }
        }
        
        return array;
    }
}
