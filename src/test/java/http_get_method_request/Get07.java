package http_get_method_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07 extends JsonPlaceHolderBaseUrl {

     /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request
     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }
     */

    @Test
    public void get07(){
        //Set the base url and path params
        spec.pathParams("first", "todos", "second", 2);

        //Set the expected data
        Map<String, Object> expectedDataMap = new HashMap();
        expectedDataMap.put("userId", 1);
        expectedDataMap.put("id", 2);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("completed",false);

        //2. way of setting data
        Todo expectedTodoData = new Todo(1, 2, "quis ut nam facilis et officia qui",false);




        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //1.Validate the data
        Map<String, Object> actualDataMap = response.as(HashMap.class);

        System.out.println("EXPECTED  DATA:   :   : "+expectedDataMap);
        System.out.println("ACTUAL  DATA:   :   : "+actualDataMap);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        softAssert.assertEquals(expectedDataMap.get("id"), actualDataMap.get("id"));
        softAssert.assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        softAssert.assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));
        softAssert.assertAll();

        //2. Validate the data

        Todo actualTodoData = response.as(Todo.class);

        SoftAssert softAssert2 = new SoftAssert();
        softAssert2.assertEquals(expectedTodoData.getId(), actualTodoData.getId());
        softAssert2.assertEquals(expectedTodoData.getUserId(), actualTodoData.getUserId());
        softAssert2.assertEquals(expectedTodoData.getTitle(), actualTodoData.getTitle());
        softAssert2.assertEquals(expectedTodoData.isCompleted(), actualTodoData.isCompleted());
        softAssert2.assertAll();


        System.out.println("This is EXPECTED TODO OBJECT DATA    : "+expectedTodoData);

        System.out.println("This is ACTUAL TODO OBJECT DATA    : "+actualTodoData);

    }





}
