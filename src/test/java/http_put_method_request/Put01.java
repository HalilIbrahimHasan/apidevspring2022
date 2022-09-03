package http_put_method_request;

import base_urls.MedunnaHealthBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Room;
import pojos.Room1;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends MedunnaHealthBaseUrl {


    @Test
    public void put01() throws IOException {
        String token = generateToken();


        spec.pathParams("first", "api", "second", "rooms");

        //Set the expectedData

        Room1 room1 = new Room1("Another Update", 382, 34736, "TWIN", true);
        room1.setId(267283);


        Response response = given().headers(

                "Authorization",
                "Bearer "+ token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON


        ).spec(spec).contentType(ContentType.JSON).body(room1).when().put("/{first}/{second}");


        //validate


        ObjectMapper obj = new ObjectMapper();
        //This will do the deserialization from Json to java or from java to json

        //Deserializing data from JSON to Java
        Room actualRoom = obj.readValue(response.asString(), Room.class);

        assertEquals(room1.getDescription(),actualRoom.getDescription() );
        //validating description
        assertEquals(room1.getPrice(),actualRoom.getPrice() );
        //validating price
        assertEquals(room1.getRoomType(),actualRoom.getRoomType() );
//        validating room type
        assertEquals(room1.isStatus(),actualRoom.isStatus() );
        //validating the status




    }




}
