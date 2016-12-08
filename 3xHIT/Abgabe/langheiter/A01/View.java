import java.security.InvalidParameterException;

/**
 * View class to make Trees
 * 
 * @author David Langheiter
 */
public class View {
	/**
	 * Draws tree to the Console
	 * 
	 * @param size Size of the tree
	 */
	public void drawTree(int size) {
		System.out.println("/* Baum der Groesse " + size + " */");
		System.out.println(">>");
		
		int endSize = (size*2)+1;
		for(int i = 0; i < size; i++) {
			String tmpTxt = genStringLen('#', (i*2)+1);
			System.out.println(">> " + centerText(tmpTxt, endSize));
		}
		
		System.out.println(">>");
		System.out.println();
	}
	
	/**
	 * Method to make an String filled with an Char by specific length
	 * 
	 * @param c Char
	 * @param length Length of resulting string
	 * @return Lengthened String
	 */
	private String genStringLen(char c, int length) {
		String ret = "";
		for(int i = 0; i < length; i++) {
			ret += c;
		}
		return ret;
	}
	
	/**
	 * Centers the text to an specific width
	 * 
	 * @param text Text to center
	 * @param width Width of the "canvas"
	 * @return The centerd text
	 */
	private String centerText(String text, int width) {
		if(text.length() > width) {
			throw new InvalidParameterException();
		}
		if(text.length() == width) {
			return text;
		}
		String ret = genStringLen(' ', (width-text.length())/2);
		return ret + text;
	}
	
}
