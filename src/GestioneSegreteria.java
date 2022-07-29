import org.json.simple.*;

import java.io.FileWriter;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestioneSegreteria {
    Studente s;

    //function that register student in json
    public int registerUser(Studente s){
        JSONObject js = new JSONObject();
        js.put("Id", "1");
        js.put("Nome", s.getName());
        js.put("Cognome", s.getSurname());
        js.put("Username", s.getUsername());
        js.put("Password", s.getPassword());
        js.put("Email", s.getEmail());
        js.put("CF",  s.getCF());

        //write on JSON file
        try (FileWriter file = new FileWriter("Studenti.json")) {
            file.write(js.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }

    //function that login student in json
    public int loginUser(Studente s){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("Studenti.json"));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray companyList = (JSONArray) jsonObject.get("");

            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
