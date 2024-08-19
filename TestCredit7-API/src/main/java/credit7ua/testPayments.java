package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testPaymenys {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestSoldInfo = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/loan/" + userIdTokenApi3.idLoan + "/sold-info"))
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
}
