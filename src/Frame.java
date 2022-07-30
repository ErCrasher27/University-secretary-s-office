import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame {

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


    public Frame() {
        //declare and set panel properties (and add panel)
        frame = new JFrame();
        frame.setTitle("Segreteria Universitaria");
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
        label_menu.setText("Login");

        //declare and set button login section properties and event
        JButton button_login_section = new JButton();
        button_login_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_login_section.setText("Login");
        button_login_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginSectionActionPerformed(evt);
            }
        });

        //declare and set button register section properties and event
        JButton button_register_section = new JButton();
        button_register_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_register_section.setText("Registrati");
        button_register_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterSectionActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_menu = new JPanel(new GridLayout(3, 1));
        pannello_menu.add(label_menu);
        pannello_menu.add(button_login_section);
        pannello_menu.add(button_register_section);
        pannello_menu.setVisible(true);

        frame.add(pannello_menu);
        frame.setSize(400, 200);
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
        field_password_login = new JTextField();
        field_password_login.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //declare and set button menu properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("Menu");
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare and set button login properties and event
        JButton button_login = new JButton();
        button_login.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_login.setText("Login");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_login = new JPanel(new GridLayout(3, 1));
        pannello_login.add(button_menu);
        pannello_login.add(label_username);
        pannello_login.add(field_username_login);
        pannello_login.add(label_password);
        pannello_login.add(field_password_login);
        pannello_login.add(button_login);
        pannello_login.setVisible(true);

        //add to frame
        frame.add(pannello_login);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    //fun that load register page
    private static void register() {
        clearFrame();

        //declare and set labels_login_title properties
        JLabel label_register_title = new JLabel();
        label_register_title.setFont(new java.awt.Font("Tahoma", 0, 36));
        label_register_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_register_title.setText("Registrati");

        //declare and set label_name properties
        JLabel label_name = new JLabel();
        label_name.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_name.setText("Nome");

        //declare and set label_surname properties
        JLabel label_surname = new JLabel();
        label_surname.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_surname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_surname.setText("Cognome");

        //declare and set label_email properties
        JLabel label_email = new JLabel();
        label_email.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_email.setText("Email");

        //declare and set label_cf properties
        JLabel label_cf = new JLabel();
        label_cf.setFont(new java.awt.Font("Times New Roman", 0, 24));
        label_cf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_cf.setText("Codice Fiscale");

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

        //declare and set text field username properties
        field_username = new JTextField();
        field_username.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //set password field username properties
        field_password = new JTextField();
        field_password.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //declare and set button menu properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("Menu");
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare and set button register properties and event
        JButton button_register = new JButton();
        button_register.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_register.setText("Registrati");
        button_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_register = new JPanel(new GridLayout(14, 2));
        pannello_register.add(button_menu);
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
        pannello_register.add(button_register);
        pannello_register.setVisible(true);

        //add to frame
        frame.add(pannello_register);
        frame.setSize(400, 200);
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
        us.loginStudent(s);
    }

    //event that register student
    private static void buttonRegisterActionPerformed(ActionEvent evt) {

        //create student obj
        Student s = new Student();
        s.setName(field_name.getText());
        s.setSurname(field_surname.getText());
        s.setEmail(field_email.getText());
        s.setCF(field_cf.getText());
        s.setUsername(field_username.getText());
        s.setPassword(field_password.getText());

        //register student
        UniversitySecretary us = new UniversitySecretary();
        us.registerStudent(s);
    }


}
