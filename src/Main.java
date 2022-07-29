//import java swing and awt needed for UI
import javax.swing.*;
import java.awt.*;
public class Main {
    /*Main to allow user data entry*/
    public static void main(String[] args) {

        //create frame obj and set poperties
        JFrame frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(400,500);//400 width and 500 height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //create label login
        JLabel l_login = new JLabel("Login");
        //create labels user and pw
        JLabel l_user=new JLabel("USERNAME");
        JLabel l_password=new JLabel("PASSWORD");

        //create textfield user and pw
        JTextField field_user=new JTextField();
        JPasswordField field_pw=new JPasswordField();

        //create button login
        JButton b_login=new JButton("LOGIN");

        //properties of all this components
        l_user.setBounds(50,150,100,30);
        l_password.setBounds(50,220,100,30);
        field_user.setBounds(150,150,150,30);
        field_pw.setBounds(150,220,150,30);
        b_login.setBounds(125,290,100, 40);

        //add element in frame
        frame.add(l_user);
        frame.add(field_user);
        frame.add(l_password);
        frame.add(field_pw);
        frame.add(b_login);

    }
}