package Sorts;

import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;

	public class ProcessStudents {

		public static void main(String[] args) {
			Scanner keyboard = new Scanner(System.in);
			
		
			
			int choice;
			while (true){
				choice = menu();
				switch (choice){
				case 1:
					   try{
						   readData();
						   
					   } catch(FileNotFoundException); 
					   }
			}
				        break;
				case 2:
					    System.out.println("which name are you looking for?");
				        String name = keyboard.next();
				       
				        findName(name, names, qty);
				        
				        break;
				case 3: 
					    System.out.println("this feature has not yet been implemented - stay tuned....");
					     break;
				case 4:  
					System.out.println(findShortestName(names, qty));
					    
					break;
				case 0:  System.out.println("end application");
				         keyboard.close();
				         System.exit(0);
				         break;
				}
			} //end while
			
			
			
		}
			
			/**
			 *   Read data from file and store the data in the array names[]
			 *   @return  the number of values that were read in from the file
			 */
			
			public static  int readData()throws FileNotFoundException{
				
				Scanner readFile = new Scanner(new File("C:/Users/student1/Documents/StudentNames.txt"));
				 
				String [] names = new String [30];
				
				int qty = 0;
				
				while (readFile.hasNext())
				{ names[qty] = readFile.nextLine(); 
				      qty++;  }
				
				readFile.close();
				
				return qty;
			}
			
			/**
			 * name - name to find in the list
			 * names[] - list of names that must be searched
			 * qty - how many elements of names[] contain significant data
			 * @return - position in the array in which the first instance of the name was found
			 *           return -1 if name can't be found in the list  names[]
			 */
			public static int findName(String name, String[] names, int qty){
				
				
				
				return -1;
			}
			
			
	/**
	 * 
	 * @param names  - list of names
	 * @param qty   - how many names are stored in the names[] array
	 * @return  -  the name that has the smallest length
	 */
		   public static String findShortestName(String[] names, int qty){
			 
			   String shortestName = names[0];
				 
			 for (int i = 1; i < qty; i++){
		       
				  if (names[i].compareToIgnoreCase(shortestName))
				  { shortestName= names[i];}
				  else 
				shortestName = names[0];
						  
			     return shortestName; }
			   
		   }
		
		public static int menu(){
			int choice;
			Scanner input = new Scanner(System.in);
			do{
			        System.out.println("1. Read in Student Data "
					+ "\n2. Find Name in Student List"
					+ "\n3. How may times does each name appear in the List" 
					+ "\n4. Which is the shortest name"
					+ "\n0. EXIT"
					);
			        
			        
			        choice = input.nextInt();
			       // System.out.println("choice entered was " + choice);
			
			}while(choice > 4 || choice < 0);
			
			
			
			return choice;
		}

	}
}
