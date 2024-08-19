package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testLoan{
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestSoldInfo = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/loan/" + userIdTokenApi3.idLoan + "/sold-info"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientSoldInfo = HttpClient.newHttpClient();

        HttpResponse<String> responseSoldInfo= clientSoldInfo.send(requestSoldInfo, HttpResponse.BodyHandlers.ofString());
        int statusCodeSoldInfo = responseSoldInfo.statusCode();
        String bodySoldInfo = responseSoldInfo.body();
        String headersSoldInfo = responseSoldInfo.headers().map().toString();
        if (statusCodeSoldInfo == 404) {
        System.out.println("404"+ bodySoldInfo );
            System.out.println(headersSoldInfo);}
        else if (statusCodeSoldInfo == 200) {
            System.out.println("200" + bodySoldInfo);}

        String requestBodyLoan = "{ \"user_id\": 0, \"loan_sum\": 0, \"loan_period\": 0, \"discount_code\": \"string\", \"product_id\": 0, \"target_url\": \"string\", \"ga_cid\": \"string\"}";
        HttpRequest requestLoan = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyLoan))
                .uri(URI.create("https://api3.uashort.agis.work/loan/"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient loan = HttpClient.newHttpClient();
        HttpResponse<String> responseLoan = loan.send(requestLoan, HttpResponse.BodyHandlers.ofString());
        int statusCodeLoan = responseLoan.statusCode();
        String bodyLoan = responseLoan.body();
        String headersLoan = responseLoan.headers().map().toString();

        if (statusCodeLoan == 404) {
            System.out.println("404" + bodyLoan);
            System.out.println(headersLoan);}
        else if (statusCodeLoan == 200) {
            System.out.println("200" + bodyLoan);}
        else if (statusCodeLoan == 500) {
            System.out.println("500" + bodyLoan);}

        HttpRequest requestSendSms = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .uri(URI.create("https://api3.uashort.agis.work/loan/" + userIdTokenApi3.idLoan + "/send-sms-confirmation"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient smsSend = HttpClient.newHttpClient();
        HttpResponse<String> responseSmsSend = smsSend.send(requestSendSms, HttpResponse.BodyHandlers.ofString());
        int statusCodeSmsSend = responseSmsSend.statusCode();
        String bodySmsSend = responseSmsSend.body();
        String headersSmsSend = responseSmsSend.headers().map().toString();

        if (statusCodeSmsSend == 400) {
            System.out.println("400" + bodySmsSend);
            System.out.println(headersSmsSend);}
        else if (statusCodeSmsSend == 200) {
            System.out.println("200" + bodySmsSend);}
        else if (statusCodeSmsSend == 500) {
            System.out.println("500" + bodySmsSend);}


        String requestSmsConfirmation = "\"{ \"code\": \"string\"}\"";
        HttpRequest requestSmsConfirm = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestSmsConfirmation))
                .uri(URI.create("https://api3.uashort.agis.work/loan/" + userIdTokenApi3.idLoan + "/confirmation"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient smsConfirm = HttpClient.newHttpClient();
        HttpResponse<String> responseSmsConfim = smsConfirm.send(requestSmsConfirm, HttpResponse.BodyHandlers.ofString());
        int statusCodeSmsConfim = responseSmsConfim.statusCode();
        String bodySmsConfim = responseSmsConfim.body();
        String headersSmsConfim = responseSmsConfim.headers().map().toString();

        if (statusCodeSmsConfim == 500) {
            System.out.println("500" + bodySmsConfim);
            System.out.println(headersSmsConfim);}
        else if (statusCodeSmsConfim == 200) {
            System.out.println("200" + bodySmsConfim);}

    }
}
