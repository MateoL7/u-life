package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import personalExceptions.MissingInfoException;
import personalExceptions.NoAccountFoundException;

public class ULife {

	private ArrayList<Account> Accounts;

	
	
	public ULife() {
      Accounts = new ArrayList<Account>();
	}


	public Account searchAccount(String username, String password) throws NoAccountFoundException {
		Account found = null;
		boolean stop = false;
	      for(int c = 0; c < Accounts.size() && stop == false;c++) {
	    	    Account temporal = Accounts.get(c);
	    	    if(username.equals(temporal.getUsername()) && password.equals(temporal.getPassword())) {
	    	    	found = Accounts.get(c);
	    	    }
	      }
	      if(found == null) {
	    	  throw new NoAccountFoundException();
	      }else {
	      return found;
	}
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
		if(username == null || password == null || age == 0 || weight == 0 || gender == null ||height == 0 || nickName == null ||name == null) {
	         throw new MissingInfoException();
			}else {
				Account p = new Account(username,password,age,weight,height,gender,nickName,name);
				Accounts.add(p);
			}
	}
	
	public void createNewPremiumUser(String username, String password, int age, double weight, double height, String gender, String nickName, String name) throws MissingInfoException {
		if(username == null || password == null || age == 0 || weight == 0 || gender == null ||height == 0 || nickName == null ||name == null) {
         throw new MissingInfoException();
		}else {
			PremiumAccount p = new PremiumAccount(username,password,age,weight,height,gender,nickName,name);
			Accounts.add(p);
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
		oos.writeObject(Accounts);
		oos.close();

	}

	/** 
	 * El metodo carga los datos desde un archivo .mateo
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/SavedAccounts.mateo"));
		Accounts = (ArrayList<Account>)ois.readObject();
		ois.close();
	}
	

}
