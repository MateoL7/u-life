package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	 * @return a message indicating wether or not the user could be added
	 */
	public String CreateNewUser(String username, String password, int age, double weight, double height, String gender, String nickName) {
		String message;
		if(username == null || password == null || weight == 0 || height == 0 || gender == null || nickName == null || age == 0) {
			message = "No se pude crear la cuenta debido a que uno o mas campos requeridos estan vacios";
		}else {
		Account a = new Account(username,password,age,weight,height,gender,nickName);
		if(firstUser != null) {
			Account temp = firstUser.getPrev();
			temp.setNext(a);
			firstUser.setPrev(a);
			a.setNext(firstUser);
			a.setPrev(temp);
			message = "Se creo exitosamente su cuenta : " + "\n" + "Usuario : " + username + "\n" + "Contraseña : " +password;
		}
		else {
			firstUser = a;
			firstUser.setNext(a);
			firstUser.setPrev(a);
			message = "Se creo exitosamente su cuenta : " + "\n" + "Usuario : " + username + "\n" + "Contraseña : " +password;
		}
		
		}
		return message;
	}
	
	/**
	 * El metodo carga los objetos de account y los guarda en un archivo .mateo
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void SaveData() throws FileNotFoundException, IOException {
		File f = new File("data/SavedAccounts.mateo");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(firstUser);
		oos.close();
		
	}
	
	/*El metodo carga los datos desde un archivo .mateo
	 * 
	 */
	public void LoadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/SavedAccounts.mateo"));
		firstUser = (Account)ois.readObject();
		ois.close();
	}
	
}
