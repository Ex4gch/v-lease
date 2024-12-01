public class Motorcycle extends Vehicle
{
   private final double RATE = 500.00;
   private final double EXCESSRATE = 100.00;
   
   @Override
   public double getRATE()
   {
      return this.RATE;
   }
   
   @Override
   public double getEXCESSRATE()
   {
      return this.EXCESSRATE;
   }
   
   @Override
   public String toString()
   {
      return "MOTORCYCLE";
   }
}