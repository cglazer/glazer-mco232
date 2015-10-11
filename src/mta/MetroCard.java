package mta;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetroCard {
	// static will create a number that will never repeat itself. it will create
	// an ID # with the next available #
	static private int nextID = 0;
	private int myCardID;
	private GregorianCalendar expDate;

	/**
	 * consructor- never has a return type and always has the same name as the
	 * class constructs a new instance of the class, metroCard
	 */
	public MetroCard() {
		// by putting nextID++ you will ensure never to have a repeating number
		this.myCardID = nextID++;
		// here we set the values for the instance. on the top, we just create
		// the instance
		this.expDate = new GregorianCalendar();
		// the exp date is set for a year later
		this.expDate.add(Calendar.YEAR, 1);
	}

	// getters
	public int getCardID() {
		return this.myCardID;
	}

	// you should NOT send back a reference to a class or the user can change
	// it!
	public GregorianCalendar getexpDate() {
		return this.expDate;
	}
}
