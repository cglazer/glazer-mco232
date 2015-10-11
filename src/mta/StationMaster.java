
package mta;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StationMaster {
	
	public static void main(String[] args) {
		//instantiate a MetroCard
		MetroCard aCard = new MetroCard();
		System.out.println(aCard.getCardID());
		
		MetroCard theCard = new MetroCard();
		System.out.println(theCard.getCardID());

		
		
		GregorianCalendar cardExpires = theCard.getexpDate();
		//add two years to the exp date
		cardExpires.add(Calendar.YEAR, 2);
		
		System.out.println("card expires " + theCard.getexpDate().get(Calendar.YEAR));
	}

}
