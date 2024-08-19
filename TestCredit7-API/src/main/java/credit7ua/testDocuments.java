package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testDocuments {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestAllDocuments = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/user/" + userIdTokenApi3.idUser + "/all-documents"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientAllDocuments = HttpClient.newHttpClient();

        HttpResponse<String> responseAllDocuments = clientAllDocuments.send(requestAllDocuments, HttpResponse.BodyHandlers.ofString());
        int statusCodeAllDocuments = responseAllDocuments.statusCode();
        String bodyAllDocuments = responseAllDocuments.body();
        String headersAllDocuments = responseAllDocuments.headers().map().toString();
        if (statusCodeAllDocuments == 401) {
            System.out.println("401 error" );
        } else if (statusCodeAllDocuments == 200) {
            System.out.println("200" + bodyAllDocuments);
            System.out.println(headersAllDocuments);
        }





    }
}
