package model;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ActivityTest {
	public void setupScenary1(){
		
	}
	
	@Test
	public void testActivity() {
		setupScenary1();
		Activity a = new Activity("Study science", 30, 1);
		assertNotNull("The object is null", a);
		assertTrue("Not the right value", a.getName().equalsIgnoreCase("Study science"));
		assertTrue("Not the right value", a.getHours() == 1);
		assertTrue("Not the right value", a.getMinutes() == 30);
	}
	@Test
	void testToString() {
		setupScenary1();
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
		setupScenary1();
		Activity a = new Activity("Study science", 0, 0);
		assertTrue("Not sending the right value", a.isDone() == true);
	}
	
}
