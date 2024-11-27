import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerOptionFrame extends JFrame implements ActionListener{
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   
   
   //Buttons
   JButton New = new JButton("New Customer");
   JButton Edit = new JButton("Edit Customer");
   JButton Remove = new JButton("Remove Customer");
   
   JPanel p = new JPanel();
   
   public CustomerOptionFrame (){
      this.setTitle("V-Lease");
      this.setSize(1000,600);
      this.setLocationRelativeTo(null);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
      
      label.setText("<html>V-Lease Customer Management Section<br></html>");
      p.add(label);
      p.add(New);
      p.add(Edit);
      p.add(Remove);
      
      New.addActionListener(this);
      Edit.addActionListener(this);
      Remove.addActionListener(this);
      
      p.setBounds(340,200, 300, 137);
      p.setLayout(new FlowLayout(1, 20, 10));
      p.setOpaque(false);
      this.add(p);
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == New){
         CustomerFrame cf = new CustomerFrame();
         cf.setVisible(true);
         
         
      }
   }
   
   
}
