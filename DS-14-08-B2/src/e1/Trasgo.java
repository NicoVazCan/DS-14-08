package e1;

import java.util.Random;

class Trasgo extends Bestia
{
	Trasgo(String name, int hp, int dp)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXBEAST;
		this.dado = new Random();
	}

	Trasgo(String name, int hp, int dp, int seed)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXBEAST;
		this.dado = new Random(seed);
	}
}