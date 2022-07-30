
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
    //function that register student in json
    public int registerUser(Studente s) {

        //set student stats
        JSONObject student_stats = new JSONObject();
        student_stats.put("Id", "1");
        student_stats.put("Nome", s.getName());
        student_stats.put("Cognome", s.getSurname());
        student_stats.put("Username", s.getUsername());
        student_stats.put("Password", s.getPassword());
        student_stats.put("Email", s.getEmail());
        student_stats.put("CF", s.getCF());

        //add in student
        JSONObject student = new JSONObject();
        student.put("Studente", student_stats);

        //add student to list
        JSONArray studentList  = new JSONArray();
        studentList.add(student);

        //write on JSON file
        try (FileWriter file = new FileWriter("Studenti.json")) {
            file.write(studentList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
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
