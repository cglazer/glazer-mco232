package sorts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UseBubbleSort {

	public static void main(String[] args) {

		int[] values = new int[100];
		int quantity = 0;// the number of valued read from the file into the
		// array

		try {
			Scanner inputFile = new Scanner(new File("./unsortedIntegers.txt"));

			
			while (inputFile.hasNext()) {
				if (quantity < values.length) {
					values[quantity] = inputFile.nextInt();
					quantity++;
				} else {
					System.out.println("insuffiecient space");
					break;// leave the loop, don't read any more data, no more
							// space
				}
			}
			inputFile.close();
		
			
			
		} catch (FileNotFoundException notFound) {
			System.out.println("couldn't access data file not found end application.");
			System.exit(1);
		}
		
		//display the values that were read in
		System.out.println("Unsorted Integers");
		for(int x = 0; x < quantity; x++)
		{
			System.out.println("value " + (x+1) + " is " + values[x]);
		}
		BubbleSort.bubbleSort(values, quantity);
		//display the values after they were sorted
		System.out.println("\nSorted Integers");
		for(int x=0; x< quantity; x++)
		{
			System.out.println("value " + (x+1) + " is " + values[x]);
		}
	}

}
