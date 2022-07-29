import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Studente s = new Studente();
        s.setName("Francesco");
        s.setSurname("Grauso");
        s.setUsername("ErCrasher");
        s.setPassword("soloio");
        s.setEmail("francescograuso@live.it");
        s.setCF("GRSFNC02M27M28B");

        Studente s2 = new Studente();
        s2.setName("Vincenzo");
        s2.setSurname("Angelini");
        s2.setUsername("schifName");
        s2.setPassword("solotu");
        s2.setEmail("vincenzoangelini@live.it");
        s2.setCF("VNCSDIDJ23NJSDS");

        GestioneSegreteria gs = new GestioneSegreteria();
      // gs.registerUser(s);
      // gs.registerUser(s2);
       gs.loginUser(s);
    }
}
