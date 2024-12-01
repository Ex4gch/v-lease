import java.awt.*;
import javax.swing.*;

public class vehicles 
{
   JLabel l = new JLabel();
   private String PlateNumber;
   private String model;
   private String imgpath;
   private String status;
   private Vehicle type;
   
   VehiclePanel p;
   
   public vehicles()
   {
      
   }
   
   public vehicles(String model, String imgpath, String PlateNumber, String status, Vehicle type)
   {
      this.imgpath = imgpath;
      this.model = model;
      this.PlateNumber = PlateNumber;
      this.status = status;
      this.type = type;
   }
   
   public void setStatus(String status)
   {
      this.status = status;
   }
   
   public String getStatus()
   {
      return this.status;
   }
   
   public void setType(Vehicle type)
   {
      this.type = type;
   }
   
   public Vehicle getType()
   {
      return this.type;
   }
   
   public void setImgpath(String imgpath)
   {
      this.imgpath = imgpath;
   }
   
   public String getImgpath()
   {
      return this.imgpath;
   }
   
   public void setPlateNumber(String PlateNumber)
   {
      this.PlateNumber = PlateNumber;
   }
   
   public String getPlateNumber()
   {
      return this.PlateNumber;
   }
   
   public void setModel(String model)
   {
      this.model = model;
   }
   
   public String getModel()
   {
      return this.model;
   }
    
   public String toString()
   {
      return getModel();
   }
   
   public VehiclePanel getPanel()
   {  
      p = new VehiclePanel(getModel(),getImgpath(),getPlateNumber(),getStatus(),getType());
      return this.p;
   }
}