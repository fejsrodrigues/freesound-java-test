package Tests;

import Base.BaseTests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.fejsrodrigues.core.ClientToken.getToken;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchRequestTests extends BaseTests {


    @Test
    @DisplayName("Request search by Query")
    public void SearchByQueryRequestTests() {

        RestAssured.given()
                .when()
                .headers("Authorization", "Token " + getToken())
                .get("/apiv2/search/text/?query=click")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Request search by filter")
    public void SearchByFilterRequestTests() {

        Response response = RestAssured.given()
                .when()
                .headers("Authorization", "Token " + getToken())
                .get("/apiv2/search/text/?filter=id:644049");
        JsonPath body = response.jsonPath();
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(body.getString("count")).isEqualTo("1");
        assertThat(body.getString("results[0].id")).isEqualTo("644049");

    }

    @Test
    @DisplayName("Request search by sort")
    public void SearchBySortRequestTests() {

        Response response = RestAssured.given()
                .when()
                .headers("Authorization", "Token " + getToken())
                .get("/apiv2/search/text/?sort=duration_desc");
        JsonPath body = response.jsonPath();
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(body.getString("results[0].id")).isEqualTo("592228");

    }


}
