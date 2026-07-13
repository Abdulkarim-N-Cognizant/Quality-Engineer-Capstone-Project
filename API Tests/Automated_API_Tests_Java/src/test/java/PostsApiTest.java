import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class PostsApiTest {

    static RequestSpecification spec;

    // Before all set up due to firewall restrictions
    @BeforeAll
    static void setup() {
        System.setProperty(
                "javax.net.ssl.trustStore",
                "src/test/resources/truststore.jks"
        );

        System.setProperty(
                "javax.net.ssl.trustStorePassword",
                "changeit"
        );
        baseURI = "https://jsonplaceholder.typicode.com";
        spec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();
    }


    // GET test cases
    @Test
    void getAllPosts(){
        given().spec(spec)
                .when()
                .get("/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void getPostBody(){
        given().spec(spec)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .header("Content-Type", containsString("application/json"));
    }
    @Test
    void getPostStructure(){
        given().spec(spec)
                .when()
                .get("/posts/5")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("title", notNullValue())
                .body("userId", notNullValue())
                .body("body", notNullValue());
    }

    @Test
    void getPostResponseTime(){
        given().spec(spec)
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getPostByUserId(){
        given().spec(spec)
                .when()
                .get("/posts?userId=1")
                .then()
                .statusCode(200)
                .body("userId", everyItem(equalTo(1)));
    }

    // validate GET with specific post (post 1)
    @Test
    void getPostandVerify(){
        given().spec(spec)
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id",equalTo(1))
                .body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body",equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }

    // Negative Test Case
    @Test
    void getInvalidPostId(){
        given().spec(spec)
                .when()
                .get("/posts/99999999")
                .then()
                .statusCode(404);
    }

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

    // CHAINED REQUEST
    @Test
    void getPostOneChainedRequest(){
        // First request to get posts/1
        Response response = given()
                .spec(spec)
                .when()
                .get("/posts/1");

        // break down the json into variables
        int id = response.jsonPath().getInt("id");
        int userId = response.jsonPath().getInt("userId");
        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");

        // check to see if that post exists with another GET request
        given().spec(spec)
                .when()
                .get("/posts/" + id)
                .then()
                .statusCode(200)
                .body("userId", equalTo(userId))
                .body("id",equalTo(id))
                .body("title",equalTo(title))
                .body("body",equalTo(body));

    }
}
