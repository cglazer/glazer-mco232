//Chayala Glazer
package pointOfSale;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PurchasedItem {

	private String itemName;
	private GregorianCalendar purchaseDate;
	private Double price;
	private String itemType;

	public PurchasedItem(String itemName,
			Double price, String itemType) throws NullPointerException {
		// validate parameters
		if (itemName == null || price == null
				|| itemType == null) {
			throw new NullPointerException();
		}
		this.itemName = itemName;
		this.price = price;
		this.itemType = itemType;
		// create a Gregorian Calendar for today, the date the item was
		// purchased
		purchaseDate = new GregorianCalendar();
	}

	public String getItemName() {
		return itemName;
	}

	public GregorianCalendar getPurchaseDate() {
		// return a deep copy of the date
		GregorianCalendar copyOfPurchaseDate = new GregorianCalendar(
				purchaseDate.get(Calendar.MONTH),
				purchaseDate.get(Calendar.DAY_OF_MONTH),
				purchaseDate.get(Calendar.YEAR));
		return copyOfPurchaseDate;
	}

	public Double getPrice() {
		return price;
	}

	public String getItemType() {
		return itemType;
	}

	public int compareTo(PurchasedItem other) {
		return itemName.compareTo(other.itemName);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PurchasedItem))
			return false;
		PurchasedItem other = (PurchasedItem) obj;
		if (itemName.compareTo(other.itemName) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nItem Name:");
		buffer.append(this.itemName);
		buffer.append("\nPurchasedDate:");
		buffer.append(formatter.format(purchaseDate.getTime()));
		buffer.append("\nPrice:");
		buffer.append(this.price);
		buffer.append("\nItemType");
		buffer.append(this.itemType);
		return buffer.toString();

	}

}
