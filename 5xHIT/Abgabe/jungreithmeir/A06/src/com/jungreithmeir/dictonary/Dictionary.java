package com.jungreithmeir.dictonary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.j256.ormlite.dao.Dao;
import com.jungreithmeir.database.DatabaseDAO;
import com.jungreithmeir.database.Translation;
import com.rmtheis.yandtran.ApiKeys;
import com.rmtheis.yandtran.language.Language;
import com.rmtheis.yandtran.translate.Translate;

/**
 * Based on the Yandex Language API and on Robert Theis' Java wrapper
 * (https://github.com/rmtheis/yandex-translator-java-api).
 * For the data persistence ORMLITE has been used in conjunction with H2.
 * 
 * This tool offers the functionality of translating English words and phrases with two core components.
 * 1. Translation via an API, provided by Yandex. This service is definitely not as good as the Google Translate API,
 * but as Google's implementation can not be used free of charge I decided to use these.
 * 2. The user has the possibility to save his or her own translation for every given word/phrase. The initial
 * assignment mentioned something regarding multiple files for accessing large dictionaries, but I honestly didn't
 * think that this would work particulary well and simply implemented this part with a minimal-overhead file-based
 * database solution, namely H2.
 * 
 * @author Jakob Jungreithmeir
 * @version 1.0 12-12-2016
 */
public class Dictionary {

	Dao<Translation, String> db;
	
	private String banner = "\n" +
"   dBBBBBBBBBBBBBBBBBBBBBBBBb\n" +
"  BP YBBb                 YBBb\n" +
" dB   YBb     Dictionary    YBb  Welcome to Jakob's Dictionary program.\n" +
" dB    YBBb                 YBBb\n" +
"  Yb    YBBBBBBBBBBBBBBBBBBBBBBBb  This little tool translates words & phrases\n" +
"   Yb    YBBBBBBBBBBBBBBBBBBBBBBBb  from English to German. It also offers you\n" +      
"    Yb    YBBBBBBBBBBBBBBBBBBBBBBBb  the possibility to save your own\n" +
"     Yb    YBBBBBBBBBBBBBBBBBBBBBBBb  suggestions.\n" +
"      Yb    YBBBBBBBBBBBBBBBBBBBBBBBb\n" +
"       Yb   dBBBBBBBBBBBBBBBBBBBBBBBBb	 Enter quit or exit to leave.\n" +
"        Yb dP=======================/\n" +
"         YbB=======================(\n" +
"          Ybb=======================\\\n" +
"           Y888888888888888888DSI8888b          © Jakob Jungreithmeir 2016\n";
	
	/**
	 * Sets up the Yandex translator and the database connection.
	 */
	public Dictionary() {
        Translate.setKey(ApiKeys.YANDEX_API_KEY);
        db = DatabaseDAO.getInstance();
        
	}
	
	/**
	 * Self-explanatory method being self-explanatory... ;)
	 */
	public void displayBanner() {
		System.out.println(this.banner);
	}

	/**
	 * Uses the Yandex Wrapper to translate given words/phrases.
	 * 
	 * @param text - to be translated
	 * @param langOriginal
	 * @param langTranslation
	 * @return
	 */
	private String translate(String text, Language langOriginal, Language langTranslation) {
		String translation = "";
		try {
			translation = Translate.execute(text, langOriginal, langTranslation);
		} catch (Exception e) {
			/* I would've really like to implement proper error handling, but the library I base my work on
			 * barely has any documentation on that matter which makes it hard to understand when which 
			 * kind of exception is thrown.
			 */
			System.err.println("The translation could not be performed.");
			System.exit(1);
		}
		return translation;
	}
	
	/**
	 * Uses Yandex wrapper to translate given words/phrases from German to English.
	 * 
	 * @param text - to be translated
	 * @return - translated text
	 */
	@SuppressWarnings("unused") /* For future uses */
	private String translateGERtoEN(String text) {
		return translate(text, Language.GERMAN, Language.ENGLISH);
	}
	
	/**
	 * Uses Yandex wrapper to translate given words/phrases from English to German.
	 * 
	 * @param text - to be translated
	 * @return - translated text
	 */
	private String translateENtoGER(String text) {
		return translate(text, Language.ENGLISH, Language.GERMAN);
	}
	
	/**
	 * Saves a translation object to the database file (H2 in this context).
	 * @param translation - Dataset mapping
	 */
	private void persist(Translation translation) {
		try {
			db.create(translation);
		} catch (SQLException e) {
			System.err.println("Could not persist data.");
			System.exit(1);
		}
	}
	
	/**
	 * Returns translations which have already been saved to the database file.
	 * 
	 * @param text - Which text's translation to look for
	 * @return - String containing translations, seperated by comma (if multiple translations would be possible).
	 */
	private String getPersistedTranslations(String text) {
		List<Translation> results = null;
		try {
			results = db.queryBuilder().where().eq(Translation.wordEnglishName, text).query();
		} catch (SQLException e) {
			System.err.println("Could not send/execute sql query.");
			System.exit(1);
		}
		
		/* Transforming result objects into a coherent string for displaying purposes. */
		List<String> translations = new ArrayList<String>();
		for (Translation result : results) {
			translations.add(result.getWordGerman());
		}
		
		return String.join(", ", translations);
	}
	
	/**
	 * Main method which simply constantly asks the user for input and then sends it to the appropriate parts of
	 * the dictionary instance.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		dict.displayBanner();
		Scanner stdIN = null;
		try {
	    stdIN = new Scanner(System.in);
   	 	System.out.print("INPUT: ");
	     while (stdIN.hasNext()) {
	    	 String line = null;
	    	 if (!(line = stdIN.nextLine()).isEmpty()) {
	    		 
	    		 if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) {
	    			 return;
	    		 }
	    		 
	    		 String ownTranslation;
	    		 if(!(ownTranslation = dict.getPersistedTranslations(line)).isEmpty()) {
			    	 System.out.println("Translation:\n" + 
			    			 			"Yandex API: " + dict.translateENtoGER(line) + 
			    			 			"\nOwn translation: " + ownTranslation);
	    		 } else {
	    			 String translation = dict.translateENtoGER(line);
			    	 System.out.println("Translation:\n" + "Yandex API: " + translation);
			    	 
			    	 if (!translation.isEmpty()) {
				    	 System.out.println("Do you want to add your own translation? [Y/n]");
				    	 String confirmation = stdIN.nextLine();
				    	 if (confirmation.isEmpty()) {
				    		 System.out.println("Please enter your own translation: ");
				    		 String newTranslation = stdIN.nextLine();
				    		 dict.persist(new Translation(line, newTranslation));
				    	 }
			    	 }
	    		 }
	    	 }
	    	 System.out.print("INPUT: ");
	     }
		} finally {
	     stdIN.close();
		}
	}	
}
