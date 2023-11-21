package tests.api;

import enums.URLs;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PhoneTest {


    @Test
    public void daDataPhoneTest() {
         String phone = "9873876629";
         given().header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Token 3f517459e369c8f90e47523a523d7b84a8421860")
                .header("X-Secret", "e20453ed5e236f0f56e2771348c42f07b51cc7cc")
                .body("[ \"%s\" ]".formatted(phone))
                .post(URLs.DA_DATA.getUrl())
                 .then()
                 .statusCode(200)
                 .body("source[0]", equalTo(phone));

    }
}
