package lesson4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ShoppingListScenarioTestV2 extends AbstractTest4ShoppingListScenario {
    @Test
    void addMealTest() {

        String id = given().spec(getRequestSpecification())
                .body("{\n"
                        + " \"date\": 1644881179,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post(getBaseUrl() + "/mealplanner/" + getUserName() + "/items")
                .then()
                .spec(getResponseSpecification())
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given().spec(getRequestSpecification())
                .delete(getBaseUrl() + "/mealplanner/" + getUserName() + "/items/" + id)
                .then()
                .spec(getResponseSpecification());
    }

}
