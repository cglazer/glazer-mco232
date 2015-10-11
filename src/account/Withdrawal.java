package account;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Withdrawal {

	private Double withdrawalAmount;
	private GregorianCalendar dateOfWithdrawal;

	// constructor
	public Withdrawal(Double withdrawalAmount) throws NullPointerException {
		if (withdrawalAmount == null) {
			throw new NullPointerException();
		}
		this.withdrawalAmount = withdrawalAmount;
		dateOfWithdrawal = new GregorianCalendar();
	}

	// getters
	public Double getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public GregorianCalendar getDateOfWithdrawal() {
		return dateOfWithdrawal;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nWithdrawal Amount: $");
		buffer.append(withdrawalAmount);
		buffer.append("\tDate of Withdrawal: ");
		buffer.append(formatter.format(dateOfWithdrawal.getTime()));
		return buffer.toString();
	}

	// compare the withdrawal amount
	public int compareTo(Withdrawal other) {
		return this.withdrawalAmount.compareTo(other.withdrawalAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Withdrawal other = (Withdrawal) obj;
		if (withdrawalAmount == null) {
			if (other.withdrawalAmount != null)
				return false;
		} else if (!withdrawalAmount.equals(other.withdrawalAmount))
			return false;
		return true;
	}

}
