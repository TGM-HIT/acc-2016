package langheiter.david;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Plagiatcheck {
	
	public static Double documentCheck(String real, String check) {
		Scanner scanReal = new Scanner(real);
		Scanner scanCheck = new Scanner(check);
		Double ret = null;
		
		while(scanReal.hasNextLine() && scanCheck.hasNextLine()) {
			Double t = wordCheck(scanReal.nextLine(), scanCheck.nextLine());
			if(ret == null) {
				ret = t;
			} else {
				ret = (ret + t) / 2.0;
			}
		}
		
		scanReal.close();
		scanCheck.close();
		return ret;
	}
	
	public static Double wordCheck(String real, String check) {
		Scanner scanReal = new Scanner(real);
		Scanner scanCheck = new Scanner(check);
		int ok = 0;
		int notOk = 0;
		
		while(scanReal.hasNext() && scanCheck.hasNext()) {
			if(scanReal.next().equalsIgnoreCase(scanCheck.next())) {
				notOk++;
			} else {
				ok++;
			}
		}
		
		scanReal.close();
		scanCheck.close();
		return ((notOk + 0.0) / (ok + notOk + 0.0)) * 100;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		if(!(args.length >= 2)) {
			System.out.println("Usage: cmd <realFile> <checkFile>");
			return;
		}
		
		File real = new File(args[0]);
		File check = new File(args[1]);
		
		if(!(real.isFile() && check.isFile())) {
			System.out.println("Could not find both files");
			return;
		}
		
		String realStr = null;
		String checkStr = null;
		try {
			realStr = new Scanner(real).useDelimiter("\\Z").next();
			checkStr = new Scanner(check).useDelimiter("\\Z").next();
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not open files: " + e.getMessage());
			return;
		}
		
		double percent = documentCheck(realStr, checkStr);
		DecimalFormat df = new DecimalFormat("#.00");
		
		String message = "";
		
		if(percent > 50) {
			message = "Hierbei handelt es sich vermutlich um ein Plagiat";
		} else {
			message = "Hierbei handelt es sich vermutlich nicht um ein Plagiat";
		}
		
		System.out.println("Aehnlichkeit: " + df.format(percent) + "% # " + message);
	}
	
}
