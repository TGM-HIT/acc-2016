package main;

import java.util.HashMap;
import java.util.Scanner;

/**
 * A program to create random names
 * 
 * 
 * @author Peter Fuchs
 * @version 7 Dec 2016
 */
public class Main {
	private static HashMap<Character, String> adjectives;
	private static HashMap<Character, String> bridge;
	private static HashMap<Character, String> nouns;
	
	/**
	 * Start the program
	 */
	public static void main(String[] args) {
		init();
		
		System.out.println("Please insert your name!");
		Scanner s = new Scanner(System.in);
		System.out.print(">> INPUT: ");
		System.out.println(">> OUTPUT: " + getName(s.nextLine()));
		
		s.close();
	}
	
	/**
	 * @param nextLine the input of the user
	 * @return the name
	 */
	public static String getName(String nextLine) {
		nextLine = setNamable(nextLine);
		String output = adjectives.get(nextLine.charAt(0)) + " ";
		if (nextLine.length() > 8)
			output += bridge.get(nextLine.charAt((int) (nextLine.length()/2))) + " ";
		output += nouns.get(nextLine.charAt(nextLine.length()-1));
		
		return output;
	}

	/**
	 * Deletes all spaces, upper-cased letters and numbers of the input
	 * @param nextLine the input of the user
	 * @return the new String
	 */
	private static String setNamable(String nextLine) {
		nextLine = nextLine.toLowerCase();
		nextLine = nextLine.replaceAll(" ", "");
		for (int i = 0; i < 10; i++)
			nextLine = nextLine.replaceAll(i+"", "");
		return nextLine;
	}

	/**
	 * Initalize the attributes
	 */
	private static void init() {
		initAdjectives();
		initBridge();
		initNouns();
	}

	/**
	 * Initialize adjectives
	 */
	public static void initAdjectives() {
		adjectives = new HashMap<Character, String>();
		adjectives.put('a', "alcoholic");
		adjectives.put('b', "bionomic");
		adjectives.put('c', "childish");
		adjectives.put('d', "dozy");
		adjectives.put('e', "extravagant");
		adjectives.put('f', "friendly");
		adjectives.put('g', "gigantic");
		adjectives.put('h', "high");
		adjectives.put('i', "interesting");
		adjectives.put('j', "jealous");
		adjectives.put('k', "kind");
		adjectives.put('l', "luxorious");
		adjectives.put('m', "meaningful");
		adjectives.put('n', "nonsense-talking");
		adjectives.put('o', "original");
		adjectives.put('p', "phlegmatic");
		adjectives.put('q', "qabalistic");
		adjectives.put('r', "ridiculous");
		adjectives.put('s', "superduperwows");
		adjectives.put('t', "tolerant");
		adjectives.put('u', "unexperienced if you know what i mean ;)");
		adjectives.put('v', "vertical");
		adjectives.put('w', "wow-factoring");
		adjectives.put('x', "xtreme");
		adjectives.put('y', "y u do thistic");
		adjectives.put('z', "zigzag");
	}

	/**
	 * initialize bridge
	 */
	public static void initBridge() {
		bridge = new HashMap<Character, String>();
		bridge.put('a', "apple");
		bridge.put('b', "bound");
		bridge.put('c', "curiosity");
		bridge.put('d', "downfall");
		bridge.put('e', "element");
		bridge.put('f', "freedom");
		bridge.put('g', "googlistic");
		bridge.put('h', "honey");
		bridge.put('i', "indian");
		bridge.put('j', "jitter");
		bridge.put('k', "klosterneuburg is best");
		bridge.put('l', "laughmouth");
		bridge.put('m', "mouthlaugh");
		bridge.put('n', "nonsense-talker");
		bridge.put('o', "output");
		bridge.put('p', "periodicallywally");
		bridge.put('q', "quark");
		bridge.put('r', "rumbler");
		bridge.put('s', "supercalifragilisticexpialidocious");
		bridge.put('t', "tons-weighing");
		bridge.put('u', "unexpected");
		bridge.put('v', "vaginal");
		bridge.put('w', "wow-factor");
		bridge.put('x', "xtremistic");
		bridge.put('y', "yellowbearded");
		bridge.put('z', "ziggeding");
	}

	/**
	 * initalize nouns
	 */
	public static void initNouns() {
		nouns = new HashMap<Character, String>();
		nouns.put('a', "account-spammer");
		nouns.put('b', "bear");
		nouns.put('c', "conclusion-finder");
		nouns.put('d', "dolphin");
		nouns.put('e', "eagle who likes foxes and is second place after the fox ^^");
		nouns.put('f', "fox which is the most beatuiful animal of the world <3");
		nouns.put('g', "gigant");
		nouns.put('h', "harambe");
		nouns.put('i', "intelligent dumb ironic outsiding teammate (read the first characters...)");
		nouns.put('j', "jeater with j");
		nouns.put('k', "klosterneuburg-lover");
		nouns.put('l', "luxus-spoiled-kid");
		nouns.put('m', "mister");
		nouns.put('n', "null and nothing else");
		nouns.put('o',	"Oskar");
		nouns.put('p', "poison");
		nouns.put('q', "quack");
		nouns.put('r', "riddler");
		nouns.put('s', "slytherin");
		nouns.put('t', "tpleaseinseryourpassword");
		nouns.put('u', "uganda-guy");
		nouns.put('v', "viennese");
		nouns.put('w', "wow");
		nouns.put('x', "xtremist");
		nouns.put('y',	"yolodolowow");
		nouns.put('z', "zoologist");
	}
}
