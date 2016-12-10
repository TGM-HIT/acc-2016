package Main;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author Michael Ebenstein
 * @version 10.12.2016
 * 
 */

public class Words {

	static Map<Character, String> adjectives ,nomen,bruecken;
	
	static{
		adjectives = new HashMap<Character, String>();
		nomen = new HashMap<Character, String>();
		bruecken = new HashMap<Character, String>();
	}
	
	static boolean loadWords(String file){

		try {
			RandomAccessFile f = new RandomAccessFile(file,"r");
			String s;
			
			Map<Character,String> curMap = null;
			
			
			
			while(f.getFilePointer() < f.length()){
				s = f.readLine();
				
				int marker = s.indexOf(':');
				
				
				if(marker  > -1){
					if(curMap == null){
						System.err.println("Error no header");
						return false;
					}
					
					curMap.put(s.charAt(0), s.substring(2));
					
				}else {
					
					
					if(s.equals("adjektive"))
						curMap = adjectives;
					else if(s.equals("nomen"))
						curMap = nomen;
					else if(s.equals("bruecken"))
						curMap = bruecken;
					
				
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
