package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

import java.util.List;

public class Ds_14_08 implements Behavior
{
	private List<GunslingerAction> rivalActs;
	private int turno = 0, load = 0, rivalLoad, lastAct;
	@Override
	public GunslingerAction action(Gunslinger g)
	{
		rivalActs = g.getRivalActions();
		rivalLoad = g.getRivalLoads();
		lastAct = rivalActs.size() - 1;
		turno++;

		switch(turno)
		{
			case 1:
				load++;
				return GunslingerAction.RELOAD;

			case 2:
				return GunslingerAction.PROTECT;

			case 3:
				if(rivalLoad == 0)
				{
					load--;
					return GunslingerAction.SHOOT;
				}
				else
				{
					return GunslingerAction.PROTECT;
				}
			default:
				if(rivalLoad == 0 && load > 0)
				{
					load--;
					return GunslingerAction.SHOOT;
				}
				else if(rivalLoad == 0 && load == 0)
				{
					load++;
					return GunslingerAction.RELOAD;
				}
				else if(rivalLoad > 0 && load > 0)
				{
					load--;
					return GunslingerAction.SHOOT;
				}
				else if((rivalActs.get(lastAct) == GunslingerAction.RELOAD) &&
								(rivalActs.get(lastAct - 1) == GunslingerAction.RELOAD))
				{
					load++;
					return GunslingerAction.RELOAD;
				}
				else
				{
					return GunslingerAction.PROTECT;
				}
		}
	}
}
