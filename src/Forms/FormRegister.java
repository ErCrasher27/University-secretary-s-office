package Forms;

import javax.swing.*;

public class FormLogin {
    private JPanel mainPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormLogin().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
