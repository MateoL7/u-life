package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NoteTest {

	@Test
	public void testNote() {
		Note n = new Note(1, "Nothing");
		assertNotNull(n, "It is null");
		assertTrue(n.getNum() == 1, "Not the right value");
		assertTrue(n.getNote().equals("Nothing"), "Not the right value");
	}

}
