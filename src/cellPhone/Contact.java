package cellPhone;

public class Contact {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String nickName;

	public Contact(String lastName, String phoneNumber, String nickName) {
		this(lastName, phoneNumber, nickName, null);
	}

	public Contact(String lastName, String phoneNumber, String nickName, String firstName) throws InvalidDataException {
		if (lastName == null || phoneNumber == null || nickName == null) {
			throw new InvalidDataException();
		}
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.nickName = nickName;
		this.firstName = firstName;
	}

	public void setLastName(String lastName) throws InvalidDataException {
		if (lastName == null) {
			throw new InvalidDataException();
		}
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidDataException {
		if (phoneNumber == null) {
			throw new InvalidDataException();
		}
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getNickName() {
		return nickName;
	}

	// compare to method will define how to compare for sorting purposes, two
	// instances of this class

	public int compareTo(Contact other) {
		return lastName.compareTo(other.lastName);
	}

	// equals method will define how we determine that two instances of contact
	// are the same. it will by synchronized with the CompareTo method so, here,
	// if two people have the same lastName, they will be considered the same
	public boolean equals(Object obj) {
		// determine if in fact obj is referencing a Contact
		if (obj == null) {
			return false; // because it's not referencing anything
		}
		if (!(obj instanceof Contact)) {
			return false; // because it's not referencing a contact
		}
		// if the code continues, it means it's a contact so we
		// typecast obj into being a Contact
		Contact other = (Contact) obj;
		if (lastName.compareTo(other.lastName) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nContact ");
		buffer.append(" FirstName: ");
		if (firstName == null) {
			buffer.append("N/A");
		} else {
			buffer.append(this.firstName);
		}
		buffer.append(" LastName: ");
		buffer.append(this.lastName);
		buffer.append(" PhoneNumber ");
		buffer.append(this.phoneNumber);
		buffer.append(" nickName ");
		buffer.append(this.nickName);

		return buffer.toString();
	}

	public static void main(String[] args) {
		Contact me = new Contact("Plonczak", "1234567890", "advanced");
		Contact you = new Contact("Margulis", "2345678901", "intro");

		// compareTo method is getting a reference to me and the this keyword
		// references all the data inside me. CompareTo method is also getting
		// a reference to you. this reference is coming in via the parameter
		// other so other is referencing you which in this case contains a last
		// name referencing Margulis.
		if (me.compareTo(you) == 0) {
			System.out.println("We both have the same last name");
		} else if (me.compareTo(you) < 0) {
			System.out.println("I come first");
		} else if (me.compareTo(you) > 0) {
			System.out.println("You come first");
		}
		boolean result = me.equals(you);
		if (result == true) {
			System.out.println("We have the same last name");
		} else {
			System.out.println("We are unique");
		}
	}
}
