import java.util.*;

public class Customer{
   private String name;
   private int age;
   private char gender;
   private String address;
   private int IdNum;
   
   public void setName(String name){
      this.name = name;
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setAge(int age){
      this.age = age;
   }
   
   public int getAge(){
      return this.age;
   }

   public void setGender(char gender){
      this.gender = gender;
   }
   
   public char getGender(){
      return this.gender;
   }

   public void setAddress(String address){
      this.name = name;
   }
   
   public String getAddress(){
      return this.address;
   }

   public void setIdNumber(int IdNum){
      this.IdNum = IdNum;
   }
   
   public int getIdNumber(){
      return this.IdNum;
   }
}