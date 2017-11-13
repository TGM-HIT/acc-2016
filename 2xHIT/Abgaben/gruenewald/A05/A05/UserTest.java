
/**
 * A05 Tesstklasse
 * @author Sebastian Grünewald 
 * @version 12-12-2016
 */

import javax.swing.*;

public class UserTest {
   public static void main (String[] args) {
        User u = new User();

        String ueingabe = JOptionPane.showInputDialog(null,"Username:");
        String peingabe = JOptionPane.showInputDialog(null,"Password:");
        String fneingabe = JOptionPane.showInputDialog(null,"Firstname:");
        String lneingabe = JOptionPane.showInputDialog(null,"Lastname:");
        
        u.setUsername(ueingabe);
        u.setPassword(peingabe);
        u.setFirstname(fneingabe);
        u.setLastname(lneingabe);
        
        System.out.println("Username: "+u.getUsername());
        System.out.println("Password: "+u.getPassword());
        System.out.println("Firstname: "+u.getFirstname());
        System.out.println("Lastname: "+u.getLastname());
    }
}
