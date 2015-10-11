package arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDone {

	public static void main(String[] args) {

		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(new Integer(101));
		myList.add(new Integer(102));
		System.out.println("add" + myList);
		myList.remove(new Integer(201));
		System.out.println("remove" +myList);
		myList.remove(new Integer(102));
		System.out.println("remove 102" + myList);
		System.out.println("size" + myList.size());
		System.out.println(myList);
		myList.add(new Integer(4));
		for(int i=2; i<4; i++){
			myList.add(new Integer(5+i));
		}
		System.out.println(myList);
		Collections.sort(myList);
		System.out.println(myList);
		myList.remove(new Integer(8));
		System.out.println(myList);
		System.out.println(myList.size());
		myList.set(1, new Integer(98));
		if(myList.contains(7)){
			System.out.println("yes!");
		}
		
		System.out.println(myList);
		for(Integer value: myList){
			System.out.println(value);
		}
		for(int i=0; i<myList.size(); i++){
			System.out.println(myList.get(i));
		}

	}

}
