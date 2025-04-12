package com.backend.parameterized;

import com.backend.basetest.AbstractApiTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.given;


/**
 * @author Suresh
 * @since 2025-04-12
 */
public class ParameterizedJsonSchemaValidationTest extends AbstractApiTest {

    /**
     * Parameterized test validating multiple json schemas
     * @param endpoint it is the input
     */
    @ParameterizedTest
    @ValueSource(strings = {"/posts", "/users"})
    void validateSchemaForEndpoints(String endpoint) {
        given()
                .baseUri(props.getProperty("baseUrl"))
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + endpoint + "-schema.json"));
    }
}
