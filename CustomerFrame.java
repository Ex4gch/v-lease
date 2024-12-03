import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.StandardOpenOption.*;

public class CustomerFrame extends JFrame implements ActionListener{
   String filepath = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\customer.txt";
   File file = new File(filepath);
   
   ImageIcon img = new ImageIcon("v-Lease2.png");
   
   
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   Customer customer = new Customer();
   

   
   //Texts
   JTextField Name = new JTextField("Name", 20);
   JTextField Age = new JTextField("Age", 20);
   JTextField Address = new JTextField("Address", 20);
   JTextField IdNumber = new JTextField("IdNumber", 20);
   
   //Checkbox
   ButtonGroup Gender = new ButtonGroup();
   JLabel GLabel = new JLabel("Choose One");
   JCheckBox Male = new JCheckBox("Male");
   JCheckBox Female = new JCheckBox("Female");
   
   //Buttons
   JButton Save = new JButton("Save");
   JButton Back = new JButton("Back");
   
   JPanel p = new JPanel();
   
   public CustomerFrame (){
      this.setTitle("V-Lease");
      this.setSize(1000,600);
      this.setLocationRelativeTo(null);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
      this.setIconImage(img.getImage());
      
      Gender.add(Male);
      Gender.add(Female);
      
      p.add(Name);
      p.add(Age);
      p.add(GLabel);
      p.add(Male);
      p.add(Female);
      p.add(Address);
      p.add(IdNumber);
      p.add(Save);
      p.add(Back);
      
      Back.addActionListener(this);
      Save.addActionListener(this);
      
      p.setBounds(340,200, 300, 137);
      p.setLayout(new FlowLayout(1, 20, 10));
      p.setOpaque(false);
      this.add(p);
   }
   
   public void actionPerformed(ActionEvent e){
   
      //Save
      if(e.getSource() == Save){
         boolean valid = true;
         //name
         customer.setName(Name.getText());
         try{
            //age
            customer.setAge(Integer.parseInt(Age.getText()));
            if(Integer.parseInt(Age.getText()) < 17 || Integer.parseInt(Age.getText()) > 85){
               throw new ArithmeticException();
            }
         }
         
         catch(ArithmeticException ae){
            Age.setText("Please Enter A Valid Age");
            valid = false;
         }
         catch(NumberFormatException nfe){
            Age.setText("Please Enter A Number");
            valid = false;
         }
         //gender
         if(Male.isSelected()){
            customer.setGender('M');
         }            
         else if(Female.isSelected()){
            customer.setGender('F');
         }
         else{
            valid = false;
         }
         //address
         customer.setAddress(Address.getText());
      
         try{
            customer.setIdNumber(Integer.parseInt(IdNumber.getText()));
            if (customer.getIdNumber() <= 0) {
               throw new NumberFormatException();
            }
         }
         catch(NumberFormatException nfe){
            IdNumber.setText("Please Enter A Valid License Number");
            valid = false;
         }
         
      
         if (valid) {
            try {
               FileWriter fw = new FileWriter(file, true);
               BufferedWriter bufferedWriter = new BufferedWriter(fw);
               
               fw.write(customer.getName() + "," + customer.getAge() + "," + customer.getGender() + "," + customer.getAddress() + "," + customer.getIdNumber() + "\n");
               bufferedWriter.append(System.getProperty("line.separator"));
            
               fw.close();
               bufferedWriter.close();
            
            }
            catch(Exception easd){
            
            }            
            
            CustomerManagementFrame cof = new CustomerManagementFrame();
            this.dispose();
         } 
         else {
         }  
         
                
      }
      
      else if(e.getSource() == Back){
         int confirm = JOptionPane.showConfirmDialog(
                  null,
                  "All data won't be saved, Are you sure you want to go back?",
                  "V-Lease",
                  JOptionPane.YES_NO_OPTION
                  );
            
         if (confirm == JOptionPane.YES_OPTION) {
            CustomerManagementFrame cf = new CustomerManagementFrame();
            this.dispose();
         } 
      }
      
   }
   
   public void setCustomerData(String name, String age, String gender, String address, String idNumber) {
      Name.setText(name);
      Age.setText(age);
      Address.setText(address);
      IdNumber.setText(idNumber);
   
      if (gender.equalsIgnoreCase("M")) {
         Male.setSelected(true);
      } else if (gender.equalsIgnoreCase("F")) {
         Female.setSelected(true);
      }
   }


   
}