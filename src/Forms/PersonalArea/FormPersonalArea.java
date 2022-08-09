//Edit of the 08/08//2022: Creation of the personal area form
package Forms.PersonalArea;

import Forms.Booking.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPersonalArea {
    private JPanel mainPanel;
    private JPanel personalPanel;
    private JPanel buttonPanel;
    private JButton makeAReservationButton;
    private JButton manageBookingsButton;
    private JLabel universityLabel;
    private JLabel secretaryLabel;
    private JButton doneButton;

    public FormPersonalArea() {
        makeAReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GO TO BOOKING AREA");
                FormBooking fl = new FormBooking();
                fl.init();
            }
        });

        manageBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("VIEW YOUR RESERVATIONS");
            }
        });

    }

    public  void init() {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormPersonalArea().mainPanel);
        frame.setTitle("Personal Area");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
