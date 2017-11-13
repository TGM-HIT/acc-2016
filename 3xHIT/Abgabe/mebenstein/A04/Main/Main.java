package Main;

import java.util.Scanner;

public class Main {
	static Zug z;
	public static void main(String[] args) {
		z = new Zug();
		
		String input,command;
		
		Scanner s = new Scanner(System.in);
		do{
			System.out.println("Please enter a command to controll the train:\nattach\t [type] [parameters]\ndispatch [idx]\nshow\t [wagonIdx]\nexit");
			input  = s.nextLine();
			
			int space = input.indexOf(' ');
			if(input.length() == 0){
				printCommandError();
				continue;
			}
			if(space != -1)
			command = input.substring(0, space);
			else 
			command = input;
			
			if(command.equals("attach")){
				attachCommand(input);
			}else if(command.equals("dispatch")) {
				dispatchCommand(input);
			}else if(command.equals("show")){
				showCommand(input);
			}else{
				printCommandError();
				continue;
			}
			
			System.out.println();
		}while(!input.equals("exit"));
		
	}
	
	static void printCommandError(){
		System.out.println("Unknown command!");
	}
	
	static void printParameterError(String param){
		System.out.println("Unknown parameter: "+param);
	}
	
	static void printCommandSyntaxError(){
		System.out.println("Unknown command syntax!");
	}
	
	static void attachCommand(String command){

		String[] elems = command.split(" ");
		if(elems.length < 4||elems.length > 5){
			printCommandSyntaxError();
			return;
			}
		
		String type = elems[1];
		boolean open = elems[2].equals("true");
		int persons;
		int food;
		
		try{
		  persons = Integer.parseInt(elems[3]);
		}catch(Exception e){
			printParameterError(elems[3]);
			return;
		}
		
		if(elems.length == 5)
			try{
				  food = Integer.parseInt(elems[4]);
			}catch(Exception e){
					printParameterError(elems[4]);
					return;
			}
		else food = 0;
		
		if(type.equals("wagon")){
			try{
				z.attachWagon(new Wagon(open,persons));
			}catch(Exception e){
				printParameterError(elems[3]);
			}
		}else if(type.equals("reisewagon")){
			try{
				z.attachWagon(new ReiseWagon(open,persons));
			}catch(Exception e){
				printParameterError(elems[3]);
			}
		}else if(type.equals("speisewagon")){
			try{
				z.attachWagon(new SpeiseWagon(open,persons,food));
			}catch(Exception e){
				printParameterError(elems[3]);
			}
		}else 
			printParameterError(type);
	}
	
	static void dispatchCommand(String command){

		String[] elems = command.split(" ");
		if(elems.length != 2){
			printCommandSyntaxError();
			return;
		}
		
		int idx;
		
		try{
			idx = Integer.parseInt(elems[1]);
		}catch(Exception e){
			printParameterError(elems[1]);
			return;
		}
		
		if(idx < 0||idx >= z.size()){
			printParameterError(elems[1]);
			return;
		}
		
		z.dispatchWagons(idx);
	}

	static void showCommand(String command){
		String[] elems = command.split(" ");
		if(elems.length > 2||elems.length == 0){
			printCommandSyntaxError();
			return;
		}
		
		if(elems.length == 2){
		int idx;
		
		try{
			idx = Integer.parseInt(elems[1]);
		}catch(Exception e){
			printParameterError(elems[1]);
			return;
		}
		
		if(idx < 0||idx > z.size()){
			printParameterError(elems[1]);
			return;
		}
			int countIdx = 0;
			for(Wagon w:z){
				if(countIdx == idx)System.out.println(w);
				countIdx++;
			}
		
		}else
			System.out.println(z);
	}
}

