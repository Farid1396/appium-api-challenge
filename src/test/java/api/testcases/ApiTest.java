package api.testcases;

import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.RestAssured;
import io.restassured.filter.log.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.AllureRestAssuredFilter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("API Tests")
@Feature("API")
@ExtendWith({AllureJunit5.class})
public class ApiTest {

    @Test
    @Story("API")
    @Description("Validate API")
    @Severity(SeverityLevel.CRITICAL)
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

    @BeforeEach
    public void setupApi() {
        RestAssured.filters(new AllureRestAssuredFilter());
    }
}
