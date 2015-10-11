package school;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Employee extends Person {

	private String office;
	private Double salary;
	private GregorianCalendar dateHired;

	// constructor
	public Employee(String name, String address, String phoneNumber,
			String emailAddress, String office, Double salary)
			throws NullPointerException {
		// calls the super class, Person
		super(name, address, phoneNumber, emailAddress);
		if (office == null || salary == null) {
			throw new NullPointerException();
		}
		this.office = office;
		this.salary = salary;
		this.dateHired = new GregorianCalendar();
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public void setOffice(String office) throws NullPointerException {
		if (office == null) {
			throw new NullPointerException();
		}
		this.office = office;
	}

	public void setSalary(Double salary) throws NullPointerException {
		if (salary == null) {
			throw new NullPointerException();
		}
		this.salary = salary;
	}

	public String getOffice() {
		return office;
	}

	public Double getSalary() {
		return salary;
	}

	public String getDateHired() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(dateHired);
	}

	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\tEmployee:");
		buffer.append(super.toString());
		buffer.append("\nOffice: ");
		buffer.append(this.office);
		buffer.append("\nSalary: $");
		buffer.append(this.salary);
		buffer.append("\nDate Hired: ");
		buffer.append(formatter.format(dateHired.getTime()));
		return buffer.toString();
	}

}
