package metroCardNew;

public enum TypeOfCard {
	SINGLERIDE(3.00,3.00),
	PAYPERRIDE(2.75,5.50),
	UNLIMITED30Days(0.0,116.5),
	REDUCEDFARE(1.35,5.00);
	
   private final double chargePerRide;
   private final double minCostOfCard;

   private TypeOfCard(double charge,double minCostOfCard){
	   this.chargePerRide = charge;
	   this.minCostOfCard = minCostOfCard;
   }
   
   double getCharge(){
	   return chargePerRide;
   }
   
   double getMinimumCost(){
	   return minCostOfCard;
   }
}
