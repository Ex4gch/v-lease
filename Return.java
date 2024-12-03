public class Return
{
   String customer;
   String vehicle;
   String date;
   
   public Return(String customer, String vehicle, String date)
   {
      this.customer = customer;
      this.vehicle = vehicle;
      this.date = date;
   }  
   public Return( )
   {
   }
   public String getCustomer()
   {
      return this.customer;
   }
   
   public String getVehicle()
   {
      return this.vehicle;
   }
   
   public String getDate()
   {
      return this.date;
   }
   
   public void setDate(String date)
   {
      this.date = date;
   }  
   
   public void setVehicle(String vehicle)
   {
      this.vehicle = vehicle;
   }
   
   public void setCustomer(String customer)
   {
      this.customer = customer;
   }
}