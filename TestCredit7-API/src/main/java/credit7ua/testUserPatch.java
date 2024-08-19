package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testUserPatch {
    public static void main(String[] args) throws IOException, InterruptedException {

        String requestBodyUserPatch = "{ \"code\": \"string\", \"mobile_phone\": \"string\"}";
        HttpRequest requestUserPatch = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyUserPatch))
                .uri(URI.create(userIdTokenApi3.baseURI + "/user/" + userIdTokenApi3.idUser + "/phone-confirmation"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();
        HttpClient userPatch = HttpClient.newHttpClient();
        HttpResponse<String> responseUserPatch = userPatch.send(requestUserPatch, HttpResponse.BodyHandlers.ofString());
        int statusCodeUserPatch = responseUserPatch.statusCode();
        String bodyUserPatch = responseUserPatch.body();
        String headersUserPatch = responseUserPatch.headers().map().toString();
        if (statusCodeUserPatch == 401) {
            System.out.println("401" + bodyUserPatch);
            System.out.println(headersUserPatch);
        } else if (statusCodeUserPatch == 200) {
            System.out.println("200 OK");
        }



    }
}
