package e1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class ElfoTest
{
	int seed = ShadowsOfTheMordorTest.seed;
	Random dado;
	Elfo el;
	Orco or;
	Trasgo tr;

	@BeforeEach
	void setUp()
	{
		dado = new Random(seed);
		el = new Elfo("El", 100, 50, seed);
		or = new Orco("Or", 100, 50, seed);
		tr = new Trasgo("Tr", 100, 50, seed);
	}

	@Test
	void TestElfoVsOrco()
	{
		int orHp = 100;
		int dano = Math.min(50 -
						(Math.max(dado.nextInt(ShadowsOfTheMordorTest.MAXHERO),
										dado.nextInt(ShadowsOfTheMordorTest.MAXHERO)) + 10), 0);

		el.pelearCon(or);
		assertEquals(or.getHp(), Math.max(orHp + dano, 0));
	}

	@Test
	void TestElfoVsTrasgo()
	{
		int trHp = 100;
		int dano = Math.min(50 -
						Math.max(dado.nextInt(ShadowsOfTheMordorTest.MAXHERO),
										dado.nextInt(ShadowsOfTheMordorTest.MAXHERO)), 0);

		el.pelearCon(tr);
		assertEquals(tr.getHp(), Math.max(trHp + dano, 0));
	}

	@Test
	void TestElfo()
	{
		Humano hu = new Humano("Hu", 100, 50);
		assertEquals(el.tirarDado(), dado.nextInt(ShadowsOfTheMordorTest.MAXHERO));
		assertThrows(IllegalArgumentException.class, () -> el.pelearCon(el));
		assertThrows(IllegalArgumentException.class, () -> el.pelearCon(hu));
		el.hp = 0;
		assertTrue(el.estaMuerto());
		assertEquals(el.getRaza(), "Elfo");
	}
}