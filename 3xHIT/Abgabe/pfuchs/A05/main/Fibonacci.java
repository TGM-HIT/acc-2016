package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Gives the user the possibility to get some Fibonacci-numbers
 * 
 * @author Peter Fuchs
 * @version 13 Dec 2016
 */
public class Fibonacci {
	private RandomAccessFile fibonacci_file;
	private Scanner s;
	private boolean exit;
	
	/**
	 * Constructor<br>
	 */
	public Fibonacci() {
		try {
			//Call menu
			menu();
			exit = false; //Don't exit the do-while-loop
			do {
				s = new Scanner(System.in);
				fibonacci_file = new RandomAccessFile("fibonacci.txt", "rw");
				
				
				String input = s.nextLine();

				if (input.contains("exit")) exit = true;
				else if (input.contains("print")) printSaved();
				else if (input.contains("help")) showHelp();
				else if (input.contains("size")) printToNumber(input);
				else printNumber(input);
			} while (!exit);
		} catch (FileNotFoundException e) {
			System.out.println("The file could unfortunately not be found...");
		}

		s.close();
	}

	/**
	 * Print out the number the user asked<br>
	 * and save them in the fibonacci.txt-file
	 * @param input of the user
	 */
	private void printNumber(String input) {
		try {
			int number = Integer.parseInt(input.substring(0, input.length()));
			int[] fibonacci = {0, 0, 0};
			for (int i = 0; i <= number; i++) {
				fibonacci[2] = fibonacci[0] + fibonacci[1];
				if (i == 0)
					fibonacci[1] = 1;
				else if (i == 1);
					//Do nothing
				else {
					fibonacci[0] = fibonacci[1];
					fibonacci[1] = fibonacci[2];
				}
			}
			System.out.println(number + " : " +fibonacci[2]);
			save(number, fibonacci[2]);
		} catch (NumberFormatException e) {
			//Tells the user the input was wrong
			System.out.println("Invalid input!\n\n");
		}
		
		menu();
	}
	
	/**
	 * Save the number and the Fibonacci-number into the fibonacci.txt-file
	 * @param number the number
	 * @param fibonacci the Fibonacci-number for the number
	 */
	private void save(int number, int fibonacci) {
		try {
			while (true) {
				String line = fibonacci_file.readLine();
				if (line == "" || line == null) break;
			}
			fibonacci_file.writeBytes(number + "\t" + fibonacci + "\r\n");
			System.out.println("Successfully saved your input :)\n");
		} catch (IOException e) {
			System.out.println("An error occured!");
			System.exit(-1);
		}
	}

	/**
	 * Prints all Fibonacci-numbers until the index the user wanted
	 * @param input of the user
	 */
	private void printToNumber(String input) {
		try {
			int number = Integer.parseInt(input.substring(input.indexOf("size ")+5, input.length()));
			int[] fibonacci = {0, 0, 0};
			for (int i = 0; i <= number; i++) {
				fibonacci[2] = fibonacci[0] + fibonacci[1];
				System.out.println(i + " : " +fibonacci[2]);
				if (i == 0)
					fibonacci[1] = 1;
				else if (i == 1);
					//Do nothing
				else {
					fibonacci[0] = fibonacci[1];
					fibonacci[1] = fibonacci[2];
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input after \"size\"!\n");
		}
			
		menu();
	}

	/**
	 * shows a little help menu
	 */
	private void showHelp() {
		System.out.println("[num] - Input a number and the program will show you the Fibonacci-number belonging to your input"
						 + "Also saves your file automatically in a file!");
		System.out.println("[print] - Prints all [num]'s you asked for");
		System.out.println("[size] - Input \"size\" and a number behind it to get all the Fibonacci-numbers up to your input-number!");
		System.out.println("[help] - Shows a little helping list");
		System.out.println("[exit] - Exits the program");
		System.out.println("Press enter to leave this help menu");
		
		try {
			System.in.read();
			menu();
		} catch (IOException e) {
			System.out.println("An error occured!");
			System.exit(-1);
		}
	}

	/**
	 * Shows the menu
	 */
	private void menu() {
		System.out.println("Fibonacci-Programm!\n\tPlease enter the number of times\n\tyou want the Fibonacci-row to count\n\n" +
				"Your options:\n\t[num]\t[print]\n"
				+ "\t[size]\n\t[help]\t[exit]");
	}
	
	/**
	 * Prints out the lines fibonacci.txt
	 */
	private void printSaved() {
		try {
			System.out.println("\n\nYou asked for:");
			String text = "";
			do {
				text = fibonacci_file.readLine();
				if (text != null && text != "")
					System.out.println(text);
				else System.out.println("\n\n");
			} while (text != null && text != "");
		} catch (IOException e) {
			System.out.println("An error occured while reading the line...\nTerminating the program...");
			System.exit(-1);
		}
		
		menu();
	}
}
