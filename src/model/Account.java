package model;

import java.io.Serializable;


public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int age;
	private double weight;
	private double height;
	private String gender;
	private String nickName;
	private String name;
	
	private Alarm rootAlarm;
	private Activity firstActivity;
	
	private Account next;
	private Account prev;

	public Account(String username, String password, int age, double weight, double height, String gender, String nickName, String name) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.nickName = nickName;
		this.name = name;
		this.setNext(this);
		this.setPrev(this);
	}

	/**
	 * @return the rootAlarm
	 */
	public Alarm getRootAlarm() {
		return rootAlarm;
	}

	/**
	 * @return the firstActivity
	 */
	public Activity getFirstActivity() {
		return firstActivity;
	}

	/**
	 * @param firstActivity the firstActivity to set
	 */
	public void setFirstActivity(Activity firstActivity) {
		this.firstActivity = firstActivity;
	}

	/**
	 * @param rootAlarm the rootAlarm to set
	 */
	public void setRootAlarm(Alarm rootAlarm) {
		this.rootAlarm = rootAlarm;
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

	/**
	 * @return the next
	 */
	public Account getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Account next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Account getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Account prev) {
		this.prev = prev;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void addActivity(String name, int minutes, int hours, double cal, SportType st) {
		Activity rest = new Activity(name, minutes, hours);
		if(firstActivity == null) {
			firstActivity = rest;
			rest.setNext(rest);
			rest.setPrev(rest);
		}
		else {
			Sport last = (Sport) firstActivity.getPrev();
			rest.setPrev(last);
			last.setNext(rest);
			firstActivity.setPrev(rest);
			rest.setNext(firstActivity);
		}
	}
	public void addSport(String name, int minutes, int hours, double cal, SportType st) {
		Sport sp = new Sport(name, minutes, hours, cal, st);
		if(firstActivity == null) {
			firstActivity = sp;
			sp.setNext(sp);
			sp.setPrev(sp);
		}
		else {
			Sport last = (Sport) firstActivity.getPrev();
			sp.setPrev(last);
			last.setNext(sp);
			firstActivity.setPrev(sp);
			sp.setNext(firstActivity);
		}
	}
}
