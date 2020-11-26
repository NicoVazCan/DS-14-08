package e1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShadowsOfTheMordor
{
	private static List<Heroe> heroes;
	private static List<Bestia> bestias;

	ShadowsOfTheMordor()
	{
		heroes = new ArrayList<>();
		bestias = new ArrayList<>();
	}

	public void anadirHeroe(Heroe heroe)
	{
		heroes.add(heroe);
	}

	public void anadirBestia(Bestia bestia)
	{
		bestias.add(bestia);
	}

	public String batalla()
	{
		StringBuilder c = new StringBuilder();
		Iterator<Heroe> heroeIter = heroes.iterator();
		Iterator<Bestia> bestiaIter = bestias.iterator();
		Personaje heroe;
		Personaje bestia;
		int turno = 1;

		c.append("Turn "+turno+":\n");
		while(!heroes.isEmpty() && !bestias.isEmpty())
		{
			if(heroeIter.hasNext() && bestiaIter.hasNext())
			{
				heroe = heroeIter.next();
				bestia = bestiaIter.next();

				c.append("  Fight between "+heroe.getName()+" (Energy="+heroe.getHp()+") and "+bestia.getName()+" (Energy="+bestia.getHp()+")\n");

				heroe.pelearCon(bestia);
				bestia.pelearCon(heroe);
				if(heroe.estaMuerto())
				{
					c.append("  "+heroe.getRaza()+" "+heroe.getName()+" dies!\n");
					heroeIter.remove();
				}
				if(bestia.estaMuerto())
				{
					c.append("  "+bestia.getRaza()+" "+bestia.getName()+" dies!\n");
					bestiaIter.remove();
				}
			}
			else
			{
				heroeIter = heroes.iterator();
				bestiaIter = bestias.iterator();

				turno++;
				c.append("Turn "+turno+":\n");
			}
		}
		if(heroes.isEmpty() && bestias.isEmpty())
		{
			c.append("ITS A TIE");
		}
		else
		{
			if(bestias.isEmpty()){c.append("HEROES WIN!!");}
			if(heroes.isEmpty()){c.append("BEASTS WIN!!");}
		}

		return c.toString();
	}
}