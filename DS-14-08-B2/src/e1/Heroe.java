package e1;

abstract class Heroe extends Personaje
{
	Heroe(String name, int hp, int dp)
	{
		super(name, hp, dp, 101);
	}

	public void pelearCon(Personaje contrinc)
	{
		int dano = contrinc.dp - Math.max(tirarDado(), tirarDado());

		contrinc.hp = Math.max(dano, 0);
	}
}
