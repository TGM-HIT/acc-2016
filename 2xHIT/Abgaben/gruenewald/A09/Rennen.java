
/**
 * Adventcontest -> A09
 * @author Sebastian Grünewald 
 * @version 19-12-2016
 */

import javax.swing.*;
import java.util.Random;
import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class Rennen 
{
    /** Attribute für Rennen-Objekt */
    int maxAnzahlRunden;
    Teilnehmer[] t;

    /**
     * Konstruktor für Rennen-Objekt
     */
    public Rennen (int runden, int teilnehmer) {
        this.maxAnzahlRunden = runden;

        t = new Teilnehmer[teilnehmer];
        for (int i = 0; i < teilnehmer; i++) {
            t[i] = new Teilnehmer();
        }
    }

    /**  
     * Simple Rechenaufgabe für Rennen
     * @return      ergebnis der Rechnung
     */
    public static int rechnung () {
        Random rand1 = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();

        int zahl1 = rand1.nextInt(100)+1;
        int zahl2 = rand2.nextInt(100)+1;

        int ergebnis;

        if (zahl1 % 2 == 1) {
            System.out.println(+zahl1+" + "+zahl2+" = ?");
            ergebnis = zahl1 + zahl2;
        }
        else {
            System.out.println(+zahl1+" - "+zahl2+" = ?");
            ergebnis = zahl1 - zahl2;
        }

        return ergebnis;
    }

    /**
     * Methode zum Überprüfen, ob der Spieler das richtige Ergebnis eingegeben hat
     * @param eingegeben            Wert der vom Spieler eingegeben wurde
     * @param endergebnis           Wert der Richtig ist
     * @return      boolean Wert, je nach dem ob der Spieler die Zahl richtig hat oder nicht
     */
    public static boolean überprüfen (int eingegeben, int endergebnis) {
        boolean richtig;
        if (eingegeben == endergebnis) {
            richtig = true;
        }
        else {
            richtig = false;
        }

        return richtig;
    }

    /**
     * Main/Test - Methode
     */
    public static void main (String[] args) {
        //Rennnen erstellen
        String rundenEingabe = JOptionPane.showInputDialog(null,"Wieviele Runden sollen gespielt werden?");
        String teilnehmerAnzahl = JOptionPane.showInputDialog(null,"Wieviele Spieler sollen spielen?");

        int runden = Integer.parseInt(rundenEingabe);
        int teilnehmer = Integer.parseInt(teilnehmerAnzahl);

        System.out.println("Es müssen Zahlen sein!");

        Rennen r = new Rennen(runden,teilnehmer);

        //Ablauf
        int endergebnis;
        boolean richtig;

        SimpleDateFormat begin = new SimpleDateFormat("ss.SSS");
        SimpleDateFormat ende = new SimpleDateFormat("ss.SSS");

        for (int i = 0; i < runden; i++) {
            for (int a = 0; a < teilnehmer; a++) {
                System.out.println("\nSpieler "+(a+1)+":\n");

                endergebnis = rechnung();
                Date beginn = new Date();

                String eingabe = JOptionPane.showInputDialog(null,"Antwort: ");
                int eingegeben = Integer.parseInt(eingabe);

                richtig = überprüfen(eingegeben,endergebnis);
                if (richtig == true) {
                    Date end = new Date();
                    long millis = end.getTime() - beginn.getTime();

                    System.out.println(+eingegeben+ " ist Richtig!");

                    r.t[a].rundePunkte = 0;
                    r.t[a].rundePunkte = r.t[a].rundePunkte +1;

                    r.t[a].GesamtPunktestand = r.t[a].GesamtPunktestand +1;

                    long sec = TimeUnit.MILLISECONDS.toSeconds(millis);
                    millis -= TimeUnit.SECONDS.toMillis(sec);

                    System.out.println("Dauer: "+sec+" sec "+millis+" ms");
                }
                else {
                    Date end = new Date();
                    long millis = end.getTime() - beginn.getTime();
                    System.out.println(+eingegeben+ " ist Falsch!");
                    r.t[a].rundePunkte = 0;

                    long sec = TimeUnit.MILLISECONDS.toSeconds(millis);
                    millis -= TimeUnit.SECONDS.toMillis(sec);

                    System.out.println("Dauer: "+sec+" sec "+millis+" ms");
                }
            }
            for (int t = 0; t < teilnehmer; t++) {
                System.out.println("\nPunktestand dieser Runde - Spieler "+(t+1)+": "+r.t[t].rundePunkte);
            }
        }
        for (int c = 0; c < teilnehmer; c++) {
            System.out.println("\nGesamtpunktestand Spieler "+(c+1)+": "+r.t[c].GesamtPunktestand);
        }
    }
}
