/**
 * Der Hamster legt zu jedem Korn im 10x10 Territorium ein Korn.
 * Zum Schluss geht er an seine Anfangsstelle und gibt die Anzahl der K�rner an.
 * @author Martin Jindra 
 * @version 20.12.2016
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class A02_Geschenk_Martin_Jindra extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	int korn;										//Z�hl-Variable deklarieren
	korn=0;											//Z�hl-Varaibel initialisieren
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	vor();											//geht nach vorne			
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	vor();											//geht nach vorne
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht die Zeile entlag und legt ein Korn wenn ein Korn da ist
		if(kornDa()==true)	{
			gib();
		}
		vor();
	}	
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	while(vornFrei()==true)	{						//geht zur�ck zum Start
		vor();	
	}
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	linksUm();										//geht nach links
	while(maulLeer()==false)	{					//gibt alle K�rner ab 
		gib();
		korn+=1;
	}
	schreib("Ich habe "+korn+" K�rner abgelegt");	//gibt eine Nachreicht ab
}}