package Tests;

import Base.BaseTests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.fejsrodrigues.core.ClientToken.getToken;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersRequestTests extends BaseTests {

    @Test
    @DisplayName("Request User Sounds")
    public void UserSoundRequestTests() {

        Response response = RestAssured.given()
                .when()
                .headers("Authorization", "Token " + getToken())
                .get("/apiv2/users/Jovica/sounds/");
        JsonPath body = response.jsonPath();
        assertThat(response.getStatusCode()).isEqualTo(200);

    }

    @Test
    @DisplayName("Request User Sounds by field")
    public void UserSoundByIdRequestTests() {

        Response response = RestAssured.given()
                .when()
                .headers("Authorization", "Token " + getToken())
                .get("/apiv2/users/Jovica/sounds/?fields=id,bitdepth,type,samplerate");
        JsonPath body = response.jsonPath();
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(body.getString("count")).isEqualTo("7823");

    }

    @Test
    @DisplayName("Request User Pack")
    public void UserPackRequestTests() {

        Response response = RestAssured.given()
                .when()
                .headers("Authorization", "Token " + getToken())
                .get("/apiv2/users/Jovica/packs/");
        JsonPath body = response.jsonPath();
        assertThat(response.getStatusCode()).isEqualTo(200);

    }
}
