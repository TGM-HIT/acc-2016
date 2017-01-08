package Main;

import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
/**
 * 
 * @author Michael Ebenstein
 * @version 17-12-2016
 */
public class Race {
	private int participants;
	private int maxRounds;
	private int round = 0;
	private Equation[] equations;
	
	public Race(int p,int m){
		this.participants = p;
		this.maxRounds = m;
	}
	
	public Race(int p,int m, String file){
		this(p,m);
		loadEquations(file);
	}
	
	public Equation[] nextRound(){
		if(maxRounds == round||equations == null)return null;
		
		Equation[] buffer =	Arrays.asList(equations).subList(round*participants, (round+1)*participants).toArray(new Equation[1]);
	
		round++;
		
		return buffer;
	}

	
	public void loadEquations(String file){
		try{
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			
			equations = new Equation[participants*maxRounds];
			
			String line;
			int idx;
			int eq = 0;
			while(raf.getFilePointer() < raf.length()&&eq < equations.length){
				line = raf.readLine();
				idx = line.indexOf(':');
				if(idx < 0)throw new IllegalArgumentException(line);
				
				equations[eq++] = new Equation(line.substring(0, idx), Double.parseDouble(line.substring(idx+1)));
				
			}
			
			int delta = equations.length-eq;

			
			if(delta != 0){
				for(int i = equations.length-delta;i < equations.length;++i)
					equations[i] = equations[i - (equations.length-delta)];
			}
			
			 Collections.shuffle(Arrays.asList(equations));
			
			raf.close();
		}catch(Exception e){
			System.out.println("Error: Reading from file: "+file);
			e.printStackTrace();
			equations = null;
		}
	}
	
	public boolean done(){
		for(int i = round*participants;i < (round+1) * participants;++i){
			 if(equations[i].getDuration()==0)return false;
		}
		
		
		
		return true;
	}

	public int getParticipants() {
		return participants;
	}

	

	public int getMaxRounds() {
		return maxRounds;
	}



	public int getRound() {
		return round;
	}
	
	
	public long[] getOverall(){
		long[] buffer = new long[participants];
		
		for(int i = 0; i < buffer.length;++i){
			for(int r = 0 ;r < maxRounds;++r){
				buffer[i] += equations[i+maxRounds*r].getDuration();
				
			}
		}
		
		
		return buffer;
	}
}
