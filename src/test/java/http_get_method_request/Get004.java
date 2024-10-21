package http_get_method_request;

import base_urls.HerokuappBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.Booking;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get004 extends HerokuappBaseUrl {

    /*
         https://restful-booker.herokuapp.com/booking/3
    
     */

    @Test
    public void test01() throws IOException {
        //set the path params
        spec.pathParams("bir", "booking", "iki", 3);

        //set the expected data
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2016-11-16");
        bookingDates.put("checkout","2021-08-17");


        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jim");
        expectedData.put("lastname", "Jackson");
        expectedData.put("totalprice",123 );
        expectedData.put("depositpaid", true);
        expectedData.put("additionalneeds", "Breakfast");
        expectedData.put("bookingdates", bookingDates);



                              //send the request
        Response response =  given().spec(spec).when().get("/{bir}/{iki}");



        //status code ve json validation yapiniz
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON);
        //validation 1 hemcrest matcher

//        response.then().assertThat().
//                body("firstname", equalTo("Sally"),
//                        "lastname", equalTo("Brown"),
//                        "totalprice", equalTo(678)).
//                body("depositpaid", equalTo(true)).
//                body("bookingdates.checkin", equalTo("2019-11-15")).
//                body("bookingdates.checkout", equalTo("2023-10-20"));


        //validation 2                                Json => JAVA
//        Map<String, Object> actualData = response.as(HashMap.class);
//
//        Assert.assertEquals(expectedData,actualData );
            //Validation 3
//          Booking expectedBooking =   response.as(Booking.class);
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(expectedData.get("firstname"),expectedBooking.getFirstname() );
//        softAssert.assertEquals(expectedData.get("lastname"),expectedBooking.getLastname() );
//        softAssert.assertEquals(expectedData.get("totalprice"),expectedBooking.getTotalprice() );
//        softAssert.assertAll();
            //Validation 4
        JsonPath json = response.jsonPath();

//        System.out.println(json.getString("firstname"));
//        System.out.println(json.getString("lastname"));
//        System.out.println(json.getInt("totalprice"));
//        System.out.println(json.getString("bookingdates.checkin"));


//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(expectedData.get("firstname"),json.getString("firstname") );
//        softAssert.assertEquals(expectedData.get("lastname"),json.getString("lastname") );
//        softAssert.assertEquals(expectedData.get("totalprice"),json.getInt("totalprice") );
//        softAssert.assertAll();

        //JSON   =>   JAVA   :   Deserialization
        //JAVA   =>   JSON   :   Serialization

        //GSON : ObjectMapper

        //Validation 5
        Gson gson = new Gson();

        Booking booking2 = gson.fromJson(response.asString(), Booking.class);
//        System.out.println(booking2);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(expectedData.get("firstname"), booking2.getFirstname());
//        softAssert.assertEquals(expectedData.get("lastname"),booking2.getLastname() );
//        softAssert.assertEquals(expectedData.get("totalprice"),booking2.getTotalprice() );
//        softAssert.assertAll();


        //Validation 6 ObjectMapper
        ObjectMapper obj = new ObjectMapper();
        Booking booking3 = obj.readValue(response.asString(), Booking.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedData.get("firstname"), booking3.getFirstname());
        softAssert.assertEquals(expectedData.get("lastname"),booking3.getLastname() );
        softAssert.assertEquals(expectedData.get("totalprice"),booking3.getTotalprice() );
        softAssert.assertAll();



    }
}
