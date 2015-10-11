package account;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Deposit {

	private Double depositAmount;
	private GregorianCalendar dateOfDeposit;

	// constructor
	public Deposit(Double depositAmount) throws NullPointerException {
		if (depositAmount == null) {
			throw new NullPointerException();
		}
		this.depositAmount = depositAmount;
		dateOfDeposit = new GregorianCalendar();
	}

	// getters
	public Double getDepositAmount() {
		return depositAmount;
	}

	public GregorianCalendar getDateOfDeposit() {
		return dateOfDeposit;
	}

	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nDeposit Amount: $");
		buffer.append(depositAmount);
		buffer.append("\tDate of Deposit: ");
		buffer.append(formatter.format(dateOfDeposit.getTime()));
		return buffer.toString();
	}

	// compare the deposit amounts
	public int compareTo(Deposit other) {
		return this.depositAmount.compareTo(other.depositAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposit other = (Deposit) obj;
		if (depositAmount == null) {
			if (other.depositAmount != null)
				return false;
		} else if (!depositAmount.equals(other.depositAmount))
			return false;
		return true;
	}

}
