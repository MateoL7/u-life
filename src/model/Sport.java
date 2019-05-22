package model;

public class Sport extends Activity{

	private double calories;
	private SportType type;
	
	public Sport(String name, int min, int hours, double cal, SportType st) {
		super(name, min, hours);
		calories = cal;
		type = st;
	}

	/**
	 * @return the calories
	 */
	public double getCalories() {
		return calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(double calories) {
		this.calories = calories;
	}

	/**
	 * @return the type
	 */
	public SportType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(SportType type) {
		this.type = type;
	} 

}