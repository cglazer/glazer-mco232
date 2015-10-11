/**
 * 
 */
package homework;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Chaya Glazer
 */
public class PatternRecognition {

	/**
	 * This program will indicate if there are four adjacent numbers with the
	 * same values.
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean repeat; // to repeat the loop if there was invalid input
		int rows = 0;
		// check for valid input, and reask the question in the case of invalid
		// input
		do {
			repeat = false;
			try {
				System.out
						.println("How many rows would you like there to be in the array?");
				rows = input.nextInt();
			} catch (InputMismatchException e) {
				System.out
						.println("You've entered invalid input. Please enter integers only.");
				input.nextLine();
				repeat = true;
			}
		} while (repeat);

		int columns = 0;
		do {
			repeat = false;
			try {
				System.out
						.println("How many columns would you like there to be in the array?");
				columns = input.nextInt();
			} catch (InputMismatchException e) {
				System.out
						.println("You've entered invalid input. Please enter integers only.");
				input.nextLine();
				repeat = true;
			}
		} while (repeat);
		// create a 2-dimensional array with the amount of rows and columns as
		// indicated
		int[][] values = new int[rows][columns];
		// call a method to ask for the values in the array
		do {
			repeat = false;
			try {
				values = createArray(values);
			} catch (InputMismatchException e) {
				System.out
						.println("You've entered invalid input. Please enter integers only.");
				repeat = true;
			}
		} while (repeat);
		// call a method to display the array as a table of values
		showArray(values);
		// call a method to check if there are four consecutive numbers with the
		// same value
		boolean isConsecutive = isConsecutiveFour(values);
		if (isConsecutive) {
			System.out
					.println("There are four consecutive numbers with the same value.");
		} else {
			System.out
					.println("There are no four consecutive numbers with the same value.");
		}
//close the scanner
		input.close();
	}

	/**
	 * This method will fill in the values of the array
	 * 
	 * @param values
	 *            - The array that the values will be filled into
	 * @return - the two dimensional array filled with values
	 */
	public static int[][] createArray(int[][] values) {
		Scanner input = new Scanner(System.in);
		//for each row, ask the user what values to fill in for that row
		for (int row = 0; row < values.length; row++) {
			System.out.println("Enter the values for row " + row + ":");
			for (int column = 0; column < values[row].length; column++) {
				values[row][column] = input.nextInt();
			}
		}
		//close the Scanner
		input.close();
		//return the filled array
		return values;
	}
/**
 * This method will display the array to the user as a table of values
 * @param values - the two dimensional array of values
 */
	public static void showArray(int[][] values) {
		//go throught each value and display the array like a table of values
		for (int row = 0; row < values.length; row++) {
			for (int column = 0; column < values[row].length; column++) {
				System.out.print(values[row][column] + " ");
			}
			System.out.println();
		}
	}
/**
 * This method will test if there are four consecutive numbers with the same value, vertically, horizontally, or diagnal
 * @param values - the two dimensional array of values
 * @return - true/false whether or not there are four consecutive numbers with the same values
 */
	public static boolean isConsecutiveFour(int[][] values) {
		boolean isConsecutiveFour = false;
		// test for a vertical line
		for (int row = 0; row < values.length - 3; row++) {
			for (int column = 0; column < values[row].length; column++) {
				if ((values[row][column] == values[row + 1][column])
						&& (values[row][column] == values[row + 2][column])
						&& (values[row][column] == values[row + 3][column])) {
					isConsecutiveFour = true;
					return isConsecutiveFour;
				}
			}
		}
		// test for a horizontal line
		for (int row = 0; row < values.length; row++) {
			for (int column = 0; column < values[row].length - 3; column++) {
				if ((values[row][column] == values[row][column + 1])
						&& (values[row][column] == values[row][column + 2])
						&& (values[row][column] == values[row][column + 3])) {
					isConsecutiveFour = true;
					return isConsecutiveFour;
				}
			}
		}
		// test for a negative slope
		for (int row = 0; row < values.length - 3; row++) {
			for (int column = 0; column < values[row].length - 3; column++) {
				if ((values[row][column] == values[row + 1][column + 1])
						&& (values[row][column] == values[row + 2][column + 2])
						&& (values[row][column] == values[row + 3][column + 3])) {
					isConsecutiveFour = true;
					return isConsecutiveFour;
				}
			}
		}
		// test for a positive slope
		for (int row = 3; row < values.length; row++) {
			for (int column = 0; column < values[row].length - 3; column++) {
				if ((values[row][column] == values[row - 1][column + 1])
						&& (values[row][column] == values[row - 2][column + 2])
						&& (values[row][column] == values[row - 3][column + 3])) {
					isConsecutiveFour = true;
					return isConsecutiveFour;
				}
			}

		}
		//return false if no four consecutive numbers where found with the same values
		return isConsecutiveFour;
	}
}
