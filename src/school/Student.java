package school;

public class Student extends Person {

	private StudentType status;
	private Integer numberOfCreditsEarned;

	// constructor
	public Student(String name, String address, String phoneNumber,
			String emailAddress, Integer numberOfCreditsEarned)
			throws NullPointerException {
		// call the super class, Person
		super(name, address, phoneNumber, emailAddress);
		if (numberOfCreditsEarned == null) {
			throw new NullPointerException();
		}
		this.numberOfCreditsEarned = numberOfCreditsEarned;
		// automatically set the student's status by calling the setStatus
		// method
		setStatus(this.numberOfCreditsEarned);
		this.status = getStatus();
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	/**
	 * set the student's status based on how many credits he/she has
	 * 
	 * @param numberOfCreditsEarned
	 *            - the amount of credits he has
	 * @throws NullPointerException
	 *             - if the parameter is set to null
	 */
	public void setStatus(Integer numberOfCreditsEarned)
			throws NullPointerException {
		if (numberOfCreditsEarned == null) {
			throw new NullPointerException();
		}
		if (this.numberOfCreditsEarned < 30) {
			this.status = StudentType.FRESHMAN;
		} else if (this.numberOfCreditsEarned < 60) {
			this.status = StudentType.SOPHOMORE;
		} else if (this.numberOfCreditsEarned < 90) {
			this.status = StudentType.JUNIOR;
		} else {
			this.status = StudentType.SENIOR;
		}
	}

	/**
	 * reset the number of credits that the student has
	 * 
	 * @param numberOfCreditsEarned
	 *            - the number of credits the student has
	 * @throws NullPointerException
	 */
	public void setCreditsEarned(Integer numberOfCreditsEarned)
			throws NullPointerException {
		if (numberOfCreditsEarned == null) {
			throw new NullPointerException();
		}
		this.numberOfCreditsEarned = numberOfCreditsEarned;
		// when the user earns more credits, his status changes
		setStatus(this.numberOfCreditsEarned);
	}

	/**
	 * returns the student status
	 */
	public StudentType getStatus() {
		return status;
	}

	/**
	 * 
	 * @returns the number of credits that the student earned
	 */
	public Integer getCreditsEarned() {
		return this.numberOfCreditsEarned;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\nStudent");
		buffer.append(super.toString());
		buffer.append("\nStudent status: ");
		buffer.append(status.toString());
		buffer.append("\nNumber of Credits Earned: ");
		buffer.append(this.numberOfCreditsEarned);
		return buffer.toString();

	}
}
