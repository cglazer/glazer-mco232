package school;

public class Staff extends Employee {
	private String jobTitle;

	// constructor
	public Staff(String name, String address, String phoneNumber,
			String emailAddress, String office, Double salary, String jobTitle)
			throws NullPointerException {
		// calls the super class, Employee
		super(name, address, phoneNumber, emailAddress, office, salary);
		if (jobTitle == null) {
			throw new NullPointerException();
		}
		this.jobTitle = jobTitle;
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) throws NullPointerException {
		if (jobTitle == null) {
			throw new NullPointerException();
		}
		this.jobTitle = jobTitle;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\nStaff member");
		buffer.append(super.toString());
		buffer.append("\nJob Title: ");
		buffer.append(this.jobTitle);
		return buffer.toString();
	}
}
