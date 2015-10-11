package metroCardNew;

public enum StationType { PATH(2.75),BUS(2.75),SUBWAY(2.75);

   private double charge;
   
   private StationType(double charge){
	   this.charge = charge;
   }

   public double getCharge(){
	   return charge;
   }
}
