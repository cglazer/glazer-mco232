package cellPhone;

import java.util.ArrayList;
import java.util.Scanner;

public class UseContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Contact> myContact = new ArrayList<Contact>();
		Scanner keyboard = new Scanner(System.in);
		int choice = menu();
		while (choice != 6) {

			switch (choice) {
			case 1:
				System.out.println(" What is the last name of your contact?");
				String lastName = keyboard.nextLine();
				System.out.println("What is the phone number of your contact?");
				String phoneNumber = keyboard.nextLine();
				System.out.println("What is your contact's nick name");
				String nickname = keyboard.nextLine();
				int addFirstName;
				do {
					System.out
							.println("Would you Like to add a first name to your contact? (If yes, enter 1, if not, enter 0)");
					addFirstName = keyboard.nextInt();
				} while (addFirstName < 0 || addFirstName > 1);
				if (addFirstName == 0) {
					// ArrayList<Contact> myContact = new ArrayList<Contact>();
					// Contact aContact = new Contact(lastName, phoneNumber,
					// nickname);
					// myContact.add(aContact);
					// myContact.add(new Contact(lastName, phoneNumber,
					// nickname));
				}
				if (addFirstName == 1) {
					System.out.println("What is your contact's first name?");
					String firstName = keyboard.nextLine();
					// ArrayList<Contact> myContact = new ArrayList<Contact>();
					myContact.add(new Contact(lastName, phoneNumber, nickname, firstName));

				}
				break;
			case 2:
				System.out.println("Which contact would you like to remove?");
				String remove = keyboard.nextLine();
				for (Contact x : myContact) {
					if (x.getNickName().equalsIgnoreCase(remove)) {
						myContact.remove(x);
						break;// you must make a break because by removing a
								// number, it messes up the subscripts of the
								// array, so you can only have it remove one
					}
				}
				break;
			case 3:
				System.out.println("Which contact would you like to view");
				String view = keyboard.nextLine();
				for (Contact x : myContact) {
					if (x.getNickName().equalsIgnoreCase(view)) {
						System.out.println(x);
						break;
					}

					// if(addFirstName == 0){
					// System.out.println(myContact.getLastName().getPhoneNumber())
					// }
					// if(addFirstName==1){
					// System.out.println(myContact.getLastName().getPhoneNumber().getFirstName);
					// }
				}
				break;
			case 4:
				System.out.println(myContact);
				// for(Contact; myContact){
				// System.out.println(Contact.getLastName());
				for (int i = 0; i < myContact.size(); i++) {
					System.out.println(myContact.get(i));
				}
				break;
			case 5:
				System.out.println("For which contact would you like to change the phone number");
				nickname = keyboard.nextLine();
				System.out.println("What is your contact's new phone number?");
				String newPhoneNumber = keyboard.nextLine();
				for (Contact x : myContact) {
					if (x.getNickName().equalsIgnoreCase(nickname)) {
						x.setPhoneNumber(newPhoneNumber);
						break;
					}
				}
				break;
			}
			choice = menu();
		}
		keyboard.close();
	}

	public static int menu() {
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1. Add Contact" + "\n2. Remove a specific contact"
					+ "\n 3. View a specific Contact(search by nickname" + "\n 4. Display all contacts"
					+ " \n 5. Modify Contact phoneNumber (search by nickname) \n 6. Exit");
			choice = input.nextInt();
		} while (choice < 1 || choice > 6);
		return choice;
	}

}
