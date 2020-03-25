package api;

import io.restassured.response.Response;
import models.Comment;

public class CommentApi extends BaseApi {

    final static String comments = "/maps/%s/comments";

    public static Response getCommentsOnMap(long mapId) {
        return REQUEST
                .when()
                .get(String.format(comments, mapId));
    }

    public static Response addCommentsOnMap(long mapId) {

        Comment newComment = Comment
                .builder()
                .body(String.format("I like country: %s",FAKER.address().country()))
                .build();

        return REQUEST
                .when()
                .body(newComment)
                .post(String.format(comments, mapId));
    }

}
