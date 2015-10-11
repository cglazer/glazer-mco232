package stocksHomework;

public class TestStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stockSymbol = "ORCL";
		String name = "Oracle Corporation";
		// constructor
		Stock myStock = new Stock(stockSymbol, name);
		// setters
		myStock.setPreviousClosingPrice(34.5);
		myStock.setCurrentPrice(34.35);
		// display change in price
		try {
			System.out.print("%");
			System.out.printf("%.2f", myStock.getChangePercent());
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
