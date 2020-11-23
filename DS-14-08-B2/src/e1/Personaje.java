package e1;

import java.util.Random;

abstract class Personaje
{
	protected static final int MAXHERO = 101, MAXBEAST = 91;

	protected String name;
	protected int hp, dp, maxDano;
	protected Random dado;

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

	public String getRaza()
	{
		String raza = toString();
		int beg = (raza.indexOf('.') + 1),
				end = raza.lastIndexOf('@');

		return raza.substring(beg, end);
	}

	protected int tirarDado()
	{
		return dado.nextInt(maxDano);
	}

	abstract void pelearCon(Personaje contrinc);
}