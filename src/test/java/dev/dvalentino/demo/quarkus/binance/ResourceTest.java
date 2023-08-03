package dev.dvalentino.demo.quarkus.binance;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ResourceTest {

    @Test
    public void getKlines() {
        given()
          .when().get("/api/v1/klines")
          .then()
             .statusCode(200)
             .body(is(notNullValue()));
    }

}
