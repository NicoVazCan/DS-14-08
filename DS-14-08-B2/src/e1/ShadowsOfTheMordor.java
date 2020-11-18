package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShadowsOfTheMordor
{
	private static List<Personaje> heroes;
	private static List<Personaje> bestias;
	static Random dados;

	ShadowsOfTheMordor(boolean trucar)
	{
		heroes = new ArrayList<>();
		bestias = new ArrayList<>();
		dados = trucar? new Random(2020) : new Random();
	}

	public void nuevoPersonaje(String name, int hp, int dp, Razas raza)
	{
		if(raza.esHeroe())
		{
			heroes.add(raza.crear(name, hp, dp));
		}
		else
		{
			bestias.add(raza.crear(name, hp, dp));
		}
	}

	public void batalla()
	{
		while(!heroes.isEmpty() && !bestias.isEmpty())
		{
			atacanA(heroes, bestias);
			atacanA(bestias, heroes);
		}
	}

	private static void atacanA(List<? extends Personaje> atacan, List<? extends Personaje> reciven)
	{
		int partici = Math.max(atacan.size(), reciven.size());

		for(int k = 0; k < partici; k ++)
		{
			Personaje ataca = atacan.get(k);
			Personaje reciv = reciven.get(k);

			reciv.setHp(ataca.pelearCon(reciv));
			if(!reciv.estaVivo()) {reciven.remove(reciv);}
		}
	}


	public static void main(String[]args)
	{
		ShadowsOfTheMordor test = new ShadowsOfTheMordor(true);
		test.nuevoPersonaje("Elfo", 10, 100, Razas.ElFO);
		test.nuevoPersonaje("Orco", 20, 100, Razas.ORCO);
		test.batalla();
		System.out.println(heroes.get(0).getHp());
	}
}

class Personaje
{
	private String name;
	int dp, hp, maxDaño;

	Personaje(String name, int hp, int dp)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
	}

	public String getName()
	{
		return name;
	}

	public int getHp()
	{
		return hp;
	}

	public void setHp(int hp)
	{
		this.hp = hp;
	}

	public boolean estaVivo()
	{
		return hp > 0;
	}

	public int pelearCon(Personaje contrinc)
	{
		Random dado = ShadowsOfTheMordor.dados;
		return Math.max(dado.nextInt(maxDaño) + dado.nextInt(maxDaño) - contrinc.dp, 0);
	}
}

class Heroe extends Personaje
{
	Heroe(String name, int hp, int dp)
	{
		super(name, hp, dp);
		maxDaño = 101;
	}
}

class Bestia extends Personaje
{
	Bestia(String name, int hp, int dp)
	{
		super(name, hp, dp);
		maxDaño = 91;
	}
}

class Elfo extends Heroe
{
	Elfo(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}

	@Override
	public int pelearCon(Personaje contrinc)
	{
		int ext = contrinc instanceof Orco? 10 : 0;

		return (super.pelearCon(contrinc) + ext);
	}
}

class Hobbit extends Heroe
{
	Hobbit(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}

	@Override
	public int pelearCon(Personaje contrinc)
	{
		int ext = contrinc instanceof Trasgo? 5 : 0;

		return Math.max(super.pelearCon(contrinc) - ext, 0);
	}
}

class Humano extends Heroe
{
	Humano(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}
}

class Orco extends Bestia
{
	Orco(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}

	public int pelearCon(Personaje contrinc)
	{
		int ext = (int)(contrinc.dp * 0.1);

		return (super.pelearCon(contrinc) + ext);
	}
}

class Trasgo extends Bestia
{
	Trasgo(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}
}