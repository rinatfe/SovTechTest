package tests.api;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CleanUriTest {

    static String resource = "/api/v1/shorten";
    static List<String> listOfLinks;
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://cleanuri.com";
        String path = "src/test/resources/links.txt";
        try {
            listOfLinks = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testValidUrl() {
        String validUrl = listOfLinks.get(0);
        given().param("url", validUrl)
                .post(resource)
                .then()
                .statusCode(200)
                .body("result_url", Matchers.notNullValue());
    }

    @Test
    public void testUrlWithSpecialCharacter() {
        String validUrl = listOfLinks.get(1);
        given().param("url", validUrl)
                .post(resource)
                .then()
                .statusCode(400)
                .body("error", Matchers.notNullValue());
    }

    @Test
    public void testUrlWithSpace() {
        String validUrl = listOfLinks.get(2);
        given().param("url", validUrl)
                .post(resource)
                .then()
                .statusCode(400)
                .body("error", Matchers.notNullValue());
    }

    @Test
    public void testEmptyUrl() {
       given().post(resource)
               .then()
               .statusCode(400)
               .body("error", Matchers.notNullValue());
    }

    @Test
    public void testNotUrl() {
        String validUrl = listOfLinks.get(3);
        given().param("url", validUrl)
                .post(resource)
                .then()
                .statusCode(400)
                .body("error", Matchers.notNullValue());
    }
}
