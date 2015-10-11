package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortingPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list1 = new int[20];
		int list1Counter = 0;
		int[] list2 = new int[20];
		int list2Counter = 0;
		try {
			Scanner inputFile = new Scanner(new File("./SortedLists.txt"));
			while (inputFile.hasNext()) {
				list1[list1Counter++] = inputFile.nextInt();
			}
			inputFile = new Scanner(new File("./SortedLists2.txt"));
			while (inputFile.hasNext()) {
				list2[list2Counter++] = inputFile.nextInt();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
		}
		System.out.println("list 1");
		int[] sortedList1 = sort(list1, list1Counter);
		for (int i = 0; i < sortedList1.length; i++) {
			System.out.println(sortedList1[i]);
		}

		System.out.println("list 2");
		int[] sortedList2 = sort(list2, list2Counter);
		for (int i = 0; i < sortedList2.length; i++) {
			System.out.println(sortedList2[i]);
		}

		System.out.println("intersected list");
		int[] intersectedList = intersect(sortedList1, sortedList2);
		for (int i = 0; i < intersectedList.length; i++) {
			System.out.println(intersectedList[i]);
		}

		System.out.println("merged list");
		int[] mergedList = merge(sortedList1, sortedList2);
		for (int i = 0; i < mergedList.length; i++) {
			System.out.println(mergedList[i]);
		}
	}

	public static int[] sort(int[] list, int listCounter) {
		int startScan;
		int index;
		int minValue;
		int minIndex;

		for (startScan = 0; startScan < listCounter - 1; startScan++) {
			index = startScan + 1;
			minValue = list[startScan];
			minIndex = startScan;

			for (index = startScan + 1; index < listCounter; index++) {
				if (list[index] < minValue) {
					minValue = list[index];
					minIndex = index;
				}
			}
			list[minIndex] = list[startScan];
			list[startScan] = minValue;

		}
		int[] sortedList = new int[listCounter];
		for (int i = 0; i < listCounter; i++) {
			sortedList[i] = list[i];
		}

		return sortedList;
	}

	public static int[] intersect(int[] list1, int[] list2) {
		int list1Counter = 0;
		int list2Counter = 0;
		int[] intersectedList = new int[list1.length];
		int intersectedListCounter = 0;
		
		while (list1Counter < list1.length && list2Counter < list2.length) {
			if (list1[list1Counter] == list2[list2Counter]) {
				intersectedList[intersectedListCounter++] = list1[list1Counter++];
				list2Counter++;
			}else if(list1[list1Counter] < list2[list2Counter]){
				list1Counter++;
			}else{
				list2Counter++;
			}
		}
		
		int[] fixedIntersectedList = new int[intersectedListCounter];
		for(int i=0; i< intersectedListCounter; i++){
			fixedIntersectedList[i] = intersectedList[i];
		}

		return fixedIntersectedList;
	}

	public static int[] merge(int[] list1, int[] list2) {
		int[] mergedList= new int[list1.length + list2.length];
		int mergedListCounter =0;
		int list1Counter =0;
		int list2Counter=0;
		if(list1Counter < list1.length && list2Counter < list2.length){
			do{
				if (list1[list1Counter] == list2[list2Counter]) {
					mergedList[mergedListCounter++] = list1[list1Counter++];
					list2Counter++;
				}else if(list1[list1Counter] < list2[list2Counter]){
					mergedList[mergedListCounter++] = list1[list1Counter++];
				}else{
					mergedList[mergedListCounter++] = list2[list2Counter++];
				}
		}while (list1Counter < list1.length && list2Counter < list2.length);
		}
		if(list1Counter< list1.length){
			do{
				mergedList[mergedListCounter++]= list1[list1Counter++];
			}while(list1Counter<list1.length);
		}else if(list2Counter< list2.length){
			do{
				mergedList[mergedListCounter++] = list2[list2Counter++];
			}while(list2Counter<list2.length);
		}
		
		int[] fixedMergedList = new int[mergedListCounter];
		for(int i=0; i< mergedListCounter; i++){
			fixedMergedList[i]= mergedList[i];
		}
		return fixedMergedList;
	}

}
