package model;

public class Sport extends Activity{

	private double calories;
	private SportType type;
	
	public Sport(String name, int min, int hours, double cal, SportType st) {
		super(name, min, hours);
		calories = cal;
		type = st;
	}

	/** returns the current value of calories
	 * @return the calories
	 */
	public double getCalories() {
		return calories;
	}

	/** changes the current value of calories for the paramters
	 * @param calories the calories to set
	 */
	public void setCalories(double calories) {
		this.calories = calories;
	}

	/**returns the current value of types 
	 * @return the type
	 */
	public SportType getType() {
		return type;
	}

	/**Changes the current value of type for the parameters
	 * @param type the type to set
	 */
	public void setType(SportType type) {
		this.type = type;
	} 

}
