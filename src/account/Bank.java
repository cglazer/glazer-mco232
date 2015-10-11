package account;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Bank {
	private ArrayList<Account> anAccount;

	public Bank() {
		anAccount = new ArrayList<Account>();
	}

	public Integer addAccount(Double initialBalance)
			throws NullPointerException, InsufficientFundsException {
		if (initialBalance == null) {
			throw new NullPointerException();
		}
		// an account must be opened with a minimum of $200
		if (initialBalance < 200.0) {
			throw new InsufficientFundsException();
		}
		Account myAccount = new Account(initialBalance);
		anAccount.add(myAccount);
		return myAccount.getId();
	}

	public void depositToAccount(Integer id, Double amount)
			throws NullPointerException, NotFoundException {
		if (id == null || amount == null) {
			throw new NullPointerException();
		}
		boolean found = false;
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				accounts.deposit(amount);
				found = true;
				break;
			}
		}
		if (!found) {
			throw new NotFoundException();
		}
	}

	public void withdrawFromAccount(Integer id, Double amount)
			throws NullPointerException, NotFoundException,
			InsufficientFundsException {
		if (id == null || amount == null) {
			throw new NullPointerException();
		}
		boolean found = false;
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				accounts.withdraw(amount);
				found = true;
			}
		}
		if (!found) {
			throw new NotFoundException();
		}
	}

	public Double getCurrentBalance(Integer id) throws NullPointerException,
			NotFoundException {
		if (id == null) {
			throw new NullPointerException();
		}
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				return accounts.getCurrentBalance();
			}
		}
		throw new NotFoundException();
	}

	public String getDateCreated(Integer id) throws NullPointerException,
			NotFoundException {
		if (id == null) {
			throw new NullPointerException();
		}
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				return accounts.getDateCreated();
			}
		}
		throw new NotFoundException();
	}

	public static Double getAnnualInterestRate() {
		return Account.getAnnualInterestRate();
	}

	public Double getMonthlyInterest(Integer id) throws NullPointerException,
			NotFoundException {
		if (id == null) {
			throw new NullPointerException();
		}
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				return accounts.getMonthlyInterest();
			}
		}
		throw new NotFoundException();
	}

	public static void setAnnualInterestRate(Double newInterestRate)
			throws NullPointerException {
		if (newInterestRate == null) {
			throw new NullPointerException();
		}
		Account.setAnnualInterestRate(newInterestRate);

	}

	public String getMiniStatement(Integer id, GregorianCalendar startDate,
			GregorianCalendar endDate) throws NullPointerException,
			NotFoundException, InvalidRequestException {
		if (id == null) {
			throw new NullPointerException();
		}
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				return accounts.printStatement(startDate, endDate);
			}
		}
		throw new NotFoundException();
	}

	public Double getLargestDeposit(Integer id) throws NullPointerException,
			NotFoundException, InvalidRequestException {
		if (id == null) {
			throw new NullPointerException();
		}
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				return accounts.getLargestDeposit();
			}
		}
		throw new NotFoundException();
	}

	public Double getLargestWithdrawal(Integer id) throws NullPointerException,
			NotFoundException, InvalidRequestException {
		if (id == null) {
			throw new NullPointerException();
		}
		for (Account accounts : anAccount) {
			if (id == accounts.getId()) {
				return accounts.getLargestWithdrawal();
			}
		}
		throw new NotFoundException();
	}
}
