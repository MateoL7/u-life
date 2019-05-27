package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class FreeAccountTest {

	@Test
	public void testFreeAccount() {
		FreeAccount fa = new FreeAccount("ho", "12", 12, 43, 143, "Male", "t", "Oliver");
		assertNotNull("It is null", fa);
		assertTrue("Not the right value returning", fa.getName().equals("Oliver"));
		assertTrue("Not the right value returning", fa.getNickName().equals("t"));
		assertTrue("Not the right value returning", fa.getGender().equals("Male"));
		assertTrue("Not the right value returning", fa.getUsername().equals("ho"));
		assertTrue("Not the right value returning", fa.getPassword().equals("12"));
		assertTrue("Not the right value returning", fa.getAge() == 12);
		assertTrue("Not the right value returning", fa.getHeight() == 143);
		assertTrue("Not the right value returning", fa.getWeight() == 43);
	}

}
