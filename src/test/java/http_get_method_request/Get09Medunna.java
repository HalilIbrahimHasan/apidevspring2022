package http_get_method_request;

import base_urls.MedunnaHealthBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Room1;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utility.TXTWriter.generateRoomData;

public class Get09Medunna extends MedunnaHealthBaseUrl {



    @Test
    public void get09() throws IOException {

        String  token = generateToken();
        //Set the base url and path params
        spec.pathParams("first", "api", "second", "rooms").queryParams("size", 400);


        Response response = given().headers(

                "Authorization",
                "Bearer "+ token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON


        ).spec(spec).when().get("/{first}/{second}");


        ObjectMapper obj = new ObjectMapper();

        Room1[] rooms = obj.readValue(response.asString(), Room1[].class);


        System.out.println(rooms.length);


        for (int i=0; i < rooms.length; i++){
            System.out.println(rooms[i]);
        }


        generateRoomData(rooms, "src/test/test_data/Batch8889.txt");

    }






}
