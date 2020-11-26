package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HobbitTest
{
	int seed = ShadowsOfTheMordorTest.seed;
	Random dado;
	Hobbit ho;
	Orco or;
	Trasgo tr;

	@BeforeEach
	void setUp()
	{
		dado = new Random(seed);
		ho = new Hobbit("El", 100, 50, seed);
		or = new Orco("Or", 100, 50, seed);
		tr = new Trasgo("Tr", 100, 50, seed);
	}

	@Test
	void TestHobbitVsOrco()
	{
		int orHp = 100;
		int dano = Math.min(50 -
						Math.max(dado.nextInt(ShadowsOfTheMordorTest.MAXHERO),
										dado.nextInt(ShadowsOfTheMordorTest.MAXHERO)), 0);

		ho.pelearCon(or);
		assertEquals(or.getHp(), Math.max(orHp + dano, 0));
	}

	@Test
	void TestHobbitVsTrasgo()
	{
		int trHp = 100;
		int dano = Math.min(50 -
						(Math.max(dado.nextInt(ShadowsOfTheMordorTest.MAXHERO),
										dado.nextInt(ShadowsOfTheMordorTest.MAXHERO)) - 5), 0);

		ho.pelearCon(tr);
		assertEquals(tr.getHp(), Math.max(trHp + dano, 0));
	}

	@Test
	void TestHobbit()
	{
		Humano hu = new Humano("Hu", 100, 50);
		assertEquals(ho.tirarDado(), dado.nextInt(ShadowsOfTheMordorTest.MAXHERO));
		assertThrows(IllegalArgumentException.class, () -> ho.pelearCon(ho));
		assertThrows(IllegalArgumentException.class, () -> ho.pelearCon(hu));
		ho.hp = 0;
		assertTrue(ho.estaMuerto());
		assertEquals(ho.getRaza(), "Hobbit");
	}
}