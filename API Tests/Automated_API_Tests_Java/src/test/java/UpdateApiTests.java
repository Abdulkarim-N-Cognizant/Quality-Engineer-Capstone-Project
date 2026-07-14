import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class UpdateApiTests extends ApiTestSetup{
    // UPDATE (PUT) Post
    @Test
    void updatePost(){
        String json = "{ \"title\": \"New Post Title\", \"body\": \"Updated and new Post Body\", \"userId\": 1, \"id\": 1 }";

        given().spec(spec)
                .when()
                .body(json)
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("New Post Title"))
                .body("body", equalTo("Updated and new Post Body"))
                .body("userId", equalTo(1))
                .body("id", equalTo(1))

        ;
    }
}