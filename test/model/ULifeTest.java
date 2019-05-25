package model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class ULifeTest {

	public void setupScenary1(){
		
	}
	
	@Test
	public void testULife() {
		ULife x = new ULife();
		
		assertNotNull("The object is null", x);
	}
}
