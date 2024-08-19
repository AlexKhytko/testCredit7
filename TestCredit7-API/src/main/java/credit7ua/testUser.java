package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testUser {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest requestHistory = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/user/" + userIdTokenApi3.idUser + "/loan-history"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient loanHistory = HttpClient.newHttpClient();
        HttpResponse<String> responseLoanHistory = loanHistory.send(requestHistory, HttpResponse.BodyHandlers.ofString());
        int statusCode = responseLoanHistory.statusCode();
        String body = responseLoanHistory.body();
        String headers = responseLoanHistory.headers().map().toString();
        if (statusCode == 401) {
        System.out.println("401" + body);}
        else if (statusCode == 200) {
            System.out.println("200" + body);
            System.out.print(headers);}


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
        String headersLoan = responseLoanOne.headers().map().toString();
        if (statusCodeLoan == 401) {
            System.out.println("401");}
        else if (statusCodeLoan == 200) {
            System.out.println("200" + bodyLoan);
            System.out.println(headersLoan);}


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
        String headersAuthor = responseAuthorizationInfo.headers().map().toString();
        if (statusCodeAuthor == 401) {
            System.out.println("401");}
        else if (statusCodeAuthor == 200) {
            System.out.println("200" + bodyAuthor + headersAuthor);}


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
        String headersPhoneCode = responsePhoneCode.headers().map().toString();
        if (statusCodePhoneCode == 403) {
            System.out.println("403 error' => 'repeated_phone_confirmation_error");}
        else if (statusCodePhoneCode == 200) {
            System.out.println("200" + bodyPhoneCode + headersPhoneCode);}


        String requestBodyFacePhoto = "{ \"name\": \"string\", \"contents\": \"string\", \"filename\": \"string\"}";
        HttpRequest requestFacePhoto = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyFacePhoto))
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/face-photo"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();
        HttpClient facePhoto = HttpClient.newHttpClient();
        HttpResponse<String> responseFacePhoto = facePhoto.send(requestFacePhoto, HttpResponse.BodyHandlers.ofString());
        int statusCodeFacePhoto = responseFacePhoto.statusCode();
        String bodyFacePhoto = responseFacePhoto.body();
        String headersFacePhoto = responseFacePhoto.headers().map().toString();
        if (statusCodeFacePhoto == 403) {
            System.out.println("403 no lan");}
        else if (statusCodeFacePhoto == 401) {
            System.out.println("401" + bodyFacePhoto);
            System.out.println(headersFacePhoto);}
        else if (statusCodeFacePhoto == 500) {
            System.out.println("500 error server");}

        String requestBodyIdPhoto = "{ \"multipart\": { \"name\": \"string\", \"contents\": \"string\", \"filename\": \"string\"}}";
        HttpRequest requestIdPhoto = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyIdPhoto))
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/id-photo"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();
        HttpClient idPhoto = HttpClient.newHttpClient();
        HttpResponse<String> responseIdPhoto = idPhoto.send(requestIdPhoto, HttpResponse.BodyHandlers.ofString());
        int statusCodeIdPhoto = responseIdPhoto.statusCode();
        String bodyIdPhoto = responseIdPhoto.body();
        String headersIdPhoto = responseIdPhoto.headers().map().toString();

        if (statusCodeIdPhoto == 401) {
            System.out.println("401" + bodyIdPhoto);
            System.out.println(headersIdPhoto);}
        else if(statusCodeIdPhoto == 403) {
            System.out.println("no access" + bodyIdPhoto);}
        else if (statusCodeIdPhoto == 200) {
            System.out.println("200" + bodyIdPhoto);}
        else if (statusCodeIdPhoto == 500) {
            System.out.println("500 error server");}


        HttpRequest requestSkipId = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .uri(URI.create("https://api3.uashort.agis.work/user/" + userIdTokenApi3.idUser + "/skip-identification"))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();
        HttpClient skipId = HttpClient.newHttpClient();
        HttpResponse<String> responseSkipId = skipId.send(requestSkipId, HttpResponse.BodyHandlers.ofString());
        int statusSkipId = responseSkipId.statusCode();
        String bodySkipId = responseSkipId.body();
        String headersSkipId = responseSkipId.headers().map().toString();

        if (statusSkipId == 405) {
            System.out.println("405" + bodySkipId);}
        else if (statusSkipId == 200) {
            System.out.println("200" + bodySkipId);}
        else if (statusSkipId == 500) {
            System.out.println("500" + bodySkipId);
            System.out.println(headersSkipId);}
    }
}
