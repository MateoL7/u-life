package model;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class Sport
*/
public class Sport extends Activity{

	private double calories;
	private SportType type;
	/**
	 * This is the method that instantiates an Sport, the builder of the class
	 * @param name String with the name of the sport
	 * @param min int with the minutes 
	 * @param hours int with the hours
	 * @param cal double with the calories
	 * @param st SportType with the type of sport to do
	 */
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
