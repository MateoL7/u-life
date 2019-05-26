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
	@Test
	void testToString() {
		int minutes = 30;
		int hours = 1;
		String m = "Strudy science";
		Activity a = new Activity(m, minutes, hours);
		String msg =  "\nName: " + m + "\nHours: " + hours + "\nMinutes: " + minutes;
		String toS = a+"";
		assertTrue("Not working correctly when calling it", msg.equalsIgnoreCase(toS));
	}
	@Test
	public void testIsDone() {
		Activity a = new Activity("Study science", 0, 0);
		assertTrue("Not sending the right value", a.isDone() == true);
	}
	
}
