package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import personalExceptions.MissingInfoException;

public class ULife {

	private Account firstUser;

	public ULife() {

	}
	/**
	 * @return the firstUser
	 */
	public Account getFirstUser() {
		return firstUser;
	}

	/**
	 * @param firstUser the firstUser to set
	 */
	public void setFirstUser(Account firstUser) {
		this.firstUser = firstUser;
	}

	public Account searchAccount(String username, String password) {
		boolean keep = true;
		Account found = null;
		if(firstUser != null) {
			if(firstUser.getUsername().equals(firstUser.getNext().getUsername())){
				found = firstUser;
			}
			else {
				Account current = firstUser;
				while(current.getNext() != firstUser && keep) {
					if(current.getUsername().equalsIgnoreCase(username)) {
						if(current.getPassword().equalsIgnoreCase(password)) {
							found = current;
						}
					}
					current = current.getNext();
				}
			}
		}
		return found;
	}
	/**
	 * 
	 * @param username name of the user	
	 * @param password password of the user
	 * @param age age of the user
	 * @param weight weight of the user
	 * @param height height of the user
	 * @param gender gender of the user
	 * @param nickName nickname of the user
	 * @param name name of the user
	 */
	public void createNewUser(String username, String password, int age, double weight, double height, String gender, String nickName, String name) throws MissingInfoException {
		if((username == "" || username == null) || (password == "" || password == null) || weight <= 20 || height <= 100 || (gender == "" || gender == null) || (nickName == "" || nickName == null) || age <= 5 || (name == "" || name == null)) {
			throw new MissingInfoException(username, password, age, weight, height, gender, nickName, name);
		}else {
			Account a = new Account(username,password,age,weight,height,gender,nickName, name);
			if(firstUser != null) {
				Account temp = firstUser.getPrev();
				temp.setNext(a);
				firstUser.setPrev(a);
				a.setNext(firstUser);
				a.setPrev(temp);
			}
			else {
				firstUser = a;
				firstUser.setNext(a);
				firstUser.setPrev(a);
			}

		}
	}
	
	public void createNewPremiumUser(String username, String password, int age, double weight, double height, String gender, String nickName, String name) throws MissingInfoException {
		if((username == "" || username == null) || (password == "" || password == null) || weight <= 20 || height <= 100 || (gender == "" || gender == null) || (nickName == "" || nickName == null) || age <= 5 || (name == "" || name == null)) {
			throw new MissingInfoException(username,password,age,weight,height,gender,nickName, name);
		}else {
			PremiumAccount a = new PremiumAccount(username,password,age,weight,height,gender,nickName, name);
			if(firstUser != null) {
				PremiumAccount temp = (PremiumAccount) firstUser.getPrev();
				temp.setNext(a);
				firstUser.setPrev(a);
				a.setNext(firstUser);
				a.setPrev(temp);
			}
			else {
				firstUser = a;
				firstUser.setNext(a);
				firstUser.setPrev(a);
			}

		}
		
	}

	/**
	 * El metodo carga los objetos de account y los guarda en un archivo .mateo
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveData() throws FileNotFoundException, IOException {
		File f = new File("data/savedAccounts.mateo");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(firstUser);
		oos.close();

	}

	/** 
	 * El metodo carga los datos desde un archivo .mateo
	 * 
	 */
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/SavedAccounts.mateo"));
		firstUser = (Account) ois.readObject();
		ois.close();
	}

}
