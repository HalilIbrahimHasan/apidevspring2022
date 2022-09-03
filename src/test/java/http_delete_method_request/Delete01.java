package http_delete_method_request;

import base_urls.MedunnaHealthBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete01 extends MedunnaHealthBaseUrl {


@Test
    public void delete(){

        String url = "https://medunna.com/api/rooms/267283";
        String token = generateToken();
        Response response = given().headers(

                "Authorization",
                "Bearer "+ token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON


        ).when().delete(url);

        response.then().assertThat().statusCode(204);

    }


}
