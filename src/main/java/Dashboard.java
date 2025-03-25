import javax.swing.*;
import java.awt.*;

public class Dashboard {
    private JFrame frame;
    private JPanel dashboardPanel;
    private JLabel Text;
    private JButton cancelButton;

    public Dashboard() {
        frame = new JFrame("Dashboard");
        frame.setContentPane(dashboardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);


        cancelButton.addActionListener(e -> {
            frame.dispose();
            new SignIn(null);
        });

        frame.setVisible(true);
    }
}