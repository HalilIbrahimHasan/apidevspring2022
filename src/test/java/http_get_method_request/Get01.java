package http_get_method_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {


      /*
        Given https://restful-booker.herokuapp.com/booking/3 endpoint
        When user sends a GET request to the url
        Then HTTP status code should be 200
        And   content type should be Json
        And status line should be HTTP/1.1 200 OK
 */

    @Test
    public void get01(){

    String endpoint = "https://restful-booker.herokuapp.com/booking/116";
     //I store request response here
    Response response =  given().when().get(endpoint);
                       // I start sending the request
    //This is primitive way and we do not use it
    //Validation of the requested data
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

    response.prettyPrint();

    }


}
