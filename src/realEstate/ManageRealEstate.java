package realEstate;

import java.util.ArrayList;

public class ManageRealEstate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<RealEstate> myRealEstate = new ArrayList<RealEstate>();
		myRealEstate.add(new OwnedRealEstate(10, 23545, "Leba", "Sklar",
				"1602 Ave J", "NY", "11210"));
		myRealEstate.add(new OwnedRealEstate("Touro", "1231231234", "Ave J",
				"NY", "11212", 112234, 3456));

		for (RealEstate realEstate : myRealEstate) {
			System.out.println(realEstate);
		}
	}
}