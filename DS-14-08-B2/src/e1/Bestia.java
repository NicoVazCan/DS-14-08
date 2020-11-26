package e1;

abstract class Bestia extends Personaje
{
	public void pelearCon(Personaje contrinc)
	{
		int dano = Math.min(contrinc.dp - tirarDado(), 0);

		if(contrinc instanceof Bestia)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			contrinc.hp = Math.max(contrinc.hp + dano, 0);
		}
	}
}