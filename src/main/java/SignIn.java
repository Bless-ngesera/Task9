import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignIn extends JDialog{
    private JPanel SignInPanel;
    private JLabel Logo;
    private JLabel TiTle;
    private JLabel UseName;
    private JTextField userNameField;
    private JLabel Password;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton signUpButton;
    private JButton cancelButton;
    private JLabel Text;


    public SignIn() {
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}