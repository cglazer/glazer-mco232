package account;

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(){
		super("Sorry, you don't have sufficient funds to make that withdrawal.");
	}

}
