package realEstate;

public class Address 
{
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Address(String street, String state, String zip)
	{
		this(street, null, state, zip);
	}
	
	public Address(String street, String city, String state, String zip)
	{
		//perform validation...throw exception if data provided is invalid/missing
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zip;
	}
	
	//setters
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public void setZip(String zip)
	{
		this.zipCode = zip;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		StringBuffer buffer= new StringBuffer();
		buffer.append("\nAddress");
		buffer.append("\nStreet: ");
		buffer.append(this.street);
		buffer.append("City: ");
		buffer.append(this.city);
		buffer.append("State");
		buffer.append(this.state);
		buffer.append("Zip Code");
		buffer.append(this.zipCode);
		return buffer.toString();
	}
	
	//compareTo
	//we don't have to check that it's receiveing an address type because it's already receiveing an address type as a parameter
	//we are checking two things here--the zip code and street
	public int compareTo(Address other){
		if(zipCode.equals(other.zipCode)){
			return this.street.compareTo(other.street);
		}
		else{
			return this.zipCode.compareTo(other.zipCode);
		}
		}
	//equals


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	
}
