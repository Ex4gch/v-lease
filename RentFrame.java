import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.plaf.metal.MetalComboBoxUI;
import java.time.*;

public class RentFrame extends JFrame implements ItemListener
{
   ImageIcon img = new ImageIcon("v-Lease3.png");
   Font f = new Font("Berlin Sans FB", 0, 25);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   JLabel title = new JLabel(" RENT");
   JPanel v = new JPanel();
   JPanel rp = new JPanel();
   JPanel customerPanel = new JPanel();
   JPanel historyPanel = new JPanel();
   JPanel p2 = new JPanel();
   
   JLabel Lcustomer = new JLabel("CUSTOMER : ");
   JLabel Lvehicle = new JLabel("VEHICLE : ");
   JLabel Ldays = new JLabel("DAYS : ");
   JButton calcBtn = new JButton("CALCULATE");
   JComboBox<vehicles> Tvehicle = new JComboBox<>();
   JTextField Tdays = new JTextField(7);
   
   JPanel pcustomer = new JPanel();
   JPanel pvehicle = new JPanel();
   JPanel pdays = new JPanel();
   JPanel pcalc = new JPanel();
   
   String[] customers = {"JOSHUA", "IVAN", "DANIEL", "LOUIS"};
   
   String str = "RECEIPT: \n";
   
   vehicles[] vehi;
   JComboBox<String> Tcustomer = new JComboBox<>(customers);
   JTextArea jta = new JTextArea(14,15);
   
   String vehiclefile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\vehicles.txt";
   File file = new File(vehiclefile);
   public RentFrame()
   {   
      Border blackline = BorderFactory.createLineBorder(Color.black);
      Border empborder = BorderFactory.createEmptyBorder(0,10,0,0);
      
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader(file));
         
         Object[] lines = bf.lines().toArray();
         vehi = new vehicles[lines.length];
         Vehicle vtemp;
         
         for(int i = 0; i < lines.length; i++)
         {
            String line = lines[i].toString().trim();
            String[] att = line.split(",");
            if(att[4].equals("VAN")) vtemp = new Van();
            else if(att[4].equals("SUV")) vtemp = new SUV();
            else if(att[4].equals("MINIVAN")) vtemp = new Minivan();
            else if(att[4].equals("SEDAN")) vtemp = new Sedan();
            else vtemp = new Motorcycle();
            
            vehi[i] = new vehicles(att[0],att[1],att[2],att[3],vtemp);
         
            Tvehicle.addItem(vehi[i]);
         }
          
         bf.close();
      
      }
      catch(Exception e)
      {
      
      }
   
      
      jta.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
      jta.setFont(new Font("Berlin Sans FB", 0, 22));
      jta.setEnabled(false);
      jta.setBackground(Color.GRAY);
      jta.setText(str);
      Dimension d = new Dimension(170,25);
      
      p2.setLayout(new BoxLayout(p2,1));
      p2.add(pcustomer);
      p2.add(pvehicle);
      p2.add(pdays);
      p2.add(pcalc);
      
      pcalc.add(calcBtn);
      pcustomer.add(Lcustomer);
      pcustomer.add(Tcustomer);
      pvehicle.add(Lvehicle);
      pvehicle.add(Tvehicle);
      pdays.add(Ldays);
      pdays.add(Tdays);
      
      pcustomer.setBackground(new Color(1, 25, 54));
      pvehicle.setBackground(new Color(1, 25, 54));
      pdays.setBackground(new Color(1, 25, 54));
      
      calcBtn.setBorder(BorderFactory.createLineBorder(Color.black));
      calcBtn.setPreferredSize(new Dimension(150, 30));
      
      Lcustomer.setFont(f);
      Lvehicle.setFont(f);
      Ldays.setFont(f);
      Lcustomer.setForeground(Color.WHITE);
      Lvehicle.setForeground(Color.WHITE);
      Ldays.setForeground(Color.WHITE);// 
   //       Lcustomer.setBorder(BorderFactory.createEmptyBorder(0,0,0,90));
      Lvehicle.setBorder(BorderFactory.createEmptyBorder(0,0,0,25));
      Ldays.setBorder(BorderFactory.createEmptyBorder(0,0,0,60));
   //       
      Tcustomer.setPreferredSize(d);
      Ldays.setBackground(Color.RED);
      
      Tcustomer.addItemListener(this);
      
      Tvehicle.setFont(new Font("Berlin Sans FB", 0, 22));
      Tcustomer.setFont(new Font("Berlin Sans FB", 0, 22));
      Tvehicle.setPreferredSize(d);
      Tdays.setPreferredSize(d);
      Tdays.setBorder(empborder);
      Tdays.setFont(f);
      
      v.setBounds(10,10, 960, 540);
      v.setBackground(Color.BLACK);
      v.setLayout(new BorderLayout(10, 10));
      
      v.add(title, BorderLayout.NORTH);
      v.setOpaque(false);
      title.setFont(new Font("Berlin Sans FB", 0, 30));
   
      this.setTitle("V-Lease");
      this.setSize(1000,600);
      this.setLocationRelativeTo(null);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      this.setIconImage(img.getImage());
      this.setResizable(false);
        
      rp.setBounds(20, 50, 940, 460);
      rp.setBackground(Color.BLUE);  
      
      customerPanel.setBackground(Color.WHITE);
      customerPanel.setPreferredSize(new Dimension(430, 400));
      customerPanel.setLayout(null);
      p2.setBounds(0,50, 440,300);
      customerPanel.add(p2);
      
      historyPanel.setBackground(Color.BLACK);
      historyPanel.setPreferredSize(new Dimension(430, 430));
     
      rp.add(customerPanel);  
      rp.add(historyPanel);  
      historyPanel.add(jta); 
      Tcustomer.setSelectedIndex(0);
        
      label.setIcon(new ImageIcon(new ImageIcon("bg2.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
      label.setBounds(0,0, 1000,600);
   
      this.add(label);
      label.add(v);
      label.add(rp);
   }
   
   @Override
   public void itemStateChanged(ItemEvent e)
   {  
      String temp = Tcustomer.getSelectedItem().toString();
      if(e.getStateChange() == ItemEvent.SELECTED)
      {
         str += Tcustomer.getSelectedItem().toString() + "\n";
         jta.setText(str);
         this.repaint();
         this.revalidate();
      }
      
      if(e.getStateChange() == ItemEvent.DESELECTED)
      {   
         StringBuilder sb = new StringBuilder(str);
         sb.delete(10, str.length());
         str = sb.toString();
         jta.setText(str);           
      }
      
   }

}