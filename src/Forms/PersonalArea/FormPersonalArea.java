//Edit of the 08/08//2022: Creation of the personal area form
package Forms.PersonalArea;

import Forms.Booking.*;
import Forms.Login.FormLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPersonalArea {
    private static JFrame frame;
    private JPanel mainPanel;
    private JPanel personalPanel;
    private JPanel buttonPanel;
    private JButton makeAReservationButton;
    private JButton yourBookingsButton;
    private JLabel universityLabel;
    private JLabel secretaryLabel;
    private JButton doneButton;
    private static int idStudent = 0;

    public FormPersonalArea() {
        makeAReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormBooking fl = new FormBooking();
                fl.init(idStudent);
                frame.dispose();
            }
        });

        yourBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("VIEW YOUR RESERVATIONS");
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormLogin fl = new FormLogin();
                fl.init();
                frame.dispose();
            }
        });
    }

    public  void init(int idStudent) {
        this.idStudent = idStudent;
        frame = new JFrame("University Secretary - Personal Area");
        frame.setContentPane(new FormPersonalArea().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
