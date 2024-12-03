import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RentPanel extends JPanel {
    private JLabel beginDateLabel;
    private JLabel endDateLabel;
    private JLabel rentIdLabel;
    private JLabel vehicleOwnerLabel;
    private JLabel renterLabel;
    private JLabel vehicleTypeLabel;

    private JTextField beginDateField;
    private JTextField endDateField;
    private JTextField rentIdField;
    private JTextField vehicleOwnerField;
    private JTextField renterField;
    private JTextField vehicleTypeField;

    private JButton calculatePaymentBtn;
    private JTextArea outputArea;

    private static final double HOURLY_RATE = 150.00; // Example hourly rate

    public RentPanel() {
        // Set layout and size
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 600));

        // Load background image
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(new ImageIcon("bg2.jpg")
                .getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
        background.setBounds(0, 0, 1000, 600);
        this.add(background);

        // Initialize components
        beginDateLabel = new JLabel("Begin Date (yyyy-MM-dd HH:mm):");
        endDateLabel = new JLabel("End Date (yyyy-MM-dd HH:mm):");
        rentIdLabel = new JLabel("Rent ID:");
        vehicleOwnerLabel = new JLabel("Vehicle Owner:");
        renterLabel = new JLabel("Renter:");
        vehicleTypeLabel = new JLabel("Vehicle Type:");

        beginDateField = new JTextField();
        endDateField = new JTextField();
        rentIdField = new JTextField();
        vehicleOwnerField = new JTextField();
        renterField = new JTextField();
        vehicleTypeField = new JTextField();

        calculatePaymentBtn = new JButton("Calculate Payment");

        outputArea = new JTextArea(3, 20);
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Set bounds for components
        int xLabel = 50, xField = 300, y = 50, width = 200, height = 30, gap = 50;

        beginDateLabel.setBounds(xLabel, y, width, height);
        beginDateField.setBounds(xField, y, 400, height);

        y += gap;
        endDateLabel.setBounds(xLabel, y, width, height);
        endDateField.setBounds(xField, y, 400, height);

        y += gap;
        rentIdLabel.setBounds(xLabel, y, width, height);
        rentIdField.setBounds(xField, y, 400, height);

        y += gap;
        vehicleOwnerLabel.setBounds(xLabel, y, width, height);
        vehicleOwnerField.setBounds(xField, y, 400, height);

        y += gap;
        renterLabel.setBounds(xLabel, y, width, height);
        renterField.setBounds(xField, y, 400, height);

        y += gap;
        vehicleTypeLabel.setBounds(xLabel, y, width, height);
        vehicleTypeField.setBounds(xField, y, 400, height);

        y += gap;
        calculatePaymentBtn.setBounds(xField, y, 200, height);

        outputArea.setBounds(50, y + gap, 900, 100);

        // Add components to the background
        background.add(beginDateLabel);
        background.add(beginDateField);
        background.add(endDateLabel);
        background.add(endDateField);
        background.add(rentIdLabel);
        background.add(rentIdField);
        background.add(vehicleOwnerLabel);
        background.add(vehicleOwnerField);
        background.add(renterLabel);
        background.add(renterField);
        background.add(vehicleTypeLabel);
        background.add(vehicleTypeField);
        background.add(calculatePaymentBtn);
        background.add(outputArea);

        // Add button action
        calculatePaymentBtn.addActionListener(e -> calculatePayment());
    }

    // Methods
    private void calculatePayment() {
        try {
            // Parse dates
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime beginDate = LocalDateTime.parse(beginDateField.getText(), formatter);
            LocalDateTime endDate = LocalDateTime.parse(endDateField.getText(), formatter);

            // Validate date order
            if (endDate.isBefore(beginDate)) {
                outputArea.setText("Error: End date cannot be before start date.");
                return;
            }

            // Calculate total hours
            long hours = ChronoUnit.HOURS.between(beginDate, endDate);

            // Calculate payment
            double totalPayment = hours * HOURLY_RATE;

            // Display output
            outputArea.setText("Total Hours: " + hours + "\nTotal Payment: PHP " + totalPayment);
        } catch (Exception e) {
            outputArea.setText("Error: Invalid date format or input.");
        }
    }

    @Override
    public String toString() {
        return "RentPanel{" +
                "beginDate=" + beginDateField.getText() +
                ", endDate=" + endDateField.getText() +
                ", rentId=" + rentIdField.getText() +
                ", vehicleOwner='" + vehicleOwnerField.getText() + '\'' +
                ", renter='" + renterField.getText() + '\'' +
                ", vehicleType='" + vehicleTypeField.getText() + '\'' +
                '}';
    }
}


