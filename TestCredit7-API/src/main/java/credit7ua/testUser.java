package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testLoan{
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestHistory = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/loan-history"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient loanHistory = HttpClient.newHttpClient();

        HttpResponse<String> responseLoanHistory = loanHistory.send(requestHistory, HttpResponse.BodyHandlers.ofString());
        int statusCode = responseLoanHistory.statusCode();
        String body = responseLoanHistory.body();
        if (statusCode == 401) {
        System.out.println("no loan");}
        else if (statusCode == 200) {
            System.out.println(body);}
        else { System.out.println("ERROR");
        }
        HttpRequest requestLoanOne = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/loan"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient loanOne = HttpClient.newHttpClient();
        HttpResponse<String> responseLoanOne = loanOne.send(requestLoanOne, HttpResponse.BodyHandlers.ofString());
        int statusCodeLoan = responseLoanOne.statusCode();
        String bodyLoan = responseLoanOne.body();
        if (statusCodeLoan == 401) {
            System.out.println("no loan");}
        else if (statusCodeLoan == 200) {
            System.out.println(bodyLoan);}
        else { System.out.println("ERROR");
        }


        HttpRequest requestAuthor = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/user/authorization-info"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();
        HttpClient authorizationInfo = HttpClient.newHttpClient();
        HttpResponse<String> responseAuthorizationInfo = authorizationInfo.send(requestAuthor, HttpResponse.BodyHandlers.ofString());
        int statusCodeAuthor = responseAuthorizationInfo.statusCode();
        String bodyAuthor = responseAuthorizationInfo.body();
        if (statusCodeAuthor == 401) {
            System.out.println("no loan");}
        else if (statusCodeAuthor == 200) {
            System.out.println(responseAuthorizationInfo.body());}
        else { System.out.println("ERROR");
        }


        HttpRequest requestPhoneCode = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/user/phone-confirmation-code"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();
        HttpClient phoneConfirmationCode = HttpClient.newHttpClient();
        HttpResponse<String> responsePhoneCode = phoneConfirmationCode.send(requestPhoneCode, HttpResponse.BodyHandlers.ofString());
        int statusCodePhoneCode = responsePhoneCode.statusCode();
        String bodyPhoneCode = responsePhoneCode.body();
        if (statusCodePhoneCode == 403) {
            System.out.println("error' => 'repeated_phone_confirmation_error");}
        else if (statusCodePhoneCode == 200) {
            System.out.println(bodyPhoneCode);}
        else { System.out.println("ERROR");
        }

        String requestBodyFacePhoto = "{ \"name\": \"string\", \"contents\": \"string\", \"filename\": \"string\"}";
        HttpRequest requestFacePhoto = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyFacePhoto))
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/face-photo"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();
        HttpClient facePhoto = HttpClient.newHttpClient();
        HttpResponse<String> responseFacePhoto = facePhoto.send(requestPhoneCode, HttpResponse.BodyHandlers.ofString());
        int statusCodeFacePhoto = responseFacePhoto.statusCode();
        String bodyFacePhoto = responseFacePhoto.body();
        if (statusCodeFacePhoto == 403) {
            System.out.println("error' => 'repeated_phone_confirmation_error");}
        else if (statusCodeFacePhoto == 401) {
            System.out.println(bodyFacePhoto);}
        else if (statusCodeFacePhoto == 500) {
            System.out.println(bodyFacePhoto);}
        else { System.out.println("ERROR");
        }

    }
}
