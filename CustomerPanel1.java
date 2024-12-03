import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class CustomerPanel1 extends JPanel
{
   String smodel;
   String splateNumber;
   String sstatus;
   String saddress;
   String sidnum;
   String spenaltyrate;
   String simgpath;

   JLabel Lmodel = new JLabel("MODEL: ");
   JLabel LplateNumber = new JLabel("PLATE NUMBER: ");
   JLabel Lstatus = new JLabel("STATUS: ");
   JLabel Ltype = new JLabel("TYPE: ");
   JLabel Lrate = new JLabel("RATE: ");
   JLabel LpenaltyRate = new JLabel("PENALTY RATE: ");
   
   JTextField Tmodel = new JTextField(8);
   JTextField TplateNumber = new JTextField(8);
   JTextField Trate = new JTextField(8);
   JTextField TpenaltyRate = new JTextField(8);
   
   String[] statuses = {"AVAILABLE", "NOT AVAILABLE"};
   Vehicle[] types = {new Van(), new Minivan(), new SUV(), new Sedan(), new Motorcycle()};
   
   JPanel pmodel = new JPanel();
   JPanel pplate = new JPanel();
   JPanel pstatus = new JPanel();
   JPanel ptype = new JPanel();
   JPanel prate = new JPanel();
   JPanel ppenaltyrate = new JPanel();
   
   ImageIcon img = new ImageIcon();
   
   JPanel p1 = new JPanel();
   JLabel l = new JLabel();
   JPanel p2 = new JPanel();
   Font f = new Font("Berlin Sans FB", 0, 22);
   
   public CustomerPanel1(String model, String plateNumber, String status, String address, String idnum, String imgpath)
   {
      this.simgpath = imgpath;
      this.sstatus = status;
      this.saddress = address;
      this.sidnum = idnum;
      this.smodel = model;
      this.splateNumber = plateNumber;
      
      img = new ImageIcon(new ImageIcon(imgpath).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH));
   
      Dimension d = new Dimension(170,25);
      Dimension d2 = new Dimension(10,30);
      Border empborder = BorderFactory.createEmptyBorder(0,10,0,0);
      
      l.setIcon(new ImageIcon(new ImageIcon(imgpath).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH)));
      
      Tmodel.setText(model);
      TplateNumber.setText(plateNumber);
      Tstatus.setText(status);
      Ttype.setText(address);
      Trate.setText(idnum);
      
      p1.setPreferredSize(new Dimension(360,344));
      p1.setLayout(new BorderLayout());
      p2.setPreferredSize(new Dimension(440,344));
      p2.setLayout(new BoxLayout(p2,1));
      
      Tmodel.setPreferredSize(d);
      Tmodel.setFont(f);
      Tmodel.setBorder(empborder);

      pmodel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
      
      Lmodel.setBorder(BorderFactory.createEmptyBorder(0,0,0,90));
      LplateNumber.setBorder(BorderFactory.createEmptyBorder(0,0,0,7));
      Lstatus.setBorder(BorderFactory.createEmptyBorder(0,0,0,90));
      Ltype.setBorder(BorderFactory.createEmptyBorder(0,0,0,110));
      Lrate.setBorder(BorderFactory.createEmptyBorder(0,0,0,110));
      LpenaltyRate.setBorder(BorderFactory.createEmptyBorder(0,0,0,9));
      
      TplateNumber.setBorder(empborder);
      Trate.setBorder(empborder);
      TpenaltyRate.setBorder(empborder);
      
      Tmodel.setBackground(Color.BLACK);
      TplateNumber.setBackground(Color.BLACK);
      Tstatus.setBackground(Color.WHITE);
      Ttype.setBackground(Color.WHITE);
      Trate.setBackground(Color.BLACK);
      TpenaltyRate.setBackground(Color.BLACK);
      
      Tstatus.setFocusable(false);
      Tmodel.setFont(f);
      Tmodel.setForeground(Color.GRAY);
      TplateNumber.setFont(f);
      TplateNumber.setForeground(Color.GRAY);
      Tstatus.setFont(new Font("Berlin Sans FB", 0, 20));
      Tstatus.setForeground(Color.BLACK);
      Ttype.setFont(new Font("Berlin Sans FB", 0, 20));
      Ttype.setForeground(Color.BLACK);
      Trate.setFont(f);
      Trate.setForeground(Color.GRAY);
      TpenaltyRate.setFont(f);
      TpenaltyRate.setForeground(Color.GRAY);
      
      Tmodel.setEnabled(false);
      TplateNumber.setEnabled(false);
      Tstatus.setEnabled(false);
      Ttype.setEnabled(false);
      Trate.setEnabled(false);
      TpenaltyRate.setEnabled(false);
      
      Tstatus.setPreferredSize(new Dimension(170,25));
      TplateNumber.setPreferredSize(d);
      Ttype.setPreferredSize(d);
      Trate.setPreferredSize(d);
      TpenaltyRate.setPreferredSize(d);
      
      pmodel.add(Lmodel);
      pmodel.add(Tmodel);
      pmodel.setBackground(new Color(1, 25, 54));
      pplate.add(LplateNumber);
      pplate.add(TplateNumber);
      pplate.setBackground(new Color(1, 25, 54));
      pstatus.add(Lstatus);
      pstatus.add(Tstatus);
      pstatus.setBackground(new Color(1, 25, 54));
      ptype.add(Ltype);
      ptype.add(Ttype);
      ptype.setBackground(new Color(1, 25, 54));
      prate.add(Lrate);
      prate.add(Trate);
      prate.setBackground(new Color(1, 25, 54));
      ppenaltyrate.add(LpenaltyRate);
      ppenaltyrate.add(TpenaltyRate);
      ppenaltyrate.setBackground(new Color(1, 25, 54));
      
      Lmodel.setFont(f);
      Lmodel.setForeground(Color.WHITE);
      LplateNumber.setFont(f);
      LplateNumber.setForeground(Color.WHITE);
      Lstatus.setFont(f);
      Lstatus.setForeground(Color.WHITE);
      Ltype.setFont(f);
      Ltype.setForeground(Color.WHITE);
      Lrate.setFont(f);
      Lrate.setForeground(Color.WHITE);
      LpenaltyRate.setForeground(Color.WHITE);
      LpenaltyRate.setFont(f);
      
      
      p2.add(pmodel);
      p2.add(pplate);
      p2.add(pstatus);
      p2.add(ptype);
      p2.add(prate);
      p2.add(ppenaltyrate);
      p1.add(l);
      
      this.setOpaque(false);
      l.setOpaque(true);
      this.setPreferredSize(new Dimension(810,370));
      this.setBackground(Color.WHITE);
      
      this.add(p1);
      this.add(p2);

      this.setVisible(true);
   }
      
   public String getSmodel()
   {
      return Tmodel.getText();
   }
   
   public String getSplateNumber()
   {
      return TplateNumber.getText();
   }
   
   public String getSstatus()
   {
      return Tstatus.getSelectedItem().toString();
   }
   
   public Vehicle getStype()
   {
      return this.stype;
   }
   
   public String getSrate()
   {
      return Trate.getText();
   }
   
   public String getSpenaltyRate()
   {
      return TpenaltyRate.getText();
   }
   
   public void setImg(String imgstring)
   {
      img = new ImageIcon(new ImageIcon(imgstring).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH));
   }
}