package stocksHomework;

public class Stock {

	private String symbol; // stock symbol
	private String name;
	private double previousClosingPrice = -1;// stores the stock's
										// price for the
										// previous day
	private double currentPrice = -1; // stores the stock price for
									// the current time
	private double changePercent;

	// constructor
	public Stock(String newSymbol, String newName) {
		this.symbol = newSymbol;
		this.name = newName;
	}

	// getter
	public double getChangePercent() throws InvalidDataException{
		if(currentPrice <= 0){
			throw new InvalidDataException();
		}
		else if(previousClosingPrice <= 0){
			throw new InvalidDataException();
		}else{
		this.changePercent = ((this.currentPrice - this.previousClosingPrice) / this.previousClosingPrice) * 100;
		return changePercent;
	}}

	// setters
	public void setPreviousClosingPrice(double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

}
