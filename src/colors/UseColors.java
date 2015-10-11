package colors;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UseColors {
	public static void main(String[] args) {
		System.out.println(ColorTypes.RED.toString());
		System.out.println(ColorTypes.RED);
		System.out.println(ColorTypes.GREEN.ordinal());
		System.out.println(ColorTypes.RED.values());
		System.out.println(ColorTypes.GREEN.name() + " green here");
		System.out.println(ColorTypes.RED.compareTo(ColorTypes.RED));
		System.out.println(valueOf(ColorTypes.BLUE) + "hELLO");
		DecimalFormat decFormatter = new DecimalFormat("##0.00");
		String color= "Re";
		for (ColorTypes ct : ColorTypes.values()) {
			if(ct.toString().equalsIgnoreCase(color)){
				System.out.println(ct + " Hooray!");
			}
			
			System.out.println("\n"+ct.ordinal() + " " + ct.toString()+ " name " + ct.name());
			System.out.println("cost is $" + decFormatter.format(ct.getCost()));
		}
		ColorTypes colorTypes = ColorTypes.BLUE;
		System.out.println(colorTypes);
		System.out.println(colorTypes.getNumber() + " number");
Scanner input= new Scanner(System.in);
		System.out.println("Write a color");
String inputColor= input.next();
ColorTypes inputColorType;
//for(ColorTypes c: ColorTypes.values()){
	//if(inputColor.equalsIgnoreCase(c.values())){
		inputColorType=ColorTypes.valueOf(inputColor.toUpperCase());
		System.out.println(inputColorType.toString()+ " Yay!!");
	}//}}

	

	private static ColorTypes valueOf(ColorTypes blue) {
		// TODO Auto-generated method stub
		return ColorTypes.BLUE;
	}

}
