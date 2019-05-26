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
import personalExceptions.NoDataException;

public class ULife {

	private ArrayList<Account> accounts;



	public ULife() {
		accounts = new ArrayList<Account>();
	}


	public Account searchAccount(String username, String password) throws NoAccountFoundException, NoDataException, MissingInfoException {
		if(username.equals("") || password.equals("")) {
			throw new MissingInfoException();
		}
		Account found = null;
		boolean stop = false;
		if(accounts.isEmpty()) {
			throw new NoDataException();
		}else {
			for(int c = 0; c < accounts.size() && stop == false;c++) {
				Account temporal = accounts.get(c);
				if(username.equals(temporal.getUsername()) && password.equals(temporal.getPassword())) {
					found = accounts.get(c);
				}
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
		if(username.equals("") || password.equals("") || age == 0 || weight == 0 || gender.equals("") ||height == 0 || nickName.equals("") ||name.equals("")) {
			throw new MissingInfoException();
		}else {
			Account p = new Account(username,password,age,weight,height,gender,nickName,name);
			accounts.add(p);
		}
	}

	public void createNewPremiumUser(String username, String password, int age, double weight, double height, String gender, String nickName, String name) throws MissingInfoException {
		if(username.equals("") || password.equals("") || age == 0 || weight == 0 || gender.equals("") ||height == 0 || nickName.equals("") ||name.equals("")) {
			throw new MissingInfoException();
		}else {
			PremiumAccount p = new PremiumAccount(username,password,age,weight,height,gender,nickName,name);
			accounts.add(p);
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
		oos.writeObject(accounts);
		oos.close();

	}

	/** 
	 * El metodo carga los datos desde un archivo .mateo
	 * @throws NoAccountFoundException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/savedAccounts.mateo"));
			accounts = (ArrayList<Account>)ois.readObject();
			ois.close();
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	//Selection
	public void sortByName() {
		for(int i = 0; i < accounts.size()-1; i ++) {
			int minPos = i;
			String minName = accounts.get(i).getName();
			for(int j = i+1; j < accounts.size(); j++) {
				String compareName = accounts.get(j).getName();
				if(compareName.compareTo(minName) < 0) {
					minPos = j;
					minName = compareName;
				}
			}
			Account temp = accounts.get(minPos);
			accounts.set(minPos, accounts.get(i));
			accounts.set(i, temp);
		}
	}
	public void sortByUsername() {
		for(int i = 0; i < accounts.size()-1; i ++) {
			int minPos = i;
			String minUname = accounts.get(i).getUsername();
			for(int j = i+1; j < accounts.size(); j++) {
				String compareUname = accounts.get(j).getUsername();
				if(compareUname.compareTo(minUname) < 0) {
					minPos = j;
					minUname = compareUname;
				}
			}
			Account temp = accounts.get(minPos);
			accounts.set(minPos, accounts.get(i));
			accounts.set(i, temp);
		}
	}
	//Bubble
	public void sortByNickname() {
		Account prev;
		for(int i = 0; i < accounts.size()-1; i++) {
			for(int j = 0; j < accounts.size()-1; j++) {
				if(accounts.get(j).getNickName().compareTo(accounts.get(j+1).getNickName()) > 0) {
					prev = accounts.get(j);
					accounts.set(j, accounts.get(j+1));
					accounts.set(j+1, prev);
				}
			}
		}
	}
	public void sortByWeight() {
		Account prev;
		for(int i = 0; i < accounts.size()-1; i++) {
			for(int j = 0; j < accounts.size()-1; j++) {
				if(accounts.get(j).getWeight() > accounts.get(j+1).getWeight()) {
					prev = accounts.get(j);
					accounts.set(j, accounts.get(j+1));
					accounts.set(j+1, prev);
				}
			}
		}
	}
	//Insertion
	public void sortByHeight() {
		for(int i = 1; i < accounts.size(); i++) {
			Account ini = accounts.get(i);
			int j;
			for(j = i-1; j >= 0 && accounts.get(j).getHeight() > ini.getHeight(); j--) {
				accounts.set(j+1, accounts.get(j));
			}
			accounts.set(j+1, ini);
		}
	}
	public void sortByAge() {
		for(int i = 1; i < accounts.size(); i++) {
			Account ini = accounts.get(i);
			int j;
			for(j = i-1; j >= 0 && accounts.get(j).getAge() > ini.getAge(); j--) {
				accounts.set(j+1, accounts.get(j));
			}
			accounts.set(j+1, ini);
		}
	}
	//Binary search
	public Account searchAge(int age) {
		Account gotIt = null;
		boolean found = false;
		int low = 0;
		int high = accounts.size()-1;
		while(low <= high && !found) {
			int mid = (low+high)/2;
			if(accounts.get(mid).getAge() < age) {
				low = mid + 1;
			}
			else if(accounts.get(mid).getAge() > age) {
				high = mid - 1;
			}
			else{
				gotIt = accounts.get(mid);
				found = true;
			}
		}
		
		return gotIt;
	}
	public Account searchHegiht(double height) {
		Account gotIt = null;
		boolean found = false;
		int low = 0;
		int high = accounts.size()-1;
		while(low <= high && !found) {
			int mid = (low+high)/2;
			if(accounts.get(mid).getHeight() < height) {
				low = mid + 1;
			}
			else if(accounts.get(mid).getHeight() > height) {
				high = mid - 1;
			}
			else{
				gotIt = accounts.get(mid);
				found = true;
			}
		}
		
		return gotIt;
	}


}
