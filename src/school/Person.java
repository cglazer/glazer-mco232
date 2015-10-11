package school;

public class Person {
	private String name;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private Integer personID;
	private static int lastPersonID = 0;

	public Person(String name, String address, String phoneNumber,
			String emailAddress) throws NullPointerException {
		if (name == null || address == null || phoneNumber == null
				|| emailAddress == null) {
			throw new NullPointerException();
		}
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.personID = ++lastPersonID;
	}

	public Integer getPersonID() {
		return personID;
	}

	/**
	 * returns the member's school member
	 * 
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * reset the member's phone number
	 * 
	 * @param phoneNumber
	 *            - the new phone number
	 * @throws NullPointerException
	 */
	public void setPhoneNumber(String phoneNumber) throws NullPointerException {
		if (phoneNumber == null) {
			throw new NullPointerException();
		}
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the member's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * compare the school members based on their name and phone number
	 * 
	 * @param other
	 * @return
	 */
	public int CompareTo(Person other) {
		int i = this.name.compareTo(other.name);
		if (i != 0) {
			return i;
		}
		return this.phoneNumber.compareTo(other.phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nName: ");
		buffer.append(this.name);
		buffer.append("\nAddress: ");
		buffer.append(this.address);
		buffer.append("\nPhone Number: ");
		buffer.append(this.phoneNumber);
		buffer.append("\nEmail Address: ");
		buffer.append(this.emailAddress);
		return buffer.toString();
	}
}
