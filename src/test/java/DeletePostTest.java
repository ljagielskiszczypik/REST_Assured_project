import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostTest extends BaseTest{

    @Test
    public void deletePost(){
        given()
                .pathParam("postId",1)
                .spec(reqSpec).
        when()
                .delete("{postId}").
        then()
                .spec(respSpec)
                .statusCode(200);
    }
}
