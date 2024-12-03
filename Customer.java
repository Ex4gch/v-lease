import java.util.*;

public class Customer
{
   private String name;
   private String age;
   private String gender;
   private String address;
   private String IdNum;
   private String img;
   
   public Customer(String name, String age, String gender, String address, String IdNum, String img)
   {
      this.name = name;
      this.age = age;
      this.gender = gender;
      this.address = address;
      this.img = img;
      this.IdNum = IdNum;
   }
   
   
   public Customer()
   {
   
   }
   
   
   public String getImg()
   {
      return this.img;
   }
   
   public void setImg(String img)
   {
      this.img = img;
   }
   
   
   public void setName(String name){
      this.name = name;
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setAge(String age){
      this.age = age;
   }
   
   public String getAge(){
      return this.age;
   }

   public void setGender(String gender){
      this.gender = gender;
   }
   
   public String getGender(){
      return this.gender;
   }

   public void setAddress(String address){
      this.address = address;
   }
   
   public String getAddress(){
      return this.address;
   }

   public void setIdNumber(String IdNum){
      this.IdNum = IdNum;
   }
   
   public String getIdNumber(){
      return this.IdNum;
   }
   
  public String toString(){
   return "Name: " + getName()+ "\nAge: " + getAge() + "\nGender: " + getGender() + "\nAddress: " + getAddress() + "\nID Number: " +getIdNumber();
  }
   
}