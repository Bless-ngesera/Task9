import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignUp extends JDialog {
    private JPanel SignUpPanel;
    private JLabel Logo;
    private JLabel Title;
    private JLabel firstName;
    private JTextField FnameField;
    private JLabel lastName;
    private JTextField LnameField;
    private JLabel Email;
    private JTextField emailField;
    private JLabel phone;
    private JTextField phoneField;
    private JTextField userField;
    private JPasswordField PasswordField;
    private JLabel password;
    private JLabel ConfPassword;
    private JPasswordField ConfpasswordField;
    private JButton SignUpButton;
    private JLabel text;
    private JButton signInButton;
    private JButton cancelButton;

    public SignUp(JFrame frame) {
        super(frame, "Sign Up", true);
        setContentPane(SignUpPanel);
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


}
}