package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testShortLink {
    public static void main(String[] args) throws IOException, InterruptedException {

        String requestBodyShortLink = "{ \"hash\": \"string\", \"recaptcha\": \"string\"}";
        HttpRequest requestShortLink = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyShortLink))
                .uri(URI.create(userIdTokenApi3.baseURI + "/short-link"))
                .header("accept", "application/json")
                .header("agis-client-ip", userIdTokenApi3.agisClientIp)
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientShortLink = HttpClient.newHttpClient();
        HttpResponse<String> responseLink = clientShortLink.send(requestShortLink, HttpResponse.BodyHandlers.ofString());
        int statusCodeLink = responseLink.statusCode();
        String bodyLink = responseLink.body();
        String headersLink = responseLink.headers().map().toString();
        if (statusCodeLink == 400) {
            System.out.println("400 error" + bodyLink);
            System.out.println(headersLink);
        } else if (statusCodeLink == 200) {
            System.out.println("200" + bodyLink);
             }
    }
}
