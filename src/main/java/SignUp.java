import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SignUp {
    private JDialog dialog;
    private JPanel SignUpPanel;
    private JLabel Title;
    private JLabel firstName;
    private JTextField FnameField;
    private JLabel lastName;
    private JTextField LnameField;
    private JLabel Email;
    private JTextField emailField;
    private JLabel phone;
    private JTextField phoneField;
    private JPasswordField PasswordField;
    private JLabel password;
    private JLabel ConfPassword;
    private JPasswordField ConfpasswordField;
    private JButton SignUpButton;
    private JLabel text;
    private JButton signInButton;
    private JButton cancelButton;
    private JTextField userNameField;
    private JLabel userName;

    public SignUp(JFrame parent) {
        dialog = new JDialog(parent, "Sign Up", true);
        dialog.setContentPane(SignUpPanel);
        dialog.setMinimumSize(new Dimension(800, 550));
        dialog.setLocationRelativeTo(parent);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Button listeners
        SignUpButton.addActionListener(e -> registerUser());
        signInButton.addActionListener(e -> {
            new SignIn(null);
            dialog.dispose();
        });
        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void registerUser() {
        String firstName = FnameField.getText();
        String lastName = LnameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String username = userNameField.getText();
        String password = new String(PasswordField.getPassword());
        String confirmPassword = new String(ConfpasswordField.getPassword());

        // Basic validation
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(dialog, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        final String DB_URL = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "2006";

        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO users (first_name, last_name, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, username);
            stmt.setString(6, password);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(dialog, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
                new SignIn(null);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}