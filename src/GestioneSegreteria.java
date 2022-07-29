import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class GestioneSegreteria {
    Studente s;

    //function that register student in json
    public int registerUser(Studente s){
        JSONObject js = new JSONObject();
        js.put("Id", "1");
        js.put("Nome", s.getName());
        js.put("Cognome", s.getSurname());
        js.put("Username", s.getUsername());
        //p1.put("Password", s.getPassword());
        js.put("Email", s.getEmail());
        js.put("CF",  s.getCF());

        //Write JSON file
        try (FileWriter file = new FileWriter("Studenti.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(js.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
