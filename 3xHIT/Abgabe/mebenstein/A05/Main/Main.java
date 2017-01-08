package Main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Michael Ebenstein
 * @version 12-12-2016
 */
public class Main {
	public static void main(String[] args) {
	
		
		
		
		Scanner s = new Scanner(System.in);
		Fibonacci f = new Fibonacci();
		String command;
		
		do{
			System.out.println("\nPlease enter command!\n[num]\nprint\nprint [num]\nexit\n");

			command = s.nextLine();
			
			if(command.equals("print")){
				System.out.println(f);
			}else if(command.indexOf("print")!= -1){
				try{
					ArrayList<BigInteger> a = f.getNumbers(Integer.parseInt(command.substring(command.indexOf(' ')+1)));
					System.out.println(a);
				}catch (Exception e) {
					System.out.println("Invalid parameter");
				}
			}else{
				try{
			
					System.out.println(f.getNumber(Integer.parseInt(command)));
				
				}catch (Exception e) {
					System.out.println("Invalid input");
				}
			}
			
		}while(!command.equals("exit"));
		System.out.println("End");
	}
}
