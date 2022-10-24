package JsonSchemaValidation;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateJsonTest {

    private final String PICSART_GET_REQUEST_URL = "https://api.picsart.com/localizations/en/messages?project=reusable_components,photo_editor";

    @Test
    public void testValidateJsonSchema() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(PICSART_GET_REQUEST_URL)
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
    }
}