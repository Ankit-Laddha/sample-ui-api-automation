package scenarios;

import api.MapApi;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class MapsTest extends BaseTest {

    @Test(groups = "validToken")
    public void getMapByIdShouldBeSuccess() {
        MapApi.getMapById(16792)
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", notNullValue(),
                        "data.title", equalTo("My favourite places in Ahmedabad"));

    }

    @Test(groups = "validToken")
    public void createNewMapShouldBeSuccess() {
        MapApi.createMap()
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", notNullValue());
    }

    @Test(groups = "validToken")
    public void gettingMapWithInvalidIdThrows404() {
        MapApi.getMapById(0)
                .then()
                .log().all()
                .statusCode(404);
    }


    @Test(groups = "invalidToken")
    public void gettingMapWithoutAuthTokenThrows403() {
        MapApi.getMapById(1234)
                .then()
                .log().all()
                .statusCode(403);
    }
}
