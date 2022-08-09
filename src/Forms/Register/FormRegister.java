package Forms.Register;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import Forms.FrameLogin;
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
        taxCodeField.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                taxCodeField.setDocument(new FormRegister.CustomizerJtextField(16));
            }
        });
    }

    public void init() {
        frame = new JFrame("University Secretary - Register");
        frame.setContentPane(new FormRegister().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setMaximumSize(new Dimension(1280, 800));
        frame.setPreferredSize(new Dimension(1280, 768));
        frame.pack();
        frame.setVisible(true);
    }

    /*Character limitation class for jtextfields*/
    public static class CustomizerJtextField extends PlainDocument {

        private StringBuffer cache = new StringBuffer();
        int lunghezzaMax;

        public CustomizerJtextField(int lunghezzaMax){
            this.lunghezzaMax = lunghezzaMax;
        }

        public void insertString(int off, String s, AttributeSet aset) throws BadLocationException {
            int len = getLength();
            if(len >= this.lunghezzaMax) {
                return;
            }
            cache.setLength(0);
            char c;
            for(int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                cache.append(c);
                if(cache.length() >= lunghezzaMax - len) {
                    break;
                }
            }
            if(cache.length() > 0) {
                super.insertString( off, cache.toString(), aset);
            }
        }
    }
}
