package scenarios;

import api.CommentApi;
import org.testng.annotations.Test;

public class CommentsTest extends BaseTest {

    @Test(groups = "validToken")
    public void getCommentsOnMap() {
        CommentApi.getCommentsOnMap(16792)
                .then()
                .log().ifError()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();

    }

    @Test(groups = "validToken")
    public void addNewCommentOnExistingMap() {
        CommentApi.addCommentsOnMap(16792)
                .then()
                .log().ifError()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();
    }
}
