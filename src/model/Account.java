package model;

public class Account {

	private String username;
	private String password;
	private int age;
	private double weight;
	private double height;

	public Account(String username, String password, int age, double weight, double height) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
}
