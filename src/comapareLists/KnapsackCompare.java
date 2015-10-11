package comapareLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapsackCompare {
	/**
	 * This program will read two students' supplies lists and figure out which
	 * supplies both students need, and which supplies are special to just one
	 * student.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int adinaSupplyQty = 0; // how many supplies Adina has in her knapsack
		int brachaSupplyQty = 0; // how many supplies Bracha has in her knapsack
		String[] adinaSupplies = new String[20]; // list of Adina’s supplies
		String[] brachaSupplies = new String[20]; // list of Bracha’s supplies

		try {
			// create a scanner to object to read from file
			Scanner student1File = new Scanner(new File("./BrachaSupplies.txt"));

			System.out.println("Bracha's Supplies:\n");
			// read in and store bracha’s list of supplies
			while (student1File.hasNext()) {
				brachaSupplies[brachaSupplyQty] = student1File.nextLine();
				// display her supplies
				System.out.println("\t" + brachaSupplies[brachaSupplyQty]);
				brachaSupplyQty++; // count the supplies on her list
			}
			// create new scanner object to read new file
			Scanner student2File = new Scanner(new File("./AdinaSupplies.txt"));
			System.out.println("\nAdina's Supplies:\n");
			// read in and store adina's list of supplies
			while (student2File.hasNext()) {
				adinaSupplies[adinaSupplyQty] = student2File.nextLine();
				// display her supplies
				System.out.println("\t" + adinaSupplies[adinaSupplyQty]);
				adinaSupplyQty++;// count the supplies on her list
			}
			// close the files
			student1File.close();
			student2File.close();

		} catch (FileNotFoundException notFound) {
			System.out.println("Error. File not found.");
			System.exit(1);
		}

		// find out which supplies both students have in their knapsacks
		String[] sameSupplies = sameSupplies(adinaSupplies, adinaSupplyQty,
				brachaSupplies, brachaSupplyQty);
		// display the supplies both students need
		System.out.println("\nMatching Supplies:\n");
		for (int i = 0; i < sameSupplies.length; i++)
			System.out.println("\t" + sameSupplies[i]);

		// find out which supplies Adina needs that Bracha doesn’t need
		String[] adinaSuppliesOnly = mySpecialSupplies(adinaSupplies,
				adinaSupplyQty, brachaSupplies, brachaSupplyQty);
		// display the supplies that only Adina needs
		System.out.println("\nAdina's Special Supplies:\n");
		for (int i = 0; i < adinaSuppliesOnly.length; i++) {
			System.out.println("\t" + adinaSuppliesOnly[i]);
		}

		// find out which supplies Bracha has that Adina doesn’t have
		String[] brachaSuppliesOnly = mySpecialSupplies(brachaSupplies,
				brachaSupplyQty, adinaSupplies, adinaSupplyQty);
		// display the supplies that only Bracha needs
		System.out.println("\nBracha's Special Supplies:\n");
		for (int i = 0; i < brachaSuppliesOnly.length; i++) {
			System.out.println("\t" + brachaSuppliesOnly[i]);
		}

	}// end main method

	/**
	 * This method will figure out which supplies both students need.
	 * 
	 * @param suppliesOne
	 *            -first list of supplies
	 * @param oneQty
	 *            -quantity of significant values in the first list of supplies
	 * @param suppliesTwo
	 *            -second list of supplies
	 * @param twoQty
	 *            -quantity of significant values in second list of supplies
	 * @return -list that includes only those values that appear in both lists
	 */
	public static String[] sameSupplies(String[] suppliesOne, int oneQty,
			String[] suppliesTwo, int twoQty) {

		// determine the largest possible size the array with the matching
		// supplies will need to be
		int sizeOfArray;
		if (oneQty < twoQty) {
			sizeOfArray = oneQty;
		} else {
			sizeOfArray = twoQty;
		}
		String[] sameSuppliesList = new String[sizeOfArray];
		int sameSuppliesListQty = 0;// to keep track how many supplies are in
									// both lists
		// determine which supplies are in BOTH lists and return a list that
		// contains only those supplies
		for (int x = 0; x < oneQty; x++) {
			for (int y = 0; y < twoQty; y++) {
				if (suppliesOne[x].equalsIgnoreCase(suppliesTwo[y])) {
					sameSuppliesList[sameSuppliesListQty] = suppliesOne[x];
					sameSuppliesListQty++;
				}
			}
		}
		// create a new array with the correct amount of spaces to hold the
		// matching supplies
		String[] sameSuppliesListRevised = new String[sameSuppliesListQty];
		for (int i = 0; i < sameSuppliesListQty; i++) {
			sameSuppliesListRevised[i] = sameSuppliesList[i];
		}
		// return the supplies listed in both files
		return sameSuppliesListRevised;
	}// end method

	/**
	 * This method will determine which supplies are special to each student.
	 * 
	 * @param mySupplies
	 *            - list that contains set of values
	 * @param myQty
	 *            - quantity of values in the list
	 * @param yourSupplies
	 *            - another list that contains a set of values
	 * @param yourQty
	 *            - quantity of significant values in the second list
	 * @return -list that contains only those values that appear in first list
	 *         but not in second
	 */
	public static String[] mySpecialSupplies(String[] mySupplies, int myQty,
			String[] yourSupplies, int yourQty) {
		String[] mySuppliesOnly = new String[myQty];
		boolean[] same = new boolean[myQty];
		int mySuppliesOnlyQty = 0;

		// determine which supplies appear only in the first list but not in the
		// second
		for (int x = 0; x < myQty; x++) {
			for (int y = 0; y < yourQty; y++) {
				if (mySupplies[x].equalsIgnoreCase(yourSupplies[y])) {
					same[x] = true;

				}
			}
		}
		for (int x = 0; x < myQty; x++) {
			if (!(same[x])) {
				mySuppliesOnly[mySuppliesOnlyQty] = mySupplies[x];
				mySuppliesOnlyQty++;
			}
		}
		// create a new array with the correct amount of spaces to hold the
		// special supplies for the student
		String[] mySuppliesOnlyRevised = new String[mySuppliesOnlyQty];
		for (int i = 0; i < mySuppliesOnlyQty; i++) {
			mySuppliesOnlyRevised[i] = mySuppliesOnly[i];
		}
		// return the values that were only in the first list
		return mySuppliesOnlyRevised;
	}// end method
}// end class
