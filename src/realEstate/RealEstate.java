package realEstate;

public class RealEstate {
	private Integer blockNumber;
	private Integer lotNumber;
	private Address address;

	public RealEstate(Integer blockNumber, Integer lotNumber) {
		this.blockNumber = blockNumber;
		this.lotNumber = lotNumber;
		this.address = null;
	}

	public Address getAddress() {
		return address;
	}

	// calling the same setter with more information
	public void setAddress(String street, String state, String zipCode) {
		setAddress(street, null, state, zipCode);
	}

	// second setter in case they also give you the city
	public void setAddress(String street, String city, String state, String zipCode) {
		if (this.address == null) {
			this.address = new Address(street, state, zipCode);
		}

	}

	public void setStreet(String street) {
		if (address != null) {
			this.address.setStreet(street);
		}
	}

	public Integer getBlockNumber() {
		return blockNumber;
	}

	public Integer getLotNumber() {
		return lotNumber;
	}

	@Override
	public String toString() {
		StringBuffer buffer= new StringBuffer();
		buffer.append("\n Real Estate: ");
		buffer.append("Block Number: ");
		buffer.append(this.blockNumber);
		buffer.append("\nLot Number: ");
		buffer.append(this.lotNumber);
		buffer.append(this.address.toString());
		return buffer.toString();
	}
}
