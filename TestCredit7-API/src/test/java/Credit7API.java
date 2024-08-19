import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLDocument;

public class Credit7API {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api3.uashort.agis.work"; // Замените на ваш базовый URL
    }
//    @Test
//    HTMLDocument.RunElement tes
//    public void testGetEndpoint() {
//        RestAssured.baseURI = "https://api3.uashort.agis.work/swagger";
//
//        given().
//                when().
//                get("/books").
//                then().
//                statusCode(200).
//                body("books", not(empty()));
//    }
//
//    @Test
//    public void testGetBookById() {
//        RestAssured.baseURI = "https://demoqa.com/swagger";
//
//        given().
//                pathParam("id", 1).
//                when().
//                get("/books/{id}").
//                then().
//                statusCode(200).
//                body("id", equalTo(1));
 //   }
}
