package metroCard2015;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetroCard2 {
	private Integer ID;
	private GregorianCalendar expirationDate;
	private double currentBalance;

	private static Integer lastCardID = 0;
	private static Double currentFare = 2.75;

	// constructors- have same name as class and they r public
	// validation = have to make sure data makes sense

	public MetroCard2() {
		this(currentFare);
	}

	public MetroCard2(Double amount) {
		this.ID = ++lastCardID;
		this.expirationDate = new GregorianCalendar();
		this.expirationDate.add(Calendar.YEAR, 1);

		if (amount < currentFare) {
			throw new InvalidDataException();

		}
		this.currentBalance = amount;
	}

	public Integer getCardID() {
		return ID;
	}

	public GregorianCalendar getExpirationDate() {
		GregorianCalendar expDate = new GregorianCalendar(expirationDate.get(Calendar.YEAR),
				expirationDate.get(Calendar.MONTH), expirationDate.get(Calendar.DAY_OF_MONTH));

		return expDate;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public static Double getCurrentFare() {
		return currentFare;

	}

	public static void increaseFare(Double increaseAmount) {
		if (increaseAmount / currentFare < .20) {
			currentFare += increaseAmount;
		} else
			throw new InvalidDataException();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		// obj is being casted to type Metro Card
		MetroCard2 other = (MetroCard2) obj;
		if (expirationDate == null) {
			if (other.expirationDate != null) {
				return false;
			}
			//invoke equals method from Gregorian calendar
		} else if (!expirationDate.equals(other.expirationDate)) {
			return false;
		}
		return true;
	}

	public void swipe() throws InsufficientFareException, CardExpiredException {
		GregorianCalendar today = new GregorianCalendar();
		// check if the card expired
		if (today.compareTo(this.expirationDate) > 0) {
			throw new CardExpiredException();
		}
		// check if there is enough $ on the card
		else {
			if (currentBalance < currentFare) {
				throw new InsufficientFareException();
			}
		}
		// now can swipe the card
		currentBalance -= currentFare;
	}

	// mutators
	// because this is a runtime exception--it will only happen very rarely, we
	// don't have to put the throws in the header
	public void addFunds(Double amount) {
		if (amount <= 0) {
			throw new InvalidDataException();
		}
		currentBalance += amount;
	}

	public int compareTo(MetroCard2 theCard) {
		// delegation, code reuse ( we called the compareTo method from the
		// Gregorian Calendar class
		return this.expirationDate.compareTo(theCard.expirationDate);
	}

	// we are adding a main just to show how the CompareTo method is working
	public static void main(String[] args) {
		MetroCard2 myCard = new MetroCard2(10.00);
		MetroCard2 yourCard = new MetroCard2(15.00);
		int result = myCard.compareTo(yourCard);
		if (result == 0) {
			System.out.println("We are twins!");
		} else if (result < 0) {
			System.out.println("I bought my card first!");
		} else {
			System.out.println("You bought your card first!");
		}
	}
}
