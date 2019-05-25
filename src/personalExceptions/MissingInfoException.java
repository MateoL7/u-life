package personalExceptions;

@SuppressWarnings("serial")
public class MissingInfoException extends Exception{
	public MissingInfoException() {
		super("WARNING!\\nPlease provide\\nthe information correclty.");
	}
}
