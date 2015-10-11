package account;

public class InvalidDataException extends RuntimeException {
	public InvalidDataException() {
		super("You've entered invalid data.");
	}
}
