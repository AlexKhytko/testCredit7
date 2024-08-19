package credit7ua;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testPrices {
    public static void main(String[] args) throws IOException, InterruptedException {

            HttpRequest requestProductPrises = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(userIdTokenApi3.baseURI + "/products-prices?secondary=false"))
                    .header("accept", "application/json")
                    .header("ApiKey", userIdTokenApi3.apiToken)
                    .build();

            HttpClient clientProductFalse = HttpClient.newHttpClient();
            HttpResponse<String> responseProductPriceFalse= clientProductFalse.send(requestProductPrises, HttpResponse.BodyHandlers.ofString());
            int statusCodeProductFalse = responseProductPriceFalse.statusCode();
            String bodyProductFalse = responseProductPriceFalse.body();
            String headersProductFalse = responseProductPriceFalse.headers().map().toString();
            if (statusCodeProductFalse == 404) {
                System.out.println("404"+ bodyProductFalse );}
            else if (statusCodeProductFalse == 200) {
                System.out.println("200" + bodyProductFalse);
                System.out.println(headersProductFalse);}

        HttpRequest requestPrisesProduct = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/products-prices?secondary=true"))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientProductTrue = HttpClient.newHttpClient();
        HttpResponse<String> responseProductPriceTrue= clientProductTrue.send(requestPrisesProduct, HttpResponse.BodyHandlers.ofString());
        int statusCodeProductTrue = responseProductPriceTrue.statusCode();
        String bodyProductTrue = responseProductPriceTrue.body();
        String headersProductTrue = responseProductPriceTrue.headers().map().toString();
        if (statusCodeProductTrue == 404) {
            System.out.println("404"+ bodyProductTrue );}
        else if (statusCodeProductTrue == 200) {
            System.out.println("200" + bodyProductTrue);
            System.out.println(headersProductTrue);}

        HttpRequest requestDiscountFalse = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(userIdTokenApi3.baseURI + "/discount/" + userIdTokenApi3.code +"?secondary=false&term="+ userIdTokenApi3.term +"&amount=" + userIdTokenApi3.amount))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientDiscountFalse = HttpClient.newHttpClient();
        HttpResponse<String> responseDiscountFalse= clientDiscountFalse.send(requestDiscountFalse, HttpResponse.BodyHandlers.ofString());
        int statusCodeDiscountFalse = responseDiscountFalse.statusCode();
        String bodyDiscountFalse = responseDiscountFalse.body();
        String headersDiscountFalse = responseDiscountFalse.headers().map().toString();
        if (statusCodeDiscountFalse == 404) {
            System.out.println("404"+ bodyDiscountFalse );}
        else if (statusCodeDiscountFalse == 200) {
            System.out.println("200" + bodyDiscountFalse);
            System.out.println(headersDiscountFalse);}


        HttpRequest requestDiscountTrue = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api3.uashort.agis.work/discount/" + userIdTokenApi3.code +"?secondary=true&term="+ userIdTokenApi3.term +"&amount=" + userIdTokenApi3.amount))
                .header("accept", "application/json")
                .header("ApiKey", userIdTokenApi3.apiToken)
                .build();

        HttpClient clientDiscountTrue = HttpClient.newHttpClient();
        HttpResponse<String> responseDiscountTrue= clientDiscountTrue.send(requestDiscountTrue, HttpResponse.BodyHandlers.ofString());
        int statusCodeDiscountTrue = responseDiscountTrue.statusCode();
        String bodyDiscountTrue = responseDiscountTrue.body();
        String headersDiscountTrue = responseDiscountTrue.headers().map().toString();
        if (statusCodeDiscountTrue == 404) {
            System.out.println("404 code invalid");}
        else if (statusCodeDiscountTrue == 200) {
            System.out.println("200" + bodyDiscountTrue);
            System.out.println(headersDiscountTrue);}
        else if (statusCodeDiscountTrue == 422) {
            System.out.println("422 code not configured");}
    }
}
