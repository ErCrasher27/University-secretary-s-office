//Edit of the 08/08//2022: Creation of the booking form
package Forms.Booking;

import Forms.PersonalArea.FormPersonalArea;
import UniversitySecretaryTools.Booking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormBooking {
    private static JFrame frame;
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
    private JButton backButton;
    private static int idStudent = 0;

    public FormBooking() {
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Booking b = new Booking();
                if(!b.checkBookingExist(dataTextField.getText())){
                    b.saveBooking(dataTextField.getText(), notetextArea.getText(), idStudent);
                }else{
                    JOptionPane.showMessageDialog(null, "Booking already exist");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPersonalArea f = new FormPersonalArea();
                f.init(idStudent);
                frame.dispose();
            }
        });
        dataTextField.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //declare and set text field date properties
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                //dataTextField = new JFormattedTextField(format);
                dataTextField.setFormatterFactory(tf);
                dataTextField.setValue(new Date());
            }
        });
    }

    public  void init(int idStudent) {
        this.idStudent = idStudent;
        frame = new JFrame("University Secretary - Make a reservation");
        frame.setContentPane(new FormBooking().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}