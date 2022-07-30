import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//move it
public class Main {
    private static JFrame frame;

    public static void main(String[] args) {

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

        //declare and set panel properties (and add components)
        JPanel pannello_menu = new JPanel(new GridLayout(3, 1));
        pannello_menu.add(label_menu);
        pannello_menu.add(button_login_section);
        pannello_menu.setVisible(true);

        frame.add(pannello_menu);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }


    //fun that load login
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
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("Menu");
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
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
        pannello_login.add(button_menu);
        pannello_login.add(label_username);
        pannello_login.add(field_username);
        pannello_login.add(label_password);
        pannello_login.add(field_password);
        pannello_login.add(button_login);
        pannello_login.setVisible(true);

        frame.add(pannello_login);
        frame.setSize(400, 200);
        frame.setVisible(true);    }

    //fun that clear frame
    private static void clearFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    //-----------------------------------------functions events-----------------------------------------
    private static void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {
        //code
    }

    private static void buttonMenuActionPerformed(java.awt.event.ActionEvent evt) {
        menu();
        //code
    }

    private static void buttonLoginSectionActionPerformed(ActionEvent evt) {
        login();
    }
}
