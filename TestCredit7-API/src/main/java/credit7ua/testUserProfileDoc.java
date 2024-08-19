package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testUserProfileDoc {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestGenerateToken = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/documents/user-profile/generate?token=" + userIdTokenApi3.apiToken))
                .header("accept", "application/json")
                .build();

        HttpClient clientGenerate = HttpClient.newHttpClient();

        HttpResponse<String> responseGenerate = clientGenerate.send(requestGenerateToken, HttpResponse.BodyHandlers.ofString());
        int statusCodeGenerate = responseGenerate.statusCode();
        String bodyGenerate = responseGenerate.body();
        String headersGenerate = responseGenerate.headers().map().toString();
        if (statusCodeGenerate == 500) {
            System.out.println("500 error");
        } else if (statusCodeGenerate == 200) {
            System.out.println("200" + bodyGenerate);
            System.out.println(headersGenerate);
        }




    }
}