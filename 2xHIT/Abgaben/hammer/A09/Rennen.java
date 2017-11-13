import java.util.*;
/**
 * Dieses Programm führt ein Rechen-Rennen aus, bei dem die Anzahl von Runden und Teilnehmern
 * festgelegt werden kann.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-18
 */
public class Rennen {
    public static void main (String[] args) {
        //Einlesen der Runden
        System.out.println("Anzahl der Runden:");
        Scanner sc = new Scanner(System.in);
        int runden = sc.nextInt();
        
        //Einlesen der Teilnehmer
        System.out.println("Anzahl der Teilnehmer:");
        sc = new Scanner(System.in);
        int tnanzahl = sc.nextInt();
        
        //Teilnehmer Objekte erzeugen
        Teilnehmer[] teilnehmer = new Teilnehmer[tnanzahl];
        
        for (int i = 0; i < teilnehmer.length; i++) {
            teilnehmer[i] = new Teilnehmer((i+1), runden);
        }
        
        //Variablen für den Spielablauf
        int tn; //Zählen der Teilnehmer, die schon durchgegangen werden
        int ru = 1; //Rundenzähler
        int erg;    //Variable für das Ergebnis
        long start; //Startzeit
        long runningTime;   //Endzeit
        Rechnung rechnung;  //Rechnungs-Objekt
        
        
        //Rennen 
        do {    //Runde
            tn = 0;
            do {    //Teilnehmer
                start = new Date().getTime();   //Startzeit speichern
                rechnung = new Rechnung();  //Rechnung erzeugen
                //Rechnung ausgeben
                System.out.println("\nTeilnehmer "+(tn+1)+":");
                System.out.println("Rechnung: "+rechnung.ersteZahl+""+rechnung.op+""+rechnung.zweiteZahl);
                
                do {    //Wiederholung bis das Ergebnis stimmt
                    //Ergebnis einlesen
                    sc = new Scanner (System.in);
                    erg = sc.nextInt();
                    
                    //Vergleichen, ob das Ergebnis stimmt
                    if (rechnung.ergebnis == erg) {
                        runningTime = new Date().getTime() - start;
                        teilnehmer[tn].setPunkte((int)(ru), (int) runningTime);
                        tn++;
                    } else {
                        System.out.println("Falsches Ergebnis!");
                    }
                } while (rechnung.ergebnis != erg);
            } while (tn < tnanzahl);
            
            //Ausgeben der Ergebnisse dieser Runde
            System.out.println("\nPunktestand dieser Runde:");
            for (int i=0; i < tnanzahl; i++) {
                System.out.println("Teilnehmer "+teilnehmer[i].nr+": "+teilnehmer[i].getPunkte(ru));
            }
            
            //Zählen der Runde
            ru++;
        } while (ru <= runden);
        
        //Ausgeben aller Punktestände aller Runden
        System.out.println("\n\nPUNKTESTÄNDE");
        for (int r = 1; r <= runden; r++) {
            System.out.println("\nRUNDE "+r+":"); 
            for (int i = 0; i < teilnehmer.length; i++) {
                System.out.println("Teilnehmer "+teilnehmer[i].nr+": "+teilnehmer[i].getPunkte(r));
            } 
        }
        
        //Ausgeben der Gesamtpunktzahl
        System.out.println("\n\nGesamtpunktzahl:");
        for (int i = 0; i < teilnehmer.length; i++) {
            System.out.println("Teilnehmer "+teilnehmer[i].nr+": "+teilnehmer[i].getPunkteges());
        }
        
        System.out.println("Der Teilnehmer mit der geringsten Punktezahl gewinnt"); //da es ja die Zeit zählt
        //und ja derjenige gewinnen sollte, der die wenigste Zeit für die Beispiele gebraucht hat.
    }
}
