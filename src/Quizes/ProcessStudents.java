//Chayala Glazer
package Quizes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessStudents {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String[] names = new String[20];
		int choice;
		int namesQty = 20;
		String shortestName;
		
		
		
		while (true) {
			choice = menu();
			switch (choice) {
			case 1:
				try {
					namesQty = readData(names);
					System.out.println("The array has " + namesQty + " values.");
				} catch (FileNotFoundException notFound) {
					System.out.println("File was not found");
					System.exit(1);
				}
				break;
			case 2:
				System.out.println("which name are you looking for?");
				String name = keyboard.next();
				int nameSubscript;
				nameSubscript = findName(name, names, namesQty);
				System.out.println(name + " is number " + (nameSubscript + 1) + " on the list.");

				break;
			case 3:
				eachNameAppears(names, namesQty);
				System.out.println("this feature has not yet been implemented - stay tuned....");
				break;
			case 4:

				shortestName = findShortestName(names, namesQty);
				if(shortestName == null){
					System.out.println("Sorry.");
				}else{
				System.out.println("The shortest name is " + shortestName);
				}
				break;
			case 0:
				System.out.println("end application");
				keyboard.close();
				System.exit(0);
				break;
			}
		} // end while

	}

	/**
	 * Read data from file and store the data in the array names[]
	 * 
	 * @return the number of values that were read in from the file
	 */

	public static int readData(String[] names) throws FileNotFoundException {

		Scanner inputFile = new Scanner(new File("./Students.txt"));
		int namesQty = 0;
		while (inputFile.hasNext()) {
			if(namesQty < names.length){
			names[namesQty++] = inputFile.nextLine();
			}else{
				break;
			}
		}
		inputFile.close();
		return namesQty;
	}

	/**
	 * name - name to find in the list names[] - list of names that must be
	 * searched qty - how many elements of names[] contain significant data
	 * 
	 * @return - position in the array in which the first instance of the name
	 *         was found return -1 if name can't be found in the list names[]
	 */
	public static int findName(String name, String[] names, int qty) {
		int i;
		for (i = 0; i < qty; i++) {
			if (names[i].equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param names
	 *            - list of names
	 * @param qty
	 *            - how many names are stored in the names[] array
	 * @return - the name that has the smallest length
	 */
	public static String findShortestName(String[] names, int qty) {
	if(qty >0){
		String shortestName = names[0];
		for (int i = 1; i < qty; i++) {
			if (names[i].length() < shortestName.length()) {
				shortestName = names[i];
			}
		}
		return shortestName;
	}
	return null;
	}

	public static int menu() {
		int choice;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1. Read in Student Data " + "\n2. Find Name in Student List"
					+ "\n3. How may times does each name appear in the List" + "\n4. Which is the shortest name"
					+ "\n0. EXIT");

			choice = input.nextInt();
			// System.out.println("choice entered was " + choice);

		} while (choice > 4 || choice < 0);

		return choice;
	}
	public static void eachNameAppears(String[] names, int namesQty){
		//sort the list of names
		int startSortPosition;
		String minValue;
		int minValueSubscript;
		int minIndex;
		
		for(startSortPosition =0; startSortPosition< names.length; startSortPosition++){
			minIndex = startSortPosition;
			minValue = names[startSortPosition];
			
			for(minValueSubscript = startSortPosition+1; minValueSubscript<names.length; minValueSubscript++){
				if(names[minValueSubscript].compareToIgnoreCase(minValue) < 0){
					minValue = names[minValueSubscript];
					minIndex = minValueSubscript;
				}
			
			}
			names[minIndex]= names[startSortPosition];
			names[startSortPosition]= minValue;
		}
	
		
		int index=0;
			int similarNameQty=1;
		do{	
			if(index+1 < names.length){
			similarNameQty = 1;
			while((index+1< names.length) && (names[index].equalsIgnoreCase(names[++index]))){
				similarNameQty++;
			}}
			System.out.println(names[index-1] + " was written " + similarNameQty + " times.");
			
		}while(index < names.length-1);
		
		if(index< names.length){
			System.out.println(names[index]+ " was written 1 times.");
		}
		//display the sorted list
		for(int i=0; i<names.length; i++){
			System.out.println(names[i]);
		}
}
}
