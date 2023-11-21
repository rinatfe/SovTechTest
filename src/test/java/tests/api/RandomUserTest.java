package tests.api;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.UserResult;

import static io.restassured.RestAssured.given;

public class RandomUserTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://randomuser.me/api/";
    }
    @Test
    public void withGenderMaleTest() {
       UserResult res =
               given().queryParam("gender", "male")
                .get()
                .then().statusCode(200)
                       .extract()
                       .body()
                       .as(UserResult.class);
        Assertions.assertEquals(res.getResults().get(0).getGender(), "male", "Гендер не совпадает");
    }

    @Test
    public void withGenderFemaleTest() {
        UserResult res =
                given().queryParam("gender", "female")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        Assertions.assertEquals(res.getResults().get(0).getGender(), "female", "Гендер не совпадает");
    }

    @Test
    public void withWrongGenderTest() {
        UserResult res =
                given().queryParam("gender", "middle")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        Assertions.assertNotEquals(res.getResults().get(0).getGender(), "middle", "Гендер не совпадает");
    }

    @Test
    public void withManyResultsTest() {
        UserResult res =
                given().queryParam("results", "100")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        Assertions.assertEquals(res.getResults().size(), 100, "Количество записей не совпадает");
    }

    @Test
    public void withLeastThanZeroResultsTest() {
        UserResult res =
                given().queryParam("results", "-1")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        Assertions.assertTrue(res.getResults().size()> 0, "Количество записей не совпадает");
    }

    @Test
    public void notExistParametersTest() {
        UserResult res =
                given().queryParam("public", "true")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        Assertions.assertEquals(res.getResults().size(), 1, "Количество записей не совпадает");
    }

    @Test
    public void passwordLengthTest() {
        UserResult res =
                given().queryParam("password", "1-8")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        String password = res.getResults().get(0).getLogin().getPassword();
        Assertions.assertTrue(password.length() >= 8, "Количество записей не совпадает");
    }

    @Test
    public void passwordUpperCaseTest() {
        UserResult res =
                given().queryParam("password", "upper")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        String password = res.getResults().get(0).getLogin().getPassword();
        Assertions.assertEquals(password, password.toUpperCase(), "UpperCase не применился");
    }

    @Test
    public void passwordLowerCaseTest() {
        UserResult res =
                given().queryParam("password", "lower")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        String password = res.getResults().get(0).getLogin().getPassword();
        Assertions.assertEquals(password, password.toLowerCase(), "LowerCase не применился");
    }

    @Test
    public void passwordSpecialSymbolTest() {
        UserResult res =
                given().queryParam("password", "special")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        String password = res.getResults().get(0).getLogin().getPassword();
        Assertions.assertFalse(password.matches(".*[a-zA-Z0-9].*"), "Содержит буквы или цифры");
    }

    @Test
    public void withCountryTest() {
        UserResult res =
                given().queryParam("nat", "de")
                        .get()
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        String country = res.getResults().get(0).getLocation().getCountry();
        Assertions.assertEquals(country, "Germany", "Регион не совпадает");
    }

    @Test
    public void withSeedsTest() {
        UserResult res =
                given().queryParam("seed", "foobar")
                        .get("https://randomuser.me/api/1.0/")
                        .then().statusCode(200)
                        .extract()
                        .body()
                        .as(UserResult.class);
        String user = res.getResults().get(0).getName().toString();
        Assertions.assertEquals(user, "becky sims", "Юзер не совпаддает");
    }
}
