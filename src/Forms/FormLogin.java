package Forms;

import javax.swing.*;

public class FormLogin {
    private JPanel mainPanel;
    private JTextField usernameTextField;
    private JPanel formPanel;
    private JButton LOGINButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JPanel bottonPanel;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormLogin().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
