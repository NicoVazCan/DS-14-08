package e1;

abstract class Heroe extends Personaje
{

	public void pelearCon(Personaje contrinc)
	{
		int dano = Math.min(contrinc.dp - Math.max(tirarDado(), tirarDado()), 0);

		if(contrinc instanceof Heroe)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			contrinc.hp = Math.max(contrinc.hp + dano, 0);
		}
	}
}
