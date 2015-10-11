package metroCard;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StationMaster {

	public static void main(String[] args) {
		// instantiate a metro card
		MetroCard aCard = new MetroCard();
		System.out.println(aCard.getCardID());
		
		MetroCard bCard = new MetroCard();
		System.out.println(bCard.getCardID());
		
		GregorianCalendar cardExpires = new GregorianCalendar();
		cardExpires.add(Calendar.YEAR, 2);
		bCard.getExpDate().set(Calendar.YEAR, 1);
		
		System.out.println(bCard.getExpDate());

	}

}
