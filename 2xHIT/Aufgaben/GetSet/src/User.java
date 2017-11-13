/**
 * @author Markus Reichl
 * @version 07.11.12016
 */

final class User {
    private static long uid_counter;

    private final long uid;
    private String username;
    private String password;

    User(String un, String pw) {
        this.uid = uid_counter;
        uid_counter++;

        this.username = un;
        this.password = pw;
    }

    public long getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    boolean setUsername(String un) {
        if (un.equals("")) {
            System.out.println("Username cannot be empty");
            return false;
        }

        if (un.equals(this.username)) {
            System.out.println("Username cannot be the same as before!");
            return false;
        }

        if (un.length() < 3) {
            System.out.println("Username must be at least 3 characters long!");
            return false;
        }

        this.username = un;
        return true;
    }

    public String getPassword() {
        return password;
    }

    boolean setPassword(String pw) {
        if (pw.equals("")) {
            System.out.println("Password cannot be empty");
            return false;
        }

        if (pw.equals(pw.toUpperCase()) ||
                pw.equals(pw.toLowerCase())){
            System.out.println("Password must contain at least one uppercase and one lowercase item!");
            return false;
        }

        if (pw.equals(this.password)) {
            System.out.println("Password cannot be the same as before!");
            return false;
        }

        if (pw.length() < 8) {
            System.out.println("Password must be at least 8 characters long!");
            return false;
        }

        this.password = pw;
        return true;
    }
}
