package e1;

abstract class Bestia extends Personaje
{
	Bestia(String name, int hp, int dp)
	{
		super(name, hp, dp, 91);
	}

	public void pelearCon(Personaje contrinc)
	{
		int dano = contrinc.dp - tirarDado();

		contrinc.hp = Math.max(dano, 0);
	}
}