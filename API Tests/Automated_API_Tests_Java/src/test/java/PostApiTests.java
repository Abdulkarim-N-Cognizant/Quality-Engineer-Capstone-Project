import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostApiTests extends ApiTestSetup{
    //POST requests
    @Test
    void createNewPost(){
        String json = "{ \"title\": \"Post Title\", \"body\": \"Post Body\", \"userId\": 1 }";

        given().spec(spec)
                .when()
                .body(json)
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Post Title"))
                .body("body", equalTo("Post Body"))
                .body("userId", equalTo(1));
    }
}