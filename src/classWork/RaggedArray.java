/**
 * 
 */
package classWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author student1
 *
 */
public class RaggedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// make a two dimensional ragged array to read in the data from the file
		int rowQty = 0;
		int[][] raggedArray = new int[10][];
		try {
			Scanner infile = new Scanner(new File("./Numbers.txt"));

			while (infile.hasNext()) {
				String values = infile.nextLine();
				String[] tokens = values.split(" ");
				raggedArray[rowQty] = new int[tokens.length];
				for (int i = 0; i < tokens.length; i++) {
					raggedArray[rowQty][i] = Integer.parseInt(tokens[i]);
				}

				rowQty++;
			}
			infile.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		for (int i = 0; i < rowQty; i++) {
			for (int x = 0; x < raggedArray[i].length; x++) {
				System.out.print(raggedArray[i][x] + " ");
			}
			System.out.println();
		}
		//find sum of each row
		System.out.println();
		for(int i =0; i< rowQty; i++){
			int total =0;
			System.out.print("row " + i + " total= ");
			for(int x=0; x< raggedArray[i].length; x++){
				total += raggedArray[i][x];
			}
			System.out.println(total);
		}

	}
}
