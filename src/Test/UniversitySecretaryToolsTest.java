package Test;

import UniversitySecretaryTools.Student;
import UniversitySecretaryTools.Booking;
import UniversitySecretaryTools.callApi;
import UniversitySecretaryTools.TaxCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversitySecretaryToolsTest {

    Student s1;
    Student s2;
    TaxCode t;
    callApi a;
    Booking b1;

    @BeforeEach
    void setUp() {
        b1 = new Booking();
        b1.saveBooking("23/08/1991 17:07", "test", 1);
        s1 = new Student();
        s1.setUsername("ErCrasher");
        s1.setPassword("soloio");

        //Worong Login Student
        s2 = new Student();
        s2.setUsername("sbagliato@live.it");
        s2.setPassword("PzfX6YdZTcsnQ==");
        t = new TaxCode();
        a = new callApi();
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

    @Test
    @DisplayName("Check if the tax code has the correct pattern and if it exist")
    void check() {

        String cf1 = "NGLVCN03H03F839P";
        String name = "Vincenzo";
        String surname = "Angelino";
        String cf3 = "GRSFNC02M27M289B";
        String cf2 = "NCGGGG30I23F677P";
        //Correct Login Student
        assertEquals(true, t.check(cf1, surname, name),
                "cf exist");
        assertEquals(false, t.check(cf2, surname, name),
                "cf not exist");
        assertEquals(false, t.check(cf3, surname, name),
                "cf with the wrong name and surname");
    }

    @Test
    @DisplayName("Check if the tax code exist")
    void cfApi() {

        String cf1 = "NGLVCN03H03F839P";
        String cf2 = "NCGGGG30I23F677P";
        //Correct Login Student
        assertEquals(true, a.cfApi(cf1),
                "cf exist");
        assertEquals(false, a.cfApi(cf2),
                "cf not exist");
    }
    @Test
    @DisplayName("Check Booking exists")
    void bookingExists() {

        //find a book that already exist
        assertEquals(true, b1.checkBookingExist("23/08/1991 17:07"),
                "booking already exists");

        //find a book free
        assertEquals(false, b1.checkBookingExist("23/08/1990 17:01"),
                "booking free");
    }
}

