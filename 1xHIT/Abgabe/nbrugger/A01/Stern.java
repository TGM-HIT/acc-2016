import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Stern extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    int widht = 1;
    int height = 1;
    schreib("Ich erkunde nun das Terretorium!\nAuf h�he und breite\nOb es quadratisch ist\nUnd ob die breite + h�he ungerade sind!");
    while(vornFrei())
    {
    	vor();
    	widht++;
    }
    goRight();
    while(vornFrei())
    {
    	vor();
    	height++;
    }
    goRight();
    while(vornFrei())
    {
    	vor();
    }
    goRight();
    while(vornFrei())
    {
    	vor();
    }
    goRight();
    if(height%2 == 0)
    {
    	schreib("Das feld Hat noch keine ungerade Anzahl an Feldern\nIn der h�he\nH�he: "+height+"\nDamit sich der Stern perfekt ausgeht muss das feld eine Ungerade zahl in der Breite und in der H�he haben!");
    	return;
    }
    else if(widht%2 == 0)
    {
    	schreib("Das feld Hat noch keine ungerade Anzahl an Feldern\nIn der Breite\nBreite: "+widht+"\nDamit sich der Stern perfekt ausgeht muss das feld eine Ungerade zahl in der Breite und in der H�he haben!");
    	return;
    }
    if(height != widht)
    {
    	schreib("java.lang.NichtGanzSoQuadratischException: Ich brauche ein quadratisches Feld :(No Source Found)");
    	return;
    }
    int disdance = 99999;
    int midHeight = 0;
    int mid = 0;
    int mac = 0;
    for(int y = 1;y<height+1;y++)
    {
		for(int x = 1;x<widht;x++)
		{
			if(x+1 > widht-(x+1) && mid == 0)
			{	
				mid = x+1;
				mac = mid -1;
				schreib(mac+" mac");
				schreib("Die mitte des Feldes ist : "+ mid);
			}
			if(x == mid)
			{
				if(y+1 != mid && y-1 != mid && x+1 != mid && x-1 != mid)
				{
					gib();
				}
			}
			if(y == mid)
			{
				if((x+1 != mid && x-1 != mid) && x != mid)
				{
					gib();
				}	
			}
			
			
			if(mid-disdance == x && disdance != 0 && disdance != mac)
			{
				gib();
			}
			if(x-disdance == mid && disdance != 0 && disdance != mac)
			{
				gib();
			}
			vor();
			if(y == mid && x+1 == widht)
				gib();
   		}
   		if(y%2==0)
   		{
   			linksUm();
   			vor();
   			linksUm();
   		}
   		else
   		{
   			goRight();
   			if(vornFrei())
   				vor();
   			goRight();
   		}
  		disdance = mid - (y+1);
   		if(disdance < 0)
   		{
   			disdance *= -1;
   		}
    }
}
void goRight()
{
	linksUm();
	linksUm();
	linksUm();
}}