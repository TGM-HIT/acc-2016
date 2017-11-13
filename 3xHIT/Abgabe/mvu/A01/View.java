/**
 * 
 * @author David Vu
 * @version 7-12-2016
 */
public class View {

	private Model m;
	private Control c;
	
	/**
	 * Zeichnet den Baum
	 * @param treeAmount Wie viele Zeilen der Baum groß ist
	 */
	public void drawTree(int treeAmount){
		System.out.println("/* Baum der Größe "+ treeAmount +" */");
		System.out.print(">>");
		for(int i = 0; i <= treeAmount; i++){
			System.out.print("\n>> ");
			for(int x = 0; x < treeAmount-i; x++){
				System.out.print(" ");				
			}
			for(int y = 0; y<(i*2)+1; y++){
					System.out.print("#");
			}
			
		}
		System.out.println("\n>>");
		System.out.println();
	}
}
