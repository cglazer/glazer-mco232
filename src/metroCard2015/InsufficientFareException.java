package metroCard2015;

	public class InsufficientFareException extends Exception{
		public InsufficientFareException(){
			super("insufficient funds");
		}

}
