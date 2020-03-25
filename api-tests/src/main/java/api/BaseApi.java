package api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Locale;
import java.util.UUID;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class BaseApi {

    public static RequestSpecification REQUEST =
            RestAssured
                    .given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/json" +
                            "\r\n", ContentType.JSON)))
                    .contentType("application/json")
                    .accept("application/json")
                    .header("X-Request-Id", UUID.randomUUID());

    public static String authToken;

    static Faker FAKER = new Faker(new Locale("en_IN"));

}
