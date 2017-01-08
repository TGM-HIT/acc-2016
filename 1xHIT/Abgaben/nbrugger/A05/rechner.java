import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class rechner extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    int x;
    int o;
    int y;
    while(true)
    {
    	vor();
   		x = getCorns();
    	vor();
    	o = getCorns();
    	vor();
    	y = getCorns();
    	linksUm();
	    linksUm();
    	vor();
	    vor();
	    vor();
    	if(o == 1)
    	{
    		for(int i = 0;i<x+y;i++)
    		{
    			gib();	
	    	} 
    	}
    	else if(o == 2)
    	{
    		for(int i = 0;i<x*y;i++)
    		{
    			gib();
    		} 
    	}
    	linksUm();
    	if(!vornFrei())
    	{
    		break;
    	}
    	vor();
    	linksUm();
    }
}
int getCorns()
{
	int x = 0;
    while(kornDa())
    {
    	x++;
    	nimm();
    }
    for(int i = 0;i<x;i++)
    {
    	gib();
    }
    return x;	
}}