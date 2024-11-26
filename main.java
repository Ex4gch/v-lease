import java.time.*;
import java.time.temporal.ChronoUnit;

public class main
{
   public static void main(String[]args)
   {
      ReturnVehicle rturn = new ReturnVehicle();
      
      System.out.println(rturn.calculateExcessPayment());
      System.out.println( rturn.toString());
      rturn.Returned();
   }
}