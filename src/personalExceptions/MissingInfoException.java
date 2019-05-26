package personalExceptions;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*ExceptionClass MissingInfoException
*/
@SuppressWarnings("serial")
public class MissingInfoException extends Exception{
	public MissingInfoException() {
		super("Please provide the information correclty.");
	}
}
