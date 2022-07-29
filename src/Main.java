public class Main {
    public static void main(String[] args) {
        Studente s = new Studente();
        s.setName("Francesco");
        s.setSurname("Grauso");
        s.setUsername("ErCrasher");
        s.setEmail("francescograuso@live.it");
        s.setCF("GRSFNC02M27M28B");

        System.out.println(s.getName());
        System.out.println(s.getSurname());
        System.out.println(s.getUsername());
        System.out.println(s.getEmail());
        System.out.println(s.getCF());

        GestioneSegreteria gs = new GestioneSegreteria();
        gs.registerUser(s)

    }
}
