package model;

import java.io.*;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class FreeAccount
*/
public class FreeAccount extends Account implements Information, Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * This is the constructor, is in charge of instantiate what the object must have
	 * @param username String with the username for the account
	 * @param password String with the password for the account
	 * @param age int with the age from the user
	 * @param weight double with the weight provided by the user
	 * @param height double with the height provided by the user
	 * @param gender String with the gender provided by the user
	 * @param nickName String with the nickname provided by the user
	 * @param name String with the name provided by the user
	 */
	public FreeAccount(String username, String password, int age, double weight, double height, String gender,
			String nickName, String name) {
		super(username, password, age, weight, height, gender, nickName, name);
	}
	/**
	 * This method reads the information from a txt and then allows you to retrieve it
	 * @param path String with the location of the file to read
	 */
	@Override
	public String loadInfo(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line = br.readLine();
		String separate = "";
		while(line != null) {
			String parts[] = line.split(";");
			String num = parts[0];
			String info = parts[1];
			separate += num + ";" + info + ",";

			line = br.readLine();
		}
		br.close();
		return separate;
	}
}
