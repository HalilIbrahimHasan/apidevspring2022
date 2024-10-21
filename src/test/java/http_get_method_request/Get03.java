package http_get_method_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class Get03 extends JsonPlaceHolderBaseUrl {


    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
            I send a GET request to the Url
        And
            Accept type is “application/json”
        Then
            HTTP Status Code should be 200
        And
            Response format should be "application/json"
        And
            There should be 200 todos
        And
            "quis eius est sint explicabo" should be one of the todos // title
        And
            2, 7, and 9 should be among the userIds
     */

    @Test
    public void test0001(){
        //set the path params
        spec.pathParam("bir", "todos");

        Response response = given().spec(spec).when().get("/{bir}");

        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title", hasItem("quis eius est sint explicabo")).
                body("userId", hasItems(2,7,9)).
                body("id", hasSize(200));


    }


    @Test
    public void get03(){

        //Set the base url
        spec.pathParam("first","todos" );



        //send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}");

        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("id", hasSize(200)).
                body("title", hasItem("quis eius est sint explicabo")).
                body("userId", hasItems(2,7,9));


    }


}
