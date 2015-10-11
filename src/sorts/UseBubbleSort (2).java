package Sorts;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class UseBubbleSort {
	public static void main (String []args)
	{
		try{
		File input = new File("./unsortedIntegers.txt");
			Scanner readFile = new Scanner(input);
			int quantity=0;
			int[] numbers = new int [100];
			while(readFile.hasNext())
				if(quantity< numbers.length)	
			{
				numbers[quantity] = readFile.nextInt();
				quantity++;
			}
				else{
					System.out.println("insufficient space");
					break; //leave the loop
				    }
			readFile.close();
			System.out.println("Unsorted list of integers");
			for(int i=0; i < quantity; i++)
				System.out.println("value " + (i+1) +" " + numbers[i]);
			
			//BubbleSort.bubbleSort(numbers, quantity);
			Arrays.sort(numbers);
			
			System.out.println("Sorted list of integers");
			for(int i=0; i < quantity; i++)
				System.out.println("value " + (i+1) +" "+ numbers[i]);
			
			System.out.println("ending application");
		}
		catch(FileNotFoundException notFound)
		{
			System.out.println("Could not access data. File not found.");
			System.exit(1);
		}
		}
	}