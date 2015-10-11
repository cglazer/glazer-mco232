package account;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) throws InsufficientFundsException,
			NotFoundException, InvalidRequestException, InvalidDataException {
		System.out.println("10 dummy accounts were created as follows:");
		Bank aBank = new Bank();
		int accountId = 0;
		try {
			accountId = aBank.addAccount(200.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(200.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(876.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(300.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(10000.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(768.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(530.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(210.45);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(287.0);
			System.out.println("Your account id is " + accountId + ".");
			accountId = aBank.addAccount(220.0);
			System.out.println("Your account id is " + accountId + ".");
		} catch (InsufficientFundsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Scanner input = new Scanner(System.in);
		int id = 0;
		int choice = menu();
		while (choice != 0) {
			do {
				switch (choice) {
				case 1:
					System.out
							.println("How much money would you like to put into your Account? ");
					Double initialBalance = input.nextDouble();
					try {
						accountId = aBank.addAccount(initialBalance);
						System.out
								.println("Thank you for creating an account. Your account id is "
										+ accountId + ".");
					} catch (InsufficientFundsException e1) {
						// TODO Auto-generated catch block
						System.out
								.println("Sorry, you must deposit a minimum of $200 when creating an account");
					}
					id = 0;
					break;
				case 2:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
					}
					try {
						System.out
								.printf("Your account balance is $%.2f. Please note that your monthly  interest was not yet removed from your account.", aBank.getCurrentBalance(id));
					} catch (NotFoundException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
					break;
				case 3:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
					}
					System.out
							.println("How much money would you like to deposit to your account?");
					Double depositAmount = input.nextDouble();
					try {
						aBank.depositToAccount(id, depositAmount);
					} catch (NotFoundException e1) {
						System.out.println(e1.getMessage());
					}
					break;
				case 4:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
					}
					System.out
							.println("How much money would you like to withdraw from your account?");
					Double withdrawAmount = input.nextDouble();
					try {
						aBank.withdrawFromAccount(id, withdrawAmount);
					} catch (NotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InsufficientFundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 5:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
					}
					try {
						System.out.println("Your account was created on "
								+ aBank.getDateCreated(id) + ".");
					} catch (NotFoundException e1) {
						System.out.println(e1.getMessage());
					}
					break;
				case 6:
					Double annualInterestRate = Bank.getAnnualInterestRate();
					System.out.println("The annual interest rate is "
							+ annualInterestRate + "%.");
					break;
				case 7:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
					}
					try {
						System.out.printf("\nYour monthly interest is $%.2f",
								aBank.getMonthlyInterest(id));
					} catch (NotFoundException e1) {
						System.out.println(e1.getMessage());
					}
					break;
				case 8:
					System.out
							.println("What would you like to set the new annual interest rate to?");
					Double newInterestRate = input.nextDouble();
					Bank.setAnnualInterestRate(newInterestRate);
					break;
				case 9:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
						input.nextLine();
					}
					System.out
							.println("Beginning from what date would you like a statement? Please enter the date in the following format(mm/dd/yyyy).");
					String startDates = input.nextLine(); // read in one line's
															// worth
					String[] dateDetails = startDates.split("/");
					if (dateDetails.length < 3 || dateDetails[0].length() > 2
							|| dateDetails[1].length() > 2
							|| dateDetails[2].length() != 4) {
						throw new InvalidDataException();
					}
					Integer startMonth = Integer.parseInt(dateDetails[0]);
					Integer startDayOfMonth = Integer.parseInt(dateDetails[1]);
					Integer startYear = Integer.parseInt(dateDetails[2]);
					System.out
							.println("What would you like your statement's end date to be? Please enter the date in the following format(mm/dd/yyyy)");
					String endDates = input.nextLine();
					dateDetails = endDates.split("/");
					if (dateDetails.length < 3 || dateDetails[0].length() > 2
							|| dateDetails[1].length() > 2
							|| dateDetails[2].length() != 4) {
						throw new InvalidDataException();
					}
					Integer endMonth = Integer.parseInt(dateDetails[0]);
					Integer endDayOfMonth = Integer.parseInt(dateDetails[1]);
					Integer endYear = Integer.parseInt(dateDetails[2]);
					GregorianCalendar startDate = new GregorianCalendar(
							startYear, startMonth - 1, startDayOfMonth);
					GregorianCalendar endDate = new GregorianCalendar(endYear,
							endMonth - 1, endDayOfMonth);
					try {
						try {
							System.out.println(aBank.getMiniStatement(id,
									startDate, endDate));
							System.out.println("Please note that the account interest was not calculated into the account balance.");
						} catch (InvalidRequestException e) {
							System.out
									.println("Sorry, we could not complete your request. Please try again.");
						}
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
				case 10:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
					}
					try {
						System.out.printf("Your largest deposit was $%.2f.",
								+ aBank.getLargestDeposit(id));
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					} catch (InvalidRequestException e1) {
						System.out.println("You haven't made any deposits.");
					}
					break;
				case 11:
					if (id == 0) {
						System.out
								.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
						id = input.nextInt();
					}
					try {
						System.out.printf("Your largest withdrawal was $%.2f.",
								+ aBank.getLargestWithdrawal(id));
					} catch (NotFoundException e) {
						System.out.println(e.getMessage());
					} catch (InvalidRequestException e1) {
						System.out.println("You haven't made any withdrawals.");
					}
					break;
				case 12:
					System.out
							.println("Please enter your account id. We will hold your id# until you change it or exit our application.");
					id = input.nextInt();
					break;
				}
				choice = menu();
			} while (choice >= 0 && choice < 14);
		}
		input.close();
	}

	public static int menu() {
		Scanner number = new Scanner(System.in);
		int choice;
		System.out
				.println("\n1. Add Acount\n2. Check account balance"
						+ "\n3. Make a deposit"
						+ "\n4. Make a withdrawal"
						+ "\n5. Find out when the account was created"
						+ "\n6. Get the annual interest rate"
						+ "\n7. Find out your monthly interest."
						+ "\n8. Set a new annual interest rate"
						+ "\n9. Get Mini Statement\n10. Get Largest Deposit"
						+ "\n11. Get Largest Withdrawal\n12. Change to another account\n0. Exit");
		choice = number.nextInt();
		return choice;
	}

}
