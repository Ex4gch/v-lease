import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.plaf.metal.*;

public class VehiclePanel2 extends JPanel implements ItemListener, ActionListener
{
   ImageIcon img = new ImageIcon("v-Lease3.png");
   Font f = new Font("Berlin Sans FB", 0, 17);
   JLabel label = new JLabel();
   JLabel select = new JLabel("Select");
   JLabel logo = new JLabel();
   JLabel title = new JLabel(" VEHICLES");
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
    
   JButton addBtn = new JButton("ADD VEHICLE");
   JButton cancelBtn = new JButton("CANCEL");
   JButton editBtn = new JButton("EDIT");
   JButton deleteBtn = new JButton("DELETE");
   JButton saveBtn = new JButton("SAVE");
   JButton backBtn = new JButton();
   
   JPanel thisp = this;
   vehicles[] vehi;
   JComboBox<vehicles> cb = new JComboBox<vehicles>();
   
   String vehiclefile = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\vehicles.txt";
   String filename = "C:\\Users\\jennifer\\Desktop\\John's\\java\\swing\\Project\\vehicles.txt";
   
   File file = new File(filename);
   
   public VehiclePanel2()
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
         
            cb.addItem(vehi[i]);
         }
          
         cb.setSelectedIndex(-1);
         bf.close();
      
      }
      catch(Exception e)
      {
      
      }
       
      Border compoundBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.DARK_GRAY);
      
      cb.addItemListener(this);
      cb.setUI(new MetalComboBoxUI());
      cb.setPreferredSize(new Dimension(500,40));
      cb.setBackground(Color.BLACK);
      cb.setForeground(Color.WHITE);
     
      v.setBounds(10,10, 950, 500);
      v.setBackground(Color.BLACK);
      v.setLayout(new BorderLayout(10, 10));
      
      northPanel.add(title);
      northPanel.setPreferredSize(new Dimension(960, 40));
      northPanel.setOpaque(false);
      
      cb.setPreferredSize(new Dimension(90, 20));
      
      innerNorthPanel.setPreferredSize(new Dimension(460, 30));
      innerNorthPanel.add(select);
      innerNorthPanel.add(cb);
      
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
      editBtn.setFocusable(false);
      deleteBtn.setFocusable(false);
      addBtn.setFocusable(false);
      
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
      editBtn.setVisible(false);
      deleteBtn.setVisible(false);
      
      hover(addBtn);
      hover(editBtn);
      hover(cancelBtn);
      hover(saveBtn);
      hover(deleteBtn);
      
      if(cb.getSelectedIndex() != -1)
      {
         editBtn.setVisible(true);
         deleteBtn.setVisible(true);   
      }
      
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
   }

   @Override
   public void itemStateChanged(ItemEvent e)
   {
      vehicles veh = (vehicles)e.getItem();
      
      if(cb.getSelectedIndex() != -1)
      {
         editBtn.setVisible(true);  
         deleteBtn.setVisible(true);   
      }
      
      this.repaint();
      this.revalidate();
      
      if(e.getStateChange() == ItemEvent.DESELECTED)
      {   
         innerCenterPanel.removeAll();
      }  
      
      if(e.getStateChange() == ItemEvent.SELECTED)
      {
         veh = (vehicles)cb.getSelectedItem();
         innerCenterPanel.add(veh.getPanel());
         this.repaint();
         this.revalidate();
      }
        
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == addBtn|| e.getSource() == editBtn)
      {
         VehiclePanel newV = new VehiclePanel("","","","AVAILABLE", new Van());
         JButton addPic = new JButton("ADD PHOTO");
         
         if(e.getSource() == addBtn)
         {
            newV.p1.removeAll();
         }
         else
         {
            vehicles vehi2 = new vehicles();
            try
            {
               BufferedReader bf = new BufferedReader(new FileReader(file));
            
               Object[] lines = bf.lines().toArray();
               
               vehicles vehi1 = (vehicles)cb.getSelectedItem();
               
               for(int i = 0; i < lines.length; i++)
               {
                  String line = lines[i].toString().trim();
                  String[] att = line.split(",");
                  if(att[0].equals(vehi1.getModel()))
                  {
                     newV.Tmodel.setText(att[0]);
                     newV.setImg(att[1]);
                     newV.TplateNumber.setText(att[2]);
                     newV.Tstatus.setSelectedItem(att[3]);
                     newV.Ttype.setSelectedItem(att[4]);
                     newV.Trate.setText(vehi1.getType().getRATE() + "");
                     newV.TpenaltyRate.setText(vehi1.getType().getEXCESSRATE() + "");
                     imgpath = att[1];
                  }
               }
               
               bf.close();
            
            }
            catch(Exception ea)
            {
            
            }
            addPic.setText("CHANGE PHOTO");
            addPic.setFont(new Font("Berlin Sans FB", 1, 20));
            addPic.setForeground(Color.WHITE);
            addPic.setIcon(newV.img);
            addPic.setHorizontalTextPosition(SwingConstants.CENTER);
            addPic.setVerticalTextPosition(SwingConstants.CENTER);
            
         }
         
         String temp = newV.Tmodel.getText();
         innerCenterPanel.removeAll();
         innerSouthPanel.removeAll();
         newV.Tmodel.setEnabled(true);
         newV.TplateNumber.setEnabled(true);
         newV.Tstatus.setEnabled(true);
         newV.Ttype.setEnabled(true);
         newV.Trate.setEnabled(false);
         newV.TpenaltyRate.setEnabled(false);
         
         newV.Ttype.addItemListener(
            new ItemListener()
            {
               @Override
               public void itemStateChanged(ItemEvent ea)
               {
                  Vehicle vw = (Vehicle)newV.Ttype.getSelectedItem();
                  newV.Trate.setText(vw.getRATE() + "");
                  newV.TpenaltyRate.setText(vw.getEXCESSRATE() + "");
                  
               }
            }
            );
         
         
         cb.setEnabled(false);
         innerSouthPanel.add(saveBtn);
         innerSouthPanel.add(cancelBtn);
         innerCenterPanel.add(newV);
         
         saveBtn.addActionListener(
            new ActionListener()
            {
               @Override
               public void actionPerformed(ActionEvent ex)
               {
                  boolean isAllowed = false;
                  
                  if(newV.Tmodel.getText().equals("")) isAllowed = true;
                  else if(newV.TplateNumber.getText().equals("")) isAllowed = true;
                  else if(imgpath.equals("")) isAllowed = true;
                  
                  if(isAllowed)
                  {
                     JOptionPane.showMessageDialog(null,"Wlay Sud imng input waa ka");
                     return;
                  }
                  else
                  {
                     String str =  newV.getSmodel() + "," + imgpath + "," + newV.getSplateNumber() + "," + newV.getSstatus() + "," + newV.getStype();
                     
                     if(e.getSource() == addBtn)
                     {
                        try
                        {
                           BufferedWriter w = new BufferedWriter(new FileWriter(new File(vehiclefile), true));
                           w.write(str, 0, str.length());
                           w.write(System.getProperty("line.separator"));
                           w.close();
                        }
                        catch(Exception e)
                        {
                           
                        }
                     }
                     else
                     {
                        vehicles vehi3 = (vehicles)cb.getSelectedItem();
                        String tempFile = "temp.txt";
                        File oldFile = new File(filename);
                        File newFile = new File(tempFile);
                     
                        String currentLine;
                        String currentName;
                     
                        try
                        {
                           FileWriter w = new FileWriter(tempFile, true);
                           BufferedWriter bf = new BufferedWriter(w);
                           PrintWriter pw = new PrintWriter(bf);
                        
                           FileReader r = new FileReader(filename);
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
                           File dump = new File(filename);
                           newFile.renameTo(dump);
                        
                        }
                        catch(Exception ew)
                        {
                           System.out.println(ew.getMessage());
                        }
                     
                        try
                        {
                           BufferedWriter w = new BufferedWriter(new FileWriter(new File(vehiclefile), true));
                           w.write(str, 0, str.length());
                           w.write(System.getProperty("line.separator"));
                           w.close();
                        }
                        catch(Exception e)
                        {
                           
                        }
                        
                        cb.removeItem(vehi3);
                        cb.setSelectedIndex(-1);
                     
                     }
                     
                     JOptionPane.showMessageDialog(null,"HALA NA SAVE SYA!!");
                     cb.addItem(new vehicles(newV.getSmodel(), imgpath, newV.getSplateNumber(), newV.getSstatus(), newV.getStype()));
                     cb.setSelectedIndex(-1);
                     cb.setEnabled(true);
                     innerCenterPanel.removeAll();
                     innerSouthPanel.removeAll();
                     innerCenterPanel.revalidate();
                     innerCenterPanel.repaint();
                     innerSouthPanel.add(addBtn);
                     innerSouthPanel.add(editBtn);
                     innerSouthPanel.add(deleteBtn);
                     editBtn.setVisible(false);
                     deleteBtn.setVisible(false);
                     cb.revalidate();
                     cb.repaint();
                     thisp.repaint();
                     thisp.revalidate();
                     innerSouthPanel.revalidate(); 
                     innerSouthPanel.repaint();
                     return;
                  }
                  
               }
            
            });
         
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
         newV.p1.add(addPic);
         this.repaint();
         this.revalidate();
         return;
      }
   
      if(e.getSource() == cancelBtn)
      {
         innerCenterPanel.removeAll();
         innerSouthPanel.removeAll();
         innerSouthPanel.add(addBtn); 
         innerSouthPanel.add(editBtn); 
         innerSouthPanel.add(deleteBtn);
         deleteBtn.setVisible(false);
         editBtn.setVisible(false);
         cb.setSelectedIndex(-1);
         cb.setEnabled(true);
         this.revalidate(); 
         this.repaint();
      }
      
      if(e.getSource() == deleteBtn)
      {
         vehicles vehi3 = (vehicles)cb.getSelectedItem();
         String tempFile = "temp.txt";
         File oldFile = new File(filename);
         File newFile = new File(tempFile);
      
         String currentLine;
         String currentName;
      
         try
         {
            FileWriter w = new FileWriter(tempFile, true);
            BufferedWriter bf = new BufferedWriter(w);
            PrintWriter pw = new PrintWriter(bf);
         
            FileReader r = new FileReader(filename);
            BufferedReader br = new BufferedReader(r);
         
            while((currentLine = br.readLine()) != null)
            {
               currentName = currentLine.substring(0, currentLine.indexOf(","));
            
               if(!(currentName.equals(vehi3.getModel())))
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
            File dump = new File(filename);
            newFile.renameTo(dump);
            
            JOptionPane.showMessageDialog(null,"DELETED SUCCESFULLY");
         }
         catch(Exception ew)
         {
            System.out.println(ew.getMessage());
         }
      
         cb.removeItem(vehi3);
         innerCenterPanel.removeAll();
         innerSouthPanel.removeAll();
         innerSouthPanel.add(addBtn); 
         innerSouthPanel.add(editBtn); 
         innerSouthPanel.add(deleteBtn);
         deleteBtn.setVisible(false);
         editBtn.setVisible(false);
         cb.setSelectedIndex(-1);
         cb.setEnabled(true);
         this.revalidate(); 
         this.repaint();
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