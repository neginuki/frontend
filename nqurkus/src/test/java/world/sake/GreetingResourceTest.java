package world.sake;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get("/hello-resteasy").then().statusCode(200).body(is("Hello RESTEasy"));
    }

    @Test
    public void hogehoge() {
        String txt = """
                {
                    "id": 1,
                    "name": "%s"
                }
                """;

        System.out.println(txt);
    }

}