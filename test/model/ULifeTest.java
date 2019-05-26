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

	public void setupScenary2() {
		u = new ULife();
		FreeAccount a1 = new FreeAccount("M7", "123", 18, 69.0, 166, "Male", "Teo", "Mateo");
		PremiumAccount a2 = new PremiumAccount("ares", "123", 15, 69.5, 176, "Male", "Jo", "Jorge");
		PremiumAccount a3 = new PremiumAccount("epx3", "123", 16, 62.0, 156, "Male", "Reo", "Mario");
		FreeAccount a4 = new FreeAccount("sawq12", "123", 12, 49.0, 146, "Male", "4eT", "Gato");
		PremiumAccount a5 = new PremiumAccount("MLS", "123", 19, 50.0, 157, "Female", "Manu", "Manuela");
		u.getAccounts().add(a1);
		u.getAccounts().add(a2);
		u.getAccounts().add(a3);
		u.getAccounts().add(a4);
		u.getAccounts().add(a5);
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
	public void testLoadData() throws MissingInfoException, FileNotFoundException, IOException, ClassNotFoundException, NoAccountFoundException, NoDataException {
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
	public void testCreateNewPremiumUser() throws MissingInfoException {
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
	public void testSearchAccount() throws MissingInfoException, NoAccountFoundException, NoDataException {
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

	@Test
	public void testSortByName() {
		setupScenary2();
		u.sortByName();

		for(int i = 0; i < u.getAccounts().size()-1; i++) {
			assertTrue("Not the right position", u.getAccounts().get(i).getName().compareTo(u.getAccounts().get(i+1).getName()) <= 0);
		}
	}

	@Test
	public void testSortByUsername() {
		setupScenary2();
		u.sortByUsername();

		for(int i = 0; i < u.getAccounts().size()-1; i++) {
			assertTrue("Not the right position", u.getAccounts().get(i).getUsername().compareTo(u.getAccounts().get(i+1).getUsername()) <= 0);
		}
	}
	@Test
	public void testSortByNickname() {
		setupScenary2();
		u.sortByNickname();

		for(int i = 0; i < u.getAccounts().size()-1; i++) {
			assertTrue("Not the right position", u.getAccounts().get(i).getNickName().compareTo(u.getAccounts().get(i+1).getNickName()) <= 0);
		}
	}
	@Test
	public void testSortByWeight() {
		setupScenary2();
		u.sortByWeight();

		for(int i = 0; i < u.getAccounts().size()-1; i++) {
			assertTrue("Not the right position", u.getAccounts().get(i).getWeight() <= u.getAccounts().get(i+1).getWeight());
		}
	}
	@Test
	public void testSortByHeight() {
		setupScenary2();
		u.sortByHeight();

		for(int i = 0; i < u.getAccounts().size()-1; i++) {
			assertTrue("Not the right position", u.getAccounts().get(i).getHeight() <= u.getAccounts().get(i+1).getHeight());
		}
	}
	@Test
	public void testSortByAge() {
		setupScenary2();
		u.sortByAge();

		for(int i = 0; i < u.getAccounts().size()-1; i++) {
			assertTrue("Not the right position", u.getAccounts().get(i).getAge() <= u.getAccounts().get(i+1).getAge());
		}
	}
	@Test
	public void testSearchAge() {
		setupScenary2();
		int age = 15;
		u.sortByAge();
		Account a = u.searchAge(age);
		assertNotNull("Not returning correctly", a);
		assertTrue("Not the right value when returning", a.getAge() == 15);
	}
	@Test
	public void testSearchHeight() {
		setupScenary2();
		double height = 166;
		u.sortByHeight();
		Account a = u.searchHegiht(height);
		assertNotNull("Not returning correctly", a);
		assertTrue("Not the right value when returning", a.getHeight() == 166);
	}

}
