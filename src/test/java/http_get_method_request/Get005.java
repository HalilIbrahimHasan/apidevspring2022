package http_get_method_request;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;

import static io.restassured.RestAssured.given;
import static utility.TokenGenerator.generateToken;

public class Get005 extends GMIBankBaseUrl {


    @Test
    public void test01(){
        //read all countries
        //set path params
        spec.pathParams("bir", "api", "iki","tp-countries");


        //Send the REQUEST
        Response response = given().
                headers("Authorization", "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).
                spec(spec).when().get("/{bir}/{iki}");

        Country[] countries = response.as(Country[].class);

        int counter = 1;
        for(Country eachCountry : countries){
//            System.out.println(eachCountry);
            System.out.println("Country "+counter+" name : "+ eachCountry.getName());
        counter++;
        }

    }
}
