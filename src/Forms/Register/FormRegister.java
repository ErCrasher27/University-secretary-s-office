package Forms.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  Forms.Login.*;

public class FormRegister {

    private JPanel mainPanel;
    private JPanel formPanel;
    private JPanel namePanel;
    private JPanel surnamePanel;
    private JPanel taxCodePanel;
    private JPanel emailPanel;
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JPanel buttonPanel;
    private JPanel loginPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField taxCodeField;
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton REGISTERButton;
    private JButton loginButton;
    private JLabel universityLabel;
    private JLabel secretaryLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel taxCodeLabel;
    private JLabel emailLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel areYouAlreadyRegisteredLabel;

    public FormRegister() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormLogin fl = new FormLogin();
                fl.init();
            }
        });
    }

    public void init() {
        JFrame frame = new JFrame("University Secretary - Register");
        frame.setContentPane(new FormRegister().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(650, 850);
        frame.setVisible(true);
    }
}
