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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RentPanel2 extends JPanel implements ItemListener, ActionListener
{
   Font f = new Font("Berlin Sans FB", 0, 25);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   JLabel title = new JLabel(" RENT");
   JPanel v = new JPanel();
   JPanel rp = new JPanel();
   JPanel customerPanel = new JPanel();
   JPanel historyPanel = new JPanel();
   JPanel p2 = new JPanel();
   
   JPanel ptitle = new JPanel();
   JButton backBtn = new JButton();
   JLabel Lcustomer = new JLabel("CUSTOMER : ");
   JLabel Lvehicle = new JLabel("VEHICLE : ");
   JLabel Ldays = new JLabel("DAYS : ");
   JButton calcBtn = new JButton("CALCULATE");
   
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
   JComboBox<vehicles> Tvehicle = new JComboBox<>();
   JTextField Tdays = new JTextField(7);
   
   JPanel pcustomer = new JPanel();
   JPanel pvehicle = new JPanel();
   JPanel pdays = new JPanel();
   JPanel pcalc = new JPanel();
   
   JButton confirmBtn = new JButton("CONFIRM");
   
   JPanel pthis = this;
   
   String[] customers = {"JOSHUA", "IVAN", "DANIEL", "LOUIS"};
   
   String str = "                SUMMARY\n";
   String str2 = "";
   String str3 = "";
   
   vehicles[] vehi;
   JComboBox<String> Tcustomer = new JComboBox<>(customers);
   JTextArea jta = new JTextArea(12,15);
   
   double rate = 0;
   
   String vehiclefile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\vehicles.txt";
   String rentfile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\rent.txt";
   File file = new File(vehiclefile);
   public RentPanel2()
   {   
      Border blackline = BorderFactory.createLineBorder(Color.black);
      Border empborder = BorderFactory.createEmptyBorder(0,10,0,0);
      
      ptitle.add(title);
      ptitle.setOpaque(false);
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader(file));
         
         Object[] lines = bf.lines().toArray();
         vehi = new vehicles[lines.length];
         Vehicle vtemp;
         
         int j = 0;
         for(int i = 0; i < lines.length; i++)
         {
            String line = lines[i].toString().trim();
            String[] att = line.split(",");
            
            if(att[3].equals("AVAILABLE"))
            {
               if(att[4].equals("VAN")) vtemp = new Van();
               else if(att[4].equals("SUV")) vtemp = new SUV();
               else if(att[4].equals("MINIVAN")) vtemp = new Minivan();
               else if(att[4].equals("SEDAN")) vtemp = new Sedan();
               else vtemp = new Motorcycle();
               
               vehi[j] = new vehicles(att[0],att[1],att[2],att[3],vtemp);
            
               Tvehicle.addItem(vehi[j]);
               j++;
            }
         }
          
         bf.close();
      
      }
      catch(Exception e)
      {
      
      }
      label.add(backBtn);
      backBtn.setBounds(5,5,40,40);
      backBtn.setIcon(new ImageIcon(new ImageIcon("back.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
      backBtn.setOpaque(false);
      backBtn.setBackground(Color.black);
      backBtn.setFocusable(false);
   
      jta.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
      jta.setFont(new Font("Berlin Sans FB", 0, 22));
      jta.setEnabled(false);
      jta.setBackground(new Color(105,105,105));
      jta.setText(str);
      jta.setForeground(Color.BLACK);
      Dimension d = new Dimension(170,25);
      
      p2.setOpaque(false);
      p2.setLayout(new BoxLayout(p2,1));
      p2.add(pcustomer);
      p2.add(pvehicle);
      p2.add(pdays);
      p2.add(pcalc);
      
      pcalc.setOpaque(false);
      pcalc.add(calcBtn);
      pcustomer.add(Lcustomer);
      pcustomer.add(Tcustomer);
      pvehicle.add(Lvehicle);
      pvehicle.add(Tvehicle);
      pdays.add(Ldays);
      pdays.add(Tdays);
      
      confirmBtn.addActionListener(this);
      calcBtn.addActionListener(this);
      
      pcustomer.setOpaque(false);
      pvehicle.setOpaque(false);
      pdays.setOpaque(false);
      
      calcBtn.setBorder(BorderFactory.createLineBorder(Color.black));
      calcBtn.setPreferredSize(new Dimension(150, 30));
      confirmBtn.setBorder(BorderFactory.createLineBorder(Color.black));
      confirmBtn.setPreferredSize(new Dimension(150, 30));
      calcBtn.setBackground(Color.decode("#d3d3d3"));
      confirmBtn.setBackground(Color.decode("#d3d3d3"));
      
      calcBtn.setFocusable(false);
      confirmBtn.setFocusable(false);
      backBtn.setFocusable(false);
      
      calcBtn.setFont(new Font("Berlin Sans FB", 0, 17));
      confirmBtn.setFont(new Font("Berlin Sans FB", 0, 17));
      
      hover(calcBtn);
      hover(confirmBtn);
      hover(backBtn);
    
      Lcustomer.setFont(f);
      Lvehicle.setFont(f);
      Ldays.setFont(f);
      Lcustomer.setForeground(Color.BLACK);
      Lvehicle.setForeground(Color.BLACK);
      Ldays.setForeground(Color.BLACK);// 
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
      
      Tdays.setEnabled(false);
      
      v.setBounds(10,10, 960, 540);
      v.setBackground(Color.BLACK);
      v.setLayout(new BorderLayout(10, 10));
      
      v.add(ptitle, BorderLayout.NORTH);
      v.setOpaque(false);
      title.setFont(new Font("Berlin Sans FB", 0, 30));
   
      this.setSize(1000,600);
        
      rp.setBounds(20, 50, 940, 460);
      rp.setOpaque(false);  
      
      customerPanel.setBackground(new Color(169,169,169,120));
      customerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
   
      customerPanel.setPreferredSize(new Dimension(430, 430));
      customerPanel.setLayout(null);
      p2.setBounds(0,70, 440,300);
      customerPanel.add(p2);
      
      historyPanel.setOpaque(false);
      historyPanel.setPreferredSize(new Dimension(430, 430));
     
      Tvehicle.setSelectedIndex(-1);
      Tvehicle.setEnabled(false);
      rp.add(customerPanel);  
      rp.add(historyPanel);  
      historyPanel.add(jta); 
      historyPanel.add(confirmBtn);
      Tcustomer.setSelectedIndex(0);
      Tvehicle.addItemListener(this);
        
      label.setIcon(new ImageIcon(new ImageIcon("bg2.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
      label.setBounds(0,0, 1000,600);
   
      this.add(label);
      label.add(v);
      label.add(rp);
   }
   
   @Override
   public void itemStateChanged(ItemEvent e)
   {  
      
      if(e.getSource() == Tcustomer)
      {
         Tvehicle.setEnabled(true);
         if(e.getStateChange() == ItemEvent.SELECTED)
         {
            str += "        -- CUSTOMER INFO --\nNAME: " + Tcustomer.getSelectedItem().toString() + "\n";
            jta.setText(str);
            pthis.repaint();
            pthis.revalidate();
         }
      
         if(e.getStateChange() == ItemEvent.DESELECTED)
         {   
            StringBuilder sb = new StringBuilder(str);
            sb.delete(24, str.length());
            str = sb.toString();
            jta.setText(str);           
         }
         
         str2 = str;
      
      }
      else
      {
         if(e.getStateChange() == ItemEvent.SELECTED)
         {
            vehicles v = (vehicles)Tvehicle.getSelectedItem();
            str += "          -- VEHICLE INFO -- \nMODEL : " + Tvehicle.getSelectedItem().toString() + "\nVEHICLE TYPE : " + v.getType() + "\nRATE : " + v.getType().getRATE() + "0\n";
            jta.setText(str);
            pthis.repaint();
            pthis.revalidate();
            rate = v.getType().getRATE();
            Tdays.setEnabled(true);
            
         }
      
         if(e.getStateChange() == ItemEvent.DESELECTED)
         {   
            StringBuilder sb = new StringBuilder(str);
            sb.delete(str2.length(), str.length());
            str = sb.toString();
            jta.setText(str);           
         }
      
         str3 = str;
      }
      
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      double total = 0;
      try
      {
         int num = Integer.parseInt(Tdays.getText());
      }
      catch(Exception es)
      {
         JOptionPane.showMessageDialog(null, "INVALID INPUT!!");
         Tdays.setText("");
         return;
      }
      
      LocalDate beginDate = LocalDate.now();
      String date = beginDate.format(formatter);
      LocalDate endDate = beginDate.plusDays(Integer.parseInt(Tdays.getText()));
      String date2 = endDate.format(formatter);
            
   
      if(e.getSource() == calcBtn)
      {
         if(Tdays.getText().equals(""))
         {
            JOptionPane.showMessageDialog(null,"ERROR!!");
            return;
         }
      
         
         if(str3.length() != str.length())
         {
            StringBuilder sb = new StringBuilder(str);
            sb.delete(str.length(), str3.length());
            str3 = sb.toString();
         }
      
         total = Double.parseDouble(Tdays.getText()) * rate;
         str3 += "            -- RENT INFO --\nDAYS : " + Tdays.getText() + "\nTOTAL AMOUNT : " + total + "0\n              -- DATE --\n" + date + " - " + date2;
         jta.setText(str3);
      }
      
      if(e.getSource() == confirmBtn)
      {
         if(Tdays.getText().equals(""))
         {
            JOptionPane.showMessageDialog(null, "ERROR!!");
            return;
         }
         
         String cus = Tcustomer.getSelectedItem().toString();
         String veh = Tvehicle.getSelectedItem().toString();
         String days = Tdays.getText();
         double ammount = Double.parseDouble(Tdays.getText()) * rate;
         
         String rentstr =  cus + "," + veh + "," + days + "," + ammount + "," + date2;
                     
         try
         {
            BufferedWriter w = new BufferedWriter(new FileWriter(new File(rentfile), true));
            w.write(rentstr, 0, rentstr.length());
            w.write(System.getProperty("line.separator"));
            w.close();
         }
         catch(Exception ell)
         {
                           
         }
         
         vehicles vehi3 = (vehicles)Tvehicle.getSelectedItem();
         String vehistr =  vehi3.getModel() + "," + vehi3.getImgpath() + "," + vehi3.getPlateNumber() + "," + "NOT AVAILABLE" + "," + vehi3.getType().toString();
         String temp = vehi3.getModel();
         String tempFile = "temp.txt";
         
         File oldFile = new File(vehiclefile);
         File newFile = new File(tempFile);
                     
         String currentLine;
         String currentName;
                     
         try
         {
            FileWriter w = new FileWriter(tempFile, true);
            BufferedWriter bf = new BufferedWriter(w);
            PrintWriter pw = new PrintWriter(bf);
                        
            FileReader r = new FileReader(vehiclefile);
            BufferedReader br = new BufferedReader(r);
                        
            while((currentLine = br.readLine()) != null)
            {
               currentName = currentLine.substring(0, currentLine.indexOf(","));
                           
               if(!(currentName.equals(temp)))
               {
                  pw.println(currentLine); 
               }
            }
                        
            pw.flush();
            pw.close();
            w.close();
            bf.close();
            r.close();
            br.close();
                        
            oldFile.delete();
            File dump = new File(vehiclefile);
            newFile.renameTo(dump);
                        
         }
         catch(Exception ew)
         {
            System.out.println(ew.getMessage());
         }
                     
         try
         {
            BufferedWriter w = new BufferedWriter(new FileWriter(new File(vehiclefile), true));
            w.write(vehistr, 0, vehistr.length());
            w.write(System.getProperty("line.separator"));
            w.close();
         }
         catch(Exception e2)
         {
                           
         }           
         
         jta.setText("");
         Tdays.setText("");
         Tcustomer.setSelectedIndex(-1);
         Tvehicle.setSelectedIndex(-1);
         Tdays.setEnabled(false);
         
         JOptionPane.showMessageDialog(null,"RENT SUCESSFUL");
      
      }
   
   }
   
   public void hover(JButton b)
   {
      b.addMouseListener(
         new MouseAdapter() 
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