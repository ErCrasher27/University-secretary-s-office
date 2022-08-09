//Edit of the 08/08//2022: Creation of the booking form
package Forms.Booking;

import Forms.PersonalArea.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBooking {
    private JPanel mainPanel;
    private JPanel bookingPanel;
    private JLabel dateLabel;
    private JLabel noteLabel;
    private JTextField dateTextField;
    private JButton bookButton;
    private JPanel datePanel;
    private JPanel notePanel;
    private JTextArea notetextArea;
    private JLabel universityLabel;
    private JLabel secretaryLabel;

    public FormBooking() {
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("BOOKING MADE");
                FormPersonalArea fr = new FormPersonalArea();
                fr.init();
            }
        });
    }

    public  void init() {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormBooking().mainPanel);
        frame.setTitle("Booking Area");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}