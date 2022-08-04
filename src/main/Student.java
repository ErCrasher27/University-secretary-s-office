package main;/*Class Students containing all functions for operations on student data*/

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void setPassword(String password) { String enc_pw = encrypt(password); this.password = enc_pw;
    }

    /*Creation of function for visualization of the student’s password*/
    public String getPassword() {
        return this.password;
    }


    /*Creation of the procedure for the acquisition of the student’s email*/
    public void setEmail(String email) {

        //save regex that check too if email contain a dot
        String regex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}";

        //set regex in a pattern
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        if (matchFound) {
            this.email = email;
        } else {
            JOptionPane.showMessageDialog(null, "Email not valid");
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
                    JOptionPane.showMessageDialog(null, "Invalid tax code by first and last name");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tax code format not valid");
            }
        } else {
            JOptionPane.showMessageDialog(null, "The number of characters of the tax code must be equal to 16");
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

        // declare list result
        List<Character> res_surname = new ArrayList<Character>();

        // boolean declaring and attempts
        boolean vocale = false;
        int tentativi = 1;

        // declare voice arrays
        char[] vocali = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};

        // decompose the surname in array char
        char[] cognome_scomposto = new char[this.surname.length()];

        // copying array in full name_decomposed
        for (int i = 0; i < this.surname.length(); i++) {
            cognome_scomposto[i] = this.surname.charAt(i);
        }

        // loop for the lenght of the surname, set the vocal boolean to false as
        // semaphore, then loop for how many vowels and septum the boolean, if false
        // script in array result

        while (res_surname.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < this.surname.length(); i++) {

                    // x fill up to 3
                    if (res_surname.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // compare cognome[i] e vocale[j]
                        if (cognome_scomposto[i] == vocali[j]) {
                            vocale = true;
                            break;
                        }
                    }

                    // push the result
                    if (!vocale) {
                        res_surname.add(cognome_scomposto[i]);
                    }
                }
            } else if (tentativi == 2) {
                for (int i = 0; i < this.surname.length(); i++) {

                    // if the res is = 3
                    if (res_surname.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // compare cognome[i] e vocale[j]
                        if (cognome_scomposto[i] == vocali[j]) {
                            vocale = true;
                        }
                    }

                    // push the result (this time only if it’s vocal)
                    if (vocale) {
                        res_surname.add(cognome_scomposto[i]);
                    }
                }

                // x fill up to 3
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
        // declare list result
        List<Character> res_name = new ArrayList<Character>();

        // declare boolean, attempts and second character
        boolean vocale = false;
        int tentativi = 1;
        boolean sec_char = true;

        // declare the voice arrays
        char[] vocali = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};

        // decompose the name in array char
        char[] nome_scomposto = new char[this.name.length()];

        // copy array in name
        for (int i = 0; i < this.name.length(); i++) {
            nome_scomposto[i] = this.name.charAt(i);
        }

        // count consonants to check whether or not to skip the second consonant
        // (only if less than 4 consonants)
        int count_consonanti = 0;
        for (int i = 0; i < this.name.length(); i++) {
            char ch = this.name.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                System.out.print("");
            } else if (ch != ' ') {
                count_consonanti += 1;
            }
        }

        // in case of consonants less than 4, then I will not skip the second consonant
        if (count_consonanti < 4) {
            sec_char = false;
        }

        // loop for name lenght, set the voice boolean to false as
        // semaphore, then loop for how many vowels and septum the boolean, if false
        // script in array result
        while (res_name.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < this.name.length(); i++) {

                    //  x fill up to 3
                    if (res_name.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // compare nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                            break;
                        }
                    }

                    // push the result
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

                    //  x fill up to 3
                    if (res_name.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {

                        // compare nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                        }
                    }

                    // push the result (this time only if it is vocal)
                    if (vocale) {
                        res_name.add(nome_scomposto[i]);
                    }
                }

                // x fill up to 3
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