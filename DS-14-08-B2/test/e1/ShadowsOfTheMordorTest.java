package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShadowsOfTheMordorTest
{
	static final int MAXHERO = 101, MAXBEAST = 91;
	ShadowsOfTheMordor game = new ShadowsOfTheMordor();
	static int seed = 10;

	@Test
	void añadirBatalla()
	{
		game.anadirHeroe(new Hobbit("Ho", 10, 10, seed));
		game.anadirBestia(new Trasgo("Tr", 10, 10, seed));
		assertEquals(game.batalla(), "Turn 1:\n" +
																				 "  Fight between Ho (Energy=10) and Tr (Energy=10)\n" +
																				 "  Trasgo Tr dies!\n" +
																				 "HEROES WIN!!");
	}
}