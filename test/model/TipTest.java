package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TipTest {

	public void setupScenary1() {
		
	}

	@Test
	void testTip() {
		setupScenary1();
		Tip t = new Tip(5,"Hacer pruebas es importante");
		assertTrue(t.getNumber()== 5);
		assertTrue(t.getTip().equals("Hacer pruebas es importante"));
	}

}
