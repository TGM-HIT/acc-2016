package main;

import java.io.File;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The Plagiatcheck itself
 * 
 * 
 * @author Peter Fuchs
 * @version 18 Dec 2016
 */
public class Plagiatcheck {
	/**
	 * 
	 * Constructor<br>
	 * Also provides the output for the user
	 * 
	 * @param files the files to compare
	 */
	public Plagiatcheck(CompareFile ... files) {
		System.out.println("Selected files:");
		for (CompareFile f : files)
			System.out.println(">> " +f.getName());
		
		System.out.println("");
		
		HashSet<ComparedFile> percentages = compareFiles(files);
		
		Iterator<ComparedFile> it = percentages.iterator();
		
		if (percentages.size() == 0)
			System.out.println(files[0].getName() + " ist ein Plagiat von sich selbst! Ähnlichkeit: 100%");
		
		while (it.hasNext()) {
			ComparedFile file = it.next();
			System.out.println(file.compFile1.getName() + " und " + file.compFile2.getName() + "\nÄhnlichkeit: " +file.percentage*100 + "%");
			if (file.percentage == 1)
				System.out.println("Mit extrem hoher Wahrscheinlichkeit ein Plagiat!!");
			else if (file.percentage*100>80)
				System.out.println("Es handelt sich vermutlich um ein Plagiat!");
			else System.out.println("");
		}
	}
	
	/**
	 * Compares 2 files
	 * 
	 * @param files the files to compare
	 * @return a hashset of the compared files
	 */
	public HashSet<ComparedFile> compareFiles(CompareFile ...files) {
		HashSet<ComparedFile> percentages = new HashSet<ComparedFile>();
		
		for (CompareFile f : files)
			for (CompareFile compareFile : files)
				if (!compareFile.equals(f)) {
					if (percentages.size() == 0)
						percentages.add(new ComparedFile(f, compareFile, f.compareWords(compareFile)));
					else {
						try {
							Iterator<ComparedFile> it = percentages.iterator();
							while (it.hasNext()) {
								ComparedFile file = it.next();
								if (!file.compFile2.equals(f))
									percentages.add(new ComparedFile(f, compareFile, f.compareWords(compareFile)));
							}
						} catch (ConcurrentModificationException e) {
							System.out.println("Unfortunately you can't compare more than 2 files right now :C");
						}
					}
				}
		
		return percentages;
	}
	
	public static void main(String[] args) {
		selectFiles();
	}
	
	public static void selectFiles() {
		JFileChooser fc = new JFileChooser("./src");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
		fc.setFileFilter(filter);
		fc.setMultiSelectionEnabled(true);
		fc.showOpenDialog(new JFrame());
		

		File[] files = fc.getSelectedFiles();
		
		if (files.length > 2) {
			System.out.println("Unfortunately you can't choose more than 2 files right now :C");
			System.out.println("Please try again!");
			selectFiles();
			return;
		}
		
		CompareFile[] compFiles = new CompareFile[files.length];
		for (int i = 0; i < files.length; i++)
			compFiles[i] = new CompareFile(files[i]);
		
		new Plagiatcheck(compFiles);
		
		//To exit the program at the end
		System.exit(0);
	}
}
