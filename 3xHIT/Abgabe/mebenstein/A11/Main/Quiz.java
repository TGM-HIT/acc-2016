package Main;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * 
 * @author Michael Ebenstein
 * @version 17-12-2016
 */
public class Quiz {
	private ArrayList<Question> equations;
	private int idx = 0;
	
	public Quiz( String file){
		equations = new ArrayList<>();
		loadQuiz(file);
	}
	
	public Question nextRound(){
		if(idx < equations.size())return equations.get(idx++);
		return null;
	}

	
	public void loadQuiz(String file){
		try{
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			
			
			String line;
			int idx;
			int eq = 0;
			while(raf.getFilePointer() < raf.length()){
				line = raf.readLine();
				idx = line.indexOf(':');
				if(idx < 0)throw new IllegalArgumentException(line);
				
				String[] answers = line.substring(idx+1).split(";");
				
				if(answers.length < 4)throw new IllegalArgumentException(line);
				
				equations.add(new Question(line.substring(0, idx), answers,0));
				
			}
			
			 Collections.shuffle(Arrays.asList(equations));
			
			raf.close();
		}catch(Exception e){
			System.out.println("Error: Reading from file: "+file);
			e.printStackTrace();
			equations = null;
		}
	}
	
	
}
