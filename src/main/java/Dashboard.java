import javax.swing.*;
import java.awt.*;

public class Dashboard {
    private JFrame frame;
    private JPanel dashboardPanel;
    private JLabel Logo;
    private JLabel Text;
    private JButton logoutButton;

    public Dashboard() {
        frame = new JFrame("Dashboard");
        frame.setContentPane(dashboardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Initialize logo
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/logo.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Logo.setIcon(new ImageIcon(scaledImage));
        Text.setText("Welcome to Library System");

        logoutButton.addActionListener(e -> {
            frame.dispose();
            new SignIn(null);
        });

        frame.setVisible(true);
    }
}