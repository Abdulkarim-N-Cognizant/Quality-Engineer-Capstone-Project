import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteApiTests extends  ApiTestSetup{

    // DELETE Post
    @Test
    void deletePost(){
        given().spec(spec)
                .when()
                .delete("/posts/10")
                .then()
                .statusCode(oneOf(200,201,204))
                .body(equalTo("{}"));
    }
}