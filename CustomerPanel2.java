import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class CustomerPanel2 extends JPanel
{
   String smodel;
   String splateNumber;
   String sstatus;
   String srate;
   String spenaltyrate;
   String simgpath;

   JLabel Lmodel = new JLabel("NAME : ");
   JLabel LplateNumber = new JLabel("AGE : ");
   JLabel Lstatus = new JLabel("GENDER : ");
   JLabel Ltype = new JLabel("ADDRESS :");
   JLabel Lrate = new JLabel("ID NUMBER :");
   
   JCheckBox male = new JCheckBox("MALE");
   JCheckBox female = new JCheckBox("FEMALE");
   ButtonGroup gender = new ButtonGroup();
   
   JTextField Tmodel = new JTextField(8);
   JTextField TplateNumber = new JTextField(8);
   JTextField Trate = new JTextField(8);
   JTextField TpenaltyRate = new JTextField(8);

   JTextField Tstatus = new JTextField(10);
   
   JPanel pmodel = new JPanel();
   JPanel pplate = new JPanel();
   JPanel pstatus = new JPanel();
   JPanel ptype = new JPanel();
   JPanel prate = new JPanel();
   
   ImageIcon img = new ImageIcon();
   
   JPanel p1 = new JPanel();
   JLabel l = new JLabel();
   JPanel p2 = new JPanel();
   Font f = new Font("Berlin Sans FB", 0, 22);
   
   public CustomerPanel2(String model, String plateNumber,String status, String address, String idnum, String imgpath)
   {
      gender.add(male);
      gender.add(female);
   
      this.simgpath = imgpath;
      this.sstatus = status.equals("FEMALE")? "FEMALE": "MALE";
      this.smodel = model;
      this.splateNumber = plateNumber;
      this.srate = address;
      this.spenaltyrate = idnum;
      
      if(status.equals("FEMALE")) female.setSelected(true);
      else male.setSelected(true);
      
      img = new ImageIcon(new ImageIcon(imgpath).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH));
   
      Dimension d = new Dimension(170,25);
      Dimension d2 = new Dimension(10,30);
      Border empborder = BorderFactory.createEmptyBorder(0,10,0,0);
      
      l.setIcon(new ImageIcon(new ImageIcon(imgpath).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH)));
      
      Tmodel.setText(model);
      TplateNumber.setText(plateNumber);
      Tstatus.setText(status);
      Trate.setText(address);
      TpenaltyRate.setText(idnum);

      p1.setPreferredSize(new Dimension(360,344));
      p1.setLayout(new BorderLayout());
      p2.setPreferredSize(new Dimension(440,344));
      p2.setLayout(new BoxLayout(p2,1));
      
      Tmodel.setPreferredSize(d);
      Tmodel.setFont(f);
      Tmodel.setBorder(empborder);
      Trate.setBorder(empborder);

      pmodel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
      
      Lmodel.setBorder(BorderFactory.createEmptyBorder(0,0,0,90));
      LplateNumber.setBorder(BorderFactory.createEmptyBorder(0,0,0,110));
      Lstatus.setBorder(BorderFactory.createEmptyBorder(0,0,0,70));
      Ltype.setBorder(BorderFactory.createEmptyBorder(0,0,0,70));
      Lrate.setBorder(BorderFactory.createEmptyBorder(0,0,0,60));
      
      TplateNumber.setBorder(empborder);
      Trate.setBorder(empborder);
      TpenaltyRate.setBorder(empborder);
      
      Tmodel.setBackground(Color.BLACK);
      TplateNumber.setBackground(Color.BLACK);
      Tstatus.setBackground(Color.WHITE);
      Trate.setBackground(Color.BLACK);
      Trate.setBackground(Color.BLACK);
      TpenaltyRate.setBackground(Color.BLACK);
      
      Tstatus.setFocusable(false);
      Tmodel.setFont(f);
      Tmodel.setForeground(Color.GRAY);
      TplateNumber.setFont(f);
      TplateNumber.setForeground(Color.GRAY);
      Tstatus.setFont(new Font("Berlin Sans FB", 0, 20));
      Tstatus.setForeground(Color.WHITE);
      Trate.setFont(new Font("Berlin Sans FB", 0, 20));
      Trate.setForeground(Color.GRAY);
      Trate.setFont(f);
      Trate.setForeground(Color.GRAY);
      TpenaltyRate.setFont(f);
      TpenaltyRate.setForeground(Color.GRAY);
      
      Tmodel.setEnabled(false);
      TplateNumber.setEnabled(false);
      Tstatus.setEnabled(false);
      Trate.setEnabled(true);
      Trate.setEnabled(true);
      TpenaltyRate.setEnabled(true);
      
      Tstatus.setPreferredSize(new Dimension(170,25));
      TplateNumber.setPreferredSize(d);
      Trate.setPreferredSize(d);
      Trate.setPreferredSize(d);
      TpenaltyRate.setPreferredSize(d);
      
      pmodel.add(Lmodel);
      pmodel.add(Tmodel);
      pmodel.setBackground(new Color(1, 25, 54));
      pplate.add(LplateNumber);
      pplate.add(TplateNumber);
      pplate.setBackground(new Color(1, 25, 54));
      pstatus.add(Lstatus);
      pstatus.add(male);
      pstatus.add(female);
      male.setFont(new Font("Berlin Sans FB", 0, 20));
      male.setForeground(Color.WHITE);
      female.setForeground(Color.WHITE);
      female.setFont(new Font("Berlin Sans FB", 0, 20));
      
      male.setOpaque(false);
      female.setOpaque(false);
      
      pstatus.setBackground(new Color(1, 25, 54));
      ptype.add(Ltype);
      ptype.add(Trate);
      ptype.setBackground(new Color(1, 25, 54));
      prate.add(Lrate);
      prate.add(TpenaltyRate);
      prate.setBackground(new Color(1, 25, 54));

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
      
      p2.add(pmodel);
      p2.add(pplate);
      p2.add(pstatus);
      p2.add(ptype);
      p2.add(prate);
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
      if(male.isSelected()) return "MALE";
      else return "FEMALE";
   }
   
   public String getStype()
   {
      return this.Tstatus.toString();
   }
   
   public String getSrate()
   {
      return this.Trate.getText().toString();
   }
   
   public String getSpenaltyRate()
   {
      return this.TpenaltyRate.getText().toString();
   }
   
   public void setImg(String imgstring)
   {
      img = new ImageIcon(new ImageIcon(imgstring).getImage().getScaledInstance(360, 344, Image.SCALE_SMOOTH));
   }
}