package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AlarmTest {
	
	private Alarm a1;
	private Alarm a2;

	public void setupScenary1() {
		
	}
	
	public void setupScenary2() {
		
	}
	
	@Test
	public void testAlarm() {
		Alarm a = new Alarm(11, 11, "AM 11:11");
		
		assertNotNull("The object is null", a);
		assertTrue(a.getTime().equalsIgnoreCase("AM 11:11"));
		assertTrue(a.getHour() == 11);
		assertTrue(a.getMin() == 11);
	}
	
	@Test
	void testCompareTo() {
		a1 = new Alarm(11,11,"AM 11:11");
		a2 = new Alarm(12,12,"PM 12:12");
		
		 int data  =a2.compareTo(a2);
		int data2 = a1.compareTo(a1);
		assertTrue("Not comparing correctly", data>-1);
		assertTrue("Not comparing correctly", data2<1);
	}
}
