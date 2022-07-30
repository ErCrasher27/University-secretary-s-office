
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestioneSegreteria {
    Student s;

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
            System.out.println("Errore");
        }

        //adding student's stats to json object
        jobj.put("Id", "1");
        jobj.put("Nome", s.getName());
        jobj.put("Cognome", s.getSurname());
        jobj.put("Username", s.getUsername());
        jobj.put("Password", s.getPassword());
        jobj.put("Email", s.getEmail());
        jobj.put("CF", s.getCF());

        //add jobj in jrr, now jrr has  all students + the last registration
        jrr.add(jobj);

        //write on json file adding jrr
        try {
            FileWriter file = new FileWriter("Students.json");
            file.write(jrr.toJSONString());
            file.close();
        } catch (Exception ex) {
            System.out.println("Errore");
        }
        System.out.println("Registrazione avvenuta con successo");
    }

    //function that login student in json
    public void loginStudent(Student s) {

        //define obj, json array and json parser
        Object obj = null;
        JSONArray jrr = new JSONArray();
        JSONParser Jp = new JSONParser();

        //read file nad parse in jrr
        try {
            FileReader file = new FileReader("Students.json");
            obj = Jp.parse(file);
            jrr = (JSONArray) obj;
            file.close();
        } catch (
                Exception ex) {
            System.out.println("Errore");
        }

        //declare json obj to put inside username and pw
        JSONObject jobj = new JSONObject();
        jobj.put("Username", s.getUsername());
        jobj.put("Password", s.getPassword());
        boolean matched = false;

        //loop to check validation
        for (int i = 0; i < jrr.size(); i++) {
            if (jobj.equals(jrr.get(i))) {
                matched = true;
                break;
            }
        }

        //output if matched or not
        if(matched){
            System.out.println("Login effetuato con successo");
        }
        else{
            System.out.println("Username o Password errati");
        }
    }

}
