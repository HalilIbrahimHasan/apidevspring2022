package http_get_method_request;

import base_urls.JsonBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get0002 extends JsonBaseUrl {

    @Test
    public void test01(){


        //set the path parameters
        specification.pathParams("bir", "todos", "iki", "10");

        Response response = given().spec(specification).
                            when().get("/{bir}/{iki}");

        response.prettyPrint();



    }


}
