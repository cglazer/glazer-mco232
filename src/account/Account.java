package account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Account {
	private Integer id;
	private static Integer lastId = 0;
	private Double balance;
	private static Double annualInterestRate = 0.0;
	private GregorianCalendar dateCreated;
	private ArrayList<Withdrawal> aWithdrawal;
	private ArrayList<Deposit> aDeposit;

	// constructors
	// no args constructor
	public Account() {
		this(null);
	}

	public Account(Double newBalance) {
		this.id = ++lastId;
		// if no money was deposited into the account when the account was
		// opened, the balance will remain zero until a further deposit is made
		if (newBalance == null) {
			this.balance = 0.0;
		} else {
			this.balance = newBalance;
		}
		// create Date field
		this.dateCreated = new GregorianCalendar();
		this.aDeposit = new ArrayList<Deposit>();
		this.aWithdrawal = new ArrayList<Withdrawal>();
	}

	// getters and setters
	public Integer getId() {
		return id;
	}

	// the interest is not calculated into the balance
	public Double getCurrentBalance() {
		Double totalWithdrawal = 0.0;
		for (Withdrawal withdrawals : aWithdrawal) {
			totalWithdrawal += withdrawals.getWithdrawalAmount();
		}
		Double totalDeposit = 0.0;
		for (Deposit deposits : aDeposit) {
			totalDeposit += deposits.getDepositAmount();
		}
		return this.balance + totalDeposit - totalWithdrawal;
	}

	// the set balance method was removed because the user should never be able
	// to reset his balance. if he makes a deposit/withdrawal...then the balance
	// will be recalculated automatically

	public static Double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(Double newAnnualInterestRate)
			throws NullPointerException {
		if (newAnnualInterestRate == null) {
			throw new NullPointerException();
		}
		Account.annualInterestRate = newAnnualInterestRate;
	}

	public String getDateCreated() {
		// format the date
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		// return the date as a string
		return formatter.format(dateCreated.getTime());
	}

	public Double getMonthlyInterest() {
		Double monthlyInterest = this.balance
				* ((annualInterestRate / 100) / 12);
		return monthlyInterest;
	}

	public void withdraw(Double withdrawAmount)
			throws InsufficientFundsException, NullPointerException {
		// throw an exception if there are insufficient funds in the account
		if (withdrawAmount == null) {
			throw new NullPointerException();
			// throw an exception if the user tries withdrawing more money than
			// he has in his account
		} else if (withdrawAmount > getCurrentBalance()) {
			throw new InsufficientFundsException();
		}
		aWithdrawal.add(new Withdrawal(withdrawAmount));
	}

	public void deposit(Double depositAmount) throws NullPointerException {
		if (depositAmount == null) {
			throw new NullPointerException();
		}
		aDeposit.add(new Deposit(depositAmount));
	}

	// get the balance as of a specific date. If the user asks for a the balance
	// before a the account was created, throw an exception
	public Double getBalanceAsOf(GregorianCalendar date)
			throws InvalidRequestException {
		if (date.get(Calendar.YEAR) < (this.dateCreated.get(Calendar.YEAR))) {
			throw new InvalidRequestException();
		} else if (date.get(Calendar.MONTH) < (this.dateCreated
				.get(Calendar.MONTH))) {
			throw new InvalidRequestException();
		} else if (date.get(Calendar.DAY_OF_MONTH) < (this.dateCreated
				.get(Calendar.DAY_OF_MONTH))) {
			throw new InvalidRequestException();
		}
		Double balanceAsOf = this.balance;
		for (Deposit deposits : aDeposit) {
			if (deposits.getDateOfDeposit().compareTo(date) <= 0) {
				balanceAsOf += deposits.getDepositAmount();
			}
		}
		for (Withdrawal withdrawals : aWithdrawal) {
			if (withdrawals.getDateOfWithdrawal().compareTo(date) <= 0) {
				balanceAsOf -= withdrawals.getWithdrawalAmount();
			}
		}
		return balanceAsOf;
	}

	/**
	 * print an account statement starting from a specific date until anther
	 * date, include all deposits and withdrawals made in that time
	 * 
	 * @param startDate
	 *            - start date of the statement
	 * @param endDate
	 *            - end date of the statement
	 * @return statement
	 * @throws InvalidRequestException
	 * @throws NullPointerException
	 */
	public String printStatement(GregorianCalendar startDate,
			GregorianCalendar endDate) throws InvalidRequestException,
			NullPointerException {
		if (startDate == null || endDate == null) {
			throw new NullPointerException();
		}
		GregorianCalendar today = new GregorianCalendar();
		// make sure the end date is not later than today.
		if (endDate.compareTo(today) > 0) {
			throw new InvalidRequestException();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nAccount Statement for Account #");
		buffer.append(this.id);
		buffer.append(" as of ");
		buffer.append(formatter.format(endDate.getTime()));
		buffer.append("\nStart Balance: $");
		buffer.append(getBalanceAsOf(startDate));
		// for the comparisms, the day of the end date month is sent to the next
		// day(and automatically the first hour) and then the comparisms say the
		// deposit date must be less than the end date.
		endDate.add(Calendar.DAY_OF_MONTH, 1);
		for (Deposit deposits : aDeposit) {
			if (deposits.getDateOfDeposit().compareTo(startDate) >= 0
					&& deposits.getDateOfDeposit().compareTo(endDate) < 0) {
				buffer.append(deposits);
			}
		}
		for (Withdrawal withdrawals : aWithdrawal) {
			if (withdrawals.getDateOfWithdrawal().compareTo(startDate) >= 0
					&& withdrawals.getDateOfWithdrawal().compareTo(endDate) < 0) {
				buffer.append(withdrawals);
			}
		}
		buffer.append("\nEnd Balance: $");
		buffer.append(getBalanceAsOf(endDate));

		return buffer.toString();
	}

	public String getDeposits() {
		return aDeposit.toString();
	}

	public String getWithdrawals() {
		return aWithdrawal.toString();
	}

	public Double getLargestDeposit() throws InvalidRequestException {
		if (aDeposit.size() == 0) {
			throw new InvalidRequestException();
		}
		Double largestDeposit = aDeposit.get(0).getDepositAmount();
		if (aDeposit.size() == 1) {
			return largestDeposit;
		}
		for (int i = 1; i < aDeposit.size(); i++) {
			if (largestDeposit < aDeposit.get(i).getDepositAmount()) {
				largestDeposit = aDeposit.get(i).getDepositAmount();
			}
		}
		return largestDeposit;

	}

	public Double getLargestWithdrawal() throws InvalidRequestException {
		if (aWithdrawal.size() == 0) {
			throw new InvalidRequestException();
		}
		Double largestWithdrawal = aWithdrawal.get(0).getWithdrawalAmount();
		if (aWithdrawal.size() == 1) {
			return largestWithdrawal;
		}
		for (int i = 1; i < aWithdrawal.size(); i++) {
			if (largestWithdrawal < aWithdrawal.get(i).getWithdrawalAmount()) {
				largestWithdrawal = aWithdrawal.get(i).getWithdrawalAmount();
			}
		}
		return largestWithdrawal;
	}

	/**
	 * compare the accounts based on the date they were created
	 */
	public int compareTo(Account other) {
		return this.dateCreated.compareTo(other.dateCreated);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nAccount");
		buffer.append("\nBalance: $");
		buffer.append(this.getCurrentBalance());
		buffer.append("\nDate Created: ");
		buffer.append(formatter.format(this.dateCreated.getTime()));
		buffer.append("\nWithdrawals: ");
		buffer.append(this.getWithdrawals());
		buffer.append("\nDeposits: ");
		buffer.append(this.getDeposits());
		return buffer.toString();
	}

	public void setBalance(double balance) {
		this.balance= balance;
		// TODO Auto-generated method stub
		
	}
}
