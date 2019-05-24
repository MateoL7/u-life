package personalExceptions;

@SuppressWarnings("serial")
public class MissingInfoException extends Exception{
	public MissingInfoException(String username, String password, int age, double weight, double height, String gender, String nickName, String name) {
		super("WARNING!\\nPlease provide\\nthe information correclty.");
	}
}
