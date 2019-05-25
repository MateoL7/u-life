package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import personalExceptions.MissingInfoException;
import personalExceptions.NoAccountFoundException;
import personalExceptions.NoDataException;

public class ULifeTest {

	private ULife u;

	public void setupScenary1(){
		u = new ULife();
	}	

	@Test
	public void testULife() {
		ULife x = new ULife();

		assertNotNull("The object is null", x);
	}

	@Test
	void testCreateNewUser() throws MissingInfoException {
		setupScenary1();
		u.createNewUser("JP", "1234", 19, 86, 183, "Male", "JP", "Juan");
		Account tem = u.getAccounts().get(0);
		assertTrue(tem.getName().equals("Juan"));
		assertTrue(tem.getAge() == 19);
		assertTrue(tem.getHeight()==183);
		assertTrue(tem.getWeight() == 86);
		assertTrue(tem.getGender().equals("Male"));
		assertTrue(tem.getUsername().equals("JP"));
		assertTrue(tem.getPassword().equals("1234"));
		assertTrue(tem.getNickName().equals("JP"));
	}

	@Test
	void testLoadData() throws MissingInfoException, FileNotFoundException, IOException, ClassNotFoundException, NoAccountFoundException, NoDataException {
		setupScenary1();
		u.createNewUser("JP", "1234", 19, 86, 183, "Male", "JP", "Juan");
		u.saveData();
		u.loadData();
		Account tem = u.getAccounts().get(0);
		assertTrue(tem.getName().equals("Juan"));
		assertTrue(tem.getAge() == 19);
		assertTrue(tem.getHeight()==183);
		assertTrue(tem.getWeight() == 86);
		assertTrue(tem.getGender().equals("Male"));
		assertTrue(tem.getUsername().equals("JP"));
		assertTrue(tem.getPassword().equals("1234"));
		assertTrue(tem.getNickName().equals("JP"));
	}

	@Test
	void testPremiumUser() throws MissingInfoException {
		setupScenary1();
		u.createNewPremiumUser("JP", "1234", 19, 86, 183, "Male", "JP", "Juan");
		Account tem = u.getAccounts().get(0);
		assertTrue(tem.getName().equals("Juan"));
		assertTrue(tem.getAge() == 19);
		assertTrue(tem.getHeight()==183);
		assertTrue(tem.getWeight() == 86);
		assertTrue(tem.getGender().equals("Male"));
		assertTrue(tem.getUsername().equals("JP"));
		assertTrue(tem.getPassword().equals("1234"));
		assertTrue(tem.getNickName().equals("JP"));
	}

	@Test
	void testSearchAccount() throws MissingInfoException, NoAccountFoundException, NoDataException {
		setupScenary1();
		u.createNewPremiumUser("JP", "1234", 19, 86, 183, "Male", "JP", "Juan");
		Account tem = u.searchAccount("JP", "1234");
		assertTrue(tem.getName().equals("Juan"));
		assertTrue(tem.getAge() == 19);
		assertTrue(tem.getHeight()==183);
		assertTrue(tem.getWeight() == 86);
		assertTrue(tem.getGender().equals("Male"));
		assertTrue(tem.getUsername().equals("JP"));
		assertTrue(tem.getPassword().equals("1234"));
		assertTrue(tem.getNickName().equals("JP"));
	}
}
