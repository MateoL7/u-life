package model;

public class Activity {

	private String name;
	private int minutes;
	private int hours;
	
	private Activity next;
	private Activity prev;
	
	public Activity(String name, int minutes, int hours) {
		
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

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * @return the next
	 */
	public Activity getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Activity next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Activity getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Activity prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nHours: " + hours + "\nMinutes: " + minutes;
	}
}
