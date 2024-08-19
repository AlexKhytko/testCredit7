package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testPayments {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestPaymentsHistory = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/payment-history"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientPayHistory = HttpClient.newHttpClient();

        HttpResponse<String> responsePayHistory = clientPayHistory.send(requestPaymentsHistory, HttpResponse.BodyHandlers.ofString());
        int statusCodePayHistory = responsePayHistory.statusCode();
        String bodyPayHistory = responsePayHistory.body();
        String headersPayHistory = responsePayHistory.headers().map().toString();
        if (statusCodePayHistory == 404) {
            System.out.println("404 error" );
        } else if (statusCodePayHistory == 200) {
            System.out.println("200" + bodyPayHistory);
            System.out.println(headersPayHistory);
        }

        HttpRequest requestPaymantsProvider = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/payment-provider"))
                .header("accept", "application/json")
                .build();

        HttpClient clientPayProvider = HttpClient.newHttpClient();

        HttpResponse<String> responsePayProvider = clientPayProvider.send(requestPaymantsProvider, HttpResponse.BodyHandlers.ofString());
        int statusCodePayProvider = responsePayProvider.statusCode();
        String bodyPayProvider = responsePayProvider.body();
        String headersPayProvider = responsePayProvider.headers().map().toString();
        if (statusCodePayProvider == 404) {
            System.out.println("404 error" );

        } else if (statusCodePayProvider == 200) {
            System.out.println("200" + bodyPayProvider);
            System.out.println(headersPayProvider);
        }

        String requestBodyVerify = "{ \"cardNumber\": \"string\", \"returnUrl\": \"string\", \"returnUrlGood\": \"string\", \"returnUrlBad\": \"string\"}";
        HttpRequest requestVerify = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyVerify))
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/verify"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient verifyUser = HttpClient.newHttpClient();
        HttpResponse<String> responseVerifyUser = verifyUser.send(requestVerify, HttpResponse.BodyHandlers.ofString());
        int statusCodeVerifyUser = responseVerifyUser.statusCode();
        String bodyVerifyUser = responseVerifyUser.body();
        String headersVerifyUser = responseVerifyUser.headers().map().toString();

        if (statusCodeVerifyUser == 422) {
            System.out.println("422" + bodyVerifyUser);
            System.out.println(headersVerifyUser);}
        else if (statusCodeVerifyUser == 200) {
            System.out.println("200" + bodyVerifyUser);
            System.out.println(headersVerifyUser);}
        else if (statusCodeVerifyUser == 500) {
            System.out.println("500" + bodyVerifyUser);}

        String requestBodyValidateCard = "{ \"cardNumber\": \"string\"}";
        HttpRequest requestValidate = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyValidateCard))
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/card-number/validate"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient validateCard = HttpClient.newHttpClient();
        HttpResponse<String> responseValidateCard = validateCard.send(requestValidate, HttpResponse.BodyHandlers.ofString());
        int statusCodeValidateCard = responseValidateCard.statusCode();
        String bodyValidateCard = responseValidateCard.body();
        String headersValidateCard = responseValidateCard.headers().map().toString();

        if (statusCodeValidateCard == 200) {
            System.out.println("200" + bodyValidateCard);
            System.out.println(headersValidateCard);}
        else if (statusCodeValidateCard == 500) {
            System.out.println("500" + bodyValidateCard);}
    }
}
