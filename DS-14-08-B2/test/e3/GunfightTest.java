package e3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunfightTest
{

	@Test
	void setUp()
	{
	    Gunslinger test1 = new Gunslinger();
        Gunslinger test2 = new Gunslinger();
        assertEquals(test1.getLoads(),test2.getRivalLoads());
		System.out.println(test2.getRivalActions());
        test2.rivalAction(GunslingerAction.RELOAD);
		test2.rivalAction(GunslingerAction.SHOOT);
		assertEquals(test1.getLoads(),test2.getRivalLoads());
		test2.rivalAction(GunslingerAction.RELOAD);
		//assertEquals(test1.getLoads(),test2.getRivalLoads());
		//assertEquals(test2.getRivalActions(),"[]");
		System.out.println(test2.getRivalActions());
	}

	/*@AfterEach
	void tearDown()
	{
	}*/
}