package Main;
import java.util.Scanner;

/**
 * 
 * @author Michael Ebenstein
 * @version 6.12.2016
 * 
 */


public class Main {
	
	
	public static void main(String[] args) {
		if(!Words.loadWords("Main/words.txt"))
			return;
		
		String name;
		System.out.println("Please enter your name!");
		name = new Scanner(System.in).nextLine().toLowerCase();
		
		String out = Words.adjectives.get(name.charAt(0));
		
		if(name.length() > 8){
			out+= " "+Words.bruecken.get(name.charAt(name.length()/2));
			System.out.println(name.charAt(name.length()/2));
		}
		
		out+= " "+Words.nomen.get(name.charAt(name.length()-1));
		
		System.out.println(out);
	}
}
