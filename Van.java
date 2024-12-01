public class Van extends Vehicle
{
   private final double RATE = 2500.00;
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
      return "VAN";
   }
}