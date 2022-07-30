import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        //init components
        login();
    }

    //fun that init comp
    private static void login() {

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

        //declare and set button login properties and event
        JButton button_login = new JButton();
        button_login.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_login.setText("Login");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
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

        //declare and set text field username properties
        JTextField field_username = new JTextField();
        field_username.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //set password field username properties
        JTextField field_password = new JTextField();
        field_password.setFont(new java.awt.Font("Times New Roman", 0, 24));

        //declare and set panel properties (and add components)
        JPanel pannello_login = new JPanel(new GridLayout(3, 1));
        pannello_login.add(label_username);
        pannello_login.add(field_username);
        pannello_login.add(label_password);
        pannello_login.add(field_password);
        pannello_login.add(button_login);
        pannello_login.setVisible(true);

        //declare and set panel properties (and add panel)
        JFrame frame = new JFrame();
        frame.setTitle("Segreteria Universitaria");
        frame.setLocation(new Point(500, 300));
        frame.add(pannello_login);
        frame.setSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {
        //code
    }

    private static void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        //code
    }
}
