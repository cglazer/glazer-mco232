package classWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FoodIngredients {


	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int choice ;    //records user choice from menu options
		final int EXIT = 5;
		String dataInput;  //stores one line of data read from file
		String[] tokens;
		String[][] foodIngredients = new String[10][];  //can handle up to 10 foods
		int numFoodsEntered =0;
		int numValuesOnLine; //how many values on a particular row 
		try{
			Scanner inputFile = new Scanner(new File("./FoodIngredients.txt"));
			while (inputFile.hasNext() ){
				//more data to read from file
				if (numFoodsEntered < foodIngredients.length){
					//have space left in the array
					dataInput = inputFile.nextLine();  //read in one line's worth

					//now separate the data into pieces , use ; as delimiter
					//tokens = dataInput.split(";");
					//how many separate values are in this String
					//numValuesOnLine = tokens.length;  
					//instantiate the array on the current row
					//foodIngredients[numFoodsEntered] = new String[numValuesOnLine];
					//enter the data on that row
					//for (int nextToken=0;nextToken<numValuesOnLine;nextToken++){
					//	foodIngredients[numFoodsEntered][nextToken]= tokens[nextToken];
					//}
					
					//instead of lines 28-37 use the next line
					//foodIngredients[numFoodsEntered][]= dataInput.split(";");
					//completed entering a food and its ingredients
					//add one to go to next row
					numFoodsEntered++;   

				}
				else {
					System.out.println("insufficient memory - can't complete process");
					inputFile.close();
					System.exit(1);   //end the program
				}
			}

		}
		catch (FileNotFoundException e1){
			System.out.println("cant process data - file not found - contact IT");
			System.exit(1);
		}

	
		do{
			choice = menu();
			switch (choice){
			case 1: //list all foods that have been recorded
				System.out.println("FOOD");
				for (int i=0;i<numFoodsEntered;i++){
					//the food name is in the first column of each row
					System.out.println(foodIngredients[i][0]);
				}
				break;
			case 2: //list all ingredients of a particular food
				System.out.println("Enter name of the food ");
				//use nextLine since name might include whitespace
				String foodName = keyboard.nextLine();  
				int row = searchForFood(foodName, foodIngredients,numFoodsEntered);
				if (row == -1){
					System.out.println("Food not in List: " + foodName);
				}
				else{
					//on this row , the first column contains the name of the food
					System.out.println(foodIngredients[row][0] + " Ingredients:");
					//on this row print out each column , starting from the 
					//second column
					for (int i=1;i<foodIngredients[row].length;i++){
						System.out.print(foodIngredients[row][i] + "\t");
					}
					System.out.println();  //go to next line in output
				}
				break;
			case 3:  //display list of foods that have a particular ingredient

				System.out.println("Enter name of ingredient to search for");

				String ingredient = keyboard.nextLine();
				System.out.println("The following foods contain " + ingredient  + "\n [");
				//for each food, check if it has this ingredient in its list of ingredients
				for (int i=0;i<numFoodsEntered;i++){
					String[] ingredients= getIngredients(i,foodIngredients);
					boolean containsIngredient = hasIngredient(ingredient,ingredients);
					if (containsIngredient){
						System.out.print(foodIngredients[i][0] + "  ");
					}
				}
                System.out.print("]");
				System.out.println();  //go to next line
				break;
			case 4: //list all data

				//display contents of the array
				for (int food=0;food <numFoodsEntered;food++)
				{
					for (int ingredientNum = 0 ; ingredientNum < foodIngredients[food].length;ingredientNum++){
						System.out.print(foodIngredients[food][ingredientNum] + "\t");
					}
					System.out.println();
				}
				break;
			case 5:
				 System.out.println("have a great day ---- ending application");
				 break;

			}   //end switch statement

		}while (choice != EXIT);
	}

	public static int menu(){
		Scanner keyboard = new Scanner(System.in);
		int choice;
		do{
			System.out.println("1.List foods" + 
					"\n2.List ingredients for a particular food" +
					"\n3.List foods with particular ingredient" +
					"\n4.Display each food and its ingredients" +
					"\n5.Exit");
			choice = keyboard.nextInt();
		}while (choice < 1 || choice > 5);  //invalid choice
		return choice;

	}

	public static int searchForFood(String foodName, String[][] foodIngredients, int qtyRows){
		for (int i=0; i< qtyRows;i++){
			if (foodName.equalsIgnoreCase(foodIngredients[i][0])){
				//found a match
				return i;   //this is the row on which the match was found
			}
		}
		return -1;
	}


	public static String[] getIngredients (int row, String[][] foodIngredients){
		//subtract 1 from a particular row since the first column contains
		//the food name, not an ingredient
		String[] ingredients = new String[foodIngredients[row].length-1]; 
		for (int i=0;i<ingredients.length;i++){
			ingredients[i]= foodIngredients[row][i+1];
		}
		return ingredients;
	}

	public static boolean hasIngredient(String ingredient, String[] ingredients){
		boolean found = false;
		for (String ing : ingredients){
			if (ing.equalsIgnoreCase(ingredient)){
				return true;  //found the ingredient, no need to look further
			}
		}
		return false;  //searched through all ingredients and it wasnt found

	}

}
