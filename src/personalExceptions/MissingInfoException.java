package personalExceptions;

@SuppressWarnings("serial")
public class MissingInfoException extends Exception{
	public MissingInfoException() {
		super("Please provide the information correclty.");
	}
}
