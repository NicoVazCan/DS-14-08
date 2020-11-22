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
		String mensj = new String();
		while(!heroes.isEmpty() && !bestias.isEmpty())
		{
			int partici = Math.min(heroes.size(), bestias.size());

			for(int k = 0; k < partici; k ++)
			{
				Personaje heroe = heroes.get(k);
				Personaje bestia = bestias.get(k);

				heroe.pelearCon(bestia);
				bestia.pelearCon(heroe);

				if(heroe.estaMuerto())
				{
					heroes.remove(heroe);
				}
				if(bestia.estaMuerto())
				{
					bestias.remove(bestia);
				}
				partici = Math.min(heroes.size(), bestias.size());
			}
		}
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