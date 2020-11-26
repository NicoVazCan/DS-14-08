package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TrasgoTest
{
	int seed = ShadowsOfTheMordorTest.seed;
	Random dado;
	Humano hu;
	Elfo el;
	Trasgo tr;
	static int aux;

	@BeforeEach
	void setUp()
	{
		dado = new Random(seed);
		hu = new Humano("Hu", 100, 50, seed);
		tr = new Trasgo("El", 100, 50, seed);
		el = new Elfo("El", 100, 50, seed);
	}

	@Test
	void testTrasgoVsHumano()
	{
		int huHp = 100;
		int dano = Math.min(50 - dado.nextInt(ShadowsOfTheMordorTest.MAXBEAST), 0);

		tr.pelearCon(hu);
		assertEquals(hu.getHp(), Math.max(huHp + dano, 0));
		aux = hu.getHp();
	}

	@Test
	void testOrcoVsElfo()
	{
		int elHp = 100;
		int dano = Math.min(50 - dado.nextInt(ShadowsOfTheMordorTest.MAXBEAST), 0);

		tr.pelearCon(el);
		assertEquals(el.getHp(), Math.max(elHp + dano, 0));
		assertEquals(el.getHp(), aux);
	}

	@Test
	void TestOrco()
	{
		Orco or = new Orco("Or", 100, 50);
		assertEquals(tr.tirarDado(), dado.nextInt(ShadowsOfTheMordorTest.MAXBEAST));
		assertThrows(IllegalArgumentException.class, () -> tr.pelearCon(or));
		assertThrows(IllegalArgumentException.class, () -> tr.pelearCon(tr));
		tr.hp = 0;
		assertTrue(tr.estaMuerto());
		assertEquals(tr.getRaza(), "Trasgo");
	}
}