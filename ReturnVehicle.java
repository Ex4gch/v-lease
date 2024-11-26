import java.time.*;
import java.time.temporal.ChronoUnit;
public class ReturnVehicle
{
   private LocalDateTime dateReturned = LocalDateTime.now();
   private LocalDateTime dateBorrowed = LocalDateTime.of(2024,11,26,16,22);
   private String vehicleType = "SUV";
   private String color = "Red";
   private String plate = "GAD8756";
   public ReturnVehicle()
   {
   
   }
   
   public double calculateExcessPayment()
   {
      int excessRate;
      switch (vehicleType.toUpperCase())
      {
         case "SUV":
            excessRate = 500;
            break;
         case "VAN":
            excessRate = 500;
            break;
         case "MINIVAN":
            excessRate = 300;
            break;
         case "SEDAN":
            excessRate = 200;
            break;
         case "MOTORCYCLE":
            excessRate = 100;
            break;
         default:
            throw new IllegalArgumentException("Invalid Vehicle Type");
      }
      long totalHrs = ChronoUnit.HOURS.between(dateBorrowed, dateReturned);
      if(totalHrs <= 24)
      {
         return 0;
      }
      long excessHours = totalHrs - 24;
      return excessHours * excessRate;
   }
   
   public String toString()
   {
   int dailyRate;
      switch(vehicleType.toUpperCase())
      {
         case "SUV":
            dailyRate = 2500;
            break;
         case "VAN":
            dailyRate = 2500;
            break;
         case "MINIVAN":
            dailyRate = 2000;
            break;
         case "SEDAN":
            dailyRate = 1800;
            break;
         case "MOTORCYCLE":
            dailyRate = 500;
            break;
         default:
            throw new IllegalArgumentException("Invalid Vehicle Type");
      }
      long totalHrs = ChronoUnit.HOURS.between(dateBorrowed, dateReturned);
      long excessHours;
      if(totalHrs <= 24)
      {
         excessHours = 0;
      }else
      {
         excessHours = totalHrs - 24;
      }
      double excessPayment = calculateExcessPayment();
      
      return String.format("Vehicle: %s\n"+"Color: %s\n"+"Plate Number:%s\n"+"24-hour rate: %,d (%s)\n"+"Excess Hours: %s\n"+"Excess payment: %.2f\n"+"Total Payment: %.2f",vehicleType,color,plate,dailyRate,vehicleType.toUpperCase(),excessHours, excessPayment,(excessPayment+dailyRate)); 
   }
   
   public void Returned()
   {
      System.out.println("The "+vehicleType+" with plate: "+plate+" has successfully been returned!" );
   }
}