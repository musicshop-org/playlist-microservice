package fhv.musicshop;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class RestControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/welcome")
          .then()
             .statusCode(200)
             .body(is("Welcome to the playlist-microservice :)"));
    }

}