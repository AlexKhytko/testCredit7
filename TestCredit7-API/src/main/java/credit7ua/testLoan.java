package api3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testLoan{
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestDictionary = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/loan/" + userIdTokenApi3.idUser + "/sold-info"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientDictionary = HttpClient.newHttpClient();

        HttpResponse<String> responseDictionary = clientDictionary.send(requestDictionary, HttpResponse.BodyHandlers.ofString());
        int statusCode = responseDictionary.statusCode();
        String body = responseDictionary.body();
        if (statusCode == 404) {
        System.out.println("no loan");}
        else if (statusCode == 200) {
            System.out.println(responseDictionary.body());}
        else { System.out.println("ERROR");
        }

    }
}
