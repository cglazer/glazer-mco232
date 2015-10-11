package metroCard2015;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UseMetroCard {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// TODO Auto-generated method stub
		ArrayList<MetroCard> metroCards = new ArrayList<MetroCard>();
		
		int choice = menu();
		double amount;
		while (choice !=0){
			switch(choice){
			  
			case 1: //new MetroCard
				    System.out.println("how much money are you spending?");
				    amount =  keyboard.nextDouble();
				    metroCards.add(new MetroCard(amount));
				    //you can also write is as
				    //MetroCard aCard = new MetroCard(amount);
				    //metroCards.add(aCard);
				    break;
		
			case 2:
				boolean found = false;
				System.out.println("How much money do you wish to add? only whole dollars accepted!");
				 amount = keyboard.nextDouble();
				System.out.println("To which card do you wish to add the amount? enter the id");
				 Integer ID = keyboard.nextInt();
				 for (MetroCard card : metroCards){
					 //search for the card with the ID
					 if (card.getID().equals(ID)){
						 card.addToBalance(amount);
						 System.out.println("amount added - current balance " + card.getCurrentBalance());
						 found = true; //found the MetroCard 
						 break;   //mission accomplished break out of loop
					 }
				 }
				 if (!found){
					 System.out.println("card with ID " + ID + " not found");
				 }
				break;
			case 3: 
				   for (MetroCard card: metroCards){
					   System.out.println("card balance of card" + card.getID() + ": " + card.getCurrentBalance());
				   }
				   break;
			
			case 4:
				  SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
				  for (MetroCard card : metroCards){
					  
					  System.out.println("card expiration date " + formatter.format(card.getExpirationDate().getTime()));
				  }
				  break;
			case 5:
				 System.out.println("current fare: " + MetroCard.getCurrentFare());
				 break;
			case 6: //pay fare
				
				System.out.println("which card do you wish to use , enter id");
				boolean foundCard;
				Integer cardid;
				cardid = keyboard.nextInt();
				foundCard = false;    //assume card wont be found
				for (MetroCard card : metroCards){
					if (card.getID().equals(cardid)){
						//found the card
						foundCard = true;
						try{
					     card.swipe();  //method throws checked exceptions , they must be handled
						     System.out.println("Enter Mass Transit - Current Balance " + card.getCurrentBalance());
						     break;  //leave loop
						}
						catch(InsufficientFareException ex1){
							System.out.println(ex1.getMessage() + " add money to balance");
							break;   //leave loop
						}
						catch(CardExpiredException ex2){
							System.out.println(ex2.getMessage());
							break;  //leave loop
						}
						
					}
				}
				if (!foundCard){
					System.out.println("can't find the card with id " + cardid);
				}
				break;
			case 7: 
				boolean foundOriginal= false;
				Integer origCardID;
				System.out.println("what card are do you currently have?");
				origCardID = keyboard.nextInt();
				MetroCard originalCard = null;
				for (MetroCard card : metroCards){
					if (card.getID().equals(origCardID)){
						foundOriginal = true;
						originalCard = card;
						break;
					}
				}
				if (!foundOriginal){
					System.out.println("can't find card with ID: " + origCardID);
				}
				else {
					ArrayList<MetroCard> equivalentCards = new ArrayList<MetroCard>();
					for (MetroCard card : metroCards){
						if (originalCard.equals(card)){
							//add this card to the list
							equivalentCards.add(card);
						}
					}
					//now display the list of equivalent cards to the end user
					System.out.println("these cards are equivalent");
					System.out.println(equivalentCards);
				}
				break;
			case 8:  //sort metro cards
				   Collections.sort(metroCards);
				   System.out.println("Metro Cards sorted by balance");
				   System.out.println(metroCards);  
				   break;
			case 9: 
				System.out.println("how much will be added to current fare");
				Double incrAmt = keyboard.nextDouble();
				MetroCard.increaseFare(incrAmt);
				System.out.println("fare increased current fare is " + MetroCard.getCurrentFare());
				break;
			}  //end switch
			choice = menu();
		}//end while
        System.out.println("ending application......");
        keyboard.close();
	}
	
	public static int menu(){
		Scanner input = new Scanner(System.in);
		int choice;
		do{
		System.out.println("\n1. buy a metroCard" +
		                  "\n2.replenish a metroCard " +
				          "\n3.display balance" +
		                  "\n4.display expiration date"+
				          "\n5.display current fare" +
		                  "\n6.pay fare" +
				          "\n7. find equivalent MetroCard" +
		                  "\n8. sort metro cards" +
				          "\n9. increase fare" +
		                  "\n0. exit application"
				
				);
		choice= input.nextInt();
		}while (choice < 0 || choice > 9);
		return choice;
	}

}
