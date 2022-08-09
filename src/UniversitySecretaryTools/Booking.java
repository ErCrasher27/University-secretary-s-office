package UniversitySecretaryTools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.mail.MessagingException;
import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;

public class Booking {
    public boolean checkBookingExist(String date) {

        //define obj, json array and json parser
        Object obj = null;
        JSONArray jrr = new JSONArray();
        JSONParser Jp = new JSONParser();

        //read file and parse in jrr
        try {
            FileReader file = new FileReader("Booking.json");
            obj = Jp.parse(file);
            jrr = (JSONArray) obj;
            file.close();
        } catch (
                Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!");
        }

        //declare json obj to put inside username and pw (prepare obj want login)
        JSONObject jobj = new JSONObject();
        jobj.put("Data", date);
        boolean matched = false;

        //loop to check validation
        for (int i = 0; i < jrr.size(); i++) {
            if (((JSONObject) jrr.get(i)).get("Data").equals(jobj.get("Data"))) {
                matched = true;
                return matched;
            }
        }
        //return false
        return matched;
    }

    public void saveBooking(String date, String note, int id_studente) {

        //define json obj, array, parser
        JSONObject jobj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();

        //read file to add content in jrr (from jp)
        try {
            FileReader file = new FileReader("Booking.json");
            jrr = (JSONArray) jp.parse(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!");
        }

        //adding student's stats to json object
        jobj.put("Data", date);
        jobj.put("Note", note);
        jobj.put("Id_student", id_studente);

        //add jobj in jrr, now jrr has  all students + the last registration
        jrr.add(jobj);

        //write on json file adding jrr
        try {
            FileWriter file = new FileWriter("Booking.json");
            file.write(jrr.toJSONString());
            file.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!");
        }
        JOptionPane.showMessageDialog(null, "Booking successfully made!");

        //send email
        String email = get_email_by_id(id_studente);
        try {
            Email.Send(email, date, note);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    //fun that get booking by id
    public DefaultListModel<String> set_booking_to_list(int id) {

        //define list model
        DefaultListModel<String> l = new DefaultListModel<>();

        //define json obj, array, parser
        JSONObject jobj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();

        //read file to add content in jrr (from jp)
        try {
            FileReader file = new FileReader("Booking.json");
            jrr = (JSONArray) jp.parse(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!");
        }

        //adding student's id to json object
        jobj.put("Id_student", id);

        //loop to check if id parse == id_student of booking
        for (int i = 0; i < jrr.size(); i++) {
            if (((JSONObject) jrr.get(i)).get("Id_student").toString().equals(jobj.get("Id_student").toString())) {

                //prepare row and add in l
                String row = "DATA: " + ((JSONObject) jrr.get(i)).get("Data").toString() + "   NOTE: " + ((JSONObject) jrr.get(i)).get("Note").toString();
                l.addElement(row);
            }
        }
        return l;
    }

    //fun that get email by id
    public String get_email_by_id(int id) {

        //define json obj, array, parser
        JSONObject jobj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();

        //read file to add content in jrr (from jp)
        try {
            FileReader file = new FileReader("Students.json");
            jrr = (JSONArray) jp.parse(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!");
        }

        //adding student's id to json object
        jobj.put("Id", id);

        //loop to check if id parse == id_student of booking
        for (int i = 0; i < jrr.size(); i++) {
            if (((JSONObject) jrr.get(i)).get("Id").toString().equals(jobj.get("Id").toString())) {
                String email = ((JSONObject) jrr.get(i)).get("Email").toString();
                return email;
            }
        }
        return null;
    }
}