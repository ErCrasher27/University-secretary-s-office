public class Main {
    public static void main(String[] args) {
        Studente s1 = new Studente();
        s1.setName("Francesco");
        s1.setSurname("Grauso");
        s1.setUsername("ErCrasher");
        s1.setEmail("francescograuso@live.it");
        s1.setCF("GRSFNC02M27M28B");

        System.out.println(s1.getName());
        System.out.println(s1.getSurname());
        System.out.println(s1.getUsername());
        System.out.println(s1.getEmail());
        System.out.println(s1.getCF());


    }
}
