package personalExceptions;

@SuppressWarnings("serial")
public class NoAccountFoundException extends Exception{
	public NoAccountFoundException() {
		super("The account was not found.");
	}

}
