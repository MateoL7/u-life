package personalExceptions;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*ExceptionClass NoDataException
*/
@SuppressWarnings("serial")
public class NoDataException extends Exception{
    public NoDataException() {
	  super("There are no accounts found in the database");
	}
} 
