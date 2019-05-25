package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Alarm implements Comparable<Alarm>{

	private int hour;
	private int min;
	private String time;
	private boolean vibrate;
//	private boolean[] days;

	
	private Alarm right;
	private Alarm left;
	
	public Alarm(int hour, int min, String t, boolean vibrate) {
		this.hour = hour;
		this.min = min;
		this.vibrate = vibrate;
		DateFormat date = new SimpleDateFormat("hh:mm:a");
		time = hour + ":"+min+":"+0;
	}
	
	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the vibrate
	 */
	public boolean isVibrate() {
		return vibrate;
	}

	/**
	 * @param vibrate the vibrate to set
	 */
	public void setVibrate(boolean vibrate) {
		this.vibrate = vibrate;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
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

	/**
	 * @return the right
	 */
	public Alarm getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Alarm right) {
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public Alarm getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Alarm left) {
		this.left = left;
	}
	
	@Override
	public String toString() {
		return time;
	}
	
}
