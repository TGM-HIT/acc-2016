package Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary("words.txt");
		
		String command;
		Scanner s = new Scanner(System.in);
		
		while(true){
			
			System.out.println("Word to translate?");
			
			command = s.nextLine();
			
			String trans = dic.translate(command);
			
			if(trans != null){
				System.out.println(trans);
			}else if(command.equals("exit")){
				break;
			}else {
				System.out.println("Unknown! Want to add it? (y/n)");
				String buffer = s.nextLine();
				if(buffer.equals("y")){
					System.out.println("Enter new word for \""+command+"\"");
					buffer = s.nextLine();
					dic.addEntry(command, buffer);
					System.out.println(command+" now means: "+buffer);
				}
					
			}
			
		}
		
		dic.save();
	}
}
