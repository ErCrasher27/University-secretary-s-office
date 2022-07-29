//FRONTEND
//Edit of 29/07/2022
//import java swing and awt needed for UI
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        /*Call of the procedure for viewing the login interface*/
        Login();
    }
    /*Procedure for viewing the login interface*/
    public static void Login(){
        //create frame obj and set poperties
        JFrame frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(400, 500);//400 width and 500 height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //create label login
        JLabel l_login = new JLabel("Login");
        //create labels user and pw
        JLabel l_email = new JLabel("EMAIL");
        JLabel l_password = new JLabel("PASSWORD");

        //create textfield user and pw
        JTextField field_email = new JTextField();
        JPasswordField field_pw = new JPasswordField();

        //create button login
        JButton b_login = new JButton("LOGIN");
        JButton b_registration = new JButton("REGISTRATION");
        //properties of all this components
        l_email.setBounds(50, 150, 100, 30);
        field_email.setBounds(150, 150, 150, 30);
        l_password.setBounds(50, 220, 100, 30);
        field_pw.setBounds(150, 220, 150, 30);
        b_login.setBounds(125, 290, 100, 40);
        b_registration.setBounds(75, 350, 200, 40);

        b_registration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                /*Call of the procedure for viewing the registration interface*/
                SignUp();
            }
        });

        //add element in frame
        frame.add(l_email);
        frame.add(field_email);
        frame.add(l_password);
        frame.add(field_pw);
        frame.add(b_login);
        frame.add(b_registration);
    }

    /*Procedure for displaying the recording interface*/
    public static void SignUp(){
        //create frame obj and set poperties
        JFrame frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(400, 500);//400 width and 500 height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //create label login
        JLabel l_login = new JLabel("Login");
        //create labels user and pw
        JLabel l_name = new JLabel("NAME");
        JLabel l_surname = new JLabel("SURNAME");
        JLabel l_cf = new JLabel("CODICE FISCALE");
        JLabel l_email = new JLabel("EMAIL");
        JLabel l_password = new JLabel("PASSWORD");

        //create textfield user and pw
        JTextField field_email = new JTextField();
        JPasswordField field_pw = new JPasswordField();
        JTextField field_name = new JTextField();
        JTextField field_surname = new JTextField();
        JTextField field_cf = new JTextField();

        //create button login
        JButton b_registration = new JButton("REGISTRATION");
        //properties of all this components
        l_name.setBounds(50, 150, 100, 30);
        field_name.setBounds(150, 150, 150, 30);
        l_surname.setBounds(50, 220, 100, 30);
        field_surname.setBounds(150, 220, 150, 30);
        l_cf.setBounds(50, 290, 100, 30);
        field_cf.setBounds(150, 290, 150, 30);
        l_email.setBounds(50, 360, 100, 30);
        field_email.setBounds(150, 360, 150, 30);
        l_password.setBounds(50, 430, 100, 30);
        field_pw.setBounds(150, 430, 150, 30);
        b_registration.setBounds(75, 500, 200, 40);


        //add element in frame
        frame.add(l_name);
        frame.add(field_name);
        frame.add(l_surname);
        frame.add(field_surname);
        frame.add(l_cf);
        frame.add(field_cf);
        frame.add(l_email);
        frame.add(field_email);
        frame.add(l_password);
        frame.add(field_pw);
        frame.add(b_registration);
    }
}