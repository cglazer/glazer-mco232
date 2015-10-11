package realEstate;

public class CorporateOwner implements Owner{
private String companyName;
private Address address;
private String phoneNumber;

public CorporateOwner(String companyName, String street, String state, String zipCode, String phoneNumber){
	this.companyName= companyName;
	this.phoneNumber= phoneNumber;
	this.address= new Address(street, state, zipCode);
}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return companyName;
	}

	@Override
	public Address getAddress() {
		// TODO Auto-generated method stub
		return  new Address(this.address.getStreet(), this.address.getState(), this.address.getZipCode());
	}

	@Override
	public void setAddress(String street, String state, String zipCode) {
		// TODO Auto-generated method stub
		this.address= new Address(street, state, zipCode);
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nCorporateOwner");
		buffer.append("\nCompany Name: ");
		buffer.append(this.companyName);
		buffer.append(address.toString());
		buffer.append("Phone Number: ");
		buffer.append(this.phoneNumber);
		return buffer.toString();
	}
	
}
