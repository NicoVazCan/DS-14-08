package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger
{
	public int loads = 0, rivalLoads = 0;
	private List<GunslingerAction> rivalActs = new ArrayList<>();
	private Behavior hace;

	public GunslingerAction action()
	{
		return hace.action(this);
	}

	public int getLoads()
	{
		return this.loads;
	}

	public void rivalAction(GunslingerAction action)
	{
		if(action.equals(GunslingerAction.RELOAD))
		{
			rivalLoads++;
		}
		else if(action.equals(GunslingerAction.SHOOT))
		{
			rivalLoads--;
		}
		else if(action.equals(GunslingerAction.MACHINE_GUN))
		{
			rivalLoads = 0;
		}
		rivalActs.add(action);
	}

	public List<GunslingerAction> getRivalActions()
	{
		return this.rivalActs;
	}

	public int getRivalLoads()
	{
		return this.rivalLoads;
	}

	public void setBehavior(Behavior behavior)
	{
		hace = behavior;
	}
}
