package model;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ActivityTest {

	public void setupScenary1() {
		
	}
	
	@Test
	public void testActivity() {
		Activity a = new Activity("Study science", 30, 1);
		assertNotNull("The object is null", a);
		assertTrue(a.getName().equalsIgnoreCase("Study science"));
		assertTrue(a.getHours() == 1);
		assertTrue(a.getMinutes() == 30);
	}
}
