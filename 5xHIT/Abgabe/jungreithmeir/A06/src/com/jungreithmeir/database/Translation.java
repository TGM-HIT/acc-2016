package com.jungreithmeir.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Mapping to the appropriate sql structure for the translations.
 * 
 * @author Jakob Jungreithmeir
 * @version 1.0 12-12-2016
 */
@DatabaseTable(tableName = "translations")
public class Translation {

	public static final String wordEnglishName = "wordEnglish";
	public static final String wordGermanName = "wordGerman";
	
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = wordEnglishName, uniqueCombo = true)
    private String wordEnglish;
    @DatabaseField(columnName = wordGermanName, uniqueCombo = true)
    private String wordGerman;

    public Translation() {
        // ORMLite needs a no-arg constructor 
    }
    
    public Translation(int id, String wordEnglish, String wordGerman) {
    	this.id = id;
    	this.wordEnglish = wordEnglish;
    	this.wordGerman = wordGerman;
    }

    public Translation(String wordEnglish, String wordGerman) {
    	this.wordEnglish = wordEnglish;
    	this.wordGerman = wordGerman;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWordEnglish() {
		return wordEnglish;
	}

	public void setWordEnglish(String wordEnglish) {
		this.wordEnglish = wordEnglish;
	}

	public String getWordGerman() {
		return wordGerman;
	}

	public void setWordGerman(String wordGerman) {
		this.wordGerman = wordGerman;
	}
	
}
