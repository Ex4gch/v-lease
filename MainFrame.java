import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame
{
   ImageIcon logoIcon;
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   JButton vehicleBtn = new JButton("VEHICLES");
   JButton rentBtn = new JButton("RENT");
   JButton returnBtn = new JButton("RETURN");
   JPanel p = new JPanel();
   
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
      
      label.setIcon(new ImageIcon(new ImageIcon("bg2.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
      label.setBounds(0,0, 1000,600);
      
      p.add(vehicleBtn);
      p.add(rentBtn);
      p.add(returnBtn);
      
      p.setBounds(340,200, 300, 137);
      p.setLayout(new FlowLayout(1, 20, 10));
      p.setOpaque(false);
      
      vehicleBtn.setPreferredSize(new Dimension(200, 35));
      rentBtn.setPreferredSize(new Dimension(200, 35));
      returnBtn.setPreferredSize(new Dimension(200, 35));
      vehicleBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
      vehicleBtn.setOpaque(false);
      rentBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
      rentBtn.setOpaque(false);
      returnBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
      returnBtn.setOpaque(false);
      vehicleBtn.setFont(f);
      rentBtn.setFont(f);
      returnBtn.setFont(f);
      vehicleBtn.setFocusable(false);
      rentBtn.setFocusable(false);
      returnBtn.setFocusable(false);
      
      vehicleBtn.setBackground(Color.decode("#d3d3d3"));
      rentBtn.setBackground(Color.decode("#d3d3d3"));
      returnBtn.setBackground(Color.decode("#d3d3d3"));


      this.add(label);
      label.add(p);
      label.add(logo);
      this.setVisible(true);
   }

}