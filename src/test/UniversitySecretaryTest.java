package test;

import UniversitySecretaryTools.Student;
import main.UniversitySecretary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversitySecretaryTest {

    UniversitySecretary uni;

    @BeforeEach
    void setUp() {
        uni = new UniversitySecretary();
    }

    @Test
    @DisplayName("Check Login credential")
    void loginStudent() {

        //Correct Login Student
        Student s1 = new Student();
        s1.setUsername("ErCrasher");
        s1.setPassword("soloio");

        //Worong Login Student
        Student s2 = new Student();
        s2.setUsername("sbagliato@live.it");
        s2.setPassword("PzfX6YdZTcsnQ==");


        assertEquals(true, uni.loginStudent(s1),
                "User registered");
        assertEquals(false, uni.loginStudent(s2),
                "User not registered");
    }
}