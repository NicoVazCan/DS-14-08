package e1;

class Elfo extends Heroe
{
	Elfo(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}

	@Override
	public void pelearCon(Personaje contrinc)
	{
		int ext = contrinc instanceof Orco? 10 : 0;
		int dano = contrinc.dp - (Math.max(tirarDado(), tirarDado()) + ext);

		contrinc.hp = Math.max(dano, 0);
	}
}