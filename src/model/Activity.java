package model;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class Activity
*/
public class Activity implements Active{

	private String name;
	private int minutes;
	private int hours;
	
	private Activity next;
	private Activity prev;
	
	/**
	 * This is the method that instantiates an Activity, the builder of the class
	 * @param name String with the name of the activity
	 * @param minutes int with the minutes provided for the activity
	 * @param hours int with the hours provided for the activity
	 */
	public Activity(String name, int minutes, int hours) {
		this.name = name;
		this.minutes = minutes;
		this.hours = hours;
	}

	/** returns the current value of name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** changes the atribute name to the parameter
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**returns the value of minute
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**Changes the value of minutes to the parameter
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**returns the value of hours
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/** Changes the value of hours to the parameter
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**returns the value of Next
	 * @return the next
	 */
	public Activity getNext() {
		return next;
	}

	/** Changes the value of next to the parameter
	 * @param next the next to set
	 */
	public void setNext(Activity next) {
		this.next = next;
	}

	/**Returns the value of prev 
	 * @return the prev
	 */
	public Activity getPrev() {
		return prev;
	}

	/** Changes the value of prev to the parameter
	 * @param prev the prev to set
	 */
	public void setPrev(Activity prev) {
		this.prev = prev;
	}
	
	/**
	 * This method confirms if an activity has finished or not
	 * @return boolean that confirms
	 */
	@Override
	public boolean isDone() {
		boolean done = false;
		
		if(hours == 0 && minutes == 0) {
			done = true;
		}
		return done;
	}
	/**
	 * This method Overrides the method toString 
	 * @return String with the message when calling the object of the class
	 */
	@Override
	public String toString() {
		return "\nName: " + name + "\nHours: " + hours + "\nMinutes: " + minutes;
	}
}
