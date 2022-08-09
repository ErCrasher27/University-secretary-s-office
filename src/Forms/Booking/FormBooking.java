//Edit of the 08/08//2022: Creation of the booking form
package Forms.Booking;

import Forms.PersonalArea.*;
import UniversitySecretaryTools.Booking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBooking {
    private JPanel mainPanel;
    private JPanel bookingPanel;
    private JLabel dateLabel;
    private JLabel noteLabel;
    private JButton bookButton;
    private JPanel datePanel;
    private JPanel notePanel;
    private JTextArea notetextArea;
    private JLabel universityLabel;
    private JLabel secretaryLabel;
    private JFormattedTextField dataTextField;
    private JPanel buttonPanel;
    private static int idStudent = 0;

    public FormBooking() {
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Booking b = new Booking();
                if(b.checkBookingExist(dataTextField.getText())){

                    b.saveBooking(dataTextField.getText(), notetextArea.getText(), idStudent);
                }
            }
        });
    }

    public  void init(int idStudent) {
        this.idStudent = idStudent;
        JFrame frame = new JFrame("University Secretary - Make a reservation");
        frame.setContentPane(new FormBooking().mainPanel);
        frame.setTitle("Booking Area");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}