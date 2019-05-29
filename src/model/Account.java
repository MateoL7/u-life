package model;

import java.io.Serializable;
/** 
 *@author: Mateo Loaiza
 *@author: Juan Pablo Herrera
 *@version: 26/05/2019
 *Class Account
 */

public class Account implements Serializable, Privileges {
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


	/**
	 * This is the method that instantiates an Account, the builder of the class
	 * @param username String with the username for the account
	 * @param password String with the password for the account
	 * @param age int with the age from the user
	 * @param weight double with the weight provided by the user
	 * @param height double with the height provided by the user
	 * @param gender String with the gender provided by the user
	 * @param nickName String with the nickname provided by the user
	 * @param name String with the name provided by the user
	 */
	public Account(String username, String password, int age, double weight, double height, String gender, String nickName, String name) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.nickName = nickName;
		this.name = name;
	}

	/** Returns the current value of rootAlarm
	 * @return the rootAlarm
	 */
	public Alarm getRootAlarm() {
		return rootAlarm;
	}

	/** returns the current value of first activity
	 * @return the firstActivity
	 */
	public Activity getFirstActivity() {
		return firstActivity;
	}

	/**Changes the atribute firstActivity to the one in 
	 * the parameter
	 * @param firstActivity the firstActivity to set
	 */
	public void setFirstActivity(Activity firstActivity) {
		this.firstActivity = firstActivity;
	}

	/** changes the atribute roomAlarm to he one in the atribute
	 * @param rootAlarm the rootAlarm to set
	 */
	public void setRootAlarm(Alarm rootAlarm) {
		this.rootAlarm = rootAlarm;
	}

	/**returns the current value of username
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/** Changes the atribute username to he one in the parameter
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**returns the current value of age
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/** changes the value of age to the parameter
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** returns the current value of password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**changes the value of password to the one in the parameter
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**returns the current value of weight
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**changes the atribute weight to the parameter
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**returns the value of height
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**changes the value of height to the atribute
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}


	/**returns the current value of gender
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**changes the value of gender to the one in the parameter
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**returns the current value of nickName
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**Changes the current value of nickname to the parameter
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/** returns the current value of name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**changes the current value of name for the parammeter
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds an activity to the linked list 
	 * @param name the name of the activity to be added
	 * @param minutes the minutes of the duration of the activity
	 * @param hours the hours of the duration of the activity
	 */
	public void addActivity(String name, int minutes, int hours) {
		Activity rest = new Activity(name, minutes, hours);
		if(firstActivity == null) {
			firstActivity = rest;
			rest.setNext(rest);
			rest.setPrev(rest);
		}
		else {
			Activity last = firstActivity.getPrev();
			rest.setPrev(last);
			last.setNext(rest);
			firstActivity.setPrev(rest);
			rest.setNext(firstActivity);
		}
	}
	/**
	 * Adds a sport to the linked list of sports
	 * @param name the name of the sport	
	 * @param minutes the minutes of the sport	
	 * @param hours the hours of the sort
	 * @param cal the amount of calories burned by the sport
	 * @param st the type of sport 
	 */
	public void addSport(String name, int minutes, int hours, double cal, SportType st) {
		Sport sp = new Sport(name, minutes, hours, cal, st);
		if(firstActivity == null) {
			firstActivity = sp;
			sp.setNext(sp);
			sp.setPrev(sp);
		}
		else {
			Activity last = firstActivity.getPrev();
			sp.setPrev(last);
			last.setNext(sp);
			firstActivity.setPrev(sp);
			sp.setNext(firstActivity);
		}
	}
	/**
	 * Creates an alarm object to later be assigned to the binary tree
	 * @param hour the hour of the alarm	
	 * @param min the minutes of the alarm
	 * @param time the time in am pm of the alarm
	 * @param vibrate wether the alarm should vibrate or not
	 */

	public void addAlarm(int hour, int min, String time) {
		Alarm a = new Alarm(hour, min,time);

		if(rootAlarm == null) {
			rootAlarm = a;
		}
		else {
			addAlarm(a, rootAlarm);
		}
	}
	/**traverses the binary tree to assign the alarm
	 * adds an alarm to the binary tree
	 * @param a the alarm to be added
	 * @param current the root of the binary tree being traversed
	 */
	private void addAlarm(Alarm a, Alarm current) {
		if(a.compareTo(current) > 0) {
			if(current.getRight() == null) {
				current.setRight(a);
			}
			else {
				addAlarm(a, current.getRight());
			}
		}
		if(a.compareTo(current) < 0) {
			if(current.getLeft() == null) {
				current.setLeft(a);
			}
			else {
				addAlarm(a, current.getLeft());
			}
		}
	}

	/**
	 * shows all the attributes of the activities
	 * @return the attributes of the activities in string form
	 */
	public String showActivities() {
		String msg = "";
		if(firstActivity != null) {
			Activity current = firstActivity;
			while(current.getNext() != firstActivity) {
				msg += "" + current;
				current = current.getNext();
			}
			msg += "" + current;
		}else {
			msg = "There are no activities planned yet";
		}
		return msg;
	}
	/**
	 * shows all of the attributes of all the alarms
	 * @return the attributes of the alarms in string format
	 */

	public String showAlarms() {
		if(rootAlarm == null) {
			return "There are no alarms set yet";
		}
		return showAlarms(rootAlarm);
	}

	/**Traverses the binary tree of alarms in order to show the alarms
	 * 
	 * @param current the root of the binary tree being traversed
	 * @return the attributes of the binary tree in string format
	 */
	private String showAlarms(Alarm current) {
		String msg = "";
		if(current != null) {
			msg += "\n" + current.getTime() + "\n";
		}
		if(current.getLeft() != null) {
			msg += showAlarms(current.getLeft());
		}
		if(current.getRight() != null) {
			msg += showAlarms(current.getRight());
		}
		return msg;
	}
	/**checks the alarms based on minutes and hours
	 * 
	 * @param hour the hour to be compared
	 * @param minute  the minutes to be compared
	 * @return a message indicating whether an alarm activated or not
	 */
	public String checkAlarm(int hour, int minute) {
		return checkAlarm(hour,minute,rootAlarm);
	}

	/**traverses the binary tree in order to check if the alarms were activated
	 * 
	 * @param hour hour to be compared
	 * @param minute minutes to be compared
	 * @param a the alarm that is root of the current binary tree
	 * @return a message indicating whether or not the alarm was activated
	 */
	private String checkAlarm(int hour,int minute,Alarm a) {
		String msg = "";
		if(a != null) {
			if(a.getHour() == hour && minute == a.getMin()) {
				msg = "Activated"; 
			}
			else {
				if(a.getLeft() != null) {
					msg = checkAlarm(hour,minute,a.getLeft());	
				}
				if(a.getRight() != null) {
					msg = checkAlarm(hour,minute,a.getRight());	
				}
			}
		}
		return msg;
	}
}

