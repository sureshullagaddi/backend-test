package com.backend.postsapi;

import com.backend.basetest.AbstractApiTest;
import org.junit.jupiter.api.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * @author Suresh
 * @since 2025-04-12
 */
public class PostsApiTest extends AbstractApiTest {

    /**
     * Validating response code and filed value
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

    /**
     * Validating response code and validating schema
     */
    @Test
    public void validatePostJsonSchema() {
        given()
                .baseUri(props.getProperty("baseUrl"))
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/posts-schema.json"));
    }
}
