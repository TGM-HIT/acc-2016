import java.util.Random;

/**
 * Es wird ein zufaelliges Muster erstellt und dieses kann um 90 Grad nach rechts gedreht werden.
 * 
 * @author David Maniak
 * @version 20.12.2016
 */
public class Rasterdrehung {
	int height, width;
	char[][] raster;
	
	/**
	 * Konstruktor bei dem die Hoehe und Breite des anfaenglichen Rasters gesetzt werden kann.
	 * 
	 * @param height die Hoehe des Rasters
	 * @param width die Breite des Rasters
	 */
	public Rasterdrehung(int height, int width) {
		this.height = height;
		this.width = width;
		raster = new char[height][width];
		
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				raster[i][j] = randChar();
			}
		}
	}
	
	/**
	 * Der Raster wird hier um 90 Grad nach rechts gedreht.
	 */
	public void rotate() {
		int temp = height;
		height = width;
		width = temp;
		
		char[][] tempArr = raster;
		raster = new char[height][width];
		
		for(int i = 0; i < raster.length; i++) {
			int j = 0;
			for(int k = raster[i].length - 1; k >= 0; k--) {
				raster[i][j] = tempArr[k][i];
				j++;
			}
		}
	}
	
	/**
	 * Es wird zuefallig ein '-' oder 'o' zurueckgegeben
	 * 
	 * @return zufaelliges gewaehltes '-' oder 'o'
	 */
	public char randChar() {
		int randomChar = new Random().nextInt(2);
		
		if(randomChar == 0)
			return '-';
		else
			return 'o';
	}
	
	/**
	 * Das Raster wird in einen String gepackt und zurueckgegeben
	 * 
	 * @return das Raster in einem String
	 */
	@Override
	public String toString() {
		String x = "";
		
		for (int i = 0; i < raster.length; i++) {
			for (int j = 0; j < raster[i].length; j++)
				x += raster[i][j];
			x += "\n";
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		Rasterdrehung x = new Rasterdrehung(5, 4);
		
		System.out.println("Uerspruengliches Raster:\n" + x.toString());
		
		for (int i = 0; i < 4; i++) {
			x.rotate();
			System.out.println((i + 1) + ". Drehung:");
			System.out.println(x.toString());
		}
	}
}
