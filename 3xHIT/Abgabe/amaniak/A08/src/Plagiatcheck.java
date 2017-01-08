import java.io.*;

/**
 * Vergleicht 2 Dateien auf ihre Aehnlichkeit um Plagiate zu vermeiden.
 * Es gibt zwei Arten wie die % zustande kommen:
 *  1) Nur der Inhalt wird auf Aehnlichkeit geprueft
 *  2) Der Titel und der Inhalt werden auf Aehnlichkeit geprueft, wobei 
 *     man eine beliebig staerkere Gewichtung auf den Inhalt setzen kann.
 * 
 * @author David Maniak
 * @version 18.12.2016
 */
public class Plagiatcheck {
	private File f1, f2;
	private BufferedReader f1Reader, f2Reader;
	
	/**
	 * Konstruktor bei dem die Files die verglichen werden sollen, mitgegeben werden.
	 * 
	 * @param f1 die erste File die verglichen werden soll
	 * @param f2 die zweite File die verglichen werden soll
	 * @throws IOException
	 */
	public Plagiatcheck(File f1, File f2) throws IOException {
		this.f1 = f1;
		this.f2 = f2;
		
		f1Reader = new BufferedReader(new FileReader(f1));
		f2Reader = new BufferedReader(new FileReader(f2));
		
		int title = (int)checkTitle();
		int content = (int)checkContent();

		System.out.println(result(content)); //Ergebnis wo nur der Inhalt der Textdatei verglichen wird
		System.out.println(result(title, content, 4)); //Ergebnis wo der Titel und Inhalt der Textdatei verglichen werden
	}
	
	/**
	 * Es wird jedes Zeichen von beiden Titeln verglichen.
	 * 
	 * @return die % wie aehnlich beide Titel sind
	 */
	public double checkTitle() {
		String first = f1.getName();
		String second = f2.getName();
		
		int same = 0;
		int total = 0;
		
		for(int i = 0; i < first.length() && i < second.length(); i++) {
			if(first.charAt(i) == second.charAt(i))
				same++;
			total++;
		}
		
		return (same / (total * 1.0)) * 100.0;
	}
	
	/**
	 * Es wird jedes Wort von beiden Dateien verglichen.
	 * 
	 * @return die % wie aehnlich beide Texte sind
	 * @throws IOException
	 */
	public double checkContent() throws IOException {
		long f1Lines = f1Reader.lines().count();
		long f2Lines = f2Reader.lines().count();
		
		//Wollte kein mark & reset verwenden, da der Buffer moeglicherweise zu klein waere
		f1Reader = new BufferedReader(new FileReader(f1));
		f2Reader = new BufferedReader(new FileReader(f2));
		
		int same = 0;
		int total = 0;
		
		for(long i = 0; i < f1Lines && i < f2Lines; i++) {
			String[] first = f1Reader.readLine().split(" ");
			String[] second = f2Reader.readLine().split(" ");
			
			for(int j = 0; j < first.length && j < second.length; j++) {
				if(first[j].equals(second[j]))
					same++;
				total++;
			}
		}
		
		//Falls eine File mehr zeilen hat als die andere, werden die restlichen Woerter auch 
		//in den Aehnlichkeitswert miteinbezogen
		if(f1Lines > f2Lines) {
			long length = f1Lines - f2Lines + 1;
			for(long i = length; i < f1Lines; i++) {
					String[] first = f1Reader.readLine().split(" ");
					total += first.length;
			}
		} else if(f1Lines < f2Lines){
			long length = f2Lines - f1Lines + 1;
			
			for(long i = length; i < f2Lines; i++) {
				String[] first = f2Reader.readLine().split(" ");
				total += first.length;
			}
		}
		
		return (same / (total * 1.0)) * 100.0;
	}
	
	/**
	 * Es wird anhand des Inhalts ausgegeben wie aehnlich beide Texte zueinander sind.
	 * 
	 * @param content die % wie aehnlich beide Texte sind
	 * @return die Ausgabe wie aehnlich beide Texte nun sind
	 */
	public String result(int content) {
		if(content >= 80)
			return "Aehnlichkeit: " + content + "% # Hierbei handelt es sich sehr wahrscheinlich um ein Plagiat. (Anhand Inhalt)";
		else if(content >= 60 && content < 80)
			return "Aehnlichkeit: " + content + "% # Hierbei handelt es sich wahrscheinlich um ein Plagiat. (Anhand Inhalt)";
		else if(content >= 35 && content < 60)
			return "Aehnlichkeit: " + content + "% # Hierbei handelt es sich vielleicht um ein Plagiat. (Anhand Inhalt)";
		else if(content >= 0 && content < 35)
			return "Aehnlichkeit: " + content + "% # Hierbei handelt es sich wahrscheinlich nicht um ein Plagiat. (Anhand Inhalt)";
		
		return "Konnte % der Aehnlichkeit nicht ermitteln";
	}
	
	/**
	 * Es wird anhand des Titels und Inhalts ausgegeben wie aehnlich beide Texte zueinander sind.
	 * Man kann den Inhalt staerker in die Gewichtung fallen lassen als den Titel. 
	 * Fuer gleiche Gewichtung: 1; Fuer 2x so grosse Gewichtung: 2; usw...
	 * 
	 * @param title die % wie aehnlich beide Titel sind
	 * @param content die % wie aehnlich beide Texte sind
	 * @param contentImportance um wie viel staerker die Gewichtung des Inhalts im Gegensatz zum Titel sein soll, 2 ist zB.: 2x so gross
	 * @return
	 */
	public String result(int title, int content, int contentImportance) {
		int fakeOrReal = (int)(title + (content * contentImportance)) / (contentImportance + 1);
		
		if(fakeOrReal >= 80)
			return "Aehnlichkeit: " + fakeOrReal + "% # Hierbei handelt es sich sehr wahrscheinlich um ein Plagiat. (Anhand Titel und Inhalt)";
		else if(fakeOrReal >= 60 && fakeOrReal < 80)
			return "Aehnlichkeit: " + fakeOrReal + "% # Hierbei handelt es sich wahrscheinlich um ein Plagiat. (Anhand Titel und Inhalt)";
		else if(fakeOrReal >= 35 && fakeOrReal < 60)
			return "Aehnlichkeit: " + fakeOrReal + "% # Hierbei handelt es sich vielleicht um ein Plagiat. (Anhand Titel und Inhalt)";
		else if(fakeOrReal >= 0 && fakeOrReal < 35)
			return "Aehnlichkeit: " + fakeOrReal + "% # Hierbei handelt es sich wahrscheinlich nicht um ein Plagiat. (Anhand Titel und Inhalt)";
		
		return "Konnte % der Aehnlichkeit nicht ermitteln";
	}
	
	public static void main(String[] args) {
		try {
			new Plagiatcheck(new File("FileReal.txt"), new File("FileFake.txt"));
		} catch(IOException ex) {
			System.err.println(ex);
		}
	}
}
