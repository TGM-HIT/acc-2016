import javax.swing.*;
import java.util.HashMap;

/**
 * @author Markus Reichl
 * @version 05.12.2016
 */

public class NameGen {
    static HashMap<Character, String> adjectives = new HashMap<>();
    static HashMap<Character, String> pronouns = new HashMap<>();
    static HashMap<Character, String> nouns = new HashMap<>();

    public static void main(String[] args) {
        // Put values into dictionary
        adjectives.put('A', "Almighty");
        adjectives.put('B', "Burning");
        adjectives.put('C', "Crying");
        adjectives.put('D', "Dark");
        adjectives.put('E', "Eccentric");
        // Put values into dictionary
        pronouns.put('A', "Artistic");
        // Put values into dictionary
        nouns.put('A', "Ant");

        while (true) {
            String name = JOptionPane.showInputDialog("Your name? (q for quit)");
            if (name == null || name.equals("q")) break;

            System.out.println("Your are a " + generate(name) + "!");
        }
    }


    static String generate(String name) {
        String nick = "";

        name = name.toUpperCase();

        nick += adjectives.get(name.charAt(0)) + " ";

        if (name.length() > 5) {
            nick += pronouns.get(name.charAt(name.length() / 2)) + " ";
        }

        nick += nouns.get(name.charAt(name.length() - 1));

        return nick;
    }
}
