//Edit of the 08/08//2022: Creation of the personal area form
package Forms.PersonalArea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPersonalArea {
    private JPanel mainPanel;
    private JPanel personalPanel;
    private JLabel personalAreaLabel;
    private JButton logoutButton;
    private JPanel buttonPanel;
    private JButton makeAReservationButton;
    private JButton manageBookingsButton;

    public FormPersonalArea() {
        makeAReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GO TO BOOKING AREA");
            }
        });

        manageBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("VIEW YOUR RESERVATIONS");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormPersonalArea().mainPanel);
        frame.setTitle("Personal Area");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
