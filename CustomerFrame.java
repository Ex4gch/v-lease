import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.StandardOpenOption.*;

public class CustomerFrame extends JFrame implements ActionListener{
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   Customer customer = new Customer();
   
   
   
   String filepath = "C:\\Users\\Ivan Cortes\\Documents\\joswa\\customer.txt";
   File file = new File(filepath);
   
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
   JButton Edit = new JButton("Edit");
   
   
   JPanel p = new JPanel();
   
   public CustomerFrame (){
      this.setTitle("V-Lease");
      this.setSize(1000,600);
      this.setLocationRelativeTo(null);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
      
      Gender.add(Male);
      Gender.add(Female);
      
      p.add(label);
      p.add(Name);
      p.add(Age);
      p.add(GLabel);
      p.add(Male);
      p.add(Female);
      p.add(Address);
      p.add(IdNumber);
      p.add(Save);
      p.add(Edit);
      label.setVisible(false);
      
      Save.addActionListener(this);
      Edit.addActionListener(this);
      
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
            label.setText("<html>" + customer.toString().replace("\n", "<br>") + "</html>");
            try
            {
               FileWriter fw = new FileWriter(file);
               BufferedWriter bufferedWriter = new BufferedWriter(fw);
               
               fw.write(customer.getName() + "," + customer.getAge() + "," + customer.getGender() + "," + customer.getAddress() + "," + customer.getIdNumber() + "\n");
               bufferedWriter.append(System.getProperty("line.separator"));

               fw.close();
               bufferedWriter.close();

               
            }
         catch(Exception easd)
         {
         
         }
            toggleVisibility(false); 
            label.setVisible(true);
         } else {
            toggleVisibility(true); 
            label.setVisible(false);
         }  
         
                
      }
      
      else if(e.getSource() == Edit){
         toggleVisibility(true); 
         label.setVisible(false);
      }
   }
   private void toggleVisibility(boolean isVisible) {
      Name.setVisible(isVisible);
      Age.setVisible(isVisible);
      GLabel.setVisible(isVisible);
      Male.setVisible(isVisible);
      Female.setVisible(isVisible);
      Address.setVisible(isVisible);
      IdNumber.setVisible(isVisible);
      Save.setVisible(isVisible);
   }
   
}
