package A01_Baumfabrik;

/**
 * Viewklasse
 * 
 * @author mario fentler
 * @version 06.12.2016
 */
public class View {

	public void drawTree(int treeAz) {
		int spaceAz = treeAz;
		int counter = 0;
		System.out.println("/* Baum der Groesse " + treeAz + " */");
		System.out.println(">>");
		for (int i = 1; i < treeAz + 1; i++) {
			System.out.print(">> ");
			for (int i2 = 0; i2 < spaceAz; i2++) {
				System.out.print(" ");
			}

			for (int i3 = 0; i3 <= counter; i3++) {
				System.out.print("#");
			}
			System.out.println();
			spaceAz--;
			counter = counter + 2;
		}
		System.out.println(">>");
	}
}
