package Main;

import java.io.RandomAccessFile;
import java.util.HashMap;

public class Dictionary {
	private String file;
	private HashMap<String, String> dic;
	
	public Dictionary(String file){
		this.file = file;
		dic = new HashMap<>();
		
		readFile();
	}
	
	public void readFile(){
		try {
			RandomAccessFile f = new RandomAccessFile(file, "r");
			
			while(f.getFilePointer()<f.length()){
				String[] words = f.readLine().split(":");
				dic.put(words[0], words[1]);
			}
			
			f.close();
			
		} catch (Exception e) {
			
		}
	}
	
	public void addEntry(String key,String val){
		dic.put(key, val);
		
		//for reverse tranlation
		dic.put(val,key);
	}
	
	public void save(){
		try {
			RandomAccessFile f = new RandomAccessFile(file, "rw");
			
			for(String s:dic.keySet()){
				f.writeBytes(s+":"+dic.get(s)+"\n");
			}
			
			f.close();
			
		} catch (Exception e) {
			
		}
	}
	
	public String translate(String s){
		try{
			return dic.get(s);
		}catch(Exception e){
			return "";
		}
	}
}
