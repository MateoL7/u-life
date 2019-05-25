package model;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
		pa.addFunFact("10", "es bueno hacer pruebas");
	}
	
	@Test
	void testAddTip() {
		setupScenary1();
		pa.addTip("10", "es bueno hacer pruebas");
	}
	
	@Test
	void testAddNote() {
		setupScenary1();
		boolean decide = pa.addNote(10,"hay que hacer pruebas");
		assertTrue(decide);
	}

}
