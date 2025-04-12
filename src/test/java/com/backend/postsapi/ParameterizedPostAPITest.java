package com.backend.postsapi;

import com.backend.basetest.AbstractApiTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * @author suresh
 * @since 2025-04-12
 */
public class ParameterizedPostAPITest extends AbstractApiTest {

    /**
     * Assume reading input from CSV file , separated
     *
     * @param index 1st row 1st column
     * @param expectedTitle 1 row 2nd column
     */
    @ParameterizedTest
    @CsvSource({
            "0, sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            "1, qui est esse",
            "2, ea molestias quasi exercitationem repellat qui ipsa sit aut"
    })
    void testGetPostsByIndexAndTitle(int index, String expectedTitle) {
        given()
                .baseUri(props.getProperty("baseUrl"))
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("[" + index + "].title", equalTo(expectedTitle));
    }
}
