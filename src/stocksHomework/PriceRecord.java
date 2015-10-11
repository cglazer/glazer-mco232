package stocksHomework;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import stocks.InvalidDateException;
import stocks.InvalidPriceException;

public class PriceRecord {
	private GregorianCalendar transactionDate;
	private Double currentPrice;
	
	
	public PriceRecord(String date, Double currentPrice)throws InvalidDateException, InvalidPriceException{
		//invoke the String / method
		String[] parts = date.split("/");
		int month = Integer.parseInt(parts[0]);  //convert the String to an Integer
		int day = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		
		//validate the month and day if you wish
		
		transactionDate = new GregorianCalendar(year, month-1, day);
		if (currentPrice < 0){
			throw new InvalidPriceException();
		}
		else{
		   this.currentPrice = currentPrice;
		}
		
	}
	
	public int compareTo(PriceRecord otherPrice){
		//on what should the comparison be based, price or date or both
		//let us choose date
		return this.transactionDate.compareTo(otherPrice.transactionDate);
	}
	
	public boolean equals(Object obj){
		//must be synchronized with compareTo method
		if (obj == null) return false;
		if  ( !(obj instanceof PriceRecord)) return false;
		else{
			PriceRecord otherPrice  =              (PriceRecord) obj;  //typecast obj
		    if (transactionDate.compareTo(otherPrice.transactionDate)==0)
		    { return true;
		    }
		   
		    else{
		    	return false;
		    }
		}
		
	}
	
	public String toString(){
		SimpleDateFormat formatter = new SimpleDateFormat("mm/DD/yyyy");
		String date = formatter.format(transactionDate);
		return "\nPriceChange " + date + " Price: " + currentPrice;
	}

}
