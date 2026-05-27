import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PatchPostTest extends BaseTest{

    @Test
    public void patchPost(){

        Post post = new Post("Patched");

        Post patchedPost = given()
                                  .spec(reqSpec)
                                  .pathParam("postId",3)
                                  .body(post).
                           when()
                                  .patch("{postId}").
                           then()
                                  .spec(respSpec)
                                  .extract().body().as(Post.class);

        Assert.assertEquals(patchedPost.getTitle(),post.getTitle());
    }
}
