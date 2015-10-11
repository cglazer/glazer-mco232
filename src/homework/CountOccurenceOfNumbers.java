package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountOccurenceOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] number = new int[100];
		try {
			Scanner inputFile = new Scanner(new File("./randomNumbers.txt"));

			while (inputFile.hasNext()) {
				number[inputFile.nextInt() - 1]++;
			}

			inputFile.close();
		} catch (FileNotFoundException notFound) {
			System.out.println("Error! File not found.");
			System.exit(1);
		}
		for (int i = 0; i < number.length; i++) {
			if (number[i] < 1) {
				System.out.println(i + 1 + " never occurs");
			} else if (number[i] == 1) {
				System.out.println(i + 1 + " occurs 1 time");
			} else {
				System.out.println(i + 1 + " occurs " + number[i] + " times");
			}
		}
	}
}
