package model;

import java.io.IOException;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Interface Information
*/
public interface Information {

	public final static String PATHFACTS = "data\\funFacts.txt";
	public final static String PATHTIPS = "data\\randomTips.txt";
	
	/** This is a method that must be override in the classes that implement it 
	*@param String with the location of the file to load
	*@return String with the information that was loaded
	*/
	public String loadInfo(String r) throws IOException;
}
