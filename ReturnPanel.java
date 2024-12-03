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
import java.nio.file.*;
import java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ReturnPanel extends JPanel implements ItemListener, ActionListener
{
   Font f = new Font("Berlin Sans FB", 0, 25);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   JLabel title = new JLabel("");
   JPanel v = new JPanel();
   JPanel rp = new JPanel();
   JPanel customerPanel = new JPanel();
   JPanel historyPanel = new JPanel();
   JPanel p2 = new JPanel();
   
   JPanel ptitle = new JPanel();
   JButton backBtn = new JButton();
   JButton calcBtn = new JButton("RETURN");
   
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
   
   JScrollPane scrollPane;  
   
   String str = "                SUMMARY\n";
   String str2 = "";
   String str3 = "";
   JTextArea jta = new JTextArea(5,15);
   
   double rate = 0;
   
   String vehiclefile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\vehicles.txt";
   String rentfile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\rent.txt";
   String customerfile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\customer.txt";
   File file = new File(vehiclefile);
   
   String[] customers;
   Return[] rent;
   vehicles[] vehi;
   JComboBox<String> Tcustomer = new JComboBox<String>();
   JComboBox<vehicles> Tvehicle = new JComboBox<vehicles>();
   
   String[] columnNames = { "CUSTOMER", "VEHICLE MODEL", "DUE DATE"};
   DefaultTableModel model = new DefaultTableModel(columnNames, 0);
   JTable table;
   List<Return> rents = loadCustomersFromFile();
   ArrayList<Return> computer = new ArrayList<Return>();
   
   public ReturnPanel()
   {   
      p2.setLayout(new BorderLayout());
      p2.setOpaque(true);
      Border blackline = BorderFactory.createLineBorder(Color.black);
      Border empborder = BorderFactory.createEmptyBorder(0,10,0,0);
         
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader(new File(rentfile)));
         
         Object[] lines = bf.lines().toArray();
         rent = new Return[lines.length];
         
         for(int i = 0; i < lines.length; i++)
         {
            String line = lines[i].toString().trim();
            String[] att = line.split(",");
            rent[i] = new Return(att[0],att[1],att[4]);
            
            computer.add(rent[i]);
         }
         bf.close();
         rents = computer;
      }
      
      catch(Exception e)
      {
      
      }
      
      for(Return cust : rents) {
         model.addRow(new Object[] {
               cust.getCustomer(),
               cust.getVehicle(),
               cust.getDate(),
               });
      }
      
      table = new JTable(model);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
      scrollPane = new JScrollPane(table);
      customerPanel.add(scrollPane, BorderLayout.CENTER);
      calcBtn.setBounds(0,0, 200, 30);
     
      ptitle.add(title);
      ptitle.setOpaque(false);
      
      label.add(backBtn);
      backBtn.setBounds(5,5,40,40);
      backBtn.setIcon(new ImageIcon(new ImageIcon("back.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
      backBtn.setOpaque(false);
      backBtn.setBackground(Color.black);
      backBtn.setFocusable(false);
   
      jta.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      jta.setFont(new Font("Berlin Sans FB", 0, 22));
      jta.setEnabled(false);
      jta.setBackground(new Color(105,105,105));
      jta.setText(str);
      jta.setPreferredSize(new Dimension(900, 200));
      jta.setForeground(Color.BLACK);
      Dimension d = new Dimension(170,25);
      
      p2.setOpaque(false);
      calcBtn.addActionListener(this);
      calcBtn.setBorder(BorderFactory.createLineBorder(Color.black));
      calcBtn.setPreferredSize(new Dimension(150, 30));
      calcBtn.setBackground(Color.decode("#d3d3d3"));
      
      calcBtn.setFocusable(false);
      backBtn.setFocusable(false);
      calcBtn.setFont(new Font("Berlin Sans FB", 0, 17));
      
      hover(calcBtn);
      hover(backBtn);
      
      v.setBounds(10,10, 960, 540);
      v.setBackground(Color.BLACK);
      v.setLayout(new BorderLayout(10, 10));
      
      v.setOpaque(false);
      title.setFont(new Font("Berlin Sans FB", 0, 30));
   
      this.setSize(1000,600);
        
      rp.setLayout(new BorderLayout());
      rp.setBounds(40, 50, 900, 460);
      rp.setOpaque(false);  
      rp.add(ptitle, BorderLayout.NORTH);
      rp.add(calcBtn, BorderLayout.NORTH);
      
      rp.add(scrollPane, BorderLayout.CENTER);  
   
      scrollPane.setPreferredSize(new Dimension(900,600));
      rp.add(jta, BorderLayout.SOUTH); 
        
      label.setIcon(new ImageIcon(new ImageIcon("bg2.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
      label.setBounds(0,0, 1000,600);
   
      this.add(label);
      label.add(v);
      label.add(rp);
   }
   
   @Override
   public void itemStateChanged(ItemEvent e)
   {  
      
     //  if(e.getSource() == Tcustomer)
   //       {
   //          Tvehicle.setEnabled(true);
   //          if(e.getStateChange() == ItemEvent.SELECTED)
   //          {
   //             str += "        -- CUSTOMER INFO --\nNAME: " + Tcustomer.getSelectedItem().toString() + "\n";
   //             jta.setText(str);
   //             pthis.repaint();
   //             pthis.revalidate();
   //          }
   //       
   //          if(e.getStateChange() == ItemEvent.DESELECTED)
   //          {   
   //             StringBuilder sb = new StringBuilder(str);
   //             sb.delete(24, str.length());
   //             str = sb.toString();
   //             jta.setText(str);           
   //          }
   //          
   //          str2 = str;
   //       
   //       }
   //       else
   //       {
   //          if(e.getStateChange() == ItemEvent.SELECTED)
   //          {
   //             vehicles v = (vehicles)Tvehicle.getSelectedItem();
   //             str += "          -- VEHICLE INFO -- \nMODEL : " + Tvehicle.getSelectedItem().toString() + "\nVEHICLE TYPE : " + v.getType() + "\nRATE : " + v.getType().getRATE() + "0\n";
   //             jta.setText(str);
   //             pthis.repaint();
   //             pthis.revalidate();
   //             rate = v.getType().getRATE();
   //             Tdays.setEnabled(true);
   //             
   //          }
   //       
   //          if(e.getStateChange() == ItemEvent.DESELECTED)
   //          {   
   //             StringBuilder sb = new StringBuilder(str);
   //             sb.delete(str2.length(), str.length());
   //             str = sb.toString();
   //             jta.setText(str);           
   //          }
   //       
   //          str3 = str;
   //       }
      
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      str = "                SUMMARY\n";
      String temp =  "";
      LocalDateTime now = LocalDateTime.now();
      String date = now.format(formatter);
      String vehistr ="";
      
      double rate = 0; 
      int selectedRow = table.getSelectedRow();
      if (selectedRow != -1) {
         try
         {
            BufferedReader bf = new BufferedReader(new FileReader(file));
         
            Object[] lines = bf.lines().toArray();
            vehicles vehi = null;
            Vehicle vtemp = null;
            
            for(int i = 0; i < lines.length; i++)
            {
               String line = lines[i].toString().trim();
               String[] att = line.split(",");
               if(att[0].equals(model.getValueAt(selectedRow,1).toString()))
               {
                  if(att[4].equals("VAN")) vtemp = new Van();
                  else if(att[4].equals("SUV")) vtemp = new SUV();
                  else if(att[4].equals("MINIVAN")) vtemp = new Minivan();
                  else if(att[4].equals("SEDAN")) vtemp = new Sedan();
                  else vtemp = new Motorcycle();
                  vehi = new vehicles(att[0],att[1],att[2],att[3],vtemp);
                  
               }
               
               vehistr =  vehi.getModel() + "," + vehi.getImgpath() + "," + vehi.getPlateNumber() + "," + "NOT AVAILABLE" + "," + vehi.getType().toString();

               temp = vehi.getModel();
               rate = vtemp.getEXCESSRATE();
            }
            bf.close();
         }
         catch(Exception se)
         {
         
         }
         
         String paglast = model.getValueAt(selectedRow,2).toString();
         LocalDateTime sauna = LocalDateTime.parse(paglast,formatter);
         
         long kadugayan = ChronoUnit.HOURS.between(sauna,now);
         double hours = kadugayan/3600.0;
         
         double tannan = hours * rate;
         if(hours  > 0)
         {
            str += "  DUE DATE: " + paglast + "\nEXCESS HOURS: " + hours + "\nPENALTY AMOUNT: " + tannan;
            jta.setText(str);
         }
         else
         {
            str += " RETURNED SUCCESSFULL ";
            jta.setText(str);
         }

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
          JOptionPane.showMessageDialog(null,"RENT SUCESSFUL");
      
                        
      } else {
         JOptionPane.showMessageDialog(this, "Please select a Vehicle To Return.");
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
  
   private List<Return> loadCustomersFromFile() {
      List<Return> customers = new ArrayList<>();
      try (BufferedReader br = new BufferedReader(new FileReader(rentfile))) {
         String line;
         while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) {
               Return cust = new Return();
               cust.setCustomer(data[0]);
               cust.setVehicle(data[1]);
               cust.setDate(data[4]);
            }
         }
      } catch (IOException ex) {
         JOptionPane.showMessageDialog(this, "Error reading customer data.", "File Error", JOptionPane.ERROR_MESSAGE);
      }
      return customers;
   }   

}