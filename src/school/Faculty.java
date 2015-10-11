package school;

public class Faculty extends Employee {

	private FacultyType status;
	private String departmentName;

	// constructor
	public Faculty(String name, String address, String phoneNumber,
			String emailAddress, String office, Double salary,
			String departmentName) throws NullPointerException {
		// calls the super class, Employee
		super(name, address, phoneNumber, emailAddress, office, salary);
		if (departmentName == null) {
			throw new NullPointerException();
		}
		this.departmentName = departmentName;
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public FacultyType getStatus() {
		return status;
	}

	public void setStatus(FacultyType status) throws NullPointerException {
		if (status == null) {
			throw new NullPointerException();
		}
		this.status = status;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
			throws NullPointerException {
		if (departmentName == null) {
			throw new NullPointerException();
		}
		this.departmentName = departmentName;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\nFaculty Member");
		buffer.append(super.toString());
		buffer.append("\nFaculty status: ");
		buffer.append(this.status);
		buffer.append("\nDepartment Name: ");
		buffer.append(this.departmentName);
		return buffer.toString();
	}
}
