package Test;

import UniversitySecretaryTools.callApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallApiTest {

    callApi a;

    @BeforeEach
    void setUp() {
        a = new callApi();
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
}
