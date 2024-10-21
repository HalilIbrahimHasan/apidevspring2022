package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonBaseUrl {

    protected  RequestSpecification specification;



    @Before
    public void setup(){
//        set the base url
        specification = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();


    }



}
