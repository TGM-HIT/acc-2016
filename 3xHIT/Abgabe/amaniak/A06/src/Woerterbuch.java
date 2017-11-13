import java.io.*;
import java.util.Scanner;

/**
 * Ein Woerterbuch welches englische Woerter in Deutsche uebersetzt.
 * Falls ein Wort im Woerterbuch nicht vorhanden ist, kann dieses geaddet werden.
 * 
 * @author David Maniak
 * @version 14.12.2016
 */
public class Woerterbuch {
	private File file;
	private FileWriter writer;
	private FileReader reader;
	private BufferedReader bReader;
	private Scanner scn;
	private boolean repeat = true;
	
	/**
	 * Default-Konstruktor
	 * 
	 * @throws IOException
	 */
	public Woerterbuch() throws IOException {
		file = new File("dictionary.txt");
		writer = new FileWriter(file, true);
		
		while(repeat) {
			System.out.println("Word to translate? (type in \"ccc\" to exit)");
			System.out.print("INPUT: ");
			
			scn = new Scanner(System.in);
			String x = scn.nextLine();
			
			wantToQuit(x);
			searchWord(x);
		} 
	}
	
	/**
	 * Prueft ob der Benutzer "ccc" eingegeben hat, und ob das Programm beendet werden soll.
	 * 
	 * @param input Die eígentlich zu uebersetzende Wort
	 * @throws IOException
	 */
	public void wantToQuit(String input) throws IOException {
		if(input.equals("ccc")) {
			System.out.println("Program will shutdown.");
			repeat = false;
			
			writer.close();
			reader.close();
			bReader.close();
			
			System.exit(0);
		}
	}
	
	/**
	 * Es wird in der File nach dem zu uebersetzenden Wort gesucht und wenn
	 * es gefunden wurde, wird die Uebersetzung angezeigt.
	 * Wenn es das Wort noch nicht gibt, kann es hinzugefuegt werden.
	 * 
	 * @param word Wort welches uebersetzt werden soll
	 * @throws IOException
	 */
	public void searchWord(String word) throws IOException {
		String oldWord = word;
		word = "E°" + word + "D°";
		
		reader = new FileReader(file);
		bReader = new BufferedReader(reader);
		
		boolean loop = true;
		
		while(loop) {
			String x = bReader.readLine();
			
			if(x != null && x.startsWith(word)) {
				loop = false;
				
				int wordLength = word.length();
				printWord(x.substring(wordLength));
				return;
			}
			
			if(x == null)
				loop = false;
		}
		addWord(oldWord);
	}
	
	/**
	 * Es wird ein Wort mit zugehoeriger Uebersetzung in Woerterbuch gespeichert.
	 * 
	 * @param word das Wort welches hinzugefuegt werden soll
	 * @throws IOException
	 */
	public void addWord(String word) throws IOException {
		System.out.print("\"" + word + "\" doesn't exist! Want to add it?(true/false)");
		
		if(!scn.nextBoolean())
			return;
		
		System.out.print("German word for \"" + word + "\": ");
		scn = new Scanner(System.in);
		String newWord = scn.nextLine();
		
		writer.write("\nE°" + word + "D°" + newWord);
		writer.flush();
		
		System.out.println(word + " now means: " + newWord);
		System.out.println("=====================");
	}
	
	/**
	 * Das englische Wort wird in der Konsole ausgegeben.
	 * 
	 * @param word Das uebersetzte Wort welches ausgegeben wird
	 */
	public void printWord(String word) {
		System.out.println("OUTPUT: " + word);
		System.out.println("=====================");
	}
	
	public static void main(String[] args) {
		try {
			new Woerterbuch();
		} catch(IOException ex) {
			System.err.println(ex);
		}
	}
}
