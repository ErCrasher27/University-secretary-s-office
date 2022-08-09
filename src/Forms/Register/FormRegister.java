package Forms.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  Forms.Login.*;
import UniversitySecretaryTools.Student;

import static java.lang.String.valueOf;

public class FormRegister {
    private static JFrame frame;
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
                frame.dispose();
            }
        });
        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student();
                boolean empty = true;
                if (!nameField.getText().isEmpty()
                        && !surnameField.getText().isEmpty()
                        && !emailField.getText().isEmpty()
                        && !taxCodeField.getText().isEmpty()
                        && !usernameField.getText().isEmpty()
                        && !valueOf(passwordField.getPassword()).isEmpty()) {
                    s.setName(nameField.getText());
                    s.setSurname(surnameField.getText());
                    s.setEmail(emailField.getText());
                    s.setCF(taxCodeField.getText());
                    s.setUsername(usernameField.getText());
                    s.setPassword(valueOf(passwordField.getPassword()));
                    empty = false;

                    //check validation email and cf (in case null empty == true)
                    if (s.getEmail() == null) {
                        empty = true;
                    }else if (s.getCF() == null) {
                        empty = true;
                    }
                }
                if (!empty) {
                    s.registerStudent();
                } else
                    JOptionPane.showMessageDialog(null, "Some fields are empty");
            }
        });
    }

    public void init() {
        frame = new JFrame("University Secretary - Register");
        frame.setContentPane(new FormRegister().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(650, 850);
        frame.setVisible(true);
    }
}
