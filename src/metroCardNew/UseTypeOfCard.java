package metroCardNew;

import java.text.DecimalFormat;

public class UseTypeOfCard {

	public static void main(String[] args) {
		TypeOfCard typeOfCard = TypeOfCard.PAYPERRIDE;
		
		System.out.println(typeOfCard.name() + " numric value " + typeOfCard.ordinal());
		DecimalFormat formatter = new DecimalFormat("##0.00");
		for (TypeOfCard t : TypeOfCard.values()){
			System.out.println("\nvalue " + t.ordinal() + " " + t.toString());
			System.out.println("cost per ride " + t.toString() + " would be $" + formatter.format(t.getCharge()));
		System.out.println("cost of a " + t.toString() + " metro card would be $" + formatter.format(t.getMinimumCost()));	
		}
	}

}
