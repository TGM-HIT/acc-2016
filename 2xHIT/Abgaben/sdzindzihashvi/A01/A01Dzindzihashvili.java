import javax.swing.*;
/**
 * Dieses Programm soll einen Weihnachtsbaum ausgeben, mit der vorgegebenen Anzahl der Zeilen.
 * 
 * @author Shai Dzindzihashvili 2DHIT 
 * @version 1.0
 */
public class A01Dzindzihashvili
{
    /*
     * Die main Methode - In der läuft alles ab
     * 
     */
    public static void main(String[] args) {
        String hashtags = "#";
        int zeilen = Integer.parseInt(JOptionPane.showInputDialog("Geben sie die Anzahl der Zeilen für den Weihnachtsbaum ein!"));
        int anzHashtags = 1;

        for(int i = 1; i <= zeilen; i++){
            printleerzeichen(zeilen-i);
            ausgeben(hashtags);           
            hashtags += "##";
        }
    }

    
    /*
     * Gibt den übergegebenen String aus
     * 
     * @param String s - Der String der ausgegeben werden soll
     */
    public static void ausgeben(String s){
        System.out.println(s);
    }
    
    /*
     * Gibt die Leerzeichen ein die für die zentrierung der Rautezeichen benötigt werden.
     * 
     * @param int anzahl - gibt die anzahl der Leerzeichen über
     */
    public static void printleerzeichen(int anzahl){
        for(int i = 0; i < anzahl; i++){
            System.out.print(" ");
        }
    }
}
