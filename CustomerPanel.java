import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.plaf.metal.*;
import java.nio.file.*;
import java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CustomerPanel extends JPanel implements ActionListener
{
   ImageIcon img = new ImageIcon("v-Lease3.png");
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel logo = new JLabel();
   JLabel title = new JLabel(" CUSTOMER");
   String imgpath = "";
   JPanel v = new JPanel();
   JPanel p1 = new JPanel();
   JPanel northPanel = new JPanel();
   JPanel innerNorthPanel = new JPanel();
   JPanel centerPanel = new JPanel();
   JPanel innerCenterPanel = new JPanel();
   JPanel innerSouthPanel = new JPanel();
   JPanel innerWestPanel = new JPanel();
   JPanel innerEastPanel = new JPanel();
    
   JButton addBtn = new JButton("ADD CUSTOMER");
   JButton cancelBtn = new JButton("CANCEL");
   JButton editBtn = new JButton("EDIT");
   JButton deleteBtn = new JButton("DELETE");
   JButton saveBtn = new JButton("SAVE");
   JButton backBtn = new JButton();
  
   JPanel thisp = this;
   
   
   JScrollPane scrollPane;
   
   String vehiclefile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\vehicles.txt";
   String filename = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\customer.txt";
   
   String[] columnNames = { "NAME", "AGE", "GENDER", "ADDRESS", "ID NUMBER", "IMAGE" };
   
   DefaultTableModel model = new DefaultTableModel(columnNames, 0);
   JTable table;

   Customer[] cus;
   Customer customerTemp = new Customer();
   File file = new File(filename);
   
   List<Customer> customers = loadCustomersFromFile();
   ArrayList<Customer> customer = new ArrayList<Customer>();
   
   public CustomerPanel()
   {        
      
      Border blackline = BorderFactory.createLineBorder(Color.black);
      
      backBtn.addActionListener(this);
      label.add(backBtn);
      backBtn.setBounds(5,5,40,40);
      backBtn.setIcon(new ImageIcon(new ImageIcon("back.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
      backBtn.setOpaque(false);
      backBtn.setBackground(Color.black);
      backBtn.setFocusable(false);
      backBtn.setBorder(BorderFactory.createEmptyBorder());
      
      innerCenterPanel.setLayout(new BorderLayout());     
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader(file));
         
         Object[] lines = bf.lines().toArray();
         cus = new Customer[lines.length];
         
         for(int i = 0; i < lines.length; i++)
         {
            String line = lines[i].toString().trim();
            String[] att = line.split(",");
            cus[i] = new Customer(att[0],att[1],att[2],att[3],att[4],att[5]);
            customer.add(cus[i]);
         }
         bf.close();
         customers = customer;
      }
      
      catch(Exception e)
      {
      
      }
      for (Customer cust : customers) {
         model.addRow(new Object[] {
               cust.getName(),
               cust.getAge(),
               cust.getGender(),
               cust.getAddress(),
               cust.getIdNumber(),
               cust.getImg()
               });
      }
      
      table = new JTable(model);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
      scrollPane = new JScrollPane(table);
      innerCenterPanel.add(scrollPane, BorderLayout.CENTER);
      
      Border compoundBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.DARK_GRAY);
      v.setBounds(10,10, 950, 500);
      v.setBackground(Color.BLACK);
      v.setLayout(new BorderLayout(10, 10));
      
      northPanel.add(title);
      northPanel.setPreferredSize(new Dimension(960, 40));
      northPanel.setOpaque(false);
      
      innerNorthPanel.setPreferredSize(new Dimension(460, 30));
      
      centerPanel.setPreferredSize(new Dimension(460, 20));
      centerPanel.setOpaque(false);
      centerPanel.setLayout(new BorderLayout());
      
      innerCenterPanel.setBorder(compoundBorder);
      innerSouthPanel.setPreferredSize(new Dimension(900, 50));
      
      innerWestPanel.setPreferredSize(new Dimension(50, 1));
      innerEastPanel.setPreferredSize(new Dimension(50, 1));
      
      innerNorthPanel.setOpaque(false);
      innerCenterPanel.setOpaque(false);
      innerSouthPanel.setOpaque(false);
      innerWestPanel.setOpaque(false);
      innerEastPanel.setOpaque(false);
      
      innerSouthPanel.add(addBtn);
      
      addBtn.addActionListener(this);
      cancelBtn.addActionListener(this);
      editBtn.addActionListener(this);
      deleteBtn.addActionListener(this);
      
      addBtn.setPreferredSize(new Dimension(150, 30));
      cancelBtn.setPreferredSize(new Dimension(150, 30));
      editBtn.setPreferredSize(new Dimension(150, 30));
      deleteBtn.setPreferredSize(new Dimension(150, 30));
      saveBtn.setPreferredSize(new Dimension(150, 30));
      
      addBtn.setBackground(Color.decode("#d3d3d3"));
      cancelBtn.setBackground(Color.decode("#d3d3d3"));
      editBtn.setBackground(Color.decode("#d3d3d3"));
      deleteBtn.setBackground(Color.decode("#d3d3d3"));
      addBtn.setBackground(Color.decode("#d3d3d3"));
      saveBtn.setBackground(Color.decode("#d3d3d3"));
      
      cancelBtn.setFocusable(false);
      editBtn.setFocusable(true);
      deleteBtn.setFocusable(true);
      addBtn.setFocusable(true);
      
      addBtn.setBorder(blackline);
      cancelBtn.setBorder(blackline);
      editBtn.setBorder(blackline);
      deleteBtn.setBorder(blackline);
      saveBtn.setBorder(blackline);
      
      addBtn.setFont(f);
      cancelBtn.setFont(f);
      editBtn.setFont(f);
      deleteBtn.setFont(f);
      saveBtn.setFont(f);
        
      innerSouthPanel.add(editBtn);
      innerSouthPanel.add(deleteBtn);
      
      hover(addBtn);
      hover(editBtn);
      hover(cancelBtn);
      hover(saveBtn);
      hover(deleteBtn);
      
      centerPanel.add(innerNorthPanel, BorderLayout.NORTH);
      centerPanel.add(innerCenterPanel, BorderLayout.CENTER);
      centerPanel.add(innerSouthPanel, BorderLayout.SOUTH);
      centerPanel.add(innerWestPanel, BorderLayout.WEST);
      centerPanel.add(innerEastPanel, BorderLayout.EAST);
      
      v.add(northPanel, BorderLayout.NORTH);
      v.add(centerPanel, BorderLayout.CENTER);
      v.setOpaque(false);
      title.setFont(new Font("Berlin Sans FB", 0, 30));
   
      this.setSize(1000,600);
        
      logo.setIcon(new ImageIcon(new ImageIcon("carbg.png").getImage().getScaledInstance(700 , 400, Image.SCALE_SMOOTH)));
      logo.setBounds(100, 900, 700, 400);
   
      label.setIcon(new ImageIcon(new ImageIcon("bg2.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
      label.setBounds(0,0, 1000,600);
      label.add(logo);
   
      this.add(label);
      label.add(v);
      this.setVisible(true);
   }
   
   static int selectedRow;
   CustomerPanel2 newV;
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      JButton addPic = new JButton("ADD PHOTO");
      if(e.getSource() == addBtn )
      {
         
         innerCenterPanel.removeAll();
         newV = new CustomerPanel2("","","","","","");
         innerCenterPanel.add(newV);
         innerSouthPanel.removeAll();
         innerSouthPanel.add(saveBtn);
         innerSouthPanel.add(cancelBtn);
         newV.Tmodel.setEnabled(true);
         newV.TplateNumber.setEnabled(true);
         newV.Trate.setEnabled(true);
         newV.TpenaltyRate.setEnabled(true);
         newV.Tstatus.setEnabled(true);
      
         this.revalidate();
         this.repaint();
         
         saveBtn.addActionListener(
            new ActionListener()
            {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                  boolean valid = true;
                  String img;
                  int count = 0;
                  try
                  {
                     int num = Integer.parseInt(newV.TplateNumber.getText());
                     
                     if(newV.Tmodel.getText().toString().equals("") || newV.Trate.getText().toString().equals("") || imgpath.equals(""))
                     {
                        throw new ArithmeticException();
                     }
                     
                     if(num < 17 || num > 85)
                     {
                        throw new NumberFormatException();
                     }
                     
                     customerTemp.setName(newV.Tmodel.getText().toString());
                     customerTemp.setAge(newV.TplateNumber.getText().toString());
                  }
                  catch(ArithmeticException ae){
                     JOptionPane.showMessageDialog(null, "Please Input All Details");
                     valid = false;
                     return;
                  }
                  catch(NumberFormatException nfe){
                     JOptionPane.showMessageDialog(null, "Please Enter A Number");
                     valid = false;
                     return;
                  }
               
                  if(newV.male.isSelected()){
                     customerTemp.setGender("MALE");
                  }            
                  else if(newV.female.isSelected()){
                     customerTemp.setGender("FEMALE");
                  }
                  else{
                     valid = false;
                  }
                  
                  customerTemp.setAddress(newV.Trate.getText().toString());
               
                  try{
                     int num = Integer.parseInt(newV.TpenaltyRate.getText());
                     if (num <= 0) {
                        throw new NumberFormatException();
                     }
                     
                     customerTemp.setIdNumber(newV.TpenaltyRate.getText().toString());
                  }
                  catch(NumberFormatException nfe){
                     JOptionPane.showMessageDialog(null, "Please Enter A Valid License Number");
                        
                     saveBtn.removeActionListener(this);
                     valid = false;
                  }
                  
                  customerTemp.setImg(imgpath);
                  String genderTemp = "";
                  
                  if (valid) {
                     try {
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fw);
                        
                        
                        if(newV.male.isSelected()) genderTemp = "MALE";
                        else genderTemp = "FEMALE";
                        
                        fw.write(newV.Tmodel.getText().toString() + "," + newV.TplateNumber.getText().toString() + "," + genderTemp + "," + newV.Trate.getText().toString() + "," + newV.TpenaltyRate.getText().toString() + "," + imgpath + "\n");
                        bufferedWriter.append(System.getProperty("line.separator"));
                     
                        fw.close();
                        bufferedWriter.close();
                     
                     }
                     catch(Exception easd){
                     
                     }            
                  
                  } 
                  
                  
                  JOptionPane.showMessageDialog(null,"HALA NA SAVE SYA!!");
                  innerCenterPanel.removeAll();
                  innerSouthPanel.removeAll();
                  
                  model.setRowCount(0);
                  customers = loadCustomersFromFile();
                  
                  for (Customer cust : customers) {
                     model.addRow(new Object[] {
                        cust.getName(),
                        cust.getAge(),
                        cust.getGender(),
                        cust.getAddress(),
                        cust.getIdNumber(),
                        cust.getImg()
                        });
                  }
                  innerCenterPanel.add(scrollPane, BorderLayout.CENTER);
                  innerCenterPanel.revalidate();
                  innerCenterPanel.repaint();
                  table.revalidate();
                  innerSouthPanel.add(addBtn);
                  innerSouthPanel.add(editBtn);
                  innerSouthPanel.add(deleteBtn);
                  innerSouthPanel.revalidate(); 
                  innerSouthPanel.repaint();   
                  saveBtn.removeActionListener(this);
                  return;   
               }   
            }
            
            );      
         newV.p1.add(addPic);    
         this.revalidate();
         this.repaint();    
         addPic.addActionListener(
            new ActionListener()
            {
               @Override
               public void actionPerformed(ActionEvent ex)
               {
                  JFileChooser fileChooser = new JFileChooser();
                  fileChooser.setCurrentDirectory(new File("C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project"));
                  
                  int result = fileChooser.showOpenDialog(getParent());
                  if (result == JFileChooser.APPROVE_OPTION) 
                  {
                     try 
                     {
                        File file = fileChooser.getSelectedFile();
                        BufferedImage picture = ImageIO.read(file);
                        imgpath = file.getName();
                        
                        newV.l.setIcon(new ImageIcon(new ImageIcon(picture).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH)));
                        newV.p1.removeAll();
                        newV.p1.add(newV.l);
                        newV.p1.revalidate();
                     } 
                     catch (Exception ioe) 
                     {
                        JOptionPane.showMessageDialog(null, "ERROR");
                     }
                  }
               
               }
            });    
      }
      
      if(e.getSource() == cancelBtn)
      {
         innerCenterPanel.removeAll();
         innerCenterPanel.add(scrollPane, BorderLayout.CENTER);
         innerSouthPanel.removeAll();
         innerSouthPanel.add(addBtn);
         innerSouthPanel.add(editBtn);
         innerSouthPanel.add(deleteBtn);
         this.revalidate();
         this.repaint();
      }
      
      if(e.getSource() == editBtn)
      {
         newV = new CustomerPanel2("","","","","","");
      
         innerCenterPanel.removeAll();
         innerSouthPanel.removeAll();
         innerSouthPanel.add(saveBtn);
         innerSouthPanel.add(cancelBtn);
         this.revalidate();
         this.repaint();
      }
      
      if(e.getSource() == deleteBtn)
      {
         int selectedRow = table.getSelectedRow();
         if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this customer?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
               customers.remove(selectedRow);
               updateCustomerFile(customers);
               model.removeRow(selectedRow); 
               JOptionPane.showMessageDialog(this, "Customer deleted successfully.");
            }
         } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to delete.");
         }
      
      }
      
      if(e.getSource() == editBtn)
      {
         innerCenterPanel.removeAll();
         int selectedRow = table.getSelectedRow();
         if (selectedRow != -1) 
         {
            String name = model.getValueAt(selectedRow, 0).toString();
            String age = model.getValueAt(selectedRow, 1).toString();
            String gender = model.getValueAt(selectedRow, 2).toString();
            String address = model.getValueAt(selectedRow, 3).toString();
            String idNumber = model.getValueAt(selectedRow, 4).toString();
            String img = model.getValueAt(selectedRow, 5).toString();  
            newV = new CustomerPanel2(name,age,gender,address,idNumber,img);   
            innerCenterPanel.add(newV);
            innerSouthPanel.removeAll();
            innerSouthPanel.add(saveBtn);
            innerSouthPanel.add(cancelBtn);
            newV.Tmodel.setEnabled(true);
            newV.TplateNumber.setEnabled(true);
            newV.Trate.setEnabled(true);
            newV.TpenaltyRate.setEnabled(true);
            newV.Tstatus.setEnabled(true);
         
            customers.remove(selectedRow);
            updateCustomerFile(customers);
            model.removeRow(selectedRow);
            this.revalidate();
            this.repaint();
         
            saveBtn.addActionListener(
               new ActionListener()
               {
                  @Override
                  public void actionPerformed(ActionEvent e)
                  {
                     boolean valid = true;
                     String img;
                     int count = 0;
                     try
                     {
                        int num = Integer.parseInt(newV.TplateNumber.getText());
                     
                        if(newV.Tmodel.getText().toString().equals("") || newV.Trate.getText().toString().equals("") || imgpath.equals(""))
                        {
                           throw new ArithmeticException();
                        }
                     
                        if(num < 17 || num > 85)
                        {
                           throw new NumberFormatException();
                        }
                     
                     }
                     catch(ArithmeticException ae){
                        JOptionPane.showMessageDialog(null, "Please Input All Details");
                        valid = false;
                        return;
                     }
                     catch(NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Please Enter A Number");
                        valid = false;
                        return;
                     }
                  
                     try
                     {
                        int num = Integer.parseInt(newV.TpenaltyRate.getText());
                        if (num <= 0) {
                           throw new NumberFormatException();
                        }
                     }
                     catch(NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Please Enter A Valid License Number");
                        valid = false;
                     }
                  
                     String genderTemp = "";
                  
                     if (valid) {
                        try {
                           FileWriter fw = new FileWriter(file, true);
                           BufferedWriter bufferedWriter = new BufferedWriter(fw);
                        
                        
                           if(newV.male.isSelected()) genderTemp = "MALE";
                           else genderTemp = "FEMALE";
                        
                           fw.write(newV.Tmodel.getText().toString() + "," + newV.TplateNumber.getText().toString() + "," + genderTemp + "," + newV.Trate.getText().toString() + "," + newV.TpenaltyRate.getText().toString() + "," + imgpath + "\n");
                           bufferedWriter.append(System.getProperty("line.separator"));
                        
                           fw.close();
                           bufferedWriter.close();
                        
                        }
                        catch(Exception easd){
                        
                        }            
                     
                     } 
                     JOptionPane.showMessageDialog(null,"HALA NA SAVE SYA!!");
                     innerCenterPanel.removeAll();
                     innerSouthPanel.removeAll();
                  
                     model.setRowCount(0);
                     customers = loadCustomersFromFile();
                  
                     for (Customer cust : customers) {
                        model.addRow(new Object[] {
                           cust.getName(),
                           cust.getAge(),
                           cust.getGender(),
                           cust.getAddress(),
                           cust.getIdNumber(),
                           cust.getImg()
                           });
                     }
                     innerCenterPanel.add(scrollPane, BorderLayout.CENTER);
                     innerCenterPanel.revalidate();
                     innerCenterPanel.repaint();
                     table.revalidate();
                     innerSouthPanel.add(addBtn);
                     innerSouthPanel.add(editBtn);
                     innerSouthPanel.add(deleteBtn);
                     innerSouthPanel.revalidate(); 
                     innerSouthPanel.repaint();   
                     saveBtn.removeActionListener(this);
                     return;   
                  }   
               }
               
               );      
            newV.p1.add(addPic);  
            addPic.setText("CHANGE PHOTO");
            addPic.setFont(new Font("Berlin Sans FB", 1, 20));
            addPic.setForeground(Color.WHITE);
            addPic.setIcon(newV.img);
            addPic.setHorizontalTextPosition(SwingConstants.CENTER);
            addPic.setVerticalTextPosition(SwingConstants.CENTER);  
            this.revalidate();
            this.repaint();    
         
            addPic.addActionListener(
               new ActionListener()
               {
                  @Override
                  public void actionPerformed(ActionEvent ex)
                  {
                     JFileChooser fileChooser = new JFileChooser();
                     fileChooser.setCurrentDirectory(new File("C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project"));
                  
                     int result = fileChooser.showOpenDialog(getParent());
                     if (result == JFileChooser.APPROVE_OPTION) 
                     {
                        try 
                        {
                           File file = fileChooser.getSelectedFile();
                           BufferedImage picture = ImageIO.read(file);
                           imgpath = file.getName();
                        
                           newV.l.setIcon(new ImageIcon(new ImageIcon(picture).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH)));
                           newV.p1.removeAll();
                           newV.p1.add(newV.l);
                           newV.p1.revalidate();
                        } 
                        catch (Exception ioe) 
                        {
                           JOptionPane.showMessageDialog(null, "ERROR");
                        }
                     }
                  
                  }
               });    
         }
         else {
            JOptionPane.showMessageDialog(this, "Please select a customer to edit.");
         }  
      }
      
      if(e.getSource() == cancelBtn)
      {
         innerCenterPanel.removeAll();
         innerCenterPanel.add(scrollPane, BorderLayout.CENTER);
         innerSouthPanel.removeAll();
         innerSouthPanel.add(addBtn);
         innerSouthPanel.add(editBtn);
         innerSouthPanel.add(deleteBtn);
         this.revalidate();
         this.repaint();
            
         customers.remove(selectedRow);
         updateCustomerFile(customers);
         model.removeRow(selectedRow); 
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
   
   protected void updateCustomerFile(List<Customer> customers) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
         for (Customer cust : customers) {
            writer.write(String.format("%s,%s,%s,%s,%s,%s%n",
                   cust.getName(),
                   cust.getAge(),
                   cust.getGender(),
                   cust.getAddress(),
                   cust.getIdNumber(),
                   cust.getImg()
               ));
         }
      } catch (IOException ex) {
         JOptionPane.showMessageDialog(this, "Error updating customer data.", "File Error", JOptionPane.ERROR_MESSAGE);
      }
   }
   
   private List<Customer> loadCustomersFromFile() {
      List<Customer> customers = new ArrayList<>();
      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
         String line;
         while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 6) {
               Customer cust = new Customer();
               cust.setName(data[0]);
               cust.setAge(data[1]);
               cust.setGender(data[2]);
               cust.setAddress(data[3]);
               cust.setIdNumber(data[4]);
               cust.setImg(data[5]);
               customers.add(cust);
            }
         }
      } catch (IOException ex) {
         JOptionPane.showMessageDialog(this, "Error reading customer data.", "File Error", JOptionPane.ERROR_MESSAGE);
      }
      return customers;
   }   

}