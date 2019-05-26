package model;

public class Activity implements Active{

	private String name;
	private int minutes;
	private int hours;
	
	private Activity next;
	private Activity prev;
	
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
	
	@Override
	public String toString() {
		return "Name: " + name + "\nHours: " + hours + "\nMinutes: " + minutes;
	}
}
