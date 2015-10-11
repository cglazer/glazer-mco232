package cellPhone;

public class InvalidDataException extends RuntimeException {
	public InvalidDataException() {
		super("Insufficient Data");
	}
}
