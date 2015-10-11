package metroCard;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetroCard {
	static private int nextID = 0;
	private int myCardID;
	private GregorianCalendar expDate;
	
	/** constructor - constructs new instance of class */
	
	public MetroCard(){
		this.myCardID = nextID++;
		this.expDate = new GregorianCalendar();
		this.expDate.add(Calendar.YEAR, 1);
	}
	
	
	//getters
	public int getCardID(){
		return this.myCardID;
		
	}
	
	public GregorianCalendar getExpDate(){
		return this.expDate;
	}
}
