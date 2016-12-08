package modliba;

import java.util.Scanner;

/**
 * Diese Klasse generiert einen Nickname aus einem Vornamen
 * 
 * @author Daniel Modliba
 * @version 07-12-2016
 */
public class NameGenerator {

	// Dieser String enthaelt die moeglichen Anfaenge der Nicknames
	public static String[] adjectives = { "Awesome", "Brave", "Cool", "Dumb", "Egocentric", "Famous", "Glory", "Happy",
			"Insane", "Jealous", "Kind", "Light", "Mean", "Nosey", "Organic", "Phenomenal", "Qualified", "Raw", "Sexy",
			"Tired", "Unbelievable", "Vanilla", "Well-Known", "Xenial", "Young", "Zippy" };
	// Dieser String enthaelt die moeglichen Mittelteile der Nicknames
	public static String[] bridges = { "Ant", "Boolean", "Character", "Double", "Exception", "Float", "Goose",
			"Hamster", "Integer", "Java", "King", "Long", "Method", "Null", "Object", "Panel", "Query", "Random",
			"Short", "Transistor", "Ubuntu", "Vowel", "While", "X-Ray", "Yankee", "Zorro" };
	// Dieser String enthaelt die moeglichen Enden der Nicknames
	public static String[] nouns = { "Apple", "BigFoot", "Clown", "Dude", "Eagle", "Fly", "Giant", "Hammer", "Insect",
			"Judge", "Key", "Lobster", "Monkey", "Newby", "Ogre", "Pen", "Queue", "Rectangle", "String", "Turkey",
			"Umbrella", "Ventilator", "Wolf", "Xylophone", "Yeti", "Zebra" };
	// Dieser String enthaelt das Alphabet welches fuer Abfragen benoetigt wird
	public static String a = "abcdefghijklmnopqrstuvwxyz";

	// Dieses Praefix wird vor jeder Eingabe- und Ausgabezeile ausgegeben
	public static String prefix = ">> ";

	/**
	 * Standard main-Methode des Programms
	 * 
	 * @param args
	 *            Die Argumente des Programms
	 * @since 07-12-2016
	 */
	public static void main(String[] args) {
		printName(readName());
	}

	/**
	 * Gibt einen Nickname aus
	 * 
	 * @param name
	 *            Der Vorname aus dem der Nickname generiert werden soll
	 * @since 07-12-2016
	 */
	public static void printName(String name) {
		name = name.toLowerCase();
		System.out.print(prefix + generateName(name));
	}

	/**
	 * Generiert einen Nickname aus einem Vornamen
	 * 
	 * @param name
	 *            Der Vorname aus dem der Nickname generiert wird
	 * @return Der Nickname
	 * @since 07-12-2016
	 */
	public static String generateName(String name) {
		String newName = "";
		newName += adjectives[a.indexOf(name.charAt(0))] + " ";
		if (name.length() > 8) {
			newName += bridges[a.indexOf(name.charAt((int) (name.length() / 2)))] + " ";
		}
		newName += nouns[a.indexOf(name.charAt(name.length() - 1))];

		return newName;
	}

	/**
	 * Liest vom Benutzer einen Namen ein
	 * 
	 * @return Der Name des Benutzers
	 * @since 07-12-2016
	 */
	public static String readName() {
		System.out.println("Gib bitte deinen Vornamen ohne Sonderzeichen ein!");
		System.out.print(prefix);
		Scanner s = new Scanner(System.in);
		return s.next();
	}

}
