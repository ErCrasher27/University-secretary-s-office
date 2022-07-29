/*Class Students containing all functions for operations on student data*/
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.json.*;
/*Creation of the class Students*/
public class Studente {
    private String name, surname, username, password, email, cf = null;

    /*Creation of the procedure for the acquisition of the student’s name*/
    public void setName(String name){
        this.name = name;
    }
    /*Creation of function for visualization of the student’s name*/
    public String getName(){
        return this.name;
    }

    /*Creation of the procedure for the acquisition of the student’s surname*/
    public void setSurname(String surname){
        this.surname = surname;
    }
    /*Creation of function for visualization of the student’s surname*/
    public String getSurname(){
        return this.surname;
    }

    /*Creation of the procedure for the acquisition of the student’s username*/
    public void setUsername(String username){
        this.username = username;
    }
    /*Creation of function for visualization of the student’s username*/
    public String getUsername(){
        return this.username;
    }

    /*Creation of the procedure for the acquisition of the student’s password*/
    public void setPassword(String password){
        this.password = password;
    }
    /*Creation of function for visualization of the student’s password*/
    public String getPassword(){
        return this.password;
    }


    /*Creation of the procedure for the acquisition of the student’s email*/
    public void setEmail(String email){
        /*Checking for the @ in the email address. If it is present, its existence is verified*/
        Pattern pattern = Pattern.compile("@", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        if(matchFound) {
            this.email = email;
        } else {
            System.out.println("email not valid");
        }
    }
    /*Creation of function for visualization of the student’s email*/
    public String getEmail(){
        return this.email;
    }

    /*Creation of the procedure for the acquisition of the student’s CF*/
    public void setCF(String cf){
        this.cf = cf;
    }
    /*Creation of function for visualization of the student’s CF*/
    public String getCF(){
        return this.cf;
    }
}