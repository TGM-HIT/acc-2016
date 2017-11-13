package Baumfabrik;
import java.util.ArrayList;


/**
 * 
 * @author Michael Ebenstein
 * @version 6.12.2016
 * 
 */

public class View{

	void drawTree(ArrayList<ArrayList<Boolean>> tree){
		
		System.out.println("/* Baum der Groesse "+tree.size()+" */");
		for(ArrayList<Boolean> row:tree){
			for(Boolean elem:row){
				if(elem)
				System.out.print('#');
				else
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	
}
