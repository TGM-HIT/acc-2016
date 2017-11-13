package langheiter.david;

import java.io.File;

public class Main {
	
	public static void main(String[] args) {
		String savePath = System.getProperty("user.home") + "\\AppData\\funnyNames";
		new File(savePath).mkdirs();
		new Controller(savePath);
	}
	
}
