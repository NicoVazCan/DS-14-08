package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunfight
{
	private List<GunslingerAction> g1Acts = new ArrayList<>(), g2Acts = new ArrayList<>();

	public void duel(Gunslinger g1, Gunslinger g2)
	{
		GunslingerAction g1Act = g1.action(), g2Act = g1.action();
		Gunslinger ganador = null;
		do
		{
			g1.rivalAction(g2Act);
			g2.rivalAction(g1Act);

			g1Act = g1.action();
			g2Act = g2.action();
			g1Acts.add(g1Act);
			g2Acts.add(g2Act);

			if((g1Act == GunslingerAction.MACHINE_GUN) ||
							((g1Act == GunslingerAction.SHOOT) && (g2Act == GunslingerAction.RELOAD)))
			{
				ganador = g1;
			}
			else if((g2Act == GunslingerAction.MACHINE_GUN) ||
							((g2Act == GunslingerAction.SHOOT) && (g1Act == GunslingerAction.RELOAD)))
			{
				ganador = g1;
			}
		}while(ganador == null);

	}
}
