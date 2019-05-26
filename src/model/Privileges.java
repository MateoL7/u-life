package model;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Interface Privileges
*/
public interface Privileges {

	/** This is a method that must be override in the classes that implement it 
	*/
	public void addActivity(String name, int minutes, int hours);
	/** This is a method that must be override in the classes that implement it 
	*/
	public void addAlarm(int hour, int min, String time);
	/** This is a method that must be override in the classes that implement it 
	*/
	public void addSport(String name, int minutes, int hours, double cal, SportType st);
}
