package Forms;

import javax.swing.*;

public class FormRegister {
    private JPanel mainPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormRegister().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
