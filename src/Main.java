public class Main {
    public static void main(String[] args) {
        Studente s = new Studente();
        s.setName("Francesco");
        s.setSurname("Grauso");
        s.setUsername("ErCrasher");
        s.setPassword("soloio");
        s.setEmail("francescograuso@live.it");
        s.setCF("GRSFNC02M27M28B");

        GestioneSegreteria gs = new GestioneSegreteria();
        gs.registerUser(s);
        gs.loginUser(s);
    }
}
