import java.util.*;
/**
 * Dieses Programm führt ein Hangman Spiel aus, das ein Wort einliest und die Fehler zählt. Ab 10 Fehlern wird 
 * das Wort aufgelöst.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-18
 */
public class Hangman {
    public static void main (String[] args) {
        //EINLESEN DES ZU ERRATENDEN WORTES
        System.out.println("Bitte geben Sie das zu eratende Wort ein:");
        Scanner sc = new Scanner (System.in);
        
        //eigene Variablen für die Eingabe/kleingeschrieben Wort, damit man es später mit Groß-/Kleinschreibung ausgeben kann
        String worteingabe = sc.nextLine();
        String wort = worteingabe.toLowerCase();    //damit es nicht zwischen Klein- und Großbuchstaben unterscheiden muss
        
        char[] wortAr = new char[wort.length()];    //Array zur Ausgabe des Fortschrittes
        
        for (int i=0; i < wortAr.length; i++) {     //das Array mit "_" füllen
            wortAr[i] = '_';
        }
                
        int fehler = 0; //Fehler zählen
        char[] geratene = new char[30]; //für Sonderzeichen ein paar mehr Stellen
        String ch;  //Buchstabe, der geraten wird.
        
        do {
            //Einlesen des Buchstabens, der geraten wird
            System.out.println("Raten Sie einen Buchstaben! (nur Kleinbuchstaben)");
            sc = new Scanner (System.in);
            ch = sc.nextLine();

            if (wort.indexOf(ch.charAt(0))!=-1) {    //indexOf gibt den -1 zurück, wenn der Buchstabe im String nicht vorkommt
                for (int i = 0; i < wort.length(); i++) {   //Durchgehen des wortes
                    if (wort.charAt(i)==ch.charAt(0)) { //Wenn der Buchstabe an Stelle i des Wortes übereinstimmt mit dem Buchstaben
                        wortAr[i]=ch.charAt(0); //dann in der Fortschritt-Ausgabe den Buchstaben an diese Stelle tun
                    }
                }
            } else if (!Hangman.enthalten(geratene, ch.charAt(0))) {    //wenn der Buchstabe nicht stimmt und
                //der Buchstabe noch nicht im geratene-Array enthalten ist
                fehler++;   //die Fehler zählen
            }
            
            //Buchstabe zur Liste der geratenen Buchstaben dazugeben, egal, ob es gestimmt hat oder nicht
            if (!Hangman.enthalten(geratene, ch.charAt(0))) {    //Wenn es im geratene-Array noch nicht drinnen ist, ...
                    //und das Array durchgehen und es an der ersten freien Stelle einfügen
                    for (int i = 0; i < geratene.length; i++) {
                        if (geratene[i]=='\u0000') {
                            geratene[i]=ch.charAt(0);
                            break;  //damit es nicht in allen anderen leeren Stellen auch eingefügt wird
                        }
                    }
            }
            
            //Ausgaben des Fortschrittes
            System.out.print("FORTSCHRITT: ");
            for (int i = 0; i < wortAr.length; i++) {
                System.out.print(wortAr[i]+" ");
            }
            //mit den bereits gemachten Fehlern
            System.out.print("   "+fehler+" Fehler");
            
            //und den Buchstaben, die schon geraten wurden
            System.out.print("\nBereits geratene Buchstaben: ");
            for (int i = 0; i < geratene.length; i++) {
                if (geratene[i]!='\u0000') {
                    System.out.print(geratene[i]+", ");
                }
            }
            System.out.println("\n");
            
            //Wenn schon 10 Fehler gemacht wurden, auch die Lösung ausgeben
            if (fehler==10) {
                System.out.println("Sie haben 10 Fehler gemacht. Das Wort war '"+worteingabe+"'.");
            }
        } while (Hangman.enthalten(wortAr, '_') && fehler<10);  //das alles nur ausführen, wenn in dem Fortschritts-Array
        //kein "_" (nicht erratener Buchstabe) vorkommt und die 10 Fehler noch nicht erreicht wurden
        
        if(!Hangman.enthalten(wortAr, '_')) {   //Wenn der Vorgann vorbei ist und es keine unerratenen Buchstaben gibt
            System.out.println("Herzlichen Glückwunsch, Sie haben das Wort erraten!");  //Glückwunsch ausgeben
        }
    }
    
    /**
     * Diese Methode überprüft ob ein Buchstabe in einem Buchstaben-Array enthalten ist.
     * 
     * @param array das char-Array
     * @param ch der Buchstabe
     * 
     * @return true, wenn es enthalten ist / false, wenn es nicht enthalten ist
     */
    public static boolean enthalten (char[] array, char ch) {
        for (int i=0; i < array.length; i++) {  //Durchgehen des Arrays und überprüfung ob der Char an der Stelle 
            //mit dem übergebenen Ch übereinstimmt
            if (array[i]==ch) { //und wenn, true zurückgeben (beendet die Methode)
                return true;
            }
        }
        
        //wurde nichts gefunden, false zurück geben
        return false;
    }
}
