package model;

public class Alarm {

	private int hour;
	private int min;
	private boolean vibrate;
	private boolean[] days;
	
	public Alarm(int hour, int min, boolean vibrate, boolean[] days) {
		this.hour = hour;
		this.min = min;
		this.vibrate = vibrate;
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
	 * @return the days
	 */
	public boolean[] getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(boolean[] days) {
		this.days = days;
	}
}
