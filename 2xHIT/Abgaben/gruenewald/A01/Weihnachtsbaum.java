
/**
 * Dieses Programm erzeugt einen Weihnachtsbaum, mit sovielen Ebenen, wie der
 * Benutzer es möchte
 * 
 * @author Sebastian Grünewald 2DHIT 
 * @version 5-12-2016
 */

import javax.swing.*;

public class Weihnachtsbaum {
    public static void main(String[] args) {
        String eingabe = JOptionPane.showInputDialog(null,"Wieviele Ebenen soll der Baum haben?");
        
        int höhe = Integer.parseInt(eingabe);

        for (int i = 0; i < höhe; i++) {
            for (int t = 0; t < höhe - 1 - i; t++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
