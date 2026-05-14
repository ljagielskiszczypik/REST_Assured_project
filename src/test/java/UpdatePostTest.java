import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UpdatePostTest extends BaseTest{

    @Test
    public void updatePost(){

        Post post = new Post("New title", "New author");

        Post createdPost = given()
                                  .spec(reqSpec)
                                  .pathParam("postId",3)
                                  .body(post).
                           when()
                                  .put("{postId}").
                           then()
                                  .spec(respSpec)
                                  .extract().body().as(Post.class);

        Assert.assertEquals(post,createdPost);
    }
}
