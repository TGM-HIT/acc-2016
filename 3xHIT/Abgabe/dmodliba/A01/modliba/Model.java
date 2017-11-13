package modliba;

import java.util.ArrayList;

/**
 * Enthält die wichtigsten Daten und Methoden
 * 
 * @author Daniel Modliba (3CHIT)
 * @version 06-12-2016
 */
public class Model {

	// Diese ArrayList enthält je Baum einen String
	private ArrayList<String> trees = new ArrayList<String>();
	// Dies ist das Präfix, dass in nahezu jeder Zeile ausgegeben wird
	private String prefix = ">>  ";

	/**
	 * Fügt der ArrayList einen Baum hinzu
	 * 
	 * @param size
	 *            Die Höhe des Baumes in Zeilen
	 * @since 06-12-2016
	 */
	public void addTree(int size) {
		String s = "/* Baum der Größe " + size + " */\n";
		s += prefix + "\n";
		for (int i = 0; i < size; i++) {
			s += prefix;
			for (int j = 0; j < size - (i + 1); j++) {
				s += " ";
			}
			for (int j = 0; j < (i + 1) * 2 - 1; j++) {
				s += "#";
			}
			s += "\n";
		}
		s += prefix + "\n";
		if (size == 10) {
			System.out.println(s);
		}
		trees.add(s);
	}

	/**
	 * Gibt die Anzahl der Bäume zurück
	 * 
	 * @return Anzahl der Bäume in der ArrayList
	 * @since 06-12-2016
	 */
	public int storedTrees() {
		/*
		 * An dieser Stelle ist das +1 notwendig da in der Ausgabe-Schleife im
		 * Control aufrgund des -1 nur bis zum vorletzten Baum ausgegeben werden
		 * würde. Da in der Angabe klar gemacht wird, dass in der Control-Klasse
		 * nichtd verändert werden darf, habe ich diesen "Fehler" hier
		 * korrigiert. (Alles natürlich unter der Annahme, dass bei 'repaint'
		 * immer ALLE Bäume ausgegeben werden sollen)
		 */
		return trees.size() + 1;
	}

	/**
	 * Gibt einen bestimmten Baum zurück
	 * 
	 * @param index
	 *            Die Stelle des Baumes in der ArrayList
	 * @return Der Baum an der Stelle 'index'
	 * @since 06-12-2016
	 */
	public String getTree(int index) {
		return trees.get(index);
	}

}
