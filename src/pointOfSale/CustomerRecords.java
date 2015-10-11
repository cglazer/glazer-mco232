//Chayala Glazer
package pointOfSale;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CustomerRecords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the customer-purchase Invetory!");
		// In main() set up an ArrayList of Customer records.
		ArrayList<CustomerClass> aCustomer = new ArrayList<CustomerClass>();
		// Implement code that will complete each of the following tasks in the
		// menu
		int choice = menu();
		while (choice != 0) {
			switch (choice) {
			case 1:
				// add a new customer
				System.out.println("What is the customer's first name?");
				String firstName = input.nextLine();
				System.out.println("What is the customer's last name?");
				String lastName = input.nextLine();
				System.out.println("What is the customer's phone number?");
				String phoneNumber = input.nextLine();
				CustomerClass newCustomer = new CustomerClass(firstName,
						lastName, phoneNumber);
				aCustomer.add(newCustomer);
				// let the customer know his ID for future look-ups
				System.out
						.println("The customer's ID is "
								+ newCustomer.getCustomerID()
								+ ". Please use this ID # to refer to this customer in the future.");
				break;
			case 2:
				// remove a customer
				System.out
						.println("Which customer would you like to remove? Please enter the customer's ID.");
				Integer removeCustomer = input.nextInt();
				input.nextLine();
				int position = -1;
				for (int i = 0; i < aCustomer.size(); i++) {
					if (aCustomer.get(i).getCustomerID() == removeCustomer) {
						position = i;
					}
				}
				if (position >= 0) {
					aCustomer.remove(position);
				} else {
					// inform the user if the customer was not found
					System.out.println("Sorry, customer cannot be found.");
				}
				break;
			case 3:
				// make a purchase for a customer
				System.out
						.println("What is the ID of the  customer that would like to make a purchase?");
				Integer customerID = input.nextInt();
				input.nextLine();

				boolean found = false;
				for (CustomerClass x : aCustomer) {
					if (x.getCustomerID() == customerID) {
						System.out
								.println("What item would the customer like to purchase?");
						String item = input.nextLine();
						System.out.println("How many?");
						int quantity = input.nextInt();
						input.nextLine();
						System.out.println("How much does the item cost?");
						Double price = input.nextDouble();
						input.nextLine();
						System.out
								.println("What type of item does your purchase fall under?");
						String itemType = input.nextLine();
						x.makePurchase(item, quantity, price, itemType);
						found = true;
						break;
					}
				}
				// inform the user if the customer was unable to be found
				if (!found) {
					System.out.println("Sorry, the customer cannot be found");
				}
				break;
			case 4:
				// make a return
				System.out
						.println("What is the ID of the customer that would like to make a return?");
				Integer returnID = input.nextInt();
				input.nextLine();
				System.out.println("What would the customer like to return?");
				String returnItem = input.nextLine();
				System.out
						.println("Please enter the year the item was purchased.");
				Integer yearPurchased = input.nextInt();
				System.out
						.println("Please enter the month the item was purchased. Please enter the month in number format, starting with zero. For example, for January enter 0.");
				Integer monthPurchased = input.nextInt();
				System.out
						.println("Please enter the day of the month the item was purchased");
				Integer dayOfMonthPurchased = input.nextInt();
				System.out.println("How many of that item would you like to return?");
				Integer quantityReturn = input.nextInt();
				for (CustomerClass x : aCustomer) {
					if (x.getCustomerID() == returnID) {
						GregorianCalendar purchasedDate = new GregorianCalendar(
								monthPurchased, dayOfMonthPurchased,
								yearPurchased);
						try {
							x.returnPurchase(returnItem, quantityReturn, purchasedDate);
						} catch (NotFoundException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				break;
			case 5:
				// view a customer's purchases
				System.out
						.println("Which customer's purchases would you like to view? Please enter the customer's ID.");
				Integer viewID = input.nextInt();
				input.nextLine();
				boolean foundPurchase = false;
				for (CustomerClass x : aCustomer) {
					if (x.getCustomerID() == viewID) {
						System.out.println(x.getMyItems());
						foundPurchase = true;
					}
				}
				// inform the user if the customer was unable to be found
				if (!foundPurchase) {
					System.out.println("Sorry, customer cannot be found.");
				}
				break;
			case 6:
				// find the customers who bought a specific item
				System.out
						.println("For which item would you like to know its customers?");
				String purchasedItemType = input.nextLine();
				boolean itemPurchased = false;
				for (CustomerClass x : aCustomer) {
					if (x.hasPurchasedItem(purchasedItemType)) {
						System.out.println(x.getFirstName() + " "
								+ x.getLastName());
						itemPurchased = true;
					}
				}
				// inform the user if no customers bought the item
				if (!itemPurchased) {
					System.out
							.println("Sorry, this item hasn't been purchased by any customers.");
				}
				break;
			case 7:
				// find out how many times an item was bought by each customer
				System.out.println("What item name would you like to look up?");
				String itemToLookUp = input.nextLine();
				for (CustomerClass eachCustomer : aCustomer) {
					System.out.println(eachCustomer.getFirstName() + " "
							+ eachCustomer.getLastName() + " "
							+ eachCustomer.timesPurchased(itemToLookUp));
				}
				break;
			case 8:
				// find out which customers bought an item of a certain item
				// type at least once
				System.out.println("What item type would you like to look up?");
				String itemTypeWanted = input.nextLine();
				for (CustomerClass eachCustomer : aCustomer) {
					if (eachCustomer.purchasesOfType(itemTypeWanted).size() > 0) {
						System.out.println(eachCustomer.getFirstName() + " "
								+ eachCustomer.getLastName());
					}
				}
				break;
			}

			choice = menu();

		}
		input.close();
	}

	// menu()

	public static int menu() {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			System.out
					.println("1. Add a new customer \n2. Remove a customer"
							+ " \n3. Add a customer purchase (for a particular customer, a particular item)"
							+ " \n4. Return a customer purchase (for a particular customer, a particular Purchased Item)"
							+ " \n5. View customer purchases (of a particular customer)"
							+ " \n6. List names of customers who have purchased a particular item name"
							+ " \n7. For each customer,list how many times the customer has purchased a particular item name "
							+ "\n8. List which customers have purchased at least one item of a given item type \n0. Exit");
			choice = input.nextInt();
		} while (choice < 0 || choice > 8);

		return choice;
	}
}
