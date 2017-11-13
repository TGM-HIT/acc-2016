import java.util.ArrayList;
import java.util.Scanner;

/**
 * Es koennen Fibonacci Zahlen augegeben werden.
 * 
 * @author David Maniak
 * @version 17.12.2016
 */
public class Fibonacci {
	private ArrayList<Integer> nums = new ArrayList<>();
	private ArrayList<Integer> fibos = new ArrayList<>();
	
	/**
	 * Default-Konstruktor
	 */
	public Fibonacci() {
			
	}
	
	/**
	 * Es wird eine Zahl eingelesen um die dazugehoerige Fibonacci Zahl auszurechnen,
	 */
	public void read() {
		System.out.print("Zahl eingeben: ");
		Scanner scn = new Scanner(System.in);
		
		int num = scn.nextInt();
		int fibo = generate(num);
		
		add(num, fibo);
		System.out.println("Fibonacci Zahl von " + num + ": " + fibo);
		System.out.println("================================");
	}
	
	/**
	 * Es wird eine Zahl und die dazugehoerige Fibonacci Zahl in deren ArrayLists gespeichert.
	 * 
	 * @param num die Zahl aus der die Fibonacci Zahl berechnet werden soll
	 * @param fibo die dazugehoerige Fibonacci Zahl
	 */
	private void add(int num, int fibo) {
		for(int x : fibos) {
			if(x == fibo)
				return;
		}
		nums.add(num);
		fibos.add(fibo);
	}
	
	/**
	 * Die Fibonacci Zahl wird generiert.
	 * 
	 * @param num die Zahl aus der die Fibonacci Zahl generiert werden soll
	 * 
	 * @return die berechnete Fibonacci Zahl
	 */
	private int generate(int num) {
		int first = 0;
		int second = 1;
		
		if(num < 1)
			return 0;
		
		for (int i = 1; i < num; i++) {
			int temp = second;
			
			second = first + second;
			first = temp;
		}
		
		return second;
	}
	
	/**
	 * Fasst die gespeicherten Fibonacci-Zahlen in einem String zusammen
	 * 
	 * @return die gespeicherten Fibonacci-Zahlen in einem String
	 */
	public String toString() {
		String saved = "================================\ngespeicherte Fibonacci Zahlen: ";
		
		if(fibos.size() == 0)
			return "Keine gespeicherten Fibonnaci Zahlen";
		
		for (int i = 0; i < fibos.size(); i++)
			saved += "\n" + nums.get(i) + " : " + fibos.get(i);
		
		saved += "\n================================";
		return saved;
	}
	
	/**
	 * Zeigt eine bestimmte Anzahl an Fibonacci Zahlen an.
	 */
	public void viewTo() {
		System.out.print("Geben Sie die Anzahl an Fibonacci Zahlen an: ");
		Scanner scn = new Scanner(System.in);
		int max = scn.nextInt();
		
		System.out.println("Fibonnaci Zahlen bis " + max + ":");
		
		for (int i = 0; i < max + 1; i++) { //(max + 1) da es angenehmer fuer den user ist wenn es bei 5 aufhoert und nicht 4
			int fibo = generate(i);
			add(i, fibo);
			System.out.println("Fibonacci Zahl von " + i + " : " + fibo);
		}
	}
}
