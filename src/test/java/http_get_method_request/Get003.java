package http_get_method_request;

import base_urls.JsonBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get003 extends JsonBaseUrl {

    @Test
    public void test01(){



        //set the path params
        specification.pathParams("bir", "todos");
        specification.queryParams("userId", 4, "completed", false,
                "id", 68);

        Response response = given().spec(specification).
                            when().get("/{bir}");

        response.prettyPrint();

    }


}
