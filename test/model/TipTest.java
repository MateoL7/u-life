package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TipTest {

	private Tip t;
	
	public void setupScenary1() {
		t = new Tip(5, "Do your best always");
	}

	@Test
	void testTip() {
		setupScenary1();
		assertTrue(t.getNumber()== 5);
		assertTrue(t.getTip().equals("Do your best always"));
		assertNotNull(t, "The object is not beign created");
	}

}
