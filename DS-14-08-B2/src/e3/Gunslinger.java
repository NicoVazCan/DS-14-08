package e3;

import java.util.List;

public class Gunslinger
{
    public int loads=0;
    public Gunslinger rival;
    public GunslingerAction last;
    private List <GunslingerAction> acciones;

	public GunslingerAction action()
	{
        if(getLoads()==0 && getRivalLoads()==0){
            return GunslingerAction.RELOAD;
        }
        else return GunslingerAction.SHOOT;
	}

	public int getLoads()
	{
        return this.loads;
	}

	public void rivalAction(GunslingerAction action)
	{
        action=this.rival.last;
	    acciones.add(action);
	}

	public List<GunslingerAction> getRivalActions()
	{
        return this.acciones;
	}

	public int getRivalLoads()
	{
        return this.rival.loads;
	}

	public void setBehavior(Behavior behavior)
	{

	}
}
