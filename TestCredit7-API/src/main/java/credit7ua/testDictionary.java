package credit7ua;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public class testDictionary {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest requestDictionary = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/dictionary"))
                .header("accept","application/json")
                .build();

        HttpClient clientDictionary = HttpClient.newHttpClient();
        HttpResponse<String> responseDictionary =  clientDictionary.send(requestDictionary, HttpResponse.BodyHandlers.ofString());
        int statusCode = responseDictionary.statusCode();
        String body = responseDictionary.body();

        System.out.println(responseDictionary.statusCode());
        System.out.print(responseDictionary.body());

        ObjectMapper dictionaryMapper = new ObjectMapper();
        dictionaryMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES,false);
        JsonNode dictionaryFull = dictionaryMapper.readTree(body).get("education");
        List<DictionaryField> allFields = Collections.unmodifiableList(dictionaryMapper.readValue(dictionaryFull.traverse(), new TypeReference<List<DictionaryField>>() {
        }));
        System.out.println(allFields);

      //  Assert.assertEquals(statusCode, 200);
    }

}
