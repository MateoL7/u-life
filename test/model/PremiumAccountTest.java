package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class PremiumAccountTest {
	
	private PremiumAccount pa;
	
	public void setupScenary1(){
		pa = new PremiumAccount("JP","123",19,87.0,183.0,"male","JP","Juan");
	}
	
	@Test
	void testPremiumAccount() {
		setupScenary1();
		 Account tem =pa;
		 assertNotNull("Not creating the object", pa);
		   assertTrue(tem.getName().equals("Juan"));
		   assertTrue(tem.getAge() == 19);
		   assertTrue(tem.getHeight()==183);
		   assertTrue(tem.getWeight() == 87);
		   assertTrue(tem.getGender().equals("male"));
		   assertTrue(tem.getUsername().equals("JP"));
		   assertTrue(tem.getPassword().equals("123"));
		   assertTrue(tem.getNickName().equals("JP"));
	}
	@Test
	void testAddFunFact() {
		setupScenary1();
		pa.addFunFact("10", "fact");
	}
	
	@Test
	void testAddTip() {
		setupScenary1();
		pa.addTip("10", "tip");
	}
	
	@Test
	void testAddNote() {
		setupScenary1();
		Note n = new Note(10,"note");
		 pa.addNote(10,"note");
		 assertTrue("Not working corectly", pa.getFirstNote().getPrev().getNum() == n.getNum());
		 assertTrue("Not working corectly", pa.getFirstNote().getPrev().getNote().equalsIgnoreCase(n.getNote()));

	}
	
	@Test
	void testNote() {
		setupScenary1();
		Note n = new Note(10,"note");
		pa.setFirstNote(n);
		Note test = pa.getFirstNote();
		assertTrue(test.getNum() == 10);
		assertTrue(test.getNote()== n.getNote());
		 
	}

}
