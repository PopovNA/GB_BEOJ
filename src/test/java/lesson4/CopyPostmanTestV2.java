package lesson4;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

public class CopyPostmanTestV2 extends AbstractTest4AbstractTest4ShoppingListScenario {
    @BeforeAll
    static void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    void getRecipesComlexSearchTest() {
        given().spec(getRequestSpecification())
                .queryParam("includeIngredients", "tomato")
                .when().get(getBaseUrl()+"/recipes/complexSearch")
                .then().spec(getResponseSpecification())
                .assertThat()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Red Lentil Soup with Chicken and Turnips"));

        given().spec(getRequestSpecification())
                .queryParam("includeIngredients", "tomato,cheese")
                .when().get(getBaseUrl()+"/recipes/complexSearch")
                .then().spec(getResponseSpecification())
                .assertThat()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Turkey Tomato Cheese Pizza"));

        given().spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .when().get(getBaseUrl()+"/recipes/complexSearch")
                .then().spec(getResponseSpecification())
                .assertThat()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Turkey Tomato Cheese Pizza"));

        given().spec(getRequestSpecification())
                .queryParam("diet", "vegetarian")
                .when().get(getBaseUrl()+"/recipes/complexSearch")
                .then().spec(getResponseSpecification())
                .assertThat()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Cannellini Bean and Asparagus Salad with Mushrooms"));

        given().spec(getRequestSpecification())
                .queryParam("type", "main course")
                .when().get(getBaseUrl()+"/recipes/complexSearch")
                .then().spec(getResponseSpecification())
                .assertThat()
                .body("totalResults", not(equalTo(0)))
                .body("results[0].title", equalTo("Cannellini Bean and Asparagus Salad with Mushrooms"));

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
