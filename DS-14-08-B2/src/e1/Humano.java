package e1;

import java.util.Random;

class Humano extends Heroe
{
	Humano(String name, int hp, int dp)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXHERO;
		this.dado = new Random();
	}

	Humano(String name, int hp, int dp, int seed)
	{
		this.name = name;
		this.hp = hp;
		this.dp = dp;
		this.maxDano = MAXBEAST;
		this.dado = new Random(seed);
	}
}
