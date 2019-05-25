package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AlarmTest {

	public void setupScenary1() {
		
	}
	
	@Test
	public void testAlarm() {
		Alarm a = new Alarm(11, 11, "AM 11:11", true);
		
		assertNotNull("The object is null", a);
		assertTrue(a.getTime().equalsIgnoreCase("AM 11:11"));
		assertTrue(a.getHour() == 11);
		assertTrue(a.getMin() == 11);
	}
}
