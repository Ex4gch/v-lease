public class Sedan extends Vehicle
{
   private final double RATE = 1800.00;
   
   private final double EXCESSRATE = 500.00;
   
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
      return "SEDAN";
   }
}