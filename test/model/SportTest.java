package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SportTest {

	@Test
	public void testSport() {
		Sport a = new Sport("Jump", 30, 1, 20, SportType.PARKOUR);
		assertNotNull("The object is null", a);
		assertTrue("Not the right value", a.getName().equalsIgnoreCase("Jump"));
		assertTrue("Not the right value", a.getHours() == 1);
		assertTrue("Not the right value", a.getMinutes() == 30);
		assertTrue("Not the right value", a.getCalories() == 20);
		assertTrue("Not the right value", a.getType().equals(SportType.PARKOUR));
	}
	@Test
	public void testIsDone() {
		Sport a = new Sport("Jump", 0, 0, 20, SportType.PARKOUR);
		assertTrue("Not sending the right value", a.isDone() == true);
	}

}
