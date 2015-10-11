package stocks;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageStocks {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Stock> ourStocks = new ArrayList<Stock>();
		int choice = 0;
		do {
			choice = menu();
			switch (choice) {
			case 1: // add a stock to list
				System.out.println("What is the symbol of the stock?");
				String symbol = input.nextLine();
				System.out.println("What is the company name of the stock?");
				String companyName = input.nextLine();
				ourStocks.add(new Stock(symbol, companyName));
				break;
			case 2: // remove a stock from list
				System.out
						.println("Which stock would you like to remove? Please enter the company name");
				String removeStock = input.nextLine();
				for (int i = 0; i < ourStocks.size(); i++) {
					if (ourStocks.get(i).getCompany()
							.equalsIgnoreCase(removeStock)) {
						ourStocks.remove(i);
						break;
					}
				}

				break;
			case 3:// record a price change of a stock
				break;
			case 4: // list historical prices of a stock
				break;
			case 5: // view highest price of a stock
				break;
			case 6: // view lowest price of a stock
				break;
			case 7: // view current price of a stock
				break;
			}

		} while (choice != 0);
		input.close();
	}

	private static Stock findStock(String symbol) {
		// return the Stock with a specific symbol
		return null;
	}

	public static int menu() {
		int choice;
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out
					.println("\n1. Record new stock\n2. Remove a stock\n3. Add price change of a Stock\n4. Get Historical Prices of a Stock\n5.Get Highest Price of a Stock\n6. Get Lowest Price of Stock\n7. Get Current Price of Stock\n8. List all Stock data\n0. EXIT");

			choice = keyboard.nextInt();
		} while (choice > 8);
		return choice;
	}

}
