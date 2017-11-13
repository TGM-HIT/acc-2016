
/**
 * A05 --> Get & Set
 * @author Sebastian Grünewald 
 * @version 12-12-2016
 */

public class User {
    
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

    public String getFirstname () {
        return this.firstname;
    }

    public String getLastname () {
        return this.lastname;
    }

    public void setUsername (String username) { 
        if (username.length() < 3 || username.equals("") || username.equals(this.getUsername())) {
            System.out.println("Username FEHLER");
            this.username = "";
        }
        else {
            this.username = username;
        }
    } 

    public void setPassword (String password) {
        char c;
        int zählen = 0, zählen2 = 0;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                zählen = zählen +1;
            }
            if (Character.isLowerCase(c)) {
                zählen2 = zählen2 +1;
            }
        }

        if (password.length() < 8 || password.equals("") || password.equals(this.getPassword()) || zählen < 1 || zählen2 < 1) {
            System.out.println("Password FEHLER");
            this.password = "";
        }
        else {
            this.password = password;
        }
    } 

    public void setFirstname (String firstname) {
        char c;
        boolean überprüfen = true;

        if (firstname != null || firstname != "") {
            for (int i = 0; i < firstname.length(); i++) {
                c = firstname.charAt(i);
                if (!Character.isLetter(c)) {
                    überprüfen = false;
                    break;
                }
            }
        }

        if (überprüfen == false || firstname == null || firstname == "") {
            System.out.println("Firstame FEHLER");
            this.firstname = "";
        }
        else {
            this.firstname = firstname;
        }  
    } 

    public void setLastname (String lastname) {
        char c;
        boolean überprüfen = true;

        if (lastname != null || lastname != "") {
            for (int i = 0; i < lastname.length(); i++) {
                c = lastname.charAt(i);
                if (!Character.isLetter(c)) {
                    überprüfen = false;
                    break;
                }
            }
        }
        else {
            System.out.println("Lastname FEHLER");
        }

        if (überprüfen == false || lastname == null || lastname == "") {
            System.out.println("Lastname FEHLER");
            this.lastname = "";
        }
        else {
            this.lastname = lastname;
        }  
    }
}


