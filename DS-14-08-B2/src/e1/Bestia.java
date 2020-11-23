package e1;

abstract class Bestia extends Personaje
{
	public void pelearCon(Personaje contrinc)
	{
		int dano = contrinc.dp - tirarDado();

		if(dano < 0) { contrinc.hp = Math.max(contrinc.hp + dano, 0); }
	}
}