import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Geschenk extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	int side = 2;
    while(true)
    {
    	while(vornFrei())
    	{
    		if(kornDa())
    		{
    			gib();
    		}
    		vor();
    	}
    	if(side%2==0)
    	{
    		linksUm();
    		linksUm();
    		linksUm();
    		
    		if(kornDa())
    			gib();
    		if(vornFrei())
    			vor();
    		else
    			break;
    		linksUm();
    		linksUm();
    		linksUm();
    		
    	}
    	else
    	{
    		linksUm();
    		
    		if(kornDa())
    			gib();
    		if(vornFrei())
    			vor();
    		else
    			break;
    		linksUm();
    	}
    	side++;
    }
    linksUm();
    linksUm();
    while(vornFrei())
    {
    	vor();
    }
    int i= 0;
    while(!maulLeer())
    {
    	gib();
    	i ++;
    }
    
    schreib("Ich habe am Ende "+ i+" k�rner auf den Boden gelegt!");
}
}