package Forms.Login;

import Forms.Register.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormLogin {
    private JPanel mainPanel;
    private JTextField usernameTextField;
    private JPanel formPanel;
    private JButton LOGINButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JPanel buttonPanel;
    private JPasswordField passwordField;
    private JLabel notRegisteredYetLabel;
    private JButton signInButton;
    private JPanel registerPanel;
    private JLabel universityLabel;
    private JLabel secretaryLabel;

    public FormLogin() {
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormRegister fr = new FormRegister();
                fr.init();
            }
        });
    }

    public void init() {
        JFrame frame = new JFrame("University Secretary - Login");
        frame.setContentPane(new FormLogin().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(650, 850);
        frame.setVisible(true);
    }
}
