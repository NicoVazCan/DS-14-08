package e1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HumanoTest
{
	int seed = ShadowsOfTheMordorTest.seed;;
	Random dado;
	Humano hu;
	Elfo el;
	Trasgo tr;
	Orco or;

	@BeforeEach
	void setUp()
	{
		dado = new Random(seed);
		hu = new Humano("Hu", 100, 50, seed);
		el = new Elfo("El", 100, 50, seed);
		tr = new Trasgo("Tr", 100, 50, seed);
		or = new Orco("Or", 100, 50, seed);
	}

	@Test
	void testHumanoVsOrco()
	{
		int orHp = or.getHp();
		int dano = Math.min(or.dp -
						Math.max(dado.nextInt(ShadowsOfTheMordorTest.MAXHERO),
										dado.nextInt(ShadowsOfTheMordorTest.MAXHERO)), 0);

		hu.pelearCon(or);
		assertEquals(or.getHp(), Math.max(orHp + dano, 0));

		dado = new Random(seed);

		el.pelearCon(tr);
		assertEquals(tr.getHp(), or.getHp());
	}

	@Test
	void TestHumano()
	{
		Hobbit ho = new Hobbit("Ho", 100, 50);
		assertEquals(hu.tirarDado(), dado.nextInt(ShadowsOfTheMordorTest.MAXHERO));
		assertThrows(IllegalArgumentException.class, () -> hu.pelearCon(ho));
		assertThrows(IllegalArgumentException.class, () -> hu.pelearCon(hu));
		hu.hp = 0;
		assertTrue(hu.estaMuerto());
		assertEquals(hu.getRaza(), "Humano");
	}
}