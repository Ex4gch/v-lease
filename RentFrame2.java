import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.time.LocalDateTime;

public class RentFrame2 extends JFrame {
    public RentFrame2() {
        this.setTitle("V-Lease");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        RentPanel rentPanel = new RentPanel();
        this.add(rentPanel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RentFrame2();
    }
}
