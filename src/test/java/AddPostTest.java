import io.restassured.http.ContentType;
import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddPostTest extends BaseTest{

    @Test
    public void addPost(){

        Post post = new Post("added title", "added author");

        Post patchedPost = given()
                                  .spec(reqSpec)
                                  .body(post).
                           when()
                                  .post().
                           then()
                                  .statusCode(201)
                                  .contentType(ContentType.JSON)
                                  .extract().body().as(Post.class);

        Assert.assertEquals(patchedPost.getTitle(),post.getTitle());
        Assert.assertEquals(patchedPost.getAuthor(),post.getAuthor());
    }
}
