package Main;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 @author Michael Ebenstein
 @version 14-12-2016
**/	
public class Main {

	public static void main(String[] args) {
		String f1 ,f2;
		
		FileDialog dia = new FileDialog(new Frame());
		
		dia.setVisible(true);
		f1 = dia.getFile();
		
		dia.setVisible(true);
		f2 = dia.getFile();
		
		ArrayList<ArrayList<String>> words = new ArrayList<>();
		ArrayList<ArrayList<String>> words2 = new ArrayList<>();


		try{
            System.out.println(f1);
			RandomAccessFile raf = new RandomAccessFile(f1, "r");
			
			while(raf.getFilePointer()<raf.length()){
				ArrayList<String> line = new ArrayList<>();
				line.addAll(Arrays.asList(raf.readLine().split(" ")));
				words.add(line);
			}
			
			raf.close();
			
			System.out.println(f2);
			raf = new RandomAccessFile(f2, "r");
			
			while(raf.getFilePointer()<raf.length()){
				ArrayList<String> line = new ArrayList<>();
				line.addAll(Arrays.asList(raf.readLine().split(" ")));
				words2.add(line);
			}
			
			raf.close();
		}catch(Exception e){
			System.out.println("Error loading files");
		}
		
		if(words.equals(words2)){
			System.out.println("Files are 100% the same");
			return;
		}
		
		double percantage = 0;
		double ratio = words.size()/(double)words2.size();
		double lineWeight = 100.0/words.size();
		
		//Looping through all lines
		x:for(ArrayList<String> line:words){
			
			ArrayList<Double> sameness = new ArrayList<>();
			
			//Looping through all lines of the other file
			for(ArrayList<String> line2:words2){
				//Comparing ever line
				if(line.equals(line2)){
					percantage += lineWeight;
					continue x;
				}else{
					//If the lines are not equal all words get compared in order to see of the order was just swapped
					double d = 0;
					for(String s:line){
						for(String s2:line2){
							if(s.equals(s2)){
								d+= lineWeight/line.size();
								break;
							}
						}
					}
					//the percentage of equality gets stored 
					sameness.add(d);
				}
			}
			//if no line  was equal than the line value with the highest equality gets added 
			percantage += Collections.max(sameness);
				
			
		}
		
		System.out.println("Files are "+String.format( "%.2f", percantage )+"% the same");
	}

}
