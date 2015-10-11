package realEstate;

public interface Owner {
	// you cannot instantiate an interface. we create it because we want
	// consistancy and we want to be able to declare what every owner must
	// provide. such as...name, company name etc. we can't store the data yet
	// because we don't know what to expect to be able to provide yet. so we say
	// they must provide at least the following methods. we used to say they
	// should only have methods-say what's required and no fields, however
	// sometimes we do provide fields.
	public String getName();

	public Address getAddress();

	// anyoine who wants to be this kind of interface must implement code for at
	// least these two methods.
	public void setAddress(String street, String state, String zipCode);

	public String toString();
}
//by setting up an interface, you'res setting up a list of basic expectations that are needed to instantiate your instance