import java.util.*;
/**
 * Diese Applikation gibt einen Tannenbaum aus, der die Höhe von einer (in diesem Fall vom Benutzer ausgewählten) 
 * Zahl hat.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-05
 */
public class A01Tannenbaum {
    public static void main (String[] args) {
        //EINLESEN DES WERTES
        System.out.println("Bitte geben Sie die gewünschte Höhe des Baumes ein:");
        Scanner sc = new Scanner (System.in);
        int hoehe = sc.nextInt();
        
        //AUSGEBEN DES BAUMES
        System.out.println("\n/* Ein Baum der Höhe " + hoehe + " */\n");
        
        for (int i=1; i<=hoehe; i++) { 
            for (int l=1; l<=hoehe-i; l++) {
                System.out.print(" "); 
            }
         
            for (int l=1; l<(2*i); l++) {
                System.out.print("#"); 
            }
            
            System.out.print("\n");
            //System.out.println(); //würde auch gehen
        } 
    }
        
}
