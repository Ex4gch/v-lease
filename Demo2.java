import javax.swing.*;
import java.awt.*;

public class Demo2
{
   static CustomerPanel r = new CustomerPanel();
   static RentPanel2 t = new RentPanel2();
   static ReturnPanel rt = new ReturnPanel();

   static JFrame frame = new JFrame();
   public static void main(String[]args)
   {
      frame.setSize(1000,600);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.add(rt);
      r.setBounds(0,0,1000,600);
      frame.setVisible(true);
//          MainFrame2 f = new MainFrame2();
//          f.setVisible(true);
   } 
}