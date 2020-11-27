package e3;

public class Gunfight
{
	//gunslinger1.setBehavior(new Behavior)
	public void duel(Gunslinger g1, Gunslinger g2)
	{
		GunslingerAction g1Act = g1.action(), g2Act = g1.action();
		String ganador = "";
		int round=1;
		do
		{
			System.out.print("Round "+round+"-------------------------\n");
			g1.rivalAction(g2Act);
			g2.rivalAction(g1Act);

			g1Act = g1.action();
			g2Act = g2.action();
			System.out.print("Gunslinger 1: "+g1Act+"\nGunslinger 2: "+g2Act+"\n");
			if((g1Act == GunslingerAction.MACHINE_GUN) ||
					((g1Act == GunslingerAction.SHOOT) && (g2Act == GunslingerAction.RELOAD)))
			{
				ganador = "Winner: GUNSLINGER1";
			}
			if((g2Act == GunslingerAction.MACHINE_GUN) ||
					((g2Act == GunslingerAction.SHOOT) && (g1Act == GunslingerAction.RELOAD)))
			{
				if(ganador.equals("Winner: GUNSLINGER1"))ganador = "Tie";
				else ganador = "Winner: GUNSLINGER2";
			}
			if(ganador.equals(""))System.out.print("The duel continues ...\n");

		}while(ganador.equals(""));
	}
}

