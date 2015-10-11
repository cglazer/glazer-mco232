package manageRealEstate;

public class Address {
  private String street;
  private String city;
  private USState state;
  private String zipCode;
 
  public Address(String street, String state,String zipCode){
	 this(street,null, state,zipCode); 
  }
  
  public Address(String street, String city,String state,String zipCode){
	  //perform validation here......throw exceptions if 
	  //data provided is invalid or missing
	
	  USState stateCode = getStateCode(state);
	  
	  if (stateCode == null) {  //no corresponding state code could be found
		  throw new InvalidDataException();
	  }
	  
	  
	  if (!isZipCodeValid(zipCode)){
		  throw new InvalidDataException();
	  }
	  
	  //assume passed validation
	
	  this.street =street;
	  this.city =city;
	  this.state = stateCode;
	  this.zipCode = zipCode;
  }
  
  //setters 
  public void setStreet(String street){
	  this.street = street;
  }
  
  public void setCity (String city){
	  this.city =city;
  }
  
  public void setState(String state){
	  this.state = getStateCode(state);
	  if (this.state == null){
		  throw new InvalidDataException();
	  }
	
  }
  //whenever you have a setter...you should add validation too to make sure that the user is entering valid data
  public void setZipCode(String zipCode){
	  if (!isZipCodeValid(zipCode)){
		  throw new InvalidDataException();
	  }
	  this.zipCode = zipCode;
  }
  //getters

public String getStreet() {
	return street;
}

public String getCity() {
	return city;
}

public String getState() {
	return state.getName();
}

public String getZipCode() {
	return zipCode;
}
  //this method checks to make sure that the state string the user entered is valid...is a choice from the list of valid states
private static USState getStateCode(String state){
	 for (USState theState : USState.values()){
		  if (theState.name().equalsIgnoreCase(state)){
			 return theState;
			
	  }
	 }
	 return null;   //couldn't find the state
}

//all zipcodes are verified same way, regardless of the instance
private static boolean isZipCodeValid(String zipCode){
	if (zipCode.length()==5 || zipCode.length()==9){
		 return true;
	  }
	else{
		return false;
	}
}
//make sure to label data and say what it is.  
//toString
  public String toString(){
	  StringBuffer info = new StringBuffer();
	  info.append("\nAddress: ");
	  info.append(" Street: " + street);
	  if (city != null){
	  info.append(" City: " + city);
	  }
	  info.append(" State: " + state.name());
	  info.append(" ZipCode: " + zipCode);
	  return info.toString();
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())   //the two objects are instances of different Classes
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
	return true;  //all fields contain equivalent data so the instances are deemed "equal"
}



  //compareTo
  public int compareTo(Address address){
	  if (this.zipCode.equals(address.zipCode)){
	  return this.street.compareTo(address.street);
	  }
	  else
	  {
		  return this.zipCode.compareTo(address.zipCode);  //sort the data according to zipcode
	  }
  }
 
}
