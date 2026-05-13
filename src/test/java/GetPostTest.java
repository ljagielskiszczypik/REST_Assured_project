import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetPostTest extends BaseTest{

    @Test
    public void getPost(){
        given()
                .pathParam("postId",1)
                .spec(reqSpec).
        when()
                .get("{postId}").
        then()
                .spec(respSpec)
                .assertThat().body("title",equalTo("Clean Code"))
                .assertThat().body("author",equalTo("Robert C. Martin"));

    }
}
