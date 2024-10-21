package utility;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TokenGenerator {



    public static String generateToken(){
        String endpoint = "https://www.gmibank.com/api/authenticate";

        Map<String, Object> data = new HashMap<>();
        data.put("password","Cw192837?" );
        data.put("username","CWoburn");
        data.put("rememberMe", true);

        Response response  = given().
                body(data).contentType(ContentType.JSON).post(endpoint);

        JsonPath json = response.jsonPath();
        return  json.getString("id_token");
    }


}
