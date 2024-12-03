import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener
{
   ImageIcon img = new ImageIcon("v-Lease3.png");
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   JButton vehicleBtn = new JButton("VEHICLES");
   JButton rentBtn = new JButton("RENT");
   JButton returnBtn = new JButton("RETURN");
   JButton customerBtn = new JButton("CUSTOMER");
   JPanel p = new JPanel();
   
   VehicleFrame vf = new VehicleFrame();
   RentFrame rf = new RentFrame();
      
   public MainFrame()
   {   
      
      Border blackline = BorderFactory.createLineBorder(Color.black);
   
      this.setTitle("V-Lease");
      this.setSize(1000,600);
      this.setLocationRelativeTo(null);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      
      logo.setIcon(new ImageIcon(new ImageIcon("v-Lease2.png").getImage().getScaledInstance(200 , 200, Image.SCALE_SMOOTH)));
      logo.setBounds(390, 20, 200, 200);      
      
      this.setIconImage(img.getImage());
      this.setResizable(false);
      
      label.setIcon(new ImageIcon(new ImageIcon("bg2.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
      label.setBounds(0,0, 1000,600);
     
      p.add(vehicleBtn);
      p.add(rentBtn);
      p.add(returnBtn);
      p.add(customerBtn);
      
      p.setBounds(340,220, 300, 200);
      p.setLayout(new FlowLayout(1, 20, 10));
      p.setOpaque(false);
      
      vehicleBtn.setPreferredSize(new Dimension(200, 35));
      rentBtn.setPreferredSize(new Dimension(200, 35));
      returnBtn.setPreferredSize(new Dimension(200, 35));
      vehicleBtn.setBorder(blackline);
      rentBtn.setBorder(blackline);
      returnBtn.setBorder(blackline);
      vehicleBtn.setFont(f);
      rentBtn.setFont(f);
      returnBtn.setFont(f);
      vehicleBtn.setFocusable(false);
      rentBtn.setFocusable(false);
      returnBtn.setFocusable(false);
      
      customerBtn.setPreferredSize(new Dimension(200, 35));
      customerBtn.setBorder(blackline);
      customerBtn.setFont(f);
      customerBtn.setFocusable(false);
      customerBtn.addActionListener(this);
      customerBtn.setBackground(Color.decode("#d3d3d3"));
      
      vehicleBtn.addActionListener(this);
      rentBtn.addActionListener(this);
      
      hover(vehicleBtn);
      hover(rentBtn);
      hover(returnBtn);
      hover(customerBtn);
      
      vehicleBtn.setBackground(Color.decode("#d3d3d3"));
      rentBtn.setBackground(Color.decode("#d3d3d3"));
      returnBtn.setBackground(Color.decode("#d3d3d3"));
   
      this.add(label);
      label.add(p);
      label.add(logo);
      this.setVisible(false);
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == vehicleBtn)
      {
         vf.setVisible(true);
         this.dispose();
         
      }
      
      if(e.getSource() == rentBtn)
      {
         this.dispose();
         rf.setVisible(true);
         
      }
   }
   
   public void hover(JButton b)
   {
      b.addMouseListener(new MouseAdapter() 
      {
         @Override
         public void mouseEntered(MouseEvent e) 
         {
            b.setBackground(Color.decode("#223947"));
            b.setForeground(Color.WHITE); 
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));        
         }
      
         @Override
         public void mouseExited(MouseEvent e) 
         {
            b.setBackground(Color.decode("#d3d3d3")); 
            b.setForeground(Color.BLACK); 
         }
      });
   }

}
