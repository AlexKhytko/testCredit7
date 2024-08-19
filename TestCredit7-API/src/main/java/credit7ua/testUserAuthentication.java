package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testUserAuthentication {
    public static void main(String[] args) throws IOException, InterruptedException {

    String requestBodyUserAuthentication = "{ \"refreshToken\": \"string\"}";
    HttpRequest requestUserAuthentication = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(requestBodyUserAuthentication))
            .uri(URI.create(userIdTokenApi3.baseURI + "/api/user/refresh-auth-token"))
            .header("accept", "application/json")
            .header("Content-Type", "application/json")
            .header("ApiKey", userIdTokenApi3.apiToken)
            .build();
    HttpClient userAuthentication = HttpClient.newHttpClient();
    HttpResponse<String> responseUserAuthentication = userAuthentication.send(requestUserAuthentication, HttpResponse.BodyHandlers.ofString());
    int statusCodeUserAuthentication = responseUserAuthentication.statusCode();
    String bodyUserAuthentication = responseUserAuthentication.body();
    String headersUserAuthentication = responseUserAuthentication.headers().map().toString();
        if(statusCodeUserAuthentication ==401) {
        System.out.println("401" + bodyUserAuthentication);
        System.out.println(headersUserAuthentication);
    } else if(statusCodeUserAuthentication ==200) {
        System.out.println("200 OK");
    }
 }
}
