package Test;

import UniversitySecretaryTools.TaxCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxCodeTest {

    TaxCode t;

    @BeforeEach
    void setUp() {
        t = new TaxCode();
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
}
