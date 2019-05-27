package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FunFactTest {

	private FunFact ff;
	
	public void setupScenary1(){
	ff = new FunFact("1", "Happy");	
	}
	
	@Test
	public void testFunFact() {
		setupScenary1();
		assertNotNull(ff, "Not creating it correctly");
		assertTrue(ff.getFact().equals("Happy"), "Not the right value returning");
		assertTrue(ff.getNumber().equals("1"), "Not the right value returning");
	}

}
