package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * A simple dictionary<br>
 * Available in English, German, French and Spain!<br>
 * 
 * @author Peter Fuchs
 * @version 14 Dec 2016
 */
public class Wörterbuch {
	private String input;
	private Scanner s;
	private File f;
	
	private int openedTab;
	
	private static final int MENU = 0;
	private static final int DICT = 1;
	private static final int SETTINGS = 2;
	private static final int HELP = 3;
	
	private Setting[] settings;
	
	/**
	 * Default Constructor<br>
	 * Creates a dictionary with English-German translation<br>
	 * Calls the {@linkplain #Wörterbuch(int, Setting, Setting) main-Constructor}
	 */
	public Wörterbuch() {
		new Wörterbuch(Wörterbuch.MENU,
				new Setting(Setting.createValues("de", "en", "fr", "esp"), "lang", "en"),
				new Setting(Setting.createValues("de", "en", "fr", "esp"), "translate to", "de"));
	}
	
	/**
	 * main-Constructor
	 * 
	 * @param openedTab - the actually opened tab
	 * @param lang - settings for {@linkplain Setting} language
	 * @param trans - settings for {@linkplain Setting} translation
	 */
	public Wörterbuch(int openedTab, Setting lang, Setting trans) {
		settings = new Setting[0];
		addSetting(lang);
		addSetting(trans);

		s = new Scanner(System.in);
		f = new File("wörterbuch_"+getSettingByName("lang").getSelectedValue()+"-"+getSettingByName("translate to").getSelectedValue()+".txt");
		this.openedTab = openedTab;
				
		try {
			if(!f.exists()) {
				f.createNewFile();
				System.out.println("Creating new dictionary");
			}
		} catch (IOException e) {
			System.out.println("An error occured!\nTerminating...");
			System.exit(-1);
		}
		
		do {
			switch (this.openedTab) {
			case Wörterbuch.MENU: menu();
			break;
			case Wörterbuch.DICT: dictionary(0, null, false);
			break;
			case Wörterbuch.SETTINGS: settings(0);
			break;
			case Wörterbuch.HELP: help();
			break;
			}
			
			if (input.equalsIgnoreCase("exit") && this.openedTab != Wörterbuch.DICT) System.exit(0);;
		} while (true);
	}
	
	/**
	 * Shows a helping menu
	 */
	private void help() {
		System.out.println("");
		System.out.println("[translate | trans] opens an input field where you can\n\ttranslate words or save untranslated ones\n");
		System.out.println("[settings | set] gives you the possibility to change the\n\tlanguage you want to translate, or the language you want to translate to\n");
		System.out.println("[exit] exits the program\n");
		System.out.println("Press \"exit\" to exit the program or Enter to leave the help-window");
		
		input = s.nextLine();
		
		if (input.equals("exit"))
			System.exit(0);
		else this.openedTab = Wörterbuch.MENU;
	}

	/**
	 * prints out the menu with possibilities for the user to choose
	 */
	private void menu() {
		System.out.println("Your options:");
		System.out.println("[translate | trans]");
		System.out.println("[settings | set]");
		System.out.println("[help | [?]");
		System.out.println("[exit]\n\n\n\n");
		
		System.out.print(">> ");
		input = s.nextLine();
		if (input.equalsIgnoreCase("translate") || input.equalsIgnoreCase("trans"))
			this.openedTab = Wörterbuch.DICT;
		else if (input.equalsIgnoreCase("settings") || input.equalsIgnoreCase("set"))
			this.openedTab = Wörterbuch.SETTINGS;
		else if (input.equalsIgnoreCase("help") || input.equals("?"))
			this.openedTab = Wörterbuch.HELP;
	}

	/**
	 * @param name the name of the setting to return
	 * @return the setting with the name of the parameter<br>
	 * if the name is invalid it returns null
	 */
	private Setting getSettingByName(String name) {
		for (Setting s : settings)
			if (s.getName().equals(name))
				return s;
		
		return null;
	}

	/**
	 * Adds a setting to settings
	 * @param setting the setting to add
	 */
	private void addSetting(Setting setting) {
		Setting[] helpArray = new Setting[settings.length+1];
		for (int i = 0; i < settings.length; i++)
			helpArray[i] = settings[i];
		helpArray[helpArray.length-1] = setting;
		settings = helpArray;
	}

	/**
	 * Shows the settings-menu to the user
	 * @param lines the lines that are printed out before calling this method
	 */
	private void settings(int lines) {
		System.out.println("Settings:");
		for (Setting setting : settings)
			System.out.println(setting.getName() + " : " + setting.getSelectedValue());
		for (int i = 8-settings.length-lines; i > 0; i--)
			System.out.println("");
		
		System.out.print(">> ");
		input = s.nextLine();
		
		if (input.equals("back"))
			this.openedTab = Wörterbuch.MENU;
		else if (input.equals("exit"))
			System.exit(0);
		else {
			for (Setting setting : settings)
				if (input.equals(setting.getName()))
					changeSetting(setting);
		}
	}

	/**
	 * gives the user the possibility to change a setting<br>
	 * with input possibility via the console
	 * @param setting the setting to change
	 */
	private void changeSetting(Setting setting) {
		System.out.println("You are acutally editing setting " + setting.getName());
		System.out.println("The current value is " + setting.getSelectedValue());
		System.out.println("The options for the setting are: ");
		for (Object o : setting.getValues())
			System.out.println(o);
		
		System.out.println("Please insert the new value!");
		for (int i = 6-setting.getValues().length; i > 0; i--)
			System.out.println("");

		System.out.print(">> ");
		input = s.nextLine();
		for (Object o : setting.getValues())
			if (input.equals(o)) {
				Object lang_old = setting.getSelectedValue();
				setting.setSelectedValue(input);
				if (input.equals(getSettingByName("translate to").getSelectedValue()))
					getSettingByName("translate to").setSelectedValue(lang_old);

				new Wörterbuch(Wörterbuch.SETTINGS, getSettingByName("lang"), getSettingByName("translate to"));
				
				return;
			}
		System.out.println("Incorrect input, please insert a valid input!");
		settings(1);
	}
	
	/**
	 * Shows the user the menu of the dictionary<br>
	 * and gives him the possibility to translate a word
	 * 
	 * @param lines - the lines written before calling this method 
	 * @param trans - the translation of a word
	 * @param needToTranslate - if the word is already translated
	 */
	private void dictionary(int lines, String trans, boolean needToTranslate) {
		System.out.println("Type \"?\" for help");
		
		String wordToTranslate = "";
		if (trans != null)
			lines = (needToTranslate) ? 0 : 1;
		if (trans != null && !trans.equals(""))
			System.out.println("Your word: " + input + " means " + trans);
		
		if (needToTranslate) {
			System.out.println("The word is not saved in the dictionary, please insert the translation of the word:");
			System.out.println("");
			wordToTranslate = input;
		}
		else {
			System.out.println("Please insert the word you want to translate:");
			System.out.println("You are actually translating: " +getSettingByName("lang").getSelectedValue() + " to "
					+getSettingByName("translate to").getSelectedValue());
		}
		for (int i = 0; i < 6-lines; i++)
			System.out.println("");
		System.out.print(">> ");
		input = s.nextLine();
		
		if (input.equals("?") || input.equals("/help"))
			helpDictionary();
		else if (input.equals("/exit"))
			System.exit(0);
		else if (input.equals("/back"))
			this.openedTab = Wörterbuch.MENU;
		else if (needToTranslate) writeTranslation(wordToTranslate, input);
		else checkTranslation(input);
	}

	/**
	 * Writes a translation into the file
	 * @param word - the word to translate
	 * @param translation - the translation
	 */
	private void writeTranslation(String word, String translation) {
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			while (true) {
				String text = raf.readLine();
				if (text == null || text.equals(""))
					break;
			}
			raf.writeBytes(word + "\t" +translation + "\r\n");
			raf.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file!");
			System.out.println("Creating file...");
			try {
				if(f.createNewFile())
					System.out.println("File successfully created!");
			} catch (IOException e_IO) {
				System.out.println("File could not be created!\nTerminating...");
				System.exit(-1);
			}
		} catch (IOException e) {
			System.out.println("An error occured!\nTerminating...");
			System.exit(-1);
		}
	}

	/**
	 * Checks if this translation is available
	 * @param input - the word to translate
	 */
	private void checkTranslation(String input) {
			try {
				if(f.canRead()) {
					RandomAccessFile raf = new RandomAccessFile(f, "rw");
					String text = "";
					String translation = "";
					do {
						text = raf.readLine();
						if (text == null || text.equals("")) break; 
						if (text.substring(0, text.indexOf("\t")).equals(input)) 
							translation = text.substring(text.indexOf("\t")+1, text.length());
					} while (true);
					dictionary(1, translation, translation.equals(""));
					
					raf.close();
				}
			} catch (IOException e) {
				System.out.println("An error occured!\nTerminating...");
				System.exit(-1);
			}
	}

	/**
	 * Shows the help menu of the dictionary-menu
	 */
	private void helpDictionary() {
		System.out.println("Type \"/back\" to return to menu");
		System.out.println("Type \"/exit\" to exit the program");
		dictionary(2, null, false);
	}
}
