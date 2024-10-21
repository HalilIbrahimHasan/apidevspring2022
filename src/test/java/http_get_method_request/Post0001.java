package http_get_method_request;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.CountryPost;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static utility.TokenGenerator.generateToken;

public class Post0001 extends GMIBankBaseUrl {


    @Test
    public void post01(){
        //set the path params
        spec.pathParams("bir", "api", "iki", "tp-countries");

        //set the expected Data
        CountryPost country = new CountryPost("ErdemBey Dream Country");
       //ikinci expectedData
        Map<String, String > country2 = new HashMap<>();
        country2.put("name", "Talent World");


        //Send the REQUEST
        Response response = given().
                headers("Authorization","Bearer "+ generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                spec(spec).
                body(country2).
                contentType(ContentType.JSON).
                when().
                post("/{bir}/{iki}");

        response.then().assertThat().statusCode(201).
                body("name", equalTo("Talent World"));


        response.prettyPrint();





    }


    @Test
    public void put01( ){
        //set the path params
        spec.pathParams("bir", "api", "iki", "tp-countries");

        //set the expected Data
        Country country = new Country("Erdem bey country update", 197837);
        //ikinci expectedData
        Map<String, String > country2 = new HashMap<>();
        country2.put("name", "Talent World update");


        //Send the REQUEST
        Response response = given().
                headers("Authorization","Bearer "+ generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                spec(spec).
                body(country).
                contentType(ContentType.JSON).
                when().
                put("/{bir}/{iki}");

        response.then().assertThat().statusCode(200).
                body("name", equalTo("Erdem bey country update"));


        response.prettyPrint();



    }

    @Test
    public void deleteCountry(){
        //set the path params
        spec.pathParams("bir", "api", "iki", "tp-countries", "uc",197835);

        //Send the REQUEST
        //Send the REQUEST
        Response response = given().
                headers("Authorization","Bearer "+ generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                spec(spec).
                when().
                delete("/{bir}/{iki}/{uc}");

        response.then().assertThat().statusCode(204);

        response.prettyPrint();

    }



}
