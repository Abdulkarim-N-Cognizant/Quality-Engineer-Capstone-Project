import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class ApiTestSetup{
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
}