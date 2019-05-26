package model;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class Alarm
*/

public class Alarm implements Comparable<Alarm>{

	private int hour;
	private int min;
	private String time;

	
	private Alarm right;
	private Alarm left;
	
	/**
	 * This is the method that instantiates an Alarm, the builder of the class
	 * @param hour int with the hour for it to activate
	 * @param min int with the minute for it to activate
	 * @param t String with the time all together
	 */
	public Alarm(int hour, int min, String t) {
		this.hour = hour;
		this.min = min;
//		DateFormat date = new SimpleDateFormat("hh:mm:a");
		time = t;
	}
	
	/** returns the current value of min
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**Changes the current value of min for the parameter
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/** returns the current value of hour
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**changes the value of hour for the parameter
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/** returns the value of time
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**Changes the value of tiem to the parameters
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public int compareTo(Alarm al) {
		int comparation = 0;
		if(time.compareTo(al.getTime()) > 0) {
			comparation = 1;
		}
		if(time.compareTo(al.getTime()) < 0) {
			comparation = -1;
		}
		return comparation;
	}

	/** returns the current value of right
	 * @return the right
	 */
	public Alarm getRight() {
		return right;
	}

	/**Changes the current value of right to the parameter
	 * @param right the right to set
	 */
	public void setRight(Alarm right) {
		this.right = right;
	}

	/**returns the current value of left
	 * @return the left
	 */
	public Alarm getLeft() {
		return left;
	}

	/**Changes the current value of Left for the parameters
	 * @param left the left to set
	 */
	public void setLeft(Alarm left) {
		this.left = left;
	}
	
	
}
