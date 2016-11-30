/**
 * @author Markus Reichl
 * @version 30.11.2016
 *
 * String a(String d){String c="BCDEFGHIJKLMNOPQRSTUVWXYZA";String b="ABCDEFGHIJKLMNOPQRSTUVWXYZ";String e="";d=d.toUpperCase();for (int i = 0; i < d.length(); i++){char f=d.charAt(i);if (b.indexOf(f) > -1) {e+=c.charAt(b.indexOf(f));}else{e+=f;}}return e;} \n "ZPV TPMWFE NZ QVAAMF"
 */


class Decrypt {
    private String alphabet;
    private String key;

    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "BCDEFGHIJKLMNOPQRSTUVWXYZA";

        System.out.println(encrypt(alphabet, key, "You solved my puzzle"));
        System.out.println(encrypt(key, alphabet, "ZPV TPMWFE NZ QVAAMF"));
    }

    private static String encrypt(String alphabet, String key, String message) {
        String encrypted = "";

        message = message.toUpperCase();

        for (int i = 0; i < message.length(); i++){
            char c = message.charAt(i);

            if (alphabet.indexOf(c) > -1) {
                encrypted += key.charAt(alphabet.indexOf(c));
            } else {
                encrypted += c;
            }
        }

        return encrypted;
    }
}
