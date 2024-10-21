package http_get_method_request;

import base_urls.JsonBaseUrl;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get0001  extends JsonBaseUrl {

    @Test
    public void test01(){



        //Set path param(s)
        specification.pathParam("bir", "todos");


        Response response = given().spec(specification).
                when().get("/{bir}");

        response.prettyPrint();
    }




}
