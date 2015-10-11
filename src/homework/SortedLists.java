//Chayala Glazer
package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortedLists {

	/**
	 * This method will create a list of values found in both list 1 and list 2.
	 * 
	 * @param list1
	 *            -first list of values
	 * @param list2
	 *            -second list of values
	 * @return - list that includes only the values included in both lists
	 */
	public static int[] intersectSet(int[] list1, int[] list2) {
		// create an array to hold the values listed in both lists. The
		// intersect set list cannot exceed the size of list 1.
		int[] intersectSet = new int[list1.length];
		int intersectSetQty = 0;
		int list1Counter = 0;
		int list2Counter = 0;
		// validate that both arrays contain values
		if (list1Counter < list1.length && list2Counter < list2.length) {
			do {
				// Find the values listed in both files
				if (list1[list1Counter] == list2[list2Counter]) {
					intersectSet[intersectSetQty++] = list1[list1Counter++];
					list2Counter++;
				} else if (list1[list1Counter] < list2[list2Counter]) {
					list1Counter++;
				} else {
					list2Counter++;
				}
			} while (list1Counter < list1.length && list2Counter < list2.length);
		}
		// make a new array with a fixed size to hold the values listed in both
		// files
		int[] intersectSetFixed = new int[intersectSetQty];
		for (int i = 0; i < intersectSetQty; i++) {
			intersectSetFixed[i] = intersectSet[i];
		}
		// return a list of values listed in both files
		return intersectSetFixed;

	}

	/**
	 * This method will sort an array of values using a selection sort and
	 * return the sorted list.
	 * 
	 * @param list
	 *            - a list of values
	 * @param listQty
	 *            - the number significant values in the array
	 * @return- a list of sorted values
	 */
	public static int[] sortedList(int[] list, int listQty) {
		int[] sortedList = new int[listQty];
		int startSortPosition;//position of scan
		int subscript; //subscript of lowest value
		int minIndex; //element with smallest value in scan
		int minValue; //smallest value found
		//compare each value to every other value in the list to find the
		//smallest value
		for (startSortPosition = 0; startSortPosition < listQty; startSortPosition++) {
			minIndex = startSortPosition;
			minValue = list[startSortPosition];

			for (subscript = startSortPosition + 1; subscript < listQty; subscript++) {
				if (list[subscript] < minValue) {
					minValue = list[subscript];
					minIndex = subscript;
				}
			}
			// place the smallest value in the next available position
			list[minIndex] = list[startSortPosition];
			list[startSortPosition] = minValue;
		}
		// create a new array with a fixed size to hold the sorted list
		for (int i = 0; i < listQty; i++) {
			sortedList[i] = list[i];
		}
		// return the sorted list of values
		return sortedList;
	}

	/**
	 * This method will merge two lists of values into one list, but will not
	 * include values written in both files twice.
	 * 
	 * @param list1
	 *            -first list of values
	 * @param list2
	 *            -second list of values
	 * @return- a merged list of values from both lists, excluding duplicates
	 */
	public static int[] mergedList(int[] list1, int[] list2) {
		int[] mergedList = new int[list1.length + list2.length];
		int mergedListQty = 0;
		int list1Counter = 0;
		int list2Counter = 0;
		// validate that both arrays contain values
		if (list1Counter < list1.length && list2Counter < list2.length) {
			do {
				// create a merged list of values
				if (list1[list1Counter] == list2[list2Counter]) {
					mergedList[mergedListQty++] = list1[list1Counter++];
					list2Counter++;
				} else if (list1[list1Counter] < list2[list2Counter]) {
					mergedList[mergedListQty++] = list1[list1Counter++];
				} else {
					mergedList[mergedListQty++] = list2[list2Counter++];
				}

			} while (list1Counter < list1.length && list2Counter < list2.length);
		}
		//if one list is longer than the other, continue putting those values in the merged list
		if (list1Counter < list1.length){
			do{
				mergedList[mergedListQty++] = list1[list1Counter++];
			}while(list1Counter< list1.length);
		}else if(list2Counter< list2.length){
			do{
			mergedList[mergedListQty++] = list2[list2Counter++];
			}while(list2Counter< list2.length);
		}
		// create a new array with a fixed length to hold the merged list of
		// values
		int[] mergedListFixed = new int[mergedListQty];
		for (int i = 0; i < mergedListQty; i++) {
			mergedListFixed[i] = mergedList[i];
		}
		// return a merged list of values from two lists
		return mergedListFixed;
	}

	/**
	 * This program will read in two lists of values and display the values
	 * listed in both files and merged list of values from both files, excluding
	 * the values mention twice.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list1 = new int[20];
		int[] list2 = new int[20];
		int list1Qty = 0;
		int list2Qty = 0;
		try {
			// create a scanner object to read from a file
			Scanner inputFile1 = new Scanner(new File("./SortedLists.txt"));
			// read data into an array
			while (inputFile1.hasNext()) {
				list1[list1Qty] = inputFile1.nextInt();
				list1Qty++;
			}
			// create a new scanner object to read from a new file
			inputFile1 = new Scanner(new File("./SortedLists2.txt"));
			// read data into an array
			while (inputFile1.hasNext()) {
				list2[list2Qty] = inputFile1.nextInt();
				list2Qty++;
			}
			// close files
			inputFile1.close();
		} catch (FileNotFoundException notfound) {
			System.out.println("Error! File not found.");
			System.exit(1);
		}
		// call a method to sort list 1
		int[] sortedList1 = sortedList(list1, list1Qty);
		// display list 1, sorted
		System.out.println("Sorted List 1");
		for (int i = 0; i < sortedList1.length; i++) {
			System.out.println("\t" + sortedList1[i]);
		}
		// call a method to sort list 2
		int[] sortedList2 = sortedList(list2, list2Qty);
		// display list 2, sorted
		System.out.println("Sorted List 2");
		for (int i = 0; i < sortedList2.length; i++) {
			System.out.println("\t" + sortedList2[i]);
		}
		// call a method to find the values listed in both lists
		int[] intersectSet = intersectSet(sortedList1, sortedList2);
		// display the values listed in both lists
		System.out.println("Values found in both lists");
		for (int i = 0; i < intersectSet.length; i++) {
			System.out.println("\t" + intersectSet[i]);
		}
		// call a method to create a merged list of values from both lists
		int[] mergedList = mergedList(sortedList1, sortedList2);
		// display the merged list
		System.out.println("Merged List (excluding duplicates)");
		for (int i = 0; i < mergedList.length; i++) {
			System.out.println("\t" + mergedList[i]);
		}
	}// end main
}// end class
