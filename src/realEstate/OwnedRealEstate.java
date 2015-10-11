package realEstate;

public class OwnedRealEstate extends RealEstate {
	// an abstract class cannot be implemented but can be extended. all other
	// class can be extended but cannot be implemented
	private Owner owner;
	protected Address address;

	public OwnedRealEstate(Integer blockNumber, Integer lotNumber, String firstName, String lastName, String street,
			String state, String zipCode) {
		// first you must set up the foundation...parents provide a foundation
		// upon which you continue to build. without a foundation, you can not
		// continue to build.
		super(blockNumber, lotNumber);
		owner = new PrivateOwner(firstName, lastName, street, state, zipCode);
		this.address = new Address(street, state, zipCode);
	}
//we put the parameters in different orders so the class knows which constuctor to call
	public OwnedRealEstate(String companyName, String phoneNumber, String street, String state, String zipCode,
			Integer blockNumber, Integer lotNumber) {
		super(blockNumber, lotNumber);
		owner = new CorporateOwner(companyName, street, state, zipCode, phoneNumber);
		this.address = new Address(street, state, zipCode);
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		buffer.append(owner.toString());
		return buffer.toString();
	}
}
