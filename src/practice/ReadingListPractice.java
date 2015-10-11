package practice;

import java.util.Scanner;

public class ReadingListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] booklist= new String[6][];
		String[] students = new String[6];
		Scanner input = new Scanner(System.in);		
		students[0] = "Adina";
		students[1] = "Batya";
		students[2] = "Chana";
		students[3] = "Dina";
		students[4] = "Esther";
		students[5] = "Freida";


		// contains books read by some students
		booklist[0] = new String[] { "Frog and Toad", "Goose and Duck" };
		booklist[1] = new String[] { "Ramona the Pest", "See Me Run", "Penny and her Song" };
		booklist[3] = new String[] { "Odd Duck", "Ramona the Pest", "Penguin Troubles", "Penny and Her Marbles" };
		booklist[4] = new String[] { "Frog and Toad" };

		// 1. invoke method to display the names of the students
		System.out.println("Student Names");
		for(int i=0; i<6; i++){
			System.out.println(students[i]);
		}
		// 2. invoke a method to display each student's name , alongside of
		// which display the books that the student read
		for(int i=0; i<6; i++){
			System.out.print(students[i] + "read ");
			for(int y=0; y< booklist[i].length; y++){
				System.out.println(booklist[i][y] + ", ");
			}
		
		}

		// 3. invoke method to display the books that a specific student read
		System.out.println(" Which Student's books would you like to see?");
		String studentWanted = input.nextLine();
		int found =-1;
		for(int i=0; i<students.length; i++){
			if(studentWanted.equalsIgnoreCase(students[i])){
				found = i;
				break;
			}
			if(found<0){
				System.out.println("Sorry...no such name");
			}else if(booklist[i].length < 1){
				{
					System.out.println("She didn't read any books");
				}
			}else{
				for(int x =0; x< booklist[i].length; x++){
				System.out.println(booklist[i][x]);
			}}
		}
		// 4. display the list of books read by the student with this specific ,
		// name
		
		// if the list is empty display message, 'student didn't read any books'

		
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
		

	}

}
