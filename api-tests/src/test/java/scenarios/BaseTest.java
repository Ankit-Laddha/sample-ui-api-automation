package scenarios;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.BeforeGroups;

import static api.BaseApi.REQUEST;
import static api.BaseApi.authToken;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static io.restassured.config.EncoderConfig.encoderConfig;

public abstract class BaseTest {

    final String baseURI = "https://uebermaps.com/api/v2";

    public BaseTest() {
        RestAssured.baseURI = baseURI;
        RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-16"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(NON_EMPTY);
    }

    @BeforeGroups(groups = "validToken")
    public void setup() {

        authToken =
                REQUEST
                        .auth().basic("your-email-here", "your-password-here")
                        .get("/authentication")
                        .then().log().all()
                        .statusCode(200)
                        .extract()
                        .path("data.auth_token");

        REQUEST.header("X-AUTH-TOKEN", authToken);
    }

    @BeforeGroups(groups = "invalidToken")
    public void setupInvalid() {
        REQUEST.header("X-AUTH-TOKEN", "invalid-authToken");
    }
}
