package http_get_method_request;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends HerokuappBaseUrl {

     /*
            Given
                https://restful-booker.herokuapp.com/booking
            When
                User send a request to the URL
            Then
                Status code is 200
            And
               Among the data there should be someone whose firstname is "Joe" and last name is "Colque"
 */


    @Test
    public void get04(){

        //set the base url and path params
        spec.pathParam("first", "booking").queryParams("firstname","Joe", "lastname",  "Colque");




        //Send the Get request and Get the response
        Response response = given().spec(spec).when().get("/{first}");


        //Validate data
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

    }





}
