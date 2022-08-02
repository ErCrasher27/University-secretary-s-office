//Changes of 01/08/2022: Translation of Italian prints into English, changing the positions of objects in jpanel, adding colors and borders
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class FrameLogin {

    //prepare frame
    private static JFrame frame;

    //prepare field for login
    private static JTextField field_username_login;
    private static JTextField field_password_login;

    //prepare field for register
    private static JTextField field_name;
    private static JTextField field_surname;
    private static JTextField field_email;
    private static JTextField field_cf;
    private static JTextField field_username;
    private static JTextField field_password;

    //id (like a session)
    private static int id_student = 0;

    public FrameLogin() {

        //declare and set panel properties (and add panel)
        frame = new JFrame();
        frame.setTitle("University Secretariat");
        frame.setLocation(new Point(500, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //call menu
        menu();
    }

    //fun that init menu
    private static void menu() {
        clearFrame();

        //declare and set title menu properties
        JLabel label_menu = new JLabel();
        label_menu.setFont(new java.awt.Font("Tahoma", 0, 36));
        label_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_menu.setText("University Secretary");

        //declare and set button login section properties and event
        JButton button_login_section = new JButton();
        button_login_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_login_section.setText("Login");
        button_login_section.setBackground(Color.getHSBColor(35, 90, 100));
        button_login_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginSectionActionPerformed(evt);
            }
        });

        //declare and set button register section properties and event
        JButton button_register_section = new JButton();
        button_register_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_register_section.setText("Registered");
        button_register_section.setBackground(Color.getHSBColor(35, 90, 100));
        button_register_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterSectionActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_menu = new JPanel(new GridLayout(3, 1));
        pannello_menu.setBackground(Color.getHSBColor(352, 90, 62));
        pannello_menu.setBorder(BorderFactory.createEmptyBorder(40,10,50,10));
        pannello_menu.add(label_menu);
        pannello_menu.add(button_login_section);
        pannello_menu.add(button_register_section);
        pannello_menu.setVisible(true);

        frame.add(pannello_menu);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }


    //fun that load login page
    private static void login() {
        clearFrame();

        //declare and set labels_login_title properties
        JLabel label_login_title = new JLabel();
        label_login_title.setFont(new java.awt.Font("Tahoma", 0, 36));
        label_login_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_login_title.setText("Login");

        //declare and set label_username properties
        JLabel label_username = new JLabel();
        label_username.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_username.setText("Username");

        //declare and set label_password properties
        JLabel label_password = new JLabel();
        label_password.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_password.setText("Password");

        //declare and set text field username properties
        field_username_login = new JTextField();
        field_username_login.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //set password field username properties
        field_password_login = new JPasswordField();
        field_password_login.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //declare and set button menu properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("<- Back to menu");
        button_menu.setBackground(Color.getHSBColor(35, 90, 100));
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare and set button login properties and event
        JButton button_login = new JButton();
        button_login.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_login.setText("Login");
        button_login.setBackground(Color.getHSBColor(35, 90, 100));
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        //Changed the position of the components in the jpanel(01/08/2022)
        //declare and set panel properties (and add components)
        JPanel pannello_login = new JPanel(new GridLayout(3, 1));
        pannello_login.setBackground(Color.getHSBColor(352, 90, 62));
        pannello_login.setBorder(BorderFactory.createEmptyBorder(40,10,50,10));
        pannello_login.add(label_username);
        pannello_login.add(field_username_login);
        pannello_login.add(label_password);
        pannello_login.add(field_password_login);
        pannello_login.add(button_menu);
        pannello_login.add(button_login);
        pannello_login.setVisible(true);

        //add to frame
        frame.add(pannello_login);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //fun that load register page
    private static void register() {
        clearFrame();

        //declare and set labels_login_title properties
        JLabel label_register_title = new JLabel();
        label_register_title.setFont(new java.awt.Font("Tahoma", 0, 36));
        label_register_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_register_title.setText("Registered");

        //declare and set label_name properties
        JLabel label_name = new JLabel();
        label_name.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_name.setText("Name");

        //declare and set label_surname properties
        JLabel label_surname = new JLabel();
        label_surname.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_surname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_surname.setText("Surname");

        //declare and set label_email properties
        JLabel label_email = new JLabel();
        label_email.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_email.setText("Email");

        //declare and set label_cf properties
        JLabel label_cf = new JLabel();
        label_cf.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_cf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_cf.setText("Tax Code");

        //declare and set label_username properties
        JLabel label_username = new JLabel();
        label_username.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_username.setText("Username");

        //declare and set label_password properties
        JLabel label_password = new JLabel();
        label_password.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_password.setText("Password");

        //declare and set text field name properties
        field_name = new JTextField();
        field_name.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //set password field surname properties
        field_surname = new JTextField();
        field_surname.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //declare and set text field email properties
        field_email = new JTextField();
        field_email.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //set password field cf properties
        field_cf = new JTextField();
        field_cf.setFont(new java.awt.Font("Times New Roman", 0, 24));

        /*CustomizerJtextField class call for character limitation*/
        field_cf.setDocument(new CustomizerJtextField(16));

        //declare and set text field username properties
        field_username = new JTextField();
        field_username.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //set password field username properties
        field_password = new JPasswordField();
        field_password.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //declare and set button menu properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("<- Back to menu");
        button_menu.setBackground(Color.getHSBColor(35, 90, 100));
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare and set button register properties and event
        JButton button_register = new JButton();
        button_register.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_register.setText("Registered");
        button_register.setBackground(Color.getHSBColor(35, 90, 100));
        button_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        //Changed the position of the components in the jpanel(01/08/2022)
        //declare and set panel properties (and add components)
        JPanel pannello_register = new JPanel(new GridLayout(7,7));
        pannello_register.setBackground(Color.getHSBColor(352, 90, 62));
        pannello_register.setBorder(BorderFactory.createEmptyBorder(40,10,50,10));
        pannello_register.add(label_name);
        pannello_register.add(field_name);
        pannello_register.add(label_surname);
        pannello_register.add(field_surname);
        pannello_register.add(label_email);
        pannello_register.add(field_email);
        pannello_register.add(label_cf);
        pannello_register.add(field_cf);
        pannello_register.add(label_username);
        pannello_register.add(field_username);
        pannello_register.add(label_password);
        pannello_register.add(field_password);
        pannello_register.add(button_menu);
        pannello_register.add(button_register);
        pannello_register.setVisible(true);

        //add to frame
        frame.add(pannello_register);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //fun that clear frame
    private static void clearFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    //-----------------------------------------functions events-----------------------------------------

    //tp to menu page
    private static void buttonMenuActionPerformed(java.awt.event.ActionEvent evt) {
        menu();
    }

    //tp to login page
    private static void buttonLoginSectionActionPerformed(ActionEvent evt) {
        login();
    }

    //tp to register page
    private static void buttonRegisterSectionActionPerformed(ActionEvent evt) {
        register();
    }

    //event that login student
    private static void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {

        //create student obj
        Student s = new Student();
        s.setUsername(field_username_login.getText());
        s.setPassword(field_password_login.getText());

        //login student
        UniversitySecretary us = new UniversitySecretary();
        if (us.loginStudent(s)) {
            id_student = s.getId();
            FrameBooking f = new FrameBooking(id_student);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect email and/or password");
        }
    }

    //event that register student
    private static void buttonRegisterActionPerformed(ActionEvent evt) {
        //create student obj
        Student s = new Student();
        boolean empty = true;
        if (!field_name.getText().isEmpty()
                && !field_surname.getText().isEmpty()
                && !field_email.getText().isEmpty()
                && !field_cf.getText().isEmpty()
                && !field_username.getText().isEmpty()
                && !field_password.getText().isEmpty()) {
            s.setName(field_name.getText());
            s.setSurname(field_surname.getText());
            s.setEmail(field_email.getText());
            s.setCF(field_cf.getText());
            s.setUsername(field_username.getText());
            s.setPassword(field_password.getText());
            empty = false;

            //check validation email and cf (in case null empty == true)
            if (s.getEmail() == null) {
                empty = true;
            }else if (s.getCF() == null) {
                empty = true;
            }
        }

        //register student
        if (!empty) {
            UniversitySecretary us = new UniversitySecretary();
            us.registerStudent(s);
        } else
            JOptionPane.showMessageDialog(null, "Some fields are empty");
    }

    /*Character limitation class for jtextfields*/
    public static class CustomizerJtextField extends PlainDocument {

        private StringBuffer cache = new StringBuffer();
        int lunghezzaMax;

        public CustomizerJtextField(int lunghezzaMax){
            this.lunghezzaMax = lunghezzaMax;
        }

        public void insertString(int off, String s, AttributeSet aset) throws BadLocationException{
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