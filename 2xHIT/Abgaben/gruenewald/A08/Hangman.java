
/**
 * Einfaches Hangman Spiel
 * @author Sebastian Grünewald 
 * @version 17-12-2016
 */

import javax.swing.*;
import java.util.Arrays;

public class Hangman
{
    static String[] wort;
    static char buchstabe;
    static int fehler = 0;
    static boolean b = false;

    /**
     * Diese Methode erzeugt die gestrichelte Linie am Anfang des Spiels und prüft ob der Benutzer das Spiel gleich am Anfang abbricht
     * @param eingabe   String der gesucht werden soll
     */
    public static void ArrayInit (String eingabe) {
        try {
            wort = new String[eingabe.length()];

            for (int i = 0; i < eingabe.length(); i++) {
                wort[i] = " _";
                System.out.print(wort[i]);
            }
            System.out.println();
        }
        catch (NullPointerException c) {
            System.exit(0);
        }
    }

    /**
     * Diese Methode ermöglicht es dem Benutzer, einzelne Buchstaben einzugeben
     * Zusätzlich wird überprüft ob der Buchstabe der geraten wurde schon im teilweise aufgelösten Wort enthalten ist
     * @param eingabe       String der gesucht wird
     */
    public static void buchstabenEingabe(String eingabe) {
        String buchstabeString = JOptionPane.showInputDialog(null,"Welchen Buchstaben möchtest du einsetzen?");

        try {
            if (buchstabeString.length() == 1) {
                buchstabe = buchstabeString.charAt(0);

                for (int i = 0; i < eingabe.length(); i++) {
                    if (wort[i].equals(buchstabe+"")) {
                        System.out.println("Diesen Buchstaben hast du bereits geraten!");
                        buchstabenEingabe(eingabe);
                    }
                }

            }
            else {
                System.out.println("Du darfst nur einen Buchstaben raten");
                buchstabenEingabe(eingabe);
            }
        }
        catch (NullPointerException c) {
            int frage = JOptionPane.showConfirmDialog(null, "Willst du das Spiel beenden?", "WARNING", JOptionPane.YES_NO_OPTION);
            if (frage == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            else {
                buchstabenEingabe(eingabe);
            }
            buchstabenEingabe(eingabe);
        }
    }

    /**
     * Diese Methode überprüft ob der Buchstabe der vom Benutzer eingegeben wurde in dem gesuchten Wort enthalten ist.
     * Wenn das nicht der Fall ist wird ein Fehler dazugezählt
     * @param eingabe       String der gesucht ist
     */
    public static void überprüfen(String eingabe) {
        char c;
        int mitzählen = 0;
        boolean überprüfen = false;

        for (int i = 0; i < eingabe.length(); i++) {
            c = eingabe.charAt(i);
            if (c == buchstabe) {        
                wort[i] = c+"";
                überprüfen = true;
            }
            if (c != buchstabe) {
                mitzählen = mitzählen+1;
            }
        }

        if (mitzählen > 0 && überprüfen == false) {
            fehler = fehler +1;
        }
    }

    /**
     * Ausgabe des Fortschrittes
     */
    public static void ausgabe () {
        for (int i = 0; i < wort.length; i++) {
            System.out.print(wort[i]);
        }
        System.out.print("  "+fehler+" Fehler");
        System.out.println();
    }

    /**
     * Diese Methode überprüft ob das zu ratende Wort bereits gefunden wurde
     * @param eingabe       String der gesucht wird
     */
    public static boolean überprüfenGesamt(String eingabe) {
        boolean proof = false;
        String[] ary = eingabe.split("");
        String s1 = Arrays.toString(ary);
        String s2 = Arrays.toString(wort);
        if (s1.equals(s2)) {
            proof = true;
        }
        return proof;
    }

    /**
     * Main / Test - Methode
     */
    public static void main (String[] args) {
        String eingabe = JOptionPane.showInputDialog(null,"Welches Wort soll gesucht werden?");

        ArrayInit(eingabe);

        boolean übernehmen;

        do {
            buchstabenEingabe(eingabe);
            überprüfen(eingabe);
            ausgabe();
            übernehmen = überprüfenGesamt(eingabe);
            if (übernehmen == true) {
                System.out.println("GESCHAFFT!");
            }
            if (fehler == 10) {
                System.out.println("\nVERLOREN! Du hast zuviele Fehler gemacht\nGesuchtes Wort war: "+eingabe);
            }
        }
        while (übernehmen != true && fehler < 10); 
    }
}
