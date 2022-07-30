//FRONTEND
//Edit of 29/07/2022
//Edit of 30/07/2022:Added the booking interface and deleted the overlap of the text from the login and the lightgreen colour has been added to the buttons
//import java swing and awt needed for UI
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

public class Main {
    public static void main(String[] args) {
        /*Call of the procedure for viewing the login interface*/
        Login();
    }
    /*Procedure for viewing the login interface*/
    public static void Login(){
        //create frame obj and set poperties
        JFrame frame = new JFrame();
        frame.setTitle("LOGIN");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(400, 500);//400 width and 500 height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //create label login
        JLabel l_login = new JLabel("LOGIN");
        //create labels user and pw
        JLabel l_user = new JLabel("USERNAME");
        JLabel l_password = new JLabel("PASSWORD");

        //create textfield user and pw
        JTextField field_user = new JTextField();
        JPasswordField field_pw = new JPasswordField();

        //create button login
        JButton b_login = new JButton("LOGIN");
        JButton b_registration = new JButton("SIGN UP");
        /*Calling the procedure for setting the lightgreen color on the button*/
        changecolorButton(b_login,new Color(144,238,144));
        /*Calling the procedure for setting the lightgreen color on the button*/
        changecolorButton(b_registration,new Color(144,238,144));
        //properties of all this components
        l_user.setBounds(50, 150, 100, 30);
        field_user.setBounds(150, 150, 150, 30);
        l_password.setBounds(50, 220, 100, 30);
        field_pw.setBounds(150, 220, 150, 30);
        b_login.setBounds(125, 290, 100, 40);
        b_registration.setBounds(75, 350, 200, 40);

        b_registration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                /*user and pw of the login will not be visible when the user goes into the registration part*/
                l_user.setVisible(false);
                l_password.setVisible(false);
                field_user.setVisible(false);
                field_pw.setVisible(false);
                //login and registration buttons not visible
                b_login.setVisible(false);
                b_registration.setVisible(false);
                frame.setVisible(false);//at the moment this frame is not visible

                /*Call of the procedure for viewing the registration interface*/
                SignUp(frame);
            }
        });

        //add element in frame
        frame.add(l_user);
        frame.add(field_user);
        frame.add(l_password);
        frame.add(field_pw);
        frame.add(b_login);
        frame.add(b_registration);
    }

    /*Procedure for displaying the recording interface*/
    public static void SignUp(JFrame frame){
        //create frame obj and set poperties
        //JFrame frame = new JFrame();
        frame.setTitle("SIGN UP");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(400, 500);//400 width and 500 height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //create label sign up
        JLabel l_signup = new JLabel("SIGN UP");
        //create labels user and pw
        JLabel l_name = new JLabel("NAME");
        JLabel l_surname = new JLabel("SURNAME");
        JLabel l_user = new JLabel("USERNAME");
        JLabel l_cf = new JLabel("CODICE FISCALE");
        JLabel l_email = new JLabel("EMAIL");
        JLabel l_password = new JLabel("PASSWORD");
        //create textfield user, email, pw, name, surname and cf
        JTextField field_user = new JTextField();
        JTextField field_email = new JTextField();
        JPasswordField field_pw = new JPasswordField();
        JTextField field_name = new JTextField();
        JTextField field_surname = new JTextField();
        JTextField field_cf = new JTextField();

        //create button sign up
        JButton b_registration = new JButton("SIGN UP");
        JButton b_login = new JButton("LOGIN");
        /*Calling the procedure for setting the lightgreen color on the button*/
        changecolorButton(b_registration,new Color(144,238,144));
        /*Calling the procedure for setting the lightgreen color on the button*/
        changecolorButton(b_login,new Color(144,238,144));
        //properties of all this components
        l_name.setBounds(50, 150, 100, 30);
        field_name.setBounds(150, 150, 150, 30);
        l_surname.setBounds(50, 220, 100, 30);
        field_surname.setBounds(150, 220, 150, 30);
        l_user.setBounds(50, 290, 100, 30);
        field_user.setBounds(150, 290, 150, 30);
        l_cf.setBounds(50, 360, 100, 30);
        field_cf.setBounds(150, 360, 150, 30);
        l_email.setBounds(50, 430, 100, 30);
        field_email.setBounds(150, 430, 150, 30);
        l_password.setBounds(50, 500, 100, 30);
        field_pw.setBounds(150, 500, 150, 30);
        b_registration.setBounds(75, 570, 200, 40);
        b_login.setBounds(75, 640, 200, 40);
        b_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                /*user and pw of the login will not be visible when the user goes into the registration part*/
                l_name.setVisible(false);
                field_name.setVisible(false);
                l_surname.setVisible(false);
                field_surname.setVisible(false);
                l_user.setVisible(false);
                field_user.setVisible(false);
                l_email.setVisible(false);
                field_email.setVisible(false);
                l_password.setVisible(false);
                field_pw.setVisible(false);
                //login and registration buttons not visible

                b_registration.setVisible(false);
                frame.setVisible(false);//at the moment this frame is not visible

                /*Call of the procedure for viewing the login interface*/
                Login();
            }
        });

        //add element in frame
        frame.add(l_name);
        frame.add(field_name);
        frame.add(l_surname);
        frame.add(field_surname);
        frame.add(l_user);
        frame.add(field_user);
        frame.add(l_cf);
        frame.add(field_cf);
        frame.add(l_email);
        frame.add(field_email);
        frame.add(l_password);
        frame.add(field_pw);
        frame.add(b_registration);
    }

    /*Procedure for viewing the booking interface*/
    /*This class will be called only when a registered user login to make a reservation*/
    public static void Booking(JFrame frame){
        //create frame obj and set poperties
        //JFrame frame = new JFrame();
        frame.setTitle("BOOKING");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(400, 500);//400 width and 500 height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //create label booking
        JLabel l_booking = new JLabel("BOOKING");
        //create labels user and pw
        JLabel l_databooking = new JLabel("DATA BOOKING");
        JLabel l_bookingtime = new JLabel("BOOKING TIME");
        JLabel l_reasonforbooking = new JLabel("REASON");

        //create textfield data booking, booking time and reason for booking
        JTextField field_databooking = new JTextField();
        JTextField field_bookingtime = new JTextField();
        JTextField field_reasonforbooking = new JTextField();

        //create button booking
        JButton b_booking = new JButton("BOOK YOUR APPOINTMENT");
        //properties of all this components
        l_databooking.setBounds(50, 150, 100, 30);
        field_databooking.setBounds(150, 150, 150, 30);
        l_bookingtime.setBounds(50, 220, 100, 30);
        field_bookingtime.setBounds(150, 220, 150, 30);
        l_reasonforbooking.setBounds(70, 290, 100, 30);
        field_reasonforbooking.setBounds(150, 290, 150, 30);
        b_booking.setBounds(75, 360, 200, 40);


        //add element in frame
        frame.add(l_databooking);
        frame.add(field_databooking);
        frame.add(l_bookingtime);
        frame.add(field_bookingtime);
        frame.add(l_reasonforbooking);
        frame.add(field_reasonforbooking);
        frame.add(b_booking);
    }

    /*Procedure to set lightgrren color on buttons*/
    public static void changecolorButton(JButton panel,Color rand){
        panel.setBackground(rand);
    }
}