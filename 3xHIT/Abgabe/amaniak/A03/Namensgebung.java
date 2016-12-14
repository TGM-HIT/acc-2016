import java.util.Scanner;

/**
 * Ein Programm mit dem man aus seinem eigentlichen Namen einen Nicknamen generiert.
 * 
 * @author David Maniak
 * @version 10.12.2016
 */
public class Namensgebung {
	String[] nouns, adjectives, bridge;
	
	/**
	 * Default-Konstruktor bei dem es einen vordefinierten Woerterpool gibt.
	 */
	public Namensgebung() {
		nouns = new String[]{"Athlete", "Bee", "Clown", "Dinosaur", "Eagle", "Font", "Ghost", 
							 "House", "Ice", "Jet", "Kangaroo", "Ladder", "Mouse", "Nose", 
							 "Ork", "Pencil", "Queen", "Rainbow", "Satellite", "Train", 
							 "Uranus", "Van", "Winner", "Xylophone", "Yeti", "Zebra"};
		
		adjectives = new String[]{"Anonymous", "Blue", "Crazy", "Dangerous", "Evil", "Fantastic",
								  "Gigantic", "Happy", "Isolated", "Joyful", "Kind", "Laughing", 
								  "Magical", "Natural", "Oval", "Perfect", "Quiet", "Rainy", "Super", 
								  "Toxic", "Universal", "Vertical", "Warm", "Xtreme", "Young", "Z"};
		
		bridge = new String[]{"Astronaut", "Big", "Cheesy", "Dancing", "Electronic", "Floating", "Goat", 
							  "Hen", "Iron", "Juggling", "King", "Lion", "Mechanical", "Moaning", "Nail", 
							  "Octupus", "Piano", "Quarter", "Running", "Singing", "Telephone", "Umbrella", 
							  "Vegetable", "Walking", "X-Ray", "Yelling", "Zoo"};
		
		String input = inputName();
		String nickname = generateName(input);
		System.out.println("Neuer Nickname: " + nickname);
	}
	
	/**
	 * Konstruktor bei dem die Nomen, Adjektive und Bruecken gesetzt werden koennen.
	 * Damit keine Fehler entstehen, sollten alle Woerter mit einem Grossbuchstaben beginnen.
	 * 
	 * @param nouns die Nomen die man im Generator haben will
	 * @param adjectives die Adjektive die man im Generator haben will
	 * @param bridge die Brueckenwoerter die man im Generator haben will
	 */
	public Namensgebung(String[] nouns, String[] adjectives, String[] bridge) {
		this.nouns = nouns;
		this.adjectives = adjectives;
		this.bridge = bridge;
		
		String input = inputName();
		String nickname = generateName(input);
		System.out.println("Neuer Nickname: " + nickname);
	}
	
	/**
	 * Name wird eingegeben um aus ihm einen Nickname zu generieren.
	 * 
	 * @return der eigegebene Name
	 */
	public String inputName() {
		System.out.print("Namen eingeben: ");
		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		scn.close();
		return input;
	}
	
	/**
	 * Der Nickname wird hier generiert.
	 * 
	 * @param name Der Name aus dem der Nickname generiert werden soll
	 * @return der Nickname
	 */
	public String generateName(String name) {
		name = name.toUpperCase();
		String start = searchWord(name.charAt(0), adjectives);
		String end = searchWord(name.charAt(name.length() - 1), nouns);
		String mid;
		if(name.length() > 8) {
			int index = (int)(name.length()/2);
			mid = searchWord(name.charAt(index), bridge);
			return start + " " + mid + " " + end;
		}
		return start + " " + end;
	}
	
	/**
	 * Es wird nach den Wort gesucht, welches mit dem selben Buchstaben beginnt wie im Parameter bestimmt.
	 * 
	 * @param letter der Buchstabe mit dem das Wort beginnen soll
	 * @param arr das Array in welchem das Wort gesucht werden soll
	 * @return ein Teil des Nicknames
	 */
	public String searchWord(char letter, String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(letter == arr[i].charAt(0))
				return arr[i];
		}
		throw new InvalidCharacterException("Ungueltige(s) Zeichen eingegeben.");
	}
	
	public static void main(String[] args) {
		new Namensgebung();
	}
}
