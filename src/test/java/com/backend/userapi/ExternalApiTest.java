package com.backend.userapi;

import com.backend.basetest.AbstractApiTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


/**
 * @author Suresh
 * @since 2025-04-12
 */
public class ExternalApiTest extends AbstractApiTest {

    /**
     * Validates field value and response code
     */
    @Test
    void testGetUsers() {
        given()
                .baseUri(props.getProperty("baseUrl"))
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("Leanne Graham"));
    }

    /**
     * Validates field value and response code
     */
    @Test
    void testGetPosts() {
        given()
                .baseUri(props.getProperty("baseUrl"))
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("[0].title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }
}
