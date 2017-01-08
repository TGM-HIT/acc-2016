import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kevin_000 on 17.12.2016.
 */
public class Woerterbuch {
    /*
    The translation file has following format:

    <Raw Word 1>
    <Translation 1>
    <Raw Word 2>
    <Translation 2>

    First line is the raw word, then the translation directly afterwards
     */

    /**
     * Reads the translation file or just returns an empty HashMap
     * @param filename The filename for the translation file
     * @return Loaded hashmap
     */
    public static HashMap<String, String> loadOrEmpty(String filename) {
        HashMap<String, String> out = new HashMap<>();

        File fileToRead = new File(filename);
        if(!fileToRead.exists())
            return out;

        try(Scanner fileScanner = new Scanner(fileToRead)) {
            while(fileScanner.hasNext()) {
                String word = fileScanner.next();
                if(!fileScanner.hasNext())
                    throw new RuntimeException("Word without translation!");
                String translation = fileScanner.next();
                out.put(word, translation);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fail to open file!", e);
        }
        return out;
    }

    /**
     * Writes the translation file
     * @param filename The filename for the translation file
     * @param translations The contents of the translations
     */
    public static void write(String filename, HashMap<String, String> translations) {
        try(PrintWriter writer = new PrintWriter(filename)) {
            for(Map.Entry<String, String> entry : translations.entrySet()) {
                writer.println(entry.getKey());
                writer.println(entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fail to open file!", e);
        }

    }


    public static void main(String[] args) {
        String filenameForFile = "translation.txt"; // The translation file

        HashMap<String, String> translations = loadOrEmpty(filenameForFile);

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("AUSGABE: Schreibe 'exit' um das Programm zu verlassen!");
        while(true) {
            System.out.println("AUSGABE: Word to translate?");
            String nextWordToTranslate = inputScanner.nextLine();
            if(nextWordToTranslate.equals("exit")) // Exit the program
                break;
            if(nextWordToTranslate.equals("")) // No input
                continue;


            if(translations.containsKey(nextWordToTranslate)){ // Translation found --> output
                System.out.println(translations.get(nextWordToTranslate));
            } else {
                System.out.println("AUSGABE: Unbekannt! Hinzufügen? (y/n)"); // Translation not found --> Ask to add
                String shouldAdd = inputScanner.nextLine();
                if(shouldAdd.equals("y")) { // Add it!
                    System.out.println("AUSGABE: Neues Wort für \"" + nextWordToTranslate + "\":");
                    String translation = inputScanner.nextLine();
                    translations.put(nextWordToTranslate, translation);
                } else if (shouldAdd.equals("n")) { // Don't add it
                    // NO-OP
                } else { // Invalid input
                    System.out.println("AUSGABE: Ungültige Eingabe \"" + shouldAdd + "\"");
                }
            }
        }

        write(filenameForFile, translations); // Write the translation file
    }

}
