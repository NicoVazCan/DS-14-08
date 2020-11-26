package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class OrcoTest
{
	int seed = ShadowsOfTheMordorTest.seed;
	Random dado;
	Humano hu;
	Elfo el;
	Orco or;

	@BeforeEach
	void setUp()
	{
		dado = new Random(seed);
		hu = new Humano("Hu", 100, 50, seed);
		el = new Elfo("El", 100, 20, seed);
		or = new Orco("Or", 100, 50, seed);
	}

	@Test
	void testOrcoVsHumano()
	{
		int huHp = 100;
		int dano = Math.min(50 - dado.nextInt(ShadowsOfTheMordorTest.MAXBEAST) - (int)(50*0.1), 0);

		or.pelearCon(hu);
		assertEquals(hu.getHp(), Math.max(huHp + dano, 0));
	}

	@Test
	void testOrcoVsElfo()
	{
		int elHp = 100;
		int dano = Math.min(20 - dado.nextInt(ShadowsOfTheMordorTest.MAXBEAST) - (int)(20*0.1), 0);

		or.pelearCon(el);
		assertEquals(el.getHp(), Math.max(elHp + dano, 0));
	}

	@Test
	void TestOrco()
	{
		Trasgo tr = new Trasgo("Tr", 100, 50);
		assertEquals(or.tirarDado(), dado.nextInt(ShadowsOfTheMordorTest.MAXBEAST));
		assertThrows(IllegalArgumentException.class, () -> or.pelearCon(or));
		assertThrows(IllegalArgumentException.class, () -> or.pelearCon(tr));
		or.hp = 0;
		assertTrue(or.estaMuerto());
		assertEquals(or.getRaza(), "Orco");
	}
}