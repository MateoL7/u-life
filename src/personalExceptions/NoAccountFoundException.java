package personalExceptions;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*ExceptionClass NoAccountFoundException
*/
@SuppressWarnings("serial")
public class NoAccountFoundException extends Exception{
	public NoAccountFoundException() {
		super("The account was not found.");
	}

}
