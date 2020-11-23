package e1;

import java.util.Random;

class Elfo extends Heroe
{
	Elfo(String name, int hp, int dp)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXHERO;
		this.dado = new Random();
	}

	Elfo(String name, int hp, int dp, int seed)
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
		int ext = contrinc instanceof Orco? 10 : 0;
		int dano = contrinc.dp - (Math.max(tirarDado(), tirarDado()) + ext);

		if(dano < 0) { contrinc.hp = Math.max(contrinc.hp + dano, 0); }
	}
}