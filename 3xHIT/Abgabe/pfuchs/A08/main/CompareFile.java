package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CompareFile extends File {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<String, Integer> wordsValue;
	LinkedList<String> words;

	public CompareFile(File file) {
		super(file, "");
		
		wordsValue = new HashMap<String, Integer>();
		words = new LinkedList<String>();
		
		try {
			RandomAccessFile raf = new RandomAccessFile(super.getPath(), "r");
			while(true) {
				String line = raf.readLine();
				if (line == null || line == "") break;
				String[] words = line.split(" ");
				
				for (String s : words) {
					if (this.wordsValue.containsKey(s)) {
						int value = this.wordsValue.get(s);
						value++;
						this.words.add(s);
						this.wordsValue.put(s, value);
					} else {
						this.words.add(s);
						this.wordsValue.put(s, 1);
					}
				}
			}
			
			raf.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found!");
			return;
		} catch (IOException e) {
			System.out.println("An error occured!\nCould not read the file's names");
		}
	}
	
	public double compareWords(CompareFile f) {
		double percentage = 0.0;
		int nrPercentages = 0;
		
		Iterator<String> it = words.iterator();
		while (it.hasNext()) {
			String word = it.next();
			if (!f.wordsValue.containsKey(word)) {
				nrPercentages++;
				percentage += 0;
			}
			else {
				int val1 = wordsValue.get(word);
				double val2 = f.wordsValue.get(word)+0.0;
				if (val1 > val2)
					percentage += val2/val1;
				else percentage += val1/val2;
				nrPercentages++;
			}
		}
		Iterator<String> it2 = f.words.iterator();
		while (it2.hasNext()) {
			String word = it2.next();
			if (!wordsValue.containsKey(word)) {
				nrPercentages++;
				percentage += 0;
			} else {
				int val1 = wordsValue.get(word);
				double val2 = f.wordsValue.get(word)+0.0;
				if (val1 > val2)
					percentage += val2/val1;
				else percentage += val1/val2;
				nrPercentages++;
			}
		}
		
		return percentage/nrPercentages;
	}
}
