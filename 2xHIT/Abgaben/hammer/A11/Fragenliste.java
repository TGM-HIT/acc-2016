import java.util.*;
/**
 * Diese Klasse organisiert Objekte der Klasse Frage als Liste und bietet einige Funktionen dafür.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-22
 */
public class Fragenliste {
    //ATTRIBUTE
    private Frage[] fragenliste;
   
    //KONSTRUKTOR
    /**
     * Dieser Konstruktor setzt die Fragenliste erstmal auf 5 Werte.
     */
    public Fragenliste () {
        this.fragenliste = new Frage[5];    //5, da in der Demo 5 Fragen vorhanden sein müssen
    }
    
    //SETTER UND GETTER
    /**
     * Diese Methode gibt die Fragenliste/das Array zurück.
     * 
     * @return das Array mit den Frage-Objekten darin
     */
    public Frage[] getFragenliste () {
        return fragenliste;
    }
    
    //METHODEN
    /**
     * Diese Methode fügt eine Frage (Frage-Objekt) an der nächsten freien Stelle ein und "vergrößert" das Array gegebenenfalls, wenn kein Platz mehr
     * verfügbar ist.
     */
    public void addFrage(Frage frage) {
        if (this.fragenliste[this.fragenliste.length-1] == null) {
            for (int i = 0; i < this.fragenliste.length; i++) {
                if (this.fragenliste[i] == null) {
                    this.fragenliste[i] = frage;
                    break;
                }
            }
        } else {
            Frage[] neu = new Frage[this.fragenliste.length+1];
            for (int i = 0; i < this.fragenliste.length; i++) {
                neu[i] = this.fragenliste[i];
            }
            
            this.fragenliste = neu;
            this.fragenliste [this.fragenliste.length-1] = frage;
        }
    }
    
    /**
     * Diese Methode stellt ein paar Standardfragen zur Verfügung.
     * Die Fragen wurden dieser Seite entnommen: http://www.fragespiel.com/quizfragen/computer.html 
     * (ausgenommen der ersten)
     */
    public void standard () {
        this.fragenliste = new Frage[16];
        
        String[] antworten1 = {"Neues Array erstellen", "Geht nicht", "Mit Array.erweitern()", "Einfach an einer Stelle außerhalb der Länge einen Wert hinzufügen, es vergrößert sich automatisch"};
        this.fragenliste[0] = new Frage("Länge eines Arrays ändern, wie geht das?", antworten1, 2);
        
        String[] antworten2 = {"Ben Hur", "Tron", "Toy Story", "Jurassic Park"};
        this.fragenliste[1] = new Frage("Wie heißt der erste vollständig computernaimierte Spielfilm? (1995)", antworten2, 3);
        
        String[] antworten3 = {"Faxgerät", "Modem", "Computer", "Digitalkamera"};
        this.fragenliste[2] = new Frage("Was wählte das TIME Magaizine 1982 zur Machine des Jahres?", antworten3, 3);
        
        String[] antworten4 = {"Podcast", "Podfast", "Broadcast", "Downstream"};
        this.fragenliste[3] = new Frage("Wie nennt man rundfunkähnliche Hörbeiträge aus dem Internet?", antworten4, 1);
        
        String[] antworten5 = {"MP3", "WMA", "Ogg Vorbis", "WAV"};
        this.fragenliste[4] = new Frage("In welchem Verfahren wird Musik nicht platzsparend gespeichert?", antworten5, 4);
        
        String[] antworten6 = {"Electric Mail", "Endurance Mail", "Electronic Mail", "Emission Mail"};
        this.fragenliste[5] = new Frage("Wofür steht E-Mail?", antworten6, 3);
        
        String[] antworten7 = {"Clear Disc", "Computer Disc", "Compact Disc", "Cool Disc"};
        this.fragenliste[6] = new Frage("Was heißt CD?", antworten7, 3);
        
        String[] antworten8 = {"DHCP", "SIM", "MP3", "WAP"};
        this.fragenliste[7] = new Frage("Welche Technik erlaubt das Ansehen spezieller Internetseiten mit einem Mobiltelefon?", antworten8, 4);
        
        String[] antworten9 = {"Internet", "Cyberspace", "World Wide Web", "Raumzeit"};
        this.fragenliste[8] = new Frage("Wie nennt man einen virtuellen Raum?", antworten9, 2);
        
        String[] antworten10 = {"EmbeddedSort", "InsertionSort", "QuickSort", "BubbleSort"};
        this.fragenliste[9] = new Frage("Was ist kein Algorithmus zum Sortieren von Werten?", antworten10, 1);
        
        String[] antworten11 = {"sp", "ep", "es", "sn"};
        this.fragenliste[10] = new Frage("Wie lautet die Internetkennung für Spanien?", antworten11, 3);
        
        String[] antworten12 = {"1960", "1970", "1980", "1990"};
        this.fragenliste[11] = new Frage("Wann kamen die ersten Disketten auf den Markt?", antworten12, 2);
        
        String[] antworten13 = {"Charles Babbage", "Konrad Zuse", "Hermann Hollerith", "Blaise Pascal"};
        this.fragenliste[12] = new Frage("Wer baute 1832 den ersten mechanischen Computer?", antworten13, 1);
        
        String[] antworten14 = {"simple mail transfer protocl", "sound mail transfer protocol", "simple mother terminal protocol", "scientific mail translocation protocol"};
        this.fragenliste[13] = new Frage("Was bedeutet SMTP?", antworten14, 1);
        
        String[] antworten15 = {"1.000.000.000 Byte", "1.000.000 Byte", "1.000 Byte", "1 Byte"};
        this.fragenliste[14] = new Frage("Wie viele Bytes hat ein Gigabyte?", antworten15, 1);
        
        String[] antworten16 = {"Moving Pictures Expression Group", "Movie Pictures Expression Graphics", "Moving Pixels Expert Graphics", "Moving Pictures Experts Group"};
        this.fragenliste[15] = new Frage("Wofür steht MPEG?", antworten16, 4);
    }
    
    /**
     * Diese Methode ändert die Reihenfolge der Fragen in der Liste.
     */
    public void random() {
        //Unwandlung zu einer Liste, um Collections.shuffle() zu verwenden
        List<Frage> f = Arrays.asList(fragenliste);
        Collections.shuffle(f);

        //Zurück in ein Array umwandeln
        this.fragenliste = f.toArray(fragenliste);
    }
}
