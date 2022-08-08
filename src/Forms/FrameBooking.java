package Forms;//Changes of 01/08/2022: Translation of Italian prints into English, changing the positions of objects in jpanel, adding colors and borders

import UniversitySecretaryTools.Booking;
import UniversitySecretaryTools.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameBooking {
    private static JFrame frame;
    private static JFormattedTextField field_date;
    private static JTextField field_note;
    private static int id_student = 0;

    public FrameBooking(int id_studente) {
        this.id_student = id_studente;

        //declare and set panel properties (and add panel)
        frame = new JFrame();
        frame.setTitle("Booking-University Secretary");
        frame.setLocation(new Point(500, 500));

        //call menu
        menu();
    }

    //fun that init menu
    private static void menu() {
        clearFrame();

        //declare and set title menu properties
        JLabel label_menu = new JLabel();
        label_menu.setFont(new java.awt.Font("Tahoma", 0, 36));
        label_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_menu.setText("Booking");

        //declare and set button book section properties and event
        JButton button_book_section = new JButton();
        button_book_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_book_section.setText("Make a reservation");
        button_book_section.setBackground(Color.getHSBColor(35, 90, 100));
        button_book_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBookSectionActionPerformed(evt);
            }
        });

        //declare and set button manage book section properties and event
        JButton button_manage_book_section = new JButton();
        button_manage_book_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_manage_book_section.setText("Manage Bookings");
        button_manage_book_section.setBackground(Color.getHSBColor(35, 90, 100));
        button_manage_book_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageBookSectionActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_menu = new JPanel(new GridLayout(3, 1));
        pannello_menu.setBackground(Color.getHSBColor(352, 90, 62));
        pannello_menu.setBorder(BorderFactory.createEmptyBorder(40, 10, 50, 10));
        pannello_menu.add(label_menu);
        pannello_menu.add(button_book_section);
        pannello_menu.add(button_manage_book_section);
        pannello_menu.setVisible(true);

        //add to frame
        frame.add(pannello_menu);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //fun that load book page
    private static void book() {
        clearFrame();

        //declare and set label_date properties
        JLabel label_date = new JLabel();
        label_date.setFont(new java.awt.Font("Tahoma", 0, 36));
        label_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_date.setText("Date");

        //declare and set label_note properties
        JLabel label_note = new JLabel();
        label_note.setFont(new java.awt.Font("Tahoma", 0, 24));
        label_note.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_note.setText("Note");

        //declare and set text field note
        field_note = new JTextField();
        field_note.setFont(new java.awt.Font("Tahoma", 0, 24));

        //declare and set text field date properties
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        field_date = new JFormattedTextField(format);
        field_date.setValue(new Date());

        //declare and set text field date properties
        field_note = new JTextField();
        field_note.setFont(new java.awt.Font("Tahoma", 0, 24));

        //declare and set button book properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("<- Back to menu");
        button_menu.setBackground(Color.getHSBColor(35, 90, 100));
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare and set button book properties and event
        JButton button_book = new JButton();
        button_book.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_book.setText("Book");
        button_book.setBackground(Color.getHSBColor(35, 90, 100));
        button_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBookActionPerformed(evt);
            }
        });

        //Changed the position of the components in the jpanel(01/08/2022)
        //declare and set panel properties (and add components)
        JPanel pannello_book = new JPanel(new GridLayout(3, 1));
        pannello_book.setBackground(Color.getHSBColor(352, 90, 62));
        pannello_book.setBorder(BorderFactory.createEmptyBorder(40, 10, 50, 10));
        pannello_book.add(label_date);
        pannello_book.add(field_date);
        pannello_book.add(label_note);
        pannello_book.add(field_note);
        pannello_book.add(button_menu);
        pannello_book.add(button_book);
        pannello_book.setVisible(true);

        //add to frame
        frame.add(pannello_book);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //fun that load book manage page
    private static void bookManage() {
        clearFrame();

        //declare and set button menu properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("<- Back to menu");
        button_menu.setBackground(Color.getHSBColor(35, 90, 100));
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare list model
        DefaultListModel<String> l = new DefaultListModel<>();

        //create obj UniversitySecretary for use fun that get counter and read bookings of student (by id)
        Booking b = new Booking();

        //call function that add element in l
        l = b.set_booking_to_list(id_student);

        //declare JList and add list
        JList<String> list_booking = new JList<>(l);
        list_booking.setBounds(100, 100, 75, 75);

        //declare and set panel properties (and add components)
        JPanel pannello_book_manage = new JPanel(new GridLayout(3, 1));
        pannello_book_manage.setBackground(Color.getHSBColor(352, 90, 62));
        pannello_book_manage.setBorder(BorderFactory.createEmptyBorder(40, 10, 50, 10));
        pannello_book_manage.add(list_booking);
        pannello_book_manage.add(button_menu);
        pannello_book_manage.setVisible(true);


        //add to frame
        frame.add(pannello_book_manage);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //fun that clear frame
    private static void clearFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    //-----------------------------------------functions events-----------------------------------------

    //tp to menu page
    private static void buttonMenuActionPerformed(java.awt.event.ActionEvent evt) {
        menu();
    }

    //tp to book page
    private static void buttonBookSectionActionPerformed(ActionEvent evt) {
        book();
    }

    //tp to book manage page
    private static void buttonManageBookSectionActionPerformed(ActionEvent evt) {
        bookManage();
    }

    //book
    private static void buttonBookActionPerformed(ActionEvent evt) {

        //create us obj
        Booking b = new Booking();

        //check if booking exist already
        if (!b.checkBookingExist(field_date.getText())) {

            //call save booking fun parsing fields and is_student
            b.saveBooking(field_date.getText(), field_note.getText(), id_student);
        } else {
            JOptionPane.showMessageDialog(null, "Already booked, try again with another time combination!");
        }
    }

    //book manage
    private static void buttonBookCheckActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Call fun code that load booking (by id)");
        //System.out.println("call fun code that load booking (by id)");
    }
}