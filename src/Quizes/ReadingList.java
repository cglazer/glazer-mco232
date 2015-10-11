/**
 * 
 */
package Quizes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author student1
 *
 */
public class ReadingList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);

		String[] students = new String[20];
		String[][] booklist = new String[20][];
		int qtyStudents = 6;

		students[0] = "Adina";
		students[1] = "Batya";
		students[2] = "Chana";
		students[3] = "Dina";
		students[4] = "Esther";
		students[5] = "Freida";


		// contains books read by some students
		booklist[0] = new String[] { "Frog and Toad", "Goose and Duck" };
		booklist[1] = new String[] { "Ramona the Pest", "See Me Run", "Penny and her Song" };
		booklist[2] = new String[] { "Odd Duck", "Ramona the Pest", "Penguin Troubles", "Penny and Her Marbles" };
		booklist[3] = new String[] { "Frog and Toad" };

		// 1. invoke method to display the names of the students
		displayNames(students, qtyStudents);
		// 2. invoke a method to display each student's name , alongside of
		// which display the books that the student read
		displayNamesAndBooksRead(students, qtyStudents, booklist);

		System.out.println("\nwhich student's reading list would you like to review?");
		String name = keyboard.next();

		// 3. invoke method to display the books that a specific student read
		String[] books = getReadingList(name, students, booklist, qtyStudents);
		// 4. display the list of books read by the student with this specific ,
		// name
		if (books == null) {
			System.out.println("Sorry, this name doesn't exist");
		} else if(books.length < 1){
			System.out.println("student didn't read any books");
		}else{
			for (int i = 0; i < books.length; i++) {
				System.out.println(books[i]);
			}
		}
		// if the list is empty display message, 'student didn't read any books'

		keyboard.close();
		System.out.println("\n\nHave a nice day");
		System.exit(0);

	}

	/**
	 * 
	 * @param names
	 *            - array that contains a list of names
	 * @param qty
	 *            - now many values are in the array names[]
	 */

	public static void displayNames(String[] names, int qty) {
		// 5. display the significant data values that are stored in names[]

		for (int i = 0; i < qty; i++) {
			System.out.println(names[i]);
		}
	}

	/**
	 * 
	 * @param names
	 *            - list of names of students
	 * @param qty
	 *            - how many names are in the list of names[]
	 * @param books
	 *            - the titles of each book read by each student who read a book
	 *            or books
	 */
	public static void displayNamesAndBooksRead(String[] names, int qty, String[][] books) {
		

		for (int i = 0; i < 4; i++) {
			System.out.print("\n" + names[i] + " read ");
			for (int y = 0; y < books[i].length; y++) {
				System.out.print(books[i][y] + " ");
			}
		}
		// 6. for each names in names[] display the name and the corresponding
		// list of books that were read by referencing
		// the corresponding position in books[][].
		// this method should display different data depending on what the
		// arrays, names[] and books[][]
		// contain at the time this method is invoked.

		// Based on the data that is currently stored in names[] and books[][]
		// the following output would be produced
		// Adina Frog and Toad Goose and Duck
		// Batya Ramona the Pest See Me Run Penny and her Song
		// Chana
		// Dina Odd Duck Ramona the Pest Penguin Troubles Penny and Her Marbles
		// Esther Frog and Toad
		// Freida

	}

	/**
	 * 
	 * 
	 * 
	 * @param name
	 *            references the name of the student whose data will be
	 *            processed
	 * @param names
	 *            references the list of names of students
	 * @param bookList
	 *            list of books read by each student
	 * @param qty
	 *            the number of students for which data has been stored
	 * @return list of book titles read by the student with name stored in
	 *         parameter ,'name' return null if student didn't read any books
	 */
	public static String[] getReadingList(String name, String[] names, String[][] bookList, int qty) {
		for (int i = 0; i < qty; i++) {
			if (name.equalsIgnoreCase(names[i])) {
					return bookList[i];
		}}
		return null; // if no books were read by a specific student	
	}
}
