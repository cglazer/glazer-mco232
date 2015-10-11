package account;

import java.util.Scanner;

public class UseAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		// create an account
		Account myAccount = new Account(20000.0);
		// set the annual interest rate to 4.5
		Account.setAnnualInterestRate(4.5);
		System.out
				.printf("You've created an account with a balance of $%,.2f and a \nmonthly interest of $%,.2f. Your account was created on "
						+ myAccount.getDateCreated() + ".\n",
						myAccount.getCurrentBalance(),
						myAccount.getMonthlyInterest());
		// call the menu method
		int choice = menu();
		while (choice != 0) {
			switch (choice) {
			case 1:
				System.out.printf("Your balance is $%,.2f. \n",
						myAccount.getCurrentBalance());
				break;
			case 2:
				myAccount.deposit(3000.0);
				System.out.printf("You're balance is now $%,.2f.",
						myAccount.getCurrentBalance());
				break;
			case 3:
				try {
					myAccount.withdraw(2500.0);
				} catch (InsufficientFundsException e) {
					System.out.println(e.getMessage());
				}
				System.out.printf("You're balance is now $%,.2f.",
						myAccount.getCurrentBalance());
				break;
			case 4:
				System.out.println("Your account was created on "
						+ myAccount.getDateCreated() + ".");
				break;
			case 5:
				System.out.println("Your annual interest rate is "
						+ Account.getAnnualInterestRate() + "%.");
				break;
			case 6:
				System.out.printf("Your monthly interest is $%.2f.",
						myAccount.getMonthlyInterest());
				break;
			case 7:
				System.out
						.println("What would you like to set your new annual interest rate to?");
				// annual interest rate is static
				Account.setAnnualInterestRate(input.nextDouble());
				System.out.println("Your annual interest rate was set to "
						+ Account.getAnnualInterestRate() + "%.");
				break;
			case 8:
				System.out
						.println("What would you like to set your balance to?");
				myAccount.setBalance(input.nextDouble());
				System.out.println("Your balance was set to $"
						+ myAccount.getCurrentBalance() + ".");
				break;
			case 9:
				// System.out.println("What is your id #?");
				// myAccount.setId(input.nextInt());
				break;
			case 10:
				System.out.println("Your ID # is " + myAccount.getId() + ".");
				break;
			}
			choice = menu();
		}
		// close the scanner class
		input.close();
	}

	public static int menu() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n1. Check account balance"
					+ "\n2. Make a deposit of $3,000"
					+ "\n3. Make a withdrawal of $2,500"
					+ "\n4. Find out when the account was created"
					+ "\n5. Get your annual interest rate"
					+ "\n6. Find out your monthly interest."
					+ "\n7. Set a new annual interest rate"
					+ "\n8. Set your balance" + "\n9. Set your id"
					+ "\n10. Get your id" + "\n0. Exit application"

			);
			choice = input.nextInt();
			// relist the menu options if the user makes an invalid input
		} while (choice < 0 || choice > 10);
		// return the menu option
		return choice;

	}

}
