import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;

import static javax.swing.UIManager.get;

public class UniversitySecretary {

    //function that register student in json file
    public void registerStudent(Student s) {

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

        //adding student's stats to json object
        jobj.put("Username", s.getUsername());
        jobj.put("Email", s.getEmail());
        jobj.put("CF", s.getCF());


        //*****************************************//
        //loop to check if email, cf or username already exists
        boolean exist = false;
        for (int i = 0; i < jrr.size(); i++) {
            if ((((JSONObject) jrr.get(i)).get("Email").equals(jobj.get("Email")))
                    || (((JSONObject) jrr.get(i)).get("CF").equals(jobj.get("CF")))
                    || (((JSONObject) jrr.get(i)).get("Username").equals(jobj.get("Username")))) {
                exist = true;
            }
        }

        if (!exist) {

            //add jobj in jrr, now jrr has  all students + the last registration
            jobj.put("Nome", s.getName());
            jobj.put("Cognome", s.getSurname());
            jobj.put("Password", s.getPassword());
            jobj.put("Id", jrr.size() + 1);
            jrr.add(jobj);

            //write on json file adding jrr
            try {
                FileWriter file = new FileWriter("Students.json");
                file.write(jrr.toJSONString());
                file.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error!");
            }
            JOptionPane.showMessageDialog(null, "Registration has been successful!");

        } else {
            JOptionPane.showMessageDialog(null, "Already exists!");
        }


    }

    //function that login student in json
    public boolean loginStudent(Student s) {

        //define obj, json array and json parser
        Object obj = null;
        JSONArray jrr = new JSONArray();
        JSONParser Jp = new JSONParser();

        //read file and parse in jrr
        try {
            FileReader file = new FileReader("Students.json");
            obj = Jp.parse(file);
            jrr = (JSONArray) obj;
            file.close();
        } catch (
                Exception ex) {
            JOptionPane.showMessageDialog(null, "Error!");
        }

        //declare json obj to put inside username and pw (prepare obj want login)
        JSONObject jobj = new JSONObject();
        jobj.put("Username", s.getUsername());
        jobj.put("Password", s.getPassword());
        s.encrypt((String) jobj.get("Password"));

        //declare result
        boolean matched = false;

        //loop to check validation
        for (int i = 0; i < jrr.size(); i++) {

            if ((((JSONObject) jrr.get(i)).get("Username").equals(jobj.get("Username"))) && (((JSONObject) jrr.get(i)).get("Password").equals(jobj.get("Password")))) {
                //get id and set it, than return matched true
                Long id = (Long) ((JSONObject) jrr.get(i)).get("Id");
                int id_convert = id.intValue();
                s.setId(id_convert);
                matched = true;
                return matched;
            }
        }

        //login failed, so return false
        return matched;
    }

    //fun that check if booking exist
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

    //function that save the booking
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
    }


    //************************ QUA **************************//
    //fun that get booking by id
    public Object[] get_booking(int id) {
        //prepare result
        Object[] res_booking = null;

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

        //*****************************************//
        //loop to check if id parse == id_student of booking
        for (int i = 0; i < jrr.size(); i++) {

            //printo per vedere se so uguali (spoiler: lo sono)
            System.out.println(jobj.get("Id_student"));
            System.out.println(((JSONObject) jrr.get(i)).get("Id_student"));


            //non entra, anche se sono uguali, guarda i print sopra
            if (((JSONObject) jrr.get(i)).get("Id_student").toString().equals(jobj.get("Id_student").toString() )) {

                System.out.println("sono dentro");

                res_booking[i] = (Object[]) jrr.get(i);

            }
        }
        System.out.println("sono fuori");

        System.out.println(res_booking);

        return res_booking;
    }

}