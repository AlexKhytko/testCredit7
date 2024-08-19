package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testBankId {
    public static void main(String[] args) throws IOException, InterruptedException {

        String requestBodyBankId = "{ \"authCode\": \"string\", \"userId\": " + userIdTokenApi3.idUser + " }";
        HttpRequest requestBankIdAuthorize = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyBankId))
                .uri(URI.create(userIdTokenApi3.baseURI + "/bankid/authorize"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        HttpClient clientBankId = HttpClient.newHttpClient();
        HttpResponse<String> responseBankId = clientBankId.send(requestBankIdAuthorize, HttpResponse.BodyHandlers.ofString());
        int statusCodeBankId = responseBankId.statusCode();
        String bodyBankId = responseBankId.body();
        String headersBankId = responseBankId.headers().map().toString();
        if (statusCodeBankId == 500) {
            System.out.println("500 error" + bodyBankId);
            System.out.println(headersBankId);
        } else if (statusCodeBankId == 200) {
            System.out.println("200" + bodyBankId);
        }

        HttpRequest requestBankIdGetAuthorize = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/bankid/get-oauth2-authorize-uri"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        HttpClient clientBankIdGet = HttpClient.newHttpClient();
        HttpResponse<String> responseBankIdGet = clientBankId.send(requestBankIdGetAuthorize, HttpResponse.BodyHandlers.ofString());
        int statusCodeBankIdGet = responseBankIdGet.statusCode();
        String bodyBankIdGet = responseBankIdGet.body();
        String headersBankIdGet = responseBankIdGet.headers().map().toString();
        if (statusCodeBankIdGet == 500) {
            System.out.println("500 error" + bodyBankIdGet);
            System.out.println(headersBankIdGet);
        } else if (statusCodeBankIdGet == 200) {
            System.out.println("200" + bodyBankIdGet);
        }
    }
}
