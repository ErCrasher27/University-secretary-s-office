package Forms.Login;

import Forms.PersonalArea.FormPersonalArea;
import Forms.Register.*;
import UniversitySecretaryTools.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormLogin {
    private static JFrame frame;
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
    private static int idStudent = 0;

    public FormLogin() {
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormRegister fr = new FormRegister();
                fr.init();
                frame.dispose();
            }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student();
                s.setUsername(usernameTextField.getText());
                s.setPassword(String.valueOf(passwordField.getPassword()));
                if (s.loginStudent()){
                    idStudent = s.getId();
                    FormPersonalArea p = new FormPersonalArea();
                    p.init(idStudent);
                    frame.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Login failed");
                }
            }
        });
    }

    public void init() {
        frame = new JFrame("University Secretary - Login");
        frame.setContentPane(new FormLogin().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(650, 850);
        frame.setVisible(true);
    }
}
