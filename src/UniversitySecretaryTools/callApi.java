package UniversitySecretaryTools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class callApi {

    /*Function for tax code calculation via API*/
    public static boolean cfApi(String cf){
    /*Domain: sium.it
     Email: provaemailsium@gmail.com*/
        /*String containing the API token for tax code verification*/
        String tokenApi = "b539f483bac9a5b80a6c03c19e83d49a484d66ca1720565850d5eb712b7312e59e";
        boolean risp = false;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                /*Pass tax code and API token for tax code verification*/
                .uri(URI.create("https://api.miocodicefiscale.com/reverse?cf="+ cf +"&access_token="+tokenApi))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String answear = response.body();

        JSONParser jp = new JSONParser();
        JSONObject jobj = new JSONObject();

        try {
            jobj = (JSONObject) jp.parse(answear);
            risp= (boolean) jobj.get("status");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return risp;
    }
}

