import java.util.*;
/**
 * Dieses Programm führt ein Quiz aus, wo einem Fragen gestellt werden und man 4 Antwortmöglichkeiten hat.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-22
 */
public class Quiz {
    public static void main(String[] args) {
        //Frage, ob man selbst fragen hinzufügen will
        System.out.println("Wollen Sie selber Fragen hinzufügen?");
        Scanner sc = new Scanner(System.in);
        char jn = sc.nextLine().toLowerCase().charAt(0);    //einscannen, in kleinbuchstaben umwandeln und nur den ersten Buchstaben speichern
        
        String frage;   //Variable für die Frage
        String[] antworten = new String[4]; //da es eine feste Anzahl von Antworten gibt
        int a;  //Index der richtigen Antwort
        
        Fragenliste fragen = new Fragenliste(); //Fragenliste-Objekt für das bessere Verwalten der Fragen
        
        //Wenn der Benutzer eigene Fragen erstellen will:
        if (jn=='j') {
            do {
                //Frage einlesen
                System.out.println("\nGeben Sie die Frage ein:");
                sc = new Scanner(System.in);
                frage = sc.nextLine();
                
                //1. Antwort
                System.out.println("\nErste Antwortmöglichkeit:");
                sc = new Scanner(System.in);
                antworten[0] = sc.nextLine();
                
                //2. Antwort
                System.out.println("\nZweite Antwortmöglichkeit:");
                sc = new Scanner(System.in);
                antworten[1] = sc.nextLine();
                
                //3. Antwort
                System.out.println("\nDritte Antwortmöglichkeit:");
                sc = new Scanner(System.in);
                antworten[2] = sc.nextLine();
                
                //4. Antwort
                System.out.println("\nVierte Antwortmöglichkeit:");
                sc = new Scanner(System.in);
                antworten[3] = sc.nextLine();
                
                //Index-Abfrage
                System.out.println("\nWelche Antwort ist die richtige?");
                sc = new Scanner(System.in);
                a = sc.nextInt();
                
                //wenn ungültiger Wert eingegeben wurde,
                while (a < 1 || a > 4) {   //solange wiederholen, bis die Eingabe gültig ist
                    System.out.println("\nUngültige Eingabe! Bitte eine Zahl zwischen 1-4!");
                    sc = new Scanner(System.in);
                    a = sc.nextInt();  
                }
                
                //Objekt erzeugen und zur Liste hinzufügen
                fragen.addFrage(new Frage(frage, antworten, a));
                
                //Fragen, ob man noch eine Frage hinzufügen will
                System.out.println("\nWollen Sie noch eine Frage hinzufügen?");
                sc = new Scanner(System.in);
                jn = sc.nextLine().toLowerCase().charAt(0);
            } while (jn=='j');
        } else {
            fragen.standard();  //sonst die Standardfragen in die Fragenliste schreiben
        }
        
        //Die Anordnung der Fragen ändern, damit es nicht immer die gleiche Reihenfolge ist
        fragen.random();
        
        //Variablen für den Durchgang
        int richtig = 0;    //Richtige Antworten zählen
        int falsch = 0; //Falsche Antworten zählen
        int eingabe = -1;    //Eingabe für die Antwort-Eingab
        int z = 0;  //Zähler für den Durchlauf
        
        //Anzahl der Fragen begrenzen:
        System.out.println("\nWollen Sie die Anzahl der Fragen, die Ihnen gestellt werden, begrenzen?");
        sc = new Scanner(System.in);
        jn = sc.nextLine().toLowerCase().charAt(0);
        
        if (jn=='j') {  //wenn ja, einlesen, wie viele Fragen
            System.out.println("\nWie viele Fragen sollen Ihnen gestellt werden?");
            sc = new Scanner(System.in);
            z = sc.nextInt()-1; //und Durchlaufszähler zuweisen
        } else {    //sonst
            z = fragen.getFragenliste().length-1;   //Länge-1 zuweisen (wegen Index)
        }
        
        do {
            //z geht zwar vom letzten Index zum niedrigsten, aber um Variablen zu sparen sind die beiden Zwecke in einer Variable
            if (fragen.getFragenliste()[z]!=null) { //wenn die Frage an dem Index nicht null ist, ...
                //Den Fragenprozess ausführen
                System.out.println("\n\n"+fragen.getFragenliste()[z]);  //Frage stellen (toString())
                
                System.out.println("Wählen Sie eine Antwort oder beenden Sie das Programm (0)");    
                sc = new Scanner(System.in);  
                eingabe = sc.nextInt();
                
                if (eingabe==fragen.getFragenliste()[z].getA()) {   //Zählen der richtigen Werte
                    richtig++;
                } 
                if (eingabe!=fragen.getFragenliste()[z].getA() && eingabe !=0) {    //Zählen der falschen Werte (die nicht 0 = Programm beenden sind)
                    falsch++;
                } 
            }
            
            z--;    //Durchlauf zählen
        } while (eingabe != 0 && z >= 0);
        
        //Je nach dem was das Programm beendet hat; das ausgeben
        if (eingabe == 0) {
            System.out.println("\nDurchlauf wurde vom Benutzer beendet");
        } else {
            System.out.println("\nDurchlauf beendet, alle verfügbaren Fragen beantwortet.");
        }
        
        //Ausgeben des Ergebnisses
        System.out.println("\nSie haben "+(richtig+falsch)+" Fragen beantwortet, davon waren...");
        System.out.println(richtig+" richtig\n"+falsch+" falsch");
    }
}
