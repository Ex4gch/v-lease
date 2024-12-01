import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame2 extends JFrame implements ActionListener
{
   CardLayout c = new CardLayout();
   MainPanel m = new MainPanel();   
   Container p = this.getContentPane();
   RentPanel2 r = new RentPanel2();
   
   public MainFrame2()
   {
      this.setTitle("V-Lease");
      this.setSize(1000,600);
      this.setLocationRelativeTo(null);
      this.setLayout(c);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      this.add(m,"a");
      this.add(r,"b");
      
      m.vehicleBtn.addActionListener(this);
      m.rentBtn.addActionListener(this);
      
      this.setVisible(true);
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == m.vehicleBtn)
      {
         VehiclePanel2 v = new VehiclePanel2();
         this.add(v,"b");
         v.backBtn.addActionListener(
            new ActionListener()
            {
               @Override
               public void actionPerformed(ActionEvent ex)
               {
                  c.show(p,"a");
               }
            }
            );
         c.show(p,"b");
      }
      
      if(e.getSource() == m.rentBtn)
      {
         r = new RentPanel2();
         this.add(r,"c");
         r.backBtn.addActionListener(
            new ActionListener()
            {
               @Override
               public void actionPerformed(ActionEvent ex)
               {
                  c.show(p,"a");
               }
            }
            );

         c.show(p,"c");
      }
   }
}