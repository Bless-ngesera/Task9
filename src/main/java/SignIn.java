import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SignIn {
    private JDialog dialog;
    private JPanel SignInPanel;
    private JLabel TiTle;
    private JLabel UseName;
    private JTextField userNameField;
    private JLabel Password;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton signUpButton;
    private JButton cancelButton;
    private JLabel Text;

    public SignIn(JFrame parent) {
        dialog = new JDialog(parent);
        dialog.setTitle("Sign In");
        dialog.setContentPane(SignInPanel);
        dialog.setMinimumSize(new Dimension(600, 400));
        dialog.setLocationRelativeTo(parent);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        signInButton.addActionListener(e -> login());
        signUpButton.addActionListener(e -> {
            new SignUp(null);
            dialog.dispose();
        });
        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void login() {
        String username = userNameField.getText();
        String password = new String(passwordField.getPassword());

        final String DB_URL = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "2006";

        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(dialog, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(dialog, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}