package e1;

class Hobbit extends Heroe
{
	Hobbit(String name, int hp, int dp)
	{
		super(name, hp, dp);
	}

	@Override
	public void pelearCon(Personaje contrinc)
	{
		int dec = contrinc instanceof Trasgo? 5 : 0;
		int dano = contrinc.dp - (Math.max(tirarDado(), tirarDado()) - dec);

		contrinc.hp = Math.max(dano, 0);
	}
}
