package personalExceptions;

@SuppressWarnings("serial")
public class NoDataException extends Exception{
    public NoDataException() {
	  super("There are no accounts found in the database");
	}
} 
