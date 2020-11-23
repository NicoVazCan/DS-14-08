package e1;

import java.util.Random;

class Hobbit extends Heroe
{
	Hobbit(String name, int hp, int dp)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXHERO;
		this.dado = new Random();
	}

	Hobbit(String name, int hp, int dp, int seed)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXBEAST;
		this.dado = new Random(seed);
	}

	@Override
	public void pelearCon(Personaje contrinc)
	{
		int dec = contrinc instanceof Trasgo? 5 : 0;
		int dano = contrinc.dp - (Math.max(tirarDado(), tirarDado()) - dec);

		if(dano < 0) { contrinc.hp = Math.max(contrinc.hp + dano, 0); }
	}
}
