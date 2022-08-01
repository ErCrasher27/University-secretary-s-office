import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.Key;
import javax.crypto.Cipher;

/*Creation of the class Students*/
public class Student {
    private String name, surname, username, password, email, cf = null;
    int id = 0;

    /*Creation of the procedure for the acquisition of the student’s name*/
    public void setName(String name) {
        this.name = name;
    }

    /*Creation of function for visualization of the student’s name*/
    public String getName() {
        return this.name;
    }

    /*Creation of the procedure for the acquisition of the student’s surname*/
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /*Creation of function for visualization of the student’s surname*/
    public String getSurname() {
        return this.surname;
    }

    /*Creation of the procedure for the acquisition of the student’s username*/
    public void setUsername(String username) {
        this.username = username;
    }

    /*Creation of function for visualization of the student’s username*/
    public String getUsername() {
        return this.username;
    }

    /*Creation of the procedure for the acquisition of the student’s password*/
    public void setPassword(String password) {
        String enc_pw = encrypt(password);
        this.password = enc_pw;
    }

    /*Creation of function for visualization of the student’s password*/
    public String getPassword() {
        return this.password;
    }


    /*Creation of the procedure for the acquisition of the student’s email*/
    public void setEmail(String email) {

        /*Checking for the @ in the email address. If it is present, its existence is verified*/
        Pattern pattern = Pattern.compile("@", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        if (matchFound) {
            this.email = email;
        } else {
            System.out.println("email not valid");
        }
    }

    /*Creation of function for visualization of the student’s email*/
    public String getEmail() {
        return this.email;
    }

    /*Creation of the procedure for the acquisition of the student’s CF*/
    public void setCF(String cf) {
        //check if length is right
        if (cf.length() == 16) {
            //check if pattern is right
            Pattern pattern = Pattern.compile("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cf);
            boolean matchFound = matcher.find();
            if (matchFound) {
                //check if name and surname are right for CF

                // calculate surname and name cf
                List<Character> surname_cf_list = surname_cf();
                List<Character> name_cf_list = name_cf();

                // convert in string
                String surname_cf_string = surname_cf_list.toString()
                        .substring(1, 3 * surname_cf_list.size() - 1)
                        .replaceAll(", ", "");
                String name_cf_string = name_cf_list.toString()
                        .substring(1, 3 * name_cf_list.size() - 1)
                        .replaceAll(", ", "");

                String surname_name_cf = surname_cf_string + name_cf_string;

                if (surname_name_cf.toUpperCase().equals(cf.substring(0, 6).toUpperCase())) {
                    this.cf = cf;
                } else {
                    System.out.println("cf not valid in base al tuo nome e cognome");
                    System.out.println(surname_name_cf.toUpperCase());
                    System.out.println(cf.substring(0, 6).toUpperCase());
                }
            } else {
                System.out.println("cf not valid, pattern");
            }
        } else {
            System.out.println("cf == 16");
        }


    }

    /*Creation of function for visualization of the student’s CF*/
    public String getCF() {
        return this.cf;
    }

    /*Creation of the procedure for the acquisition of the student’s CF*/
    public void setId(int id) {
        this.id = id;
    }

    /*Creation of function for visualization of the student’s CF*/
    public int getId() {
        return this.id;
    }

    public List<Character> surname_cf() {

        // dichiaro lista risultato
        List<Character> res_surname = new ArrayList<Character>();

        // dichiaro booleano e tentativi
        boolean vocale = false;
        int tentativi = 1;

        // dichiaro gli array vocali
        char[] vocali = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};

        // scompongo il cognome in array char
        char[] cognome_scomposto = new char[this.surname.length()];

        // copia array in cognome_scomposto
        for (int i = 0; i < this.surname.length(); i++) {
            cognome_scomposto[i] = this.surname.charAt(i);
        }

        // ciclo per la lenght del cognome, setto la booleana vocale a false come
        // semaforo, poi ciclo per quante sono le vocali e setto la booleana, se false
        // copio in array result
        while (res_surname.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < this.surname.length(); i++) {

                    // se il res è = 3 allora break
                    if (res_surname.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // comparo cognome[i] e vocale[j]
                        if (cognome_scomposto[i] == vocali[j]) {
                            vocale = true;
                            break;
                        }
                    }

                    // pusho il risultato
                    if (!vocale) {
                        res_surname.add(cognome_scomposto[i]);
                    }
                }
            } else if (tentativi == 2) {
                for (int i = 0; i < this.surname.length(); i++) {

                    // se il res è = 3 allora break
                    if (res_surname.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // comparo cognome[i] e vocale[j]
                        if (cognome_scomposto[i] == vocali[j]) {
                            vocale = true;
                        }
                    }

                    // pusho il risultato (stavolta solo se è vocale)
                    if (vocale) {
                        res_surname.add(cognome_scomposto[i]);
                    }
                }

                // riempio di x fino a 3
            } else if (tentativi == 3) {
                while (res_surname.size() < 3) {
                    res_surname.add('x');
                }

            }
            tentativi += 1;
        }

        return res_surname;
    }

    public List<Character> name_cf() {

        // dichiaro lista risultato
        List<Character> res_name = new ArrayList<Character>();

        // dichiaro booleano, tentativi e secondo carattere
        boolean vocale = false;
        int tentativi = 1;
        boolean sec_char = true;

        // dichiaro gli array vocali
        char[] vocali = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};

        // scompongo il nome in array char
        char[] nome_scomposto = new char[this.name.length()];

        // copia array in nome_scomposto
        for (int i = 0; i < this.name.length(); i++) {
            nome_scomposto[i] = this.name.charAt(i);
        }

        // conto le consonanti per verificare se saltare o meno la seconda consonant
        // (solo se minore di 4 consonanti)
        int count_consonanti = 0;
        for (int i = 0; i < this.name.length(); i++) {
            char ch = this.name.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                System.out.print("");
            } else if (ch != ' ') {
                count_consonanti += 1;
            }
        }

        // in caso di consonanti minori di 4, allora non salterò la seconda consonante
        if (count_consonanti < 4) {
            sec_char = false;
        }

        // ciclo per la lenght del nome, setto la booleana vocale a false come
        // semaforo, poi ciclo per quante sono le vocali e setto la booleana, se false
        // copio in array result

        while (res_name.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < this.name.length(); i++) {

                    // se il res è = 3 allora break
                    if (res_name.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // comparo nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                            break;
                        }
                    }

                    // pusho il risultato
                    if (!vocale) {
                        if (res_name.size() == 1 && sec_char == true) {
                            sec_char = false;
                            continue;
                        }
                        res_name.add(nome_scomposto[i]);
                    }
                }
            } else if (tentativi == 2) {
                for (int i = 0; i < this.name.length(); i++) {

                    // se il res è = 3 allora break
                    if (res_name.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // comparo nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                        }
                    }

                    // pusho il risultato (stavolta solo se è vocale)
                    if (vocale) {
                        res_name.add(nome_scomposto[i]);
                    }
                }

                // riempio di x fino a 3
            } else if (tentativi == 3) {
                while (res_name.size() < 3) {
                    res_name.add('x');
                }
            }
            tentativi += 1;
        }

        return res_name;
    }

    //fun that encrypt pw
    public String encrypt(String pw) {
        String key = "Uso12345Uso12345";
        String pass = null;
        try {

            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            // encrypt
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(pw.getBytes());

            //reconvert to string
            pass = Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pass;
    }

    //fun that decrypt pw
    /*public String decrypt(String pw) {
        String key = "Uso12345Uso12345";
        String pass = null;
        try
        {
            byte[] encrypted = Base64.getDecoder().decode(pw);

            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            // decrypt
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            pass = decrypted;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  pass;
    }*/

}