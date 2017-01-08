
/**
 * A11
 * @author Sebastian Grünewald 
 * @version 22-12-2016
 */

import java.io.*;
import javax.swing.*;

public class Quiz
{
    /** statische Attribute */
    static String[] fragen = new String[5];
    static String[] antworten = new String[20]; 
    static char[] richtigeAntworten = {'a','d','b','b','a'};
    static char buchstabe;

    /**
     * Diese Methode liest das Fragenfile und Antwortfile aus und initialisiert die statischen Arrays dazu
     */
    public static void init () throws IOException {
        FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);

        FileReader fr2 = new FileReader("antworten.txt");
        BufferedReader br2 = new BufferedReader(fr2);

        for (int i = 0; i < fragen.length; i++) {
            fragen[i] = br.readLine();
        }
        for (int i = 0; i < antworten.length; i++) {
            antworten[i] = br2.readLine();
        }
    }

    /**
     * Diese Methode erlaubt dem Spieler eine Antwort einzugeben
     * @param richtig       Anzahl der richtigen Antworten
     * @param falsch        Anzahl der falschen Antworten
     */
    public static void antwort (int richtig, int falsch) {
        String eingabe = JOptionPane.showInputDialog(null,"Antwort:");

        try {
            if (eingabe.length() == 1) {
                buchstabe = eingabe.charAt(0);
                
                if (buchstabe == 'a' || buchstabe == 'b' || buchstabe == 'c' || buchstabe == 'd') {
                    buchstabe = buchstabe;
                }
                else {
                    System.out.println("Nur Buchstaben eingeben, die zur Auswahl stehen!");
                    antwort(richtig, falsch);
                }
            }
            else  {
                System.out.println("Du darfst nur mit Buchstaben raten!");
                antwort(richtig, falsch);
            }
        }
        catch (NullPointerException c) {
            int frage = JOptionPane.showConfirmDialog(null, "Willst du das Spiel beenden?", "WARNING", JOptionPane.YES_NO_OPTION);
            if (frage == JOptionPane.YES_OPTION) {
                System.out.println("Richtige Antworten: "+richtig);
                System.out.println("Falsche Antworten: "+falsch);
                System.exit(0);
            }
            else {
                antwort(richtig, falsch);
            }
        }
    }

    /**
     * Main - Methode
     */
    public static void main (String[] args) throws IOException {
        int b = 0;
        int richtig = 0;
        int falsch  = 0;
        
        
        init();
        for (int i = 0; i < fragen.length; i++) {
            System.out.println(fragen[i]);
            for (int a = 0; a < 4; a++) {
                System.out.println(antworten[b]);
                b++;
            }
            antwort(richtig,falsch);
            if (buchstabe == richtigeAntworten[i]) {
                System.out.println("RICHTIG!\n");
                richtig++;
            }
            else {
                System.out.println("FALSCH!\n");
                falsch++;
            }
        }
        
        System.out.println("\nRichtige Antworten: "+richtig);
        System.out.println("Falsche Antworten: "+falsch);
    }
}
