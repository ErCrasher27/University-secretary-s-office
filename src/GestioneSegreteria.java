
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

        //define obj, json array, json parser and obj result
        Object obj = null;
        JSONArray jrr = new JSONArray();
        JSONParser Jp = new JSONParser();

        //read file and parse in jrr
        try {
            FileReader file = new FileReader("Students.json");
            obj = Jp.parse(file);
            jrr = (JSONArray) obj;

            //prepare user_pass as JSON ARRAY for compare with obj want login
            JSONObject parser_obj = null;
            JSONObject user_pass = new JSONObject();
            JSONArray user_pass_array = new JSONArray();

            for (int i = 0; i < jrr.size(); i++) {
                parser_obj = (JSONObject) jrr.get(i);

                System.out.println(((JSONObject) jrr.get(i)).get("Username"));

                user_pass.put("Username", (String) parser_obj.get("Username"));
                user_pass.put("Password", (String) parser_obj.get("Password"));

                user_pass_array.add(user_pass);


            }

            file.close();
        } catch (
                Exception ex) {
            System.out.println("Errore");
        }

        //declare json obj to put inside username and pw (prepare obj want login)
        JSONObject jobj = new JSONObject();
        jobj.put("Username", s.getUsername());
        jobj.put("Password", s.getPassword());
        System.out.println(jobj.get("Username"));


        System.out.println(jobj);
        boolean matched = false;

        //loop to check validation
        for (int i = 0; i < jrr.size(); i++) {

            if (((JSONObject) jrr.get(i)).get("Username").equals(jobj.get("Username"))) {
                System.out.println("andato bro");
            }

            if (jobj.equals(jrr.get(i))) {
                matched = true;
                break;
            }
        }

        //output if matched or not
        if (matched) {
            System.out.println("Login effetuato con successo");
        } else {
            System.out.println("Username o Password errati");
        }
    }

}
