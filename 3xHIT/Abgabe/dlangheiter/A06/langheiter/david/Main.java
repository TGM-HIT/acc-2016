package langheiter.david;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Loading dictonary...");
		Dictionary dict = new Dictionary();
		System.out.println("Input '(exit)' to exit");
		while(true) {
			System.out.print("Word to translate?: ");
			String userIn = in.next();
			if(userIn.equalsIgnoreCase("(exit)")) {
				break;
			}
			String res = dict.getTranslation(userIn);
			if(res == null) {
				System.out.print("Unknown! Add? (y/N) ");
				String yN = in.next().trim();
				if(yN.equalsIgnoreCase("y")) {
					System.out.print("New word for '" + userIn +"': ");
					String translation = in.next();
					dict.addTranslation(userIn, translation);
					System.out.println(userIn + " now means " + translation);
				}
			} else {
				System.out.println("Translation: " + res);
			}
		}
		in.close();
		System.out.println("Saving dictonary...");
		dict.save();
		System.out.println("Exited");
	}
	
}
