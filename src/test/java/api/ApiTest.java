package api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void testPostLifecycle() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        // Crear post
        Response postResponse = given()
                .header("Content-type", "application/json")
                .body("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}")
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract().response();

        int postId = postResponse.jsonPath().getInt("id");

        // Obtener post
        given()
                .when()
                .get("/posts/" + postId)
                .then()
                .statusCode(200)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"));

        // Actualizar post
        given()
                .header("Content-type", "application/json")
                .body("{\"title\":\"foo updated\",\"body\":\"bar updated\",\"userId\":1}")
                .when()
                .put("/posts/" + postId)
                .then()
                .statusCode(200)
                .body("title", equalTo("foo updated"))
                .body("body", equalTo("bar updated"));

        // Borrar post
        given()
                .when()
                .delete("/posts/" + postId)
                .then()
                .statusCode(200);
    }
}
