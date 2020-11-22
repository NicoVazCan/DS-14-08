package e1;

class Orco extends Bestia
{
	Orco(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}

	public void pelearCon(Personaje contrinc)
	{
		int ext = (int)(contrinc.dp * 0.1);
		int dano = contrinc.dp - (tirarDado() + ext);

		contrinc.hp = Math.max(dano, 0);
	}
}
