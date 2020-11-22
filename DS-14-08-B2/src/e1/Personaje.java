package e1;

import java.util.Random;

abstract class Personaje
{
	private final String name;
	protected int hp;
	protected final int dp, maxDano;

	Personaje(String name, int hp, int dp, int maxDano)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = maxDano;
	}

	public String getName()
	{
		return name;
	}

	public int getHp()
	{
		return hp;
	}

	public boolean estaMuerto()
	{
		return hp == 0;
	}

	public int tirarDado()
	{
		Random dado = ShadowsOfTheMordor.dados;

		return dado.nextInt(maxDano);
	}

	abstract void pelearCon(Personaje contrinc);

}
