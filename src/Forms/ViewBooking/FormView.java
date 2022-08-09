package Forms.ViewBooking;

import Forms.PersonalArea.FormPersonalArea;
import UniversitySecretaryTools.Booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormView {
    private static JFrame frame;
    private JPanel mainPanel;
    private JPanel formPanel;
    private JPanel listPanel;
    private JList bookingList;
    private JButton backButton;
    private static int idStudent = 0;

    public FormView() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPersonalArea f = new FormPersonalArea();
                f.init(idStudent);
                frame.dispose();
            }
        });

        bookingList.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //declare list model
                DefaultListModel<String> l = new DefaultListModel<>();
                //create obj UniversitySecretary for use fun that get counter and read bookings of student (by id)
                Booking b = new Booking();
                //call function that add element in l
                l = b.set_booking_to_list(idStudent);
                //add list
                bookingList.setModel(l);
            }
        });
    }

    public void init(int idStudent) {
        this.idStudent = idStudent;
        frame = new JFrame("University Secretary - Your booking");
        frame.setContentPane(new FormView().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setMaximumSize(new Dimension(1280, 800));
        frame.setPreferredSize(new Dimension(1280, 768));
        frame.pack();
        frame.setVisible(true);
    }
}
