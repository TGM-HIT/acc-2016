package main;

import java.util.Scanner;

/**
 * Creates a rectangle and turns it aroooooound
 * 
 * @author Peter Fuchs
 * @version 20 Dec 2016
 */
public class Main {
	/**
	 * Main-class starts the program, creates a new matrix<br>
	 * Size is given by the user, he can also turn it left or right!
	 * @param args unused
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x, y;
		
		while (true) {
			System.out.println("Please insert the x-Size of the rectangle! (Must be between 1 and 7!)");
			System.out.print(">> ");
			String xSize = s.nextLine();
			try {
				x = Integer.parseInt(xSize);
				if (x > 7 || x < 1)
					throw new NumberFormatException();
				
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please insert a number between 1 and 7!");
			}
		}

		while (true) {
			System.out.println("Please insert the y-Size of the rectangle! (Must be between 1 and 7!)");
			System.out.print(">> ");
			String ySize = s.nextLine();
			try {
				y = Integer.parseInt(ySize);
				if (y > 7 || y < 1)
					throw new NumberFormatException();
				
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please insert a number between 1 and 7!");
			}
		}
		
		String[][] matrix = new String[y][x];
		
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++) {
				if (Math.random()<0.5)
					matrix[i][j] = "o";
				else matrix[i][j] = "+";
			}
		showMatrix(matrix);
		int lines = 0;
		
		while (true) {
			for (int i = 0; i < (8-lines-y); i++)
				System.out.println();
			
			System.out.println("Your options: [turnLeft] | [turnRight] | [exit]");
			System.out.print(">> ");
			String input = s.nextLine();
			
			if (input.toLowerCase().equals("exit"))
				break;
			else if (input.toLowerCase().equals("turnleft")) {
				matrix = turnLeft(matrix);
				lines = 0;
			}
			else if (input.toLowerCase().equals("turnright")) {
				matrix = turnRight(matrix);
				lines = 0;
			}
			else {
				System.out.println("Invalid input");
				showMatrix(matrix);
				lines = 1;
			}
		}
		
		s.close();
		/*for (int i = 0; i < 4; i++) {
			System.out.println();
			System.out.println();
			matrix = turnRight(matrix);
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.println();
			System.out.println();
			matrix = turnLeft(matrix);
		}*/
	}
	
	/**
	 * Turns the matrix for 90°
	 * @param matrix the matrix to turn
	 * @return the turned matrix
	 */
	public static String[][] turnRight(String[][] matrix) {
		String[][] newMatrix = new String[matrix[0].length][matrix.length];
		
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				newMatrix[j][matrix.length-1-i] = matrix[i][j];
		
		showMatrix(newMatrix);
		return newMatrix;
	}
	
	/**
	 * Turns the matrix for -90°
	 * @param matrix the matrix to turn
	 * @return the turned matrix
	 */
	public static String[][] turnLeft(String[][] matrix) {
		String[][] newMatrix = new String[matrix[0].length][matrix.length];
		
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				newMatrix[matrix[i].length-1-j][i] = matrix[i][j];
		
		showMatrix(newMatrix);
		return newMatrix;
	}
	
	/**
	 * Prints out the matrix
	 * @param matrix the matrix to print
	 */
	public static void showMatrix(String[][] matrix) {
		for (String[] s : matrix) {
			for (String s2 : s)
				System.out.print(s2 + " ");
			System.out.println();
		}
	}
}
