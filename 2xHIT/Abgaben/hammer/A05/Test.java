/**
 * Testklasse für die Klasse User, der diese auf den Umgang mit fehlerhaften Eingaben testet.
 * 
 * @author Hammer Viktoria 
 * @version 2016-12-14
 */
public class Test {
    public static void main (String[] args) {
        //Gültige Werte:
        User user1 = new User ("Tora", "Imtipozs12", "Viktoria", "Hammer");
        System.out.print(user1.toString());
        
        //USERNAME TESTS
        System.out.println("\n//Benutzername < 3 Zeichen");
        user1.setUsername("Qi");

        System.out.println("\n//Benutzername entspricht dem aktuellen");
        user1.setUsername("Tora");

        
        System.out.println("\n//Benutzername ist leer");
        user1.setUsername("");
        
        
        //PASSWORT TESTS
        System.out.println("\n//Passwort ist zu kurz");
        user1.setPassword("Abc");
        
        
        System.out.println("\n//Passwort hat keine Großbuchstaben");
        user1.setPassword("imtipozs");
        
        
        System.out.println("\n//Passwort hat keine Kleinbuchstaben");
        user1.setPassword("IMTIPOZS");
        
        
        System.out.println("\n//Passwort entspricht dem aktuellen");
        user1.setPassword("Imtipozs12");
        
        
        System.out.println("\n//Passwort ist leer");
        user1.setPassword("");
        
        
        //VOR- BZW. NACHNAME TESTS
        System.out.println("\n//Vor-/Nachname enthalten Zahlen");
        user1.setFirstname("V1ktoria");
        user1.setLastname("Hamm3r");
        
        
        System.out.println("\n//Vor-/Nachnamen sind leer");
        user1.setFirstname("");
        user1.setLastname("");
    }
}
