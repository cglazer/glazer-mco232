package school;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageSchool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//create an array list of school members
		ArrayList<Person> schoolMembers = new ArrayList<Person>();
		String name;
		String address;
		String phoneNumber;
		String emailAddress;
		String office;
		Integer credits;
		Double salary;
		String jobTitle;
		Pattern validatePhone = Pattern.compile("\\d{3}-\\d{7}");
		Pattern validateEmail = Pattern
				.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]");
		Matcher matcher;
		boolean emailValid;
		boolean found;
		int choice = menu();
		do {
			switch (choice) {
			case 1:
				//add a student
				//find out student information
				System.out.println("What is the student's full name?");
				name = input.nextLine();
				System.out.println("What is the student's address?");
				address = input.nextLine();
				System.out
						.println("What is the student's phone number? Please enter the phone number in following format XXX-XXXXXXX");
				phoneNumber = input.nextLine();
				//validate the input as a phone number
				matcher = validatePhone.matcher(phoneNumber);
				while (!(matcher.matches())) {
					System.out
							.println("Phone Number must be in the form XXX-XXXXXXX. Please reenter the phone number.");
					phoneNumber = input.nextLine();
					matcher = validatePhone.matcher(phoneNumber);
				}
				System.out.println("What is the student's email address?");
				emailAddress = input.next();
				//validate the input as an email address 
				matcher = validateEmail.matcher(emailAddress);
				emailValid = matcher.matches();
				while (emailValid == false) {
					System.out
							.println("email address is Invalid, please try again");
					emailAddress = input.next();
					matcher = validateEmail.matcher(emailAddress);
					emailValid = matcher.matches();
				}
				System.out.println("How many credits does the student have?");
				credits = input.nextInt();
				//flush the buffer
				input.nextLine();
				// add a student
				schoolMembers.add(new Student(name, address, phoneNumber,
						emailAddress, credits));
				break;
			case 2:
				//add a faculty member
				//find out the faculty member's information
				System.out.println("What is the faculty member's full name?");
				name = input.nextLine();
				System.out.println("What is the faculty member's address?");
				address = input.nextLine();
				System.out
						.println("What is the faculty member's phone number?");
				phoneNumber = input.nextLine();
				//validate the input as phone number
				matcher = validatePhone.matcher(phoneNumber);
				while (!(matcher.matches())) {
					System.out
							.println("Phone Number must be in the form XXX-XXXXXXX. Please reenter the phone number.");
					phoneNumber = input.next();
					matcher = validatePhone.matcher(phoneNumber);
				}
				System.out
						.println("What is the faculty member's email address?");
				emailAddress = input.next();
				//validate the input as an email address
				matcher = validateEmail.matcher(emailAddress);
				emailValid = matcher.matches();
				while (emailValid == false) {
					System.out
							.println("email address is Invalid, please try again");
					emailAddress = input.next();
					matcher = validateEmail.matcher(emailAddress);
					emailValid = matcher.matches();
				}
				//flush the buffer
				input.nextLine();
				System.out
						.println("In what office does the faculty member work?");
				office = input.nextLine();
				System.out.println("What is the faculty member's salary?");
				salary = input.nextDouble();
				//flush the buffer
				input.nextLine();
				System.out
						.println("What is the faculty member's department name?");
				String departmentName = input.nextLine();
				//add a faculty member
				schoolMembers.add(new Faculty(name, address, phoneNumber,
						emailAddress, office, salary, departmentName));
				break;
			case 3:
				//add a staff member
				//find out staff member's information
				System.out.println("What is the staff member's full name?");
				name = input.nextLine();
				System.out.println("What is the staff member's address?");
				address = input.nextLine();
				System.out.println("What is the staff member's phone number?");
				phoneNumber = input.nextLine();
				//validate the input as a phone number
				matcher = validatePhone.matcher(phoneNumber);
				while (!(matcher.matches())) {
					System.out
							.println("Phone Number must be in the form XXX-XXXXXXX. Please reenter the phone number.");
					phoneNumber = input.next();
					matcher = validatePhone.matcher(phoneNumber);
				}
				System.out.println("What is the staff member's email address?");
				emailAddress = input.next();
				//validate the input as an email address
				matcher = validateEmail.matcher(emailAddress);
				emailValid = matcher.matches();
				while (emailValid == false) {
					System.out
							.println("email address is Invalid, please try again");
					emailAddress = input.next();
					matcher = validateEmail.matcher(emailAddress);
					emailValid = matcher.matches();
				}
				//flush the buffer
				input.nextLine();
				System.out
						.println("In what office does the staff member work?");
				office = input.nextLine();
				System.out.println("What is the staff member's salary?");
				salary = input.nextDouble();
				input.nextLine();
				System.out.println("What is the staff member's job title");
				jobTitle = input.nextLine();
				//add a staff member
				schoolMembers.add(new Staff(name, address, phoneNumber,
						emailAddress, office, salary, jobTitle));
				break;
			case 4:
				//print all school members and their information
				System.out.println(schoolMembers.toString());
				break;
			case 5:
				//modify credits earned by a specific student
				System.out
						.println("What student would you like to modify? Please enter the student's full name.");
				name = input.nextLine();
				System.out.println("How many credits has the student earned?");
				credits = input.nextInt();
				//flush the buffer
				input.nextLine();
				found = false;
				//reset the credits for the mentioned student
				for (Person aPerson : schoolMembers) {
					if (name.equalsIgnoreCase(aPerson.getName())) {
						((Student) aPerson).setCreditsEarned(credits);
						found = true;
					}
				}
				//inform the user if the student wasn't found
				if (!found) {
					System.out.println("Sorry, we could not find the student.");
				}
				break;
			case 6:
				//change the rank of a faculty member
				System.out
						.println("Which instuctor's rank would you like to change? Please enter the instructor's full name.");
				name = input.nextLine();
				System.out
						.println("What would you like to change his status to? \n1.LECTURER \n2.INSTRUCTOR \n3.PROF \n4.ASSOCIATEPROF");
				Integer status = input.nextInt();
				found = false;
				switch (status) {
				//reset the status of the faculty member
				case 1:
					for (Person aPerson : schoolMembers) {
						if (aPerson instanceof Faculty) {
							if (name.equalsIgnoreCase(aPerson.getName())) {
								((Faculty) aPerson)
										.setStatus(FacultyType.LECTURER);
								found = true;
							}
						}
					}
					break;
				case 2:
					for (Person aPerson : schoolMembers) {
						if (aPerson instanceof Faculty) {
							if (name.equalsIgnoreCase(aPerson.getName())) {
								((Faculty) aPerson)
										.setStatus(FacultyType.INSTRUCTOR);
								found = true;
							}
						}
					}
					break;
				case 3:
					for (Person aPerson : schoolMembers) {
						if (aPerson instanceof Faculty) {
							if (name.equalsIgnoreCase(aPerson.getName())) {
								((Faculty) aPerson).setStatus(FacultyType.PROF);
								found = true;
							}
						}
					}
					break;
				case 4:
					for (Person aPerson : schoolMembers) {
						if (aPerson instanceof Faculty) {
							if (name.equalsIgnoreCase(aPerson.getName())) {
								((Faculty) aPerson)
										.setStatus(FacultyType.ASSOCIATEPROF);
								found = true;
							}
						}
					}
					break;
				}
				//inform the user if the faculty member was not found
				if (!found) {
					System.out
							.println("Sorry, we can not find the faculty member.");
				}
				//flush the buffer
				input.nextLine();
				break;
			case 7:
				//modify the title of a staff member
				System.out
						.println("Which staff member's title would you like to modify? Please enter the staff member's full name.");
				name = input.nextLine();
				System.out
						.println("What would you like to change his title to?");
				jobTitle = input.nextLine();
				found = false;
				for (Person aPerson : schoolMembers) {
					if (aPerson instanceof Staff) {
						if (name.equalsIgnoreCase(aPerson.getName())) {
							((Staff) aPerson).setJobTitle(jobTitle);
							found = true;
						}
					}
				}
				
				//inform the user if the staff member wan't found
				if (!found) {
					System.out
							.println("Sorry, we can not find the staff member.");
				}
				break;
			}
			choice = menu();
		} while (choice != 0);
		//close the scanner object
		input.close();
	}
/**
 * menu of choices
 * @return
 * - the users choice
 */
	public static int menu() {
		Scanner option = new Scanner(System.in);
		int choice;
		do {
			System.out
					.println("\n1. Add a student \n2. Add a faculty member \n3. Add a staff member"
							+ "\n4. List data about all members of the school"
							+ "\n5. Modify credits earned of a specific student"
							+ "\n6. Modify the rank of a specific instructor"
							+ "\n7. Modify the job title of a specific staff member\n0. Exit");
			choice = option.nextInt();
		} while (choice < 0 || choice > 7);
		//return the user choice
		return choice;
	}
}
