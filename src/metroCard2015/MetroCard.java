package metroCard2015;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetroCard {
	private Integer ID;
	// we are using a class within our class
	private GregorianCalendar expirationDate;
	private Double currentBalance;

	// static variables are italicized
	private static Integer lastCardID = 0;
	private static Double currentFare = 2.75;

	// constructors
	// no args
	// public--because it's a constructor
	public MetroCard() {
		// this.ID = ++lastCardID;
		// this.expirationDate = new GregorianCalendar();
		// this.expirationDate.add(Calendar.YEAR,1);
		// this.currentBalance = currentFare;

		// instead of coding the above lines twice for each constructor, we
		// just call the next constructor with the next line of code using a
		// parameter to fill in the missing information. "this()" means to call
		// the constructor with the same name as itself that accepts the type of
		// information displayed in the parameter. however, if there are many
		// constructors, all accepting the same amount of parameters, it will
		// not let you code your constructors like this.

		// we made up currentFare--we assume they wouldn't let you but a metro
		// card for less than the current fare.
		this(currentFare);
	}

	// public --because it's a constructor
	public MetroCard(Double amount) throws InvalidDataException {
		this.ID = ++lastCardID;
		this.expirationDate = new GregorianCalendar();
		this.expirationDate.add(Calendar.YEAR, 1);
		if (amount < currentFare) {
			// this is a runTime exception because we don't expect it to happen
			// so we don't worry about dealing with the problem.however, if we
			// change it to a checked exception it will give us a problem--it
			// will make us deal with the problem.
			throw new InvalidDataException();
		}
		this.currentBalance = amount;
	}

	// two static methods to get and set the class variable, current fare
	// both are public so the user can access it and static
	// returns information
	public static Double getCurrentFare() {
		// we don't write "this" because it's a static variable
		return currentFare;
	}

	// does not return information
	public static void increaseFare(Double increaseAmount) throws InvalidDataException {
		// the city doesn't let the subway increase the fare by too much at a
		// time
		if ((increaseAmount / currentFare) < .20) {
			currentFare += increaseAmount;
		} else {
			throw new InvalidDataException();
		}
	}

	// getters
	public Integer getID() {
		return ID;
	}

	public GregorianCalendar getExpirationDate() {
		// we must make another Gregorian calendar instance so that when we
		// return the expirationdate, they won't have an actual reference to
		// change it.
		GregorianCalendar expDate = new GregorianCalendar(expirationDate.get(Calendar.YEAR),
				expirationDate.get(Calendar.MONTH), expirationDate.get(Calendar.DAY_OF_MONTH));

		return expDate;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

}
