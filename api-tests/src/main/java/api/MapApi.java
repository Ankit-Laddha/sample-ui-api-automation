package api;

import io.restassured.response.Response;
import models.Map;

public class MapApi extends BaseApi {

    final static String maps = "/maps";

    public static Response getMapById(long mapId) {
        return REQUEST
                .log().all()
                .when()
                .get(String.format("%s/%d", maps, mapId));
    }

    public static Response createMap() {

        String cityName = FAKER.address().cityName();
        Map newMap = Map.builder().title(String.format("%s Map", cityName)).build();

        return REQUEST
                .log().all()
                .when()
                .body(newMap)
                .post(maps);
    }

}
