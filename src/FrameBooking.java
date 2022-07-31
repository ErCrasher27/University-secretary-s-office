import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameBooking {
    private static JFrame frame;
    private static JFormattedTextField field_date;

    public FrameBooking(String s) {

        //declare and set panel properties (and add panel)
        frame = new JFrame();
        frame.setTitle("Segreteria Universitaria");
        frame.setLocation(new Point(500, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        label_menu.setText("Prenotazioni");

        //declare and set button book section properties and event
        JButton button_book_section = new JButton();
        button_book_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_book_section.setText("Effettua Prenotazione");
        button_book_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBookSectionActionPerformed(evt);
            }
        });

        //declare and set button manage book section properties and event
        JButton button_manage_book_section = new JButton();
        button_manage_book_section.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_manage_book_section.setText("Gestisci Prenotazioni");
        button_manage_book_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageBookSectionActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_menu = new JPanel(new GridLayout(3, 1));
        pannello_menu.add(label_menu);
        pannello_menu.add(button_book_section);
        pannello_menu.add(button_manage_book_section);
        pannello_menu.setVisible(true);

        //add to frame
        frame.add(pannello_menu);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    //fun that load book page
    private static void book() {
        clearFrame();

        //declare and set label_date properties
        JLabel label_date = new JLabel();
        label_date.setFont(new java.awt.Font("Tahoma", 0, 36));
        label_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_date.setText("Data");

        //declare and set text field date properties
        DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
        field_date = new JFormattedTextField(dateFormat);
        field_date.setName("Today");
        field_date.setColumns(10);
        field_date.setEditable(false);

        //declare and set button book properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("Menu");
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare and set button book properties and event
        JButton button_book = new JButton();
        button_book.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_book.setText("Prenota");
        button_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBookActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_book = new JPanel(new GridLayout(3, 1));
        pannello_book.add(button_menu);
        pannello_book.add(label_date);
        pannello_book.add(field_date);
        pannello_book.add(button_book);
        pannello_book.setVisible(true);

        //add to frame
        frame.add(pannello_book);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    //fun that load book manage page
    private static void bookManage() {
        clearFrame();

        //declare and set button menu properties and event
        JButton button_menu = new JButton();
        button_menu.setFont(new java.awt.Font("Tahoma", 0, 24));
        button_menu.setText("Menu");
        button_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuActionPerformed(evt);
            }
        });

        //declare and set panel properties (and add components)
        JPanel pannello_book_manage = new JPanel(new GridLayout(3, 1));
        pannello_book_manage.add(button_menu);
        pannello_book_manage.setVisible(true);

        //add to frame
        frame.add(pannello_book_manage);
        frame.setSize(400, 200);
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


        UniversitySecretary us = new UniversitySecretary();
        System.out.println(field_date);
        //us.checkBookingExist(field_date);
        System.out.println("call fun code that do a booking (with id_student == id logged)");
    }

    //book manage
    private static void buttonBookCheckActionPerformed(ActionEvent evt) {
        System.out.println("call fun code that load booking (by id)");
    }

}
