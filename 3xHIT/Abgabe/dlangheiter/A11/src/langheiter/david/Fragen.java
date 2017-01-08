package langheiter.david;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;

public class Fragen {
	
	private File file;
	private List<Frage> questions;
	private int currentFrage;
	
	public Fragen(String filePath) {
		this.file = new File(filePath);
		currentFrage = -1;
		questions = new ArrayList<>();
	}
	
	public Frage getNextFrage() {
		currentFrage++;
		if(currentFrage >= questions.size()) {
			currentFrage = 0;
		}
		return questions.get(currentFrage);
	}
	
	public int getCurrentAnswer() {
		return questions.get(currentFrage).getCorrect();
	}
	
	public void addFrage(Frage frage) {
		boolean ok = true;
		for(Frage f : questions) {
			if(f.getQuestion().equals(frage.getQuestion())) {
				ok = false;
			}
		}
		if(!ok) return;
		questions.add(frage);
	}
	
	public void loadFromFile() {
		if(!file.exists()) {
			saveToFile();
			return;
		}
		String content = "";
		Scanner fileScan;
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			return;
		}
		if(!fileScan.hasNext()) {
			fileScan.close();
			return;
		}
		fileScan.useDelimiter("\\Z");
		content = fileScan.next();
		fileScan.close();
		
		try {
			JSONArray t = new JSONArray(content);
			for(int i = 0; i < t.length(); i++) {
				Frage f = new Frage(t.getJSONObject(i));
				addFrage(f);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void saveToFile() {
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(this.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public String toString() {
		JSONArray t = new JSONArray();
		for(Frage f : questions) {
			t.put(f.getJSONObject());
		}
		return t.toString();
	}
	
}
