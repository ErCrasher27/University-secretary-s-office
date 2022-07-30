
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestioneSegreteria {
    Studente s;

    //function that register student in json file
    public void registerStudent(Studente s) {

        //define json obj, array, parser
        JSONObject jobj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();

        //read file to add content in jrr (from jp)
        try {
            FileReader file = new FileReader("Studenti.json");
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
            FileWriter file = new FileWriter("Studenti.json");
            file.write(jrr.toJSONString());
            file.close();
        } catch (Exception ex) {
            System.out.println("Errore");
        }
        System.out.println("Registrazione avvenuta con successo");
    }

    //function that login student in json
    public void loginUser(Studente s) throws IOException, ParseException {

        //get user e password for check it with json
        // String username = s.getUsername();
        // String password = s.getPassword();

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("Studenti.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void parseEmployeeObject(JSONObject emp) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) emp.get("Studente");

        //Get employee first name
        String firstName = (String) employeeObject.get("Nome");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("Cognome");
        System.out.println(lastName);

    }
}
