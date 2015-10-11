package stocksHomework;

public class InvalidDataException extends Exception {
	public InvalidDataException (){
		super ("Sufficient data was not received");
}
}