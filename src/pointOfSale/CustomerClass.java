//Chayala Glazer
package pointOfSale;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CustomerClass {
	private Integer customerID;
	private static Integer lastID = 0;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String creditCardID;
	private Double totalPurchaseAmt;
	ArrayList<PurchasedItem> myItems;

	public CustomerClass(String firstName, String lastName, String phoneNumber)
			throws NullPointerException {
		this.customerID = ++CustomerClass.lastID;
		// validate parameters
		if (firstName == null || lastName == null || phoneNumber == null) {
			throw new NullPointerException();
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.creditCardID = null;
		this.totalPurchaseAmt = 0.0;
		myItems = new ArrayList<PurchasedItem>();

	}

	// getters and setters
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws NullPointerException {
		if (lastName == null) {
			throw new NullPointerException();
		}
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws NullPointerException {
		// validate parameter
		if (phoneNumber == null) {
			throw new NullPointerException();
		}
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardID() {
		return creditCardID;
	}

	public void setCreditCardID(String creditCardID)
			throws NullPointerException {
		// validate parameter
		if (creditCardID == null) {
			throw new NullPointerException();
		}
		this.creditCardID = creditCardID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public Double getTotalPurchaseAmt() {
		return totalPurchaseAmt;
	}

	public ArrayList<PurchasedItem> getMyItems() {
		return myItems;
	}

	public void makePurchase(String itemName, Integer quantityPurchased,
			Double price, String itemType) throws NullPointerException {
		// validate parameters
		if (quantityPurchased == null || price == null) {
			throw new NullPointerException();
		}
		Double amountOwed = quantityPurchased * price;
		this.totalPurchaseAmt += amountOwed;
		// validate parameters
		if (itemName == null || itemType == null) {
			throw new NullPointerException();
		}
		// add an item to the purchased item arrayList
		for (int i = 0; i < quantityPurchased; i++) {
			myItems.add(new PurchasedItem(itemName, price,
					itemType));
		}
	}

	public void returnPurchase(String itemName, Integer quantityReturn, GregorianCalendar datePurchased)
			throws NotFoundException {
		boolean found = false;
		// validate that the item was purchased and on the specified date
		for(int x=0; x<quantityReturn; x++){
			found=false;
		for (PurchasedItem i : myItems) {
			if (i.getItemName().equalsIgnoreCase(itemName)) {
				if (datePurchased.compareTo(i.getPurchaseDate()) == 0) {
					myItems.remove(i);
					found = true;
					break;
				}
			}
		}}
		// if the item was not found for the date specified, throw an exception
		if (!found) {
			throw new NotFoundException();
		}

	}

	public int timesPurchased(String itemName) throws NullPointerException {
		int timesPurchased = 0;
		// validate parameter
		if (itemName == null) {
			throw new NullPointerException();
		}
		for (PurchasedItem item : myItems) {
			if (item.getItemName().equalsIgnoreCase(itemName)) {
				timesPurchased++;
			}
		}
		return timesPurchased;
	}

	public ArrayList<String> purchasesOfType(String itemType)
			throws NullPointerException {
		// validate parameter
		if (itemType == null) {
			throw new NullPointerException();
		}
		// create an arraylist to place all items with the same type in that
		// array list
		ArrayList<String> sameType = new ArrayList<String>();
		for (PurchasedItem item : myItems) {
			if (item.getItemType().equalsIgnoreCase(itemType)) {
				sameType.add(new String(item.getItemName()));
			}
		}
		return sameType;
	}

	public boolean hasPurchasedItem(String itemName)
			throws NullPointerException {
		// validate parameter
		if (itemName == null) {
			throw new NullPointerException();
		}
		// check if the item was ever purchased
		for (PurchasedItem item : myItems) {
			if (item.getItemName().equalsIgnoreCase(itemName)) {
				return true;
			}
		}
		return false;

	}
}