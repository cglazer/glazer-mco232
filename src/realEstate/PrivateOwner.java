package realEstate;
//this owner will only interact with the interface when a private owner
	// implements owner..so here it needs the get name and get address
	// implemented
public class PrivateOwner implements Owner {
private String firstName;
private String lastName;
private Address address;
private String phoneNumber;

//address is where the person lives
public PrivateOwner(String firstName, String lastName, String street, String state, String zipCode){
	this.firstName= firstName;
	this.lastName= lastName;
	this.address= new Address(street, state, zipCode);
}
	
@Override
	public String getName() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName;
	}

	@Override
	public Address getAddress() {
		// TODO Auto-generated method stub
		//make a deep copy
		return  new Address(this.address.getStreet(), this.address.getState(), this.address.getZipCode());
	}

	@Override
	public void setAddress(String street, String state, String zipCode) {
		//owner has moved...we're changing his address
		this.address= new Address(street, state, zipCode);
		
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String toString(){
		StringBuffer buffer= new StringBuffer();
		buffer.append("\n Private Owner: ");
		buffer.append("\nFirst Name: ");
		buffer.append(this.firstName);
		buffer.append("\nLast Name: ");
		buffer.append(this.lastName);
		buffer.append("\nAddress: ");
		buffer.append(address.toString());
		if(phoneNumber != null){
			buffer.append("\nPhone Number: ");
			buffer.append(this.phoneNumber);
		}
	return buffer.toString();
	
	}

	
	
}
