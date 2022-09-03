package http_post_method_request;

import base_urls.MedunnaHealthBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Room;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends MedunnaHealthBaseUrl {




    @Test
    public void post01() throws IOException {

        String token = generateToken();

        spec.pathParams("first", "api", "second", "rooms");

        //Expected data
        Room room = new Room("3. new dev with post", 900, 347654, "TWIN", true);

        //2. way
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("roomNumber", 2038);
        expectedDataMap.put("roomType", "TWIN");
        expectedDataMap.put("status", true);
        expectedDataMap.put("price", 1000);
        expectedDataMap.put("description", "Hello worl");



        //Send the request and get the response

        Response response = given().headers(

                "Authorization",
                "Bearer "+ token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON


        ).spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}/{second}");


        response.prettyPrint();

        response.then().assertThat().statusCode(201);


        //validate

        ObjectMapper obj = new ObjectMapper();
        //This will do the deserialization from Json to java or from java to json

        //Deserializing data from JSON to Java
        Room actualRoom = obj.readValue(response.asString(), Room.class);

        assertEquals(expectedDataMap.get("description"),actualRoom.getDescription() );
        //validating description
        assertEquals(expectedDataMap.get("price"),actualRoom.getPrice() );
        //validating price
        assertEquals(expectedDataMap.get("roomType"),actualRoom.getRoomType() );
//        validating room type
        assertEquals(expectedDataMap.get("status"),actualRoom.isStatus() );
        //validating the status

    }



}
