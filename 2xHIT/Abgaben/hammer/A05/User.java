/**
 * Diese Klasse speichert die Daten für einen User und beinhaltet Getter/Setter Methoden zum Verwalten
 * dieser.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-14
 */
public class User {
    //ATTRIBUTE
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    
    //KONSTRUKTOR
    /**
     * Erstellt ein Objekt für User und weist die Werte zu.
     * 
     * @param user der Benutzername
     * @param pass das Passwort
     * @param first der Vorname
     * @param last der Nachname
     */
    public User (String user, String pass, String first, String last){
        setUsername(user);
        setPassword(pass);
        setFirstname(first);
        setLastname(last);
    }
    
    
    //SETTER UND GETTER 
    //USERNAME
    /**
     * Setzt den Wert für username, sofern dieser länger als 3 Zeichen ist und nicht dem aktuellen username entspricht.
     * 
     * @param user der Benutzername
     */
    public void setUsername (String user) {
        if (user.length() >= 3 && !user.equals(username)) { //Wenn der Username min. 3 Zeichen ist und nicht dem aktuellen entspricht, ...
            username = user;    //...zuweisen
        } else if (user.equals(username)) { //sonst, wenn es aktuellem gleicht
            System.out.println("Der neue Benutzername stimmt mit dem alten überein.");  //Fehlermeldung
        } else if (user.length() <= 3) {    //sonst, wenn es zu kurz ist, ...
            System.out.println("Der neue Benutzername ist zu kurz.");   //Fehlermeldung
        }
    }
    
    /**
     * Gibt den Wert von username zurück, sofern dieser nicht null ist.
     * 
     * @return Wert von username.
     */
    public String getUsername () {
        if (username != null) { //falls username einen Wert hat,
            return username;    //diesen zurückgeben
        }
        return ""; 
    }
    
    //PASSWORD
    /**
     * Setzt den Wert von password, sofern dieser nicht leer/null und nicht kürzer als 8 Zeichen ist, und dazu noch
     * Groß- und Kleinbuchstaben enthält.
     * 
     * @param pass das neue Passwort
     */
    public void setPassword (String pass) {
        //Variablen für das Feststellen ob es Groß/Kleinbuchstaben gibt
        boolean gross = false;
        boolean klein = false;
        
        //Durchgehen des Strings, 
        for (int i = 0; i < pass.length(); i++) {
            //Überprüfung ob der aktuelle Index ein Großbuchstabe...
            if (pass.charAt(i) > 'A' && pass.charAt(i) < 'Z') {
                gross = true;
            }
            //...oder ob ein Kleinbuchstabe ist und je nach dem den Wert auf true setzen 
            if (pass.charAt(i) > 'a' && pass.charAt(i) < 'z') {
                klein = true;
            }
        }
        
        //Zuweisung falls alle Vorraussetzungen getroffen wurden
        if (pass.length() >= 8 && !pass.equals(password) && gross && klein) {
            password = pass;
        } else if (pass.equals(password)) { //Fehlermeldung, wenn das neue Passwort das alte ist
            System.out.println("Das neue Passwort stimmt mit dem alten überein.");
        } else if (pass.length() < 8) { //Fehlermeldung bei zu wenig Zeichen
            System.out.println("Das neue Passwort ist zu kurz.");
        } else if (!gross) {    //Fehlermeldung wenn keine Großbuchstaben gefunden wurden
            System.out.println("Es gibt keine Großbuchstaben.");
        } else if (!klein) {    //Fehlermeldung wenn keine Kleinbuchstaben gefunden wurden
            System.out.println("Es gibt keine Kleinbuchstaben.");
        }
    }
    
    /**
     * Gibt den Wert von password zurück, sofern dieser nicht null ist.
     * 
     * @return Wert von password.
     */
    public String getPassword () {
        if (password != null) {
            return password;
        }
        return "";
    }
    
    //FIRST NAME
    /**
     * Setzt den Wert des Vornamens, sofern dieser nicht leer/null ist und keine Zahlen enthält.
     * 
     * @param first der Vorname
     */
    public void setFirstname (String first) {
        //Variable zum Feststellen, ob Zahlenwerte vorkommen
        boolean zahl = false;   //false = es gibt keine Zahlen
        
        //Durchgehen des Strings
        for (int i = 0; i < first.length(); i++) {
            //Wenn eine Zahl vorkommt, auf true ändern
            if (Character.isDigit(first.charAt(i))) {
                zahl = true;
            }
        }
        
        //Wenn es nicht leer/null ist und es auch keine Zahlen gibt, 
        if (first!=null && first!="" && !zahl) {
            firstname = first;  //... Wert zuweisen
        } else if (first == null || first == "") {  //Fehlermeldung falls es null/leer ist
            System.out.println("Der Vorname ist leer.");
        } else if (zahl) {  //Fehlermeldung, wenn Zahlen vorkamen
            System.out.println("Der Vorname darf keine Zahlen enthalten.");
        }
    }
    
    /**
     * Gibt den Wert von firstname zurück, sofern dieser nicht null ist.
     * 
     * @return Wert von firstname.
     */
    public String getFirstname () {
        if (firstname != null) {
            return firstname;
        }
        return "";
    }
    
    //LAST NAME
    /**
     * Setzt den Wert des Nachnamens, sofern dieser nicht leer/null ist und keine Zahlen enthält.
     * 
     * @param first der Nachname
     */
    public void setLastname (String last) {
        //Variable zum Feststellen, ob Zahlenwerte vorkommen
        boolean zahl = false;
        
        //Durchgehen des Strings
        for (int i = 0; i < last.length(); i++) {
            //Wenn eine Zahl vorkommt, auf true ändern
            if (Character.isDigit(last.charAt(i))) {
                zahl = true;
            }
        }
        
         //Wenn es nicht leer/null ist und es auch keine Zahlen gibt, 
        if (last!=null && last!="" && !zahl) {
            lastname = last;
        } else if (last == null || last == "") {    //Fehlermeldung falls es null/leer ist
            System.out.println("Der Nachname ist leer.");
        } else if (zahl) {  //Fehlermeldung, wenn Zahlen vorkamen
            System.out.println("Der Nachname darf keine Zahlen enthalten.");
        }
    }

    /**
     * Gibt den Wert von lastname zurück, sofern dieser nicht null ist.
     * 
     * @return Wert von lastname.
     */
    public String getLastname () {
        if (lastname != null) {
            return lastname;
        }
        return "";
    }
    
    //METHODEN
    //Für Testzwecke
    /**
     * Diese Methode wandelt die Information des Users in Textform um, wobei es (noch) keine Rücksicht auf null-Fälle nimmt.
     * 
     * @return Text mit Informationen über den User
     */
    public String toString () {
        String ausgabe = "";
        
        ausgabe = "Username: "+username+"\nPassword: "+password+"\nFirst Name: "+firstname+"\nLast Name: "+lastname+"\n";
        return ausgabe;
    }
}
