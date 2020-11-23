package e1;

import java.util.Random;

class Orco extends Bestia
{
	Orco(String name, int hp, int dp)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXBEAST;
		this.dado = new Random();
	}

	Orco(String name, int hp, int dp, int seed)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXBEAST;
		this.dado = new Random(seed);
	}

	public void pelearCon(Personaje contrinc)
	{
		int ext = (int)(contrinc.dp * 0.1);
		int dano = contrinc.dp - (tirarDado() + ext);

		if(dano < 0) { contrinc.hp = Math.max(contrinc.hp + dano, 0); }
	}
}
