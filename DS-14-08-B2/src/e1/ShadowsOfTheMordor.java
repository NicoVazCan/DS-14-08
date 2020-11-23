package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShadowsOfTheMordor
{
	private static List<Heroe> heroes;
	private static List<Bestia> bestias;
	static Random dados;

	ShadowsOfTheMordor(boolean trucar)
	{
		heroes = new ArrayList<>();
		bestias = new ArrayList<>();
		dados = trucar? new Random(2020) : new Random();
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
		int Turno=1;
		while(!heroes.isEmpty() && !bestias.isEmpty())
		{
			int partici = Math.min(heroes.size(), bestias.size());
			c.append("Turno"+Turno+":\n");
			System.out.print("Turno"+Turno+":\n");
			for(int k = 0; k < partici; k ++)
			{
				Personaje heroe = heroes.get(k);
				Personaje bestia = bestias.get(k);
				c.append("  Fight between "+heroe.getName()+" (Energy="+heroe.hp+") and "+bestia.getName()+" (Energy"+bestia.hp+")\n");
				System.out.print("  Fight between "+heroe.getName()+" (Energy="+heroe.hp+") and "+bestia.getName()+" (Energy"+bestia.hp+")\n");
				heroe.pelearCon(bestia);
				bestia.pelearCon(heroe);
				if(heroe.estaMuerto())
				{
					c.append("  "+heroe.toString()+" "+heroe.getName()+" dies!\n");
					System.out.print("  "+heroe.toString()+" "+heroe.getName()+" dies!\n");
					heroes.remove(heroe);
				}
				if(bestia.estaMuerto())
				{
					c.append("  "+heroe.toString()+" "+heroe.getName()+" dies!\n");
					System.out.print("  "+bestia.toString()+" "+bestia.getName()+" dies!\n");
					bestias.remove(bestia);
				}
				partici = Math.min(heroes.size(), bestias.size());
			}
			Turno++;
		}
		if(heroes.isEmpty() && bestias.isEmpty()){c.append("ITS A TIE");System.out.print("ITS A TIE");}
		if(bestias.isEmpty()){c.append("HEROES WIN!!");System.out.print("HEROES WIN!!");}
		if(heroes.isEmpty()){c.append("BESTIAS WIN!!");System.out.print("BESTIAS WIN!!");}
		String mensj= c.toString();;
		return mensj;
	}

	public static void main(String[]args)
	{
		ShadowsOfTheMordor test = new ShadowsOfTheMordor(true);
		test.anadirHeroe(new Elfo("El1", 100, 50));
		test.anadirHeroe(new Humano("Hu1", 80, 60));
		test.anadirHeroe(new Humano("Hu2", 90, 55));
		test.anadirHeroe(new Hobbit("Ho1", 200, 40));
		test.anadirBestia(new Orco("Or1", 150, 30));
		test.anadirBestia(new Orco("Or2", 140, 40));
		test.anadirBestia(new Orco("Or3", 160, 20));
		test.anadirBestia(new Trasgo("Tr1", 110, 90));
		test.batalla();
	}
}