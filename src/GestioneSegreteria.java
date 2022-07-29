import java.io.*;

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
        JSONObject js = new JSONObject();
        js.put("Id", "1");
        js.put("Nome", s.getName());
        js.put("Cognome", s.getSurname());
        js.put("Username", s.getUsername());
        js.put("Password", s.getPassword());
        js.put("Email", s.getEmail());
        js.put("CF", s.getCF());

        //write on JSON file
        try (FileWriter file = new FileWriter("Studenti.json", true)) {
            file.write(js.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }

    //function that login student in json
    public void loginUser(Studente s) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("Studenti.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("Nome");
            System.out.println(name);

            String age = (String) jsonObject.get("Cognome");
            System.out.println(age);

            // loop array
            /*JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();


        }
    }
}
