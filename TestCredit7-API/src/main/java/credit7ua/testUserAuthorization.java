package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testUserAuthorization {
    public static void main(String[] args) throws IOException, InterruptedException {

        String requestBodySendPassword = "{ \"phone\": " + userIdTokenApi3.phoneNumber + ", \"app_signature\": \"FA+9qCX9VSu\"}";
        HttpRequest requestSendPassword = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodySendPassword))
                .uri(URI.create(userIdTokenApi3.baseURI + "/user/send-one-time-password"))
                .header("accept", "application/json")
                .build();

        HttpClient clientSendPassword = HttpClient.newHttpClient();
        HttpResponse<String> responseSendPassword = clientSendPassword.send(requestSendPassword, HttpResponse.BodyHandlers.ofString());
        int statusCodeSendPassword = responseSendPassword.statusCode();
        String bodySendPassword = responseSendPassword.body();
        String headersSendPassword = responseSendPassword.headers().map().toString();
        if (statusCodeSendPassword == 500) {
            System.out.println("500 error");
        } else if (statusCodeSendPassword == 200) {
            System.out.println("200" + bodySendPassword);
            System.out.println(headersSendPassword);
        }

        String requestBodyOneTimePassword = "{ \"phone\": " + userIdTokenApi3.phoneNumber + ", \"code\": \"3251\"}";
        HttpRequest requestSendOneTimePassword = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyOneTimePassword))
                .uri(URI.create(userIdTokenApi3.baseURI + "/user/one-time-password"))
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .build();

        HttpClient clientOnePassword = HttpClient.newHttpClient();
        HttpResponse<String> responseOnePassword = clientOnePassword.send(requestSendOneTimePassword, HttpResponse.BodyHandlers.ofString());
        int statusCodeOnePassword = responseOnePassword.statusCode();
        String bodyOnePassword = responseOnePassword.body();
        String headersOnePassword = responseOnePassword.headers().map().toString();
        if (statusCodeOnePassword == 400) {
            System.out.println("400 no phone or no code");
        }
        else if (statusCodeOnePassword == 403) {
            System.out.println("403 old code");
        }
        else if (statusCodeOnePassword == 404) {
            System.out.println("404 wrong code");
        }
        else if (statusCodeOnePassword == 200) {
            System.out.println("200" + bodyOnePassword);
            System.out.println(headersOnePassword);
        }
    }
}
