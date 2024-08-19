package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testExtension {

    public static void main(String[] args) throws IOException, InterruptedException {

                HttpRequest requestSendExtension = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .uri(URI.create(userIdTokenApi3.baseURI + "/loan" + userIdTokenApi3.idLoan + "/send-extension-code"))
                .header("accept", "application/json")
                        .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientSendExtensionCode = HttpClient.newHttpClient();
        HttpResponse<String> responseSendExtensionCode = clientSendExtensionCode.send(requestSendExtension, HttpResponse.BodyHandlers.ofString());
        int statusCodeSendExtensionCode = responseSendExtensionCode.statusCode();
        String bodySendExtensionCode = responseSendExtensionCode.body();
        String headersSendExtensionCode = responseSendExtensionCode.headers().map().toString();
        if (statusCodeSendExtensionCode == 400) {
            System.out.println("400 error" + bodySendExtensionCode);
            System.out.println(headersSendExtensionCode);
        } else if (statusCodeSendExtensionCode == 200) {
            System.out.println("200" + bodySendExtensionCode);
            System.out.println(headersSendExtensionCode);
        }
    }
}
