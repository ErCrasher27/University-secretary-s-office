package UniversitySecretaryTools;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxCode {

    public boolean check(String cf, String surname, String name) {

        boolean exist;
        //check if length is right
        if (cf.length() == 16) {
            if (callApi.cfApi(cf)) {
                //check if name and surname are right for CF

                // calculate surname and name cf
                List<Character> surname_cf_list = surname_cf(surname);
                List<Character> name_cf_list = name_cf(name);

                // convert in string
                String surname_cf_string = surname_cf_list.toString()
                        .substring(1, 3 * surname_cf_list.size() - 1)
                        .replaceAll(", ", "");
                String name_cf_string = name_cf_list.toString()
                        .substring(1, 3 * name_cf_list.size() - 1)
                        .replaceAll(", ", "");

                String surname_name_cf = surname_cf_string + name_cf_string;

                if (surname_name_cf.toUpperCase().equals(cf.substring(0, 6).toUpperCase())) {
                    Student s = new Student();
                    return exist = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid tax code by first and last name");
                }
            } else JOptionPane.showMessageDialog(null, "The tax code is not valid");
        } else {
            JOptionPane.showMessageDialog(null, "The number of characters of the tax code must be equal to 16");
        }
        return exist = false;
    }
    public List<Character> surname_cf(String surname) {

        // declare list result
        List<Character> res_surname = new ArrayList<Character>();

        // boolean declaring and attempts
        boolean vocale = false;
        int tentativi = 1;

        // declare voice arrays
        char[] vocali = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};

        // decompose the surname in array char
        char[] cognome_scomposto = new char[surname.length()];

        // copying array in full name_decomposed
        for (int i = 0; i < surname.length(); i++) {
            cognome_scomposto[i] = surname.charAt(i);
        }

        // loop for the lenght of the surname, set the vocal boolean to false as
        // semaphore, then loop for how many vowels and septum the boolean, if false
        // script in array result

        while (res_surname.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < surname.length(); i++) {

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
                for (int i = 0; i < surname.length(); i++) {

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

    public List<Character> name_cf(String name) {
        // declare list result
        List<Character> res_name = new ArrayList<Character>();

        // declare boolean, attempts and second character
        boolean vocale = false;
        int tentativi = 1;
        boolean sec_char = true;

        // declare the voice arrays
        char[] vocali = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};

        // decompose the name in array char
        char[] nome_scomposto = new char[name.length()];

        // copy array in name
        for (int i = 0; i < name.length(); i++) {
            nome_scomposto[i] = name.charAt(i);
        }

        // count consonants to check whether or not to skip the second consonant
        // (only if less than 4 consonants)
        int count_consonanti = 0;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
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
                for (int i = 0; i < name.length(); i++) {

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
                for (int i = 0; i < name.length(); i++) {

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
}
