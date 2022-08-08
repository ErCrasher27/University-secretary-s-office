package UniversitySecretaryTools;/*Class Students containing all functions for operations on student data*/

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
        TaxCode t = new TaxCode();
        boolean exist=t.check(cf, getSurname(), getName());
        if (exist)this.cf = cf;
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