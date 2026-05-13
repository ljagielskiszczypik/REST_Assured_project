import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostsTest extends BaseTest{

    @Test
    public void getPosts(){
        given()
                .spec(reqSpec).
        when()
                .get().
        then()
                .spec(respSpec)
                .assertThat().body("title[0]",equalTo("Clean Code"))
                .assertThat().body("author[0]",equalTo("Robert C. Martin")).
        and()
                .assertThat().body("title[1]",equalTo("The Pragmatic Programmer"))
                .assertThat().body("author[1]",equalTo("Andrew Hunt")).
        and()
                .assertThat().body("title[2]",equalTo("Design Patterns"))
                .assertThat().body("author[2]",equalTo("Erich Gamma")).
        and()
                .assertThat().body("title[3]",equalTo("Refactoring"))
                .assertThat().body("author[3]",equalTo("Martin Fowler")).
        and()
                .assertThat().body("title[4]",equalTo("Effective Java"))
                .assertThat().body("author[4]",equalTo("Joshua Bloch")).
        and()
                .assertThat().body("title[5]",equalTo("Code Complete"))
                .assertThat().body("author[5]",equalTo("Steve McConnell"));
    }
}
