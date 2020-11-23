package e1;

abstract class Heroe extends Personaje
{

	public void pelearCon(Personaje contrinc)
	{
		int dano = contrinc.dp - Math.max(tirarDado(), tirarDado());

		if(dano < 0) { contrinc.hp = Math.max(contrinc.hp + dano, 0); }
	}
}
