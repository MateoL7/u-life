package personalExceptions;

@SuppressWarnings("serial")
public class NoAccountFoundException extends Exception{
	public NoAccountFoundException() {
		super("WARNING \\n No se encontro la cuenta");
	}

}
