package main;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Model
 * 
 * 
 * @author Peter Fuchs
 * @version 19 Dec 2016
 */
public class Rennen {
	boolean exit;
	
	private int maxRunden;
	
	private int level;
	
	private HashSet<Teilnehmer> teilnehmer;
	private int aktTeilnehmer;
	
	private double result;
	
	/**
	 * Constructor
	 * 
	 * @param teilnehmer the teilnehmer of the run
	 */
	public Rennen(Teilnehmer ...teilnehmer) {
		this.aktTeilnehmer = 0;
		this.level = 1;
		this.teilnehmer = new HashSet<Teilnehmer>();
		for (Teilnehmer t : teilnehmer)
			this.teilnehmer.add(t);
	}
	
	/**
	 * @param maxRunden the maxRunden to set
	 */
	public void setMaxRunden(int maxRunden) {
		this.maxRunden = maxRunden;
	}

	/**
	 * Adds the points relative to the time
	 * @param time the time the user needed to answer
	 */
	public void addPunkte(double time) {
		Iterator<Teilnehmer> it = this.teilnehmer.iterator();
		for (int i = 0; i < aktTeilnehmer && it.hasNext(); i++)
			it.next();
		
		it.next().addPunkte(time);
		
		if (aktTeilnehmer < teilnehmer.size()-1)
			aktTeilnehmer++;
		else {
			aktTeilnehmer = 0;
			if (this.level == maxRunden)
				this.exit = true;
			else this.level++;
		}
	}
	
	/**
	 * Adds teilnehmer to the set
	 * @param teilnehmer the teilnehmer to add
	 */
	public void addTeilnehmer(Teilnehmer ...teilnehmer) {
		for (Teilnehmer t: teilnehmer)
			this.teilnehmer.add(t);
	}
	
	/**
	 * Rounds the parameter to 2 decimals
	 * @param val the parameter to round
	 * @return the rounded value
	 */
	public double roundTo2Decimals(double val) {
		DecimalFormat df = new DecimalFormat("###.##");
		return Double.valueOf(df.format(val).replaceAll(",", "."));
	}

	/**
	 * @return the calculation as a string
	 */
	public String rechnung() {
		String re = "";
		int nr1 = (int) (Math.random()*10*level+1);
		int nr2 = (int) (Math.random()*10*level+1);
		re += nr1;
		int type = (int) (Math.random()*4);
		switch (type) {
		case 0: re += "+";
		this.setResult(nr1+nr2);
		break;
		case 1: re += "-";
		this.setResult(nr1-nr2);
		break;
		case 2: re += "/";
		this.setResult((nr1+0.0)/nr2);
		break;
		case 3: re += "*";
		this.setResult((nr1+0.0)*nr2);
		break;
		}
		this.setResult(roundTo2Decimals(this.getResult()));
		re+=nr2;
		
		return re;
	}
	
	/**
	 * @return the teilnehmer whos turn it is
	 */
	public Teilnehmer getAktTeilnehmer() {
		Iterator<Teilnehmer> it = this.teilnehmer.iterator();
		for (int i = 0; i < aktTeilnehmer && it.hasNext(); i++)
			it.next();
		return it.next();
	}

	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}

	/**
	 * @return the teilnehmer
	 */
	public HashSet<Teilnehmer> getTeilnehmer() {
		return teilnehmer;
	}

	/**
	 * @param teilnehmer the teilnehmer to set
	 */
	public void setTeilnehmer(HashSet<Teilnehmer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}
}
