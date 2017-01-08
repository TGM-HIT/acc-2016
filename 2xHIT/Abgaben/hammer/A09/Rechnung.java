import java.util.*;
/**
 * Dieses Programm ist die Vorlage für Rechnungsobjekte, die Rechnungen speichern. 
 * 
 * @author Hammer Viktoria
 * @version 2016-12-18
 */
public class Rechnung {
    //ATTRIBUTE 
    int ersteZahl;  //die erste Zahl
    int zweiteZahl; //die zweite Zahl
    float ergebnis; //das Ergebnis
    char op;    //Operator
    
    //KONSTRUKTOR
    /**
     * Dieser Konstruktor erzeugt eine Rechnung und speichert die Werte in die Attribute.
     */
    public Rechnung() {
        Random r = new Random();
        ersteZahl = r.nextInt(10)+1;
        zweiteZahl = r.nextInt(10)+1;
        
        char[] operatoren = {'+', '-', '*', ':'};
        op = operatoren[r.nextInt(3)];
        
        switch (op) {
            case '+': ergebnis = ersteZahl+zweiteZahl;
            break;
            case '-': ergebnis = ersteZahl-zweiteZahl;
            break;
            case '*': ergebnis = ersteZahl*zweiteZahl;
            break;
            case ':': ergebnis = ersteZahl/zweiteZahl;
            break;
        }
    }
}
