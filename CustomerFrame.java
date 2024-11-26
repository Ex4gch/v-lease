import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerFrame extends JFrame implements ActionListener{
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   Customer customer = new Customer();
   
   //Texts
   JTextField Name = new JTextField("Name", 20);
   JTextField Age = new JTextField("Age", 20);
   JTextField Gender = new JTextField("Gender", 20);
   JTextField Address = new JTextField("Address", 20);
   JTextField IdNumber = new JTextField("IdNumber", 20);
   //Buttons
   JButton NameBtn = new JButton("Enter");
   JButton AgeBtn = new JButton("Enter");
   JButton GenderBtn = new JButton("Enter");
   JButton AddressBtn = new JButton("Enter");
   JButton IdNumberBtn = new JButton("Enter");
   
   
   JPanel p = new JPanel();
   
   public CustomerFrame (){
      this.setTitle("V-Lease");
      this.setSize(1000,600);
      this.setLocationRelativeTo(null);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      
      
      
      p.add(Name);
      p.add(NameBtn);
      p.add(Age);
      p.add(AgeBtn);
      p.add(Gender);
      p.add(GenderBtn);
      p.add(Address);
      p.add(AddressBtn);
      p.add(IdNumber);
      p.add(IdNumberBtn);
      
      NameBtn.addActionListener(this);
      AgeBtn.addActionListener(this);
      GenderBtn.addActionListener(this);
      AddressBtn.addActionListener(this);
      IdNumberBtn.addActionListener(this);
      
      p.setBounds(340,200, 300, 137);
      p.setLayout(new FlowLayout(1, 20, 10));
      p.setOpaque(false);
      this.add(p);
   }
   
   public void actionPerformed(ActionEvent e){
      //name btn
      if(e.getSource() == NameBtn){
         customer.setName(Name.getText());
         System.out.print(customer.getName());
      }
      //age btn
      else if(e.getSource() == AgeBtn){
         try{
            customer.setAge(Integer.parseInt(Age.getText()));
            System.out.print(customer.getAge());
         }
         catch(NumberFormatException nfe){
            Age.setText("Please Input A Number");
         }
      }
      //gender btn
      else if(e.getSource() == GenderBtn){
         //customer.setGender(Gender.getText(0));
         System.out.print(customer.getGender());
      }
      //address btn
      else if(e.getSource() == AddressBtn){
         customer.setAddress(Address.getText());
         System.out.print(customer.getAddress());
      }
      //id btn
      else if(e.getSource() == IdNumberBtn){
         try{
            customer.setIdNumber(Integer.parseInt(IdNumber.getText()));
            System.out.print(customer.getIdNumber());
         }
         catch(NumberFormatException nfe){
            IdNumber.setText("Please A Valid License Number");
         }
      }
   }
   
}
