package stocks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Stock {
	private String symbol;
	private String company;
	private Double lastRecordedPrice;
	private GregorianCalendar dateRecordedChange;

	private ArrayList<PriceRecord> historicalPrices;

	public Stock(String symbol, String company) {
		this.symbol = symbol;
		this.company = company;
		this.lastRecordedPrice = null;
		this.dateRecordedChange = null;

		// instantiate the ArrayList
		historicalPrices = new ArrayList<PriceRecord>();
	}

	public void recordPriceChange(Double newprice) throws InvalidDateException, InvalidPriceException {
		GregorianCalendar today = new GregorianCalendar();

		int year;
		int month;
		int day;
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH);
		day = today.get(Calendar.DAY_OF_MONTH);
		String date = month + "/" + day + "/" + year;
		historicalPrices.add(new PriceRecord(date, newprice));
		// assume price change is for current date
		// make a new date for today
		this.lastRecordedPrice = newprice;
		this.dateRecordedChange = today;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getCompany() {
		return company;
	}

	public Double getCurrentPrice() {
		return lastRecordedPrice;
	}

	public String[] getHistoricalPrices() {
		// return a deep copy
		String[] deepCopy = new String[historicalPrices.size()];
		for(int i=0; i< historicalPrices.size(); i++){
			deepCopy[i] = historicalPrices.get(i);
		}
		return deepCopy;
	}

	public Double getLowestPrice() {
		Double lowestPrice;
		for(int i=0; i< historicalPrices.size()-1; i++){
			if(i< i+1){
				lowestPrice = historicalPrices.get(i);
			}else{
				lowestPrice = historicalPrices.get(i+1);
			}
		}
		
		return lowestPrice;
	}

	public Double getHighestPrice() {
		Double highestPrice;
		for(int i=0; i< historicalPrices.size()-1; i++){
			if(i> i+1){
				highestPrice = historicalPrices.get(i);
			}
			else{
				highestPrice = historicalPrices.get(i+1);
			}
		}
		return highestPrice;
	}

	public Double getAveragePrice() {
		Double averagePrice;
		Double totalPrices;
		for(int i=0; i< historicalPrices.size(); i++){
			totalPrices += historicalPrices.get(i);
		}
		averagePrice= (totalPrices/historicalPrices.size());
		return averagePrice;
	}

	public GregorianCalendar getStartDateHistoricalData() {
		return null;
	}

}
