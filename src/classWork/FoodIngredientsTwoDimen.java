package classWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FoodIngredientsTwoDimen {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int choice ;    //records user choice from menu options
		final int EXIT = 5;
		String dataInput;  //stores one line of data read from file
		String[] tokens;
		//estimate that each food has 5 ingredients and we will store data about at most 4 different foods
		String[][] foodIngredients = new String[4][5];  
		int numFoodsEntered =0;
		int numValuesOnLine;  
		try{
			Scanner inputFile = new Scanner(new File("./FoodIngredients.txt"));
			while (inputFile.hasNext() ){
				//more data to read from file
				
					dataInput = inputFile.nextLine();  //read in one line's worth

					//now separate the data into pieces , use ; as delimiter
					tokens = dataInput.split(";");
					//how many separate values are in this String
					numValuesOnLine = tokens.length;  
					//instantiate the array on the current row
					//this statement will throw an ArrayIndexOutOfBoundsException if numFoodsEntered
					//references a row that doesn't exist in the array , foodIngredients[][]
					try{
					//enter the data on that row
					for (int nextToken=0;nextToken<numValuesOnLine;nextToken++){
						foodIngredients[numFoodsEntered][nextToken]= tokens[nextToken];
					}
					}
					catch (ArrayIndexOutOfBoundsException e2){
						System.out.println("insufficient RAM allocated to store data - contact IT");
						inputFile.close();
						System.exit(1);
					}
					//completed entering a food and its ingredients
					//add one to go to next row
					numFoodsEntered++;   

				}//end while
			
			

		}
		catch (FileNotFoundException e1){
			System.out.println("cant process data - file not found - contact IT");
			System.exit(1);
		}
		

	

	}

}
