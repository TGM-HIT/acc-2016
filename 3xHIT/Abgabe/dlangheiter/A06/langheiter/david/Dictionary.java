package langheiter.david;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Dictionary {
	
	private HashMap<String, String> dict;
	private String filePath;
	
	public Dictionary() {
		dict = new HashMap<>();
		filePath = System.getProperty("user.home") + "\\AppData\\dict";
		new File(filePath).mkdirs();
		filePath += "\\dict.sav";
		if(!loadFromFile(filePath)) {
			saveToFile(filePath);
		}
	}
	
	private boolean loadFromFile(String path) {
		Scanner file;
		try {
			file = new Scanner(new File(path));
			while(file.hasNextLine()) {
				Scanner line = new Scanner(file.nextLine());
				try {
					String key = line.next();
					String val = line.next();
					dict.put(key, val);
				} catch(NoSuchElementException e) {
					// NOTHING: Wrong entry. Ignore
				}
				line.close();
			}
			file.close();
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}
	
	private void saveToFile(String path) {
		try {
			PrintWriter pw = new PrintWriter(path);
			for (Map.Entry<String, String> entry : dict.entrySet()) {
				pw.write(entry.getKey() + " " + entry.getValue() + "\n");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void save() {
		saveToFile(filePath);
	}
	
	public void addTranslation(String key, String val) {
		dict.put(key.toLowerCase(), val);
	}
	
	public String getTranslation(String search) {
		search = search.toLowerCase();
		if(dict.containsKey(search)) {
			return dict.get(search);
		}
		return null;
	}
	
}
