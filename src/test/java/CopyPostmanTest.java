import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class CopyPostmanTest extends AbstractTest {
    @BeforeAll
    static void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    void getRecipesComlexSearchTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "tomato")
                .queryParam("offset", 3)
                .queryParam("number", 1)
                .queryParam("limitLicense", true)
                .log().uri()
                .response()
                .contentType(ContentType.JSON)
                .expect()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Turkey Tomato Cheese Pizza"))
                .when()
                .get(getBaseUrl()+"/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "tomato,cheese")
                .queryParam("offset", 0)
                .queryParam("number", 1)
                .queryParam("limitLicense", true)
                .log().uri()
                .response()
                .contentType(ContentType.JSON)
                .expect()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Turkey Tomato Cheese Pizza"))
                .when()
                .get(getBaseUrl()+"/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .queryParam("offset", 0)
                .queryParam("number", 1)
                .queryParam("limitLicense", true)
                .log().uri()
                .response()
                .contentType(ContentType.JSON)
                .expect()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Turkey Tomato Cheese Pizza"))
                .when()
                .get(getBaseUrl()+"/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "vegetarian")
                .queryParam("offset", 3)
                .queryParam("number", 1)
                .queryParam("limitLicense", true)
                .log().all()
                .response()
                .contentType(ContentType.JSON)
                .expect()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Cannellini Bean and Asparagus Salad with Mushrooms"))
                .when()
                .get(getBaseUrl()+"/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "main course")
                .queryParam("offset", 3)
                .queryParam("number", 1)
                .queryParam("limitLicense", true)
                .log().uri()
                .response()
                .contentType(ContentType.JSON)
                .expect()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Cannellini Bean and Asparagus Salad with Mushrooms"))
                .when()
                .get(getBaseUrl()+"/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200);

    }

    @Test
    void getRecipesCuisine() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Turkey Tomato Cheese Pizza\",\n"
                        + " \"ingredientList\": \"cheese\ntomato\"\n"
                        + "}")
                .log().uri()
                .log().body()
                .response()
                .contentType(ContentType.JSON)
                .expect()
                .body("confidence", not(equalTo(0)))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Cheesy Chicken Enchilada Quinoa Casserole\",\n"
                        + " \"ingredientList\": \"cheese\nchicken\"\n"
                        + "}")
                .log().uri()
                .log().body()
                .response()
                .contentType(ContentType.JSON)
                .expect()
//                .body("confidence", not(equalTo(0)))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Broccoli and Chickpea Rice Salad\",\n"
                        + " \"ingredientList\": \"rice\nbroccoli\"\n"
                        + "}")
                .log().uri()
                .log().body()
                .response()
                .contentType(ContentType.JSON)
                .expect()
//                .body("confidence", not(equalTo(0)))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Corn-Crusted Fish Tacos With Jalapeno-Lime Sauce and Spicy Black Beans\",\n"
                        + " \"ingredientList\": \"jalapeno\nlime\"\n"
                        + "}")
                .log().uri()
                .log().body()
                .response()
                .contentType(ContentType.JSON)
                .expect()
//                .body("confidence", not(equalTo(0)))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Cheesy Chicken Enchilada Quinoa Casserole\",\n"
                        + " \"ingredientList\": \"cheese\nchicken\"\n"
                        + "}")
                .log().uri()
                .log().body()
                .response()
                .contentType(ContentType.JSON)
                .expect()
//                .body("confidence", not(equalTo(0)))
                .body("cuisine", equalTo("Mediterranean"))
                .when()
                .post(getBaseUrl()+"/recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200);

    }

}
