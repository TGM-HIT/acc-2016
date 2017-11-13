package langheiter.david;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordList {
	
	private Map<Character, String> words;
	private int start = 97;
	private String name;
	private File saveFile;
	
	public WordList(File file, String name) {
		this(name);
		saveFile = file;
		loadFromFile();
	}
	
	public WordList(String wordList, String name) {
		this(name);
		loadFromString(wordList);
	}
	
	public WordList(String name) {
		this.name = name;
		words = new HashMap<>();
		for(int i = 0; i < 26; i++) {
			char c = (char) (start+i);
			setWord(c, c + "");
		}
	}
	
	public boolean setWord(char c, String word) {
		c = toLowerCase(c);
		if(inRange(c)) {
			if(!word.isEmpty()) {
				words.put(c, word);
				return true;
			}
		}
		return false;
	}
	
	public String getWord(char c) {
		c = toLowerCase(c);
		if(inRange(c)) {
			if(words.containsKey(c)) {
				return words.get(c);
			}
		}
		return null;
	}
	
	public boolean inRange(char c) {
		return c >= 97 && c <= 122; 
	}
	
	public char toLowerCase(char c) {
		return Character.toLowerCase(c);
	}
	
	public void loadFromFile() {
		loadFromFile(saveFile);
	}
	
	public void loadFromFile(File file) {
		if(!file.exists()) {
			return;
		}
		Scanner str;
		try {
			str = new Scanner(file);
		} catch (FileNotFoundException e) {
			return;
		}
		while(str.hasNextLine()) {
			Scanner line = new Scanner(str.nextLine());
			if(!line.hasNext()) { line.close(); continue; }
			String ch = line.next();
			if(!line.hasNext()) { line.close(); continue; }
			String word = line.next();
			line.close();
			if(ch.length() == 1) {
				setWord(ch.charAt(0), word);
			}
		}
		str.close();
	}
	
	public void loadFromString(String s) {
		Scanner str = new Scanner(s);
		while(str.hasNextLine()) {
			Scanner line = new Scanner(str.nextLine());
			if(!line.hasNext()) { line.close(); continue; }
			String ch = line.next();
			if(!line.hasNext()) { line.close(); continue; }
			String word = line.next();
			line.close();
			if(ch.length() == 1) {
				setWord(ch.charAt(0), word);
			}
		}
		str.close();
	}
	
	public void saveToFile() {
		saveToFile(saveFile);
	}
	
	public void saveToFile(File file) {
		if(!file.exists()) {
			return;
		}
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.write(this.toString());
			pw.close();
		} catch (FileNotFoundException e) {}
	}
	
	@Override
	public String toString() {
		String ret = "";
		
		for(int i = 0; i < 26; i++) {
			char c = (char) (start + i);
			ret += c + " " + getWord(c) + "\n";
		}
		
		return ret;
	}
	
	public String getName() {
		return name;
	}
	
	public File getSaveFile() {
		return saveFile;
	}
	
	public void setSaveFile(File saveFile) {
		this.saveFile = saveFile;
	}
	
}
