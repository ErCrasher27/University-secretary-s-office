package Test;

import UniversitySecretaryTools.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversitySecretaryTest {

    Student s1;
    Student s2;

    @BeforeEach
    void setUp() {
        s1 = new Student();
        s1.setUsername("ErCrasher");
        s1.setPassword("soloio");

        //Worong Login Student
        s2 = new Student();
        s2.setUsername("sbagliato@live.it");
        s2.setPassword("PzfX6YdZTcsnQ==");
    }

    @Test
    @DisplayName("Check Login credential")
    void loginStudent() {

        //Correct Login Student
        assertEquals(true, s1.loginStudent(),
                "User registered");
        assertEquals(false, s2.loginStudent(),
                "User not registered");
    }
}