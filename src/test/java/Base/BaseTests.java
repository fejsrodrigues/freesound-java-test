package Base;

import com.github.fejsrodrigues.config.Configuration;
import com.github.fejsrodrigues.config.ConfigurationManager;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    @BeforeEach
    public void setup(){
        Configuration configuration = ConfigurationManager.getConfiguration();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = configuration.baseURI();
    }
}
