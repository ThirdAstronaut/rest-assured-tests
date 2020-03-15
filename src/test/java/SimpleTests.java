import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleTests {

    @Test
    public void GetWeatherDetails()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";


when().get("/1").then().statusCode(200).body("id",equalTo(1) );
        String response = get().asString();
//        from(response).getList("findAll { it.id < 5 }.id");


//when().get().then().body("findAll { Integer.parseInt(it.id) < 5 }.id", hasItems("1","2","3","4"));

    }

           @Test
    public void secondTest(){
        when().get("http://dummy.restapiexample.com/api/v1/employees").then()
                .body("data.findAll { Integer.parseInt(it.id) < 5}.id", hasItems("1","2","3","4"));

               when().get("http://dummy.restapiexample.com/api/v1/employees").then().body("data.employee_name*.length().sum()",greaterThan(55));


    }

    @Test
    public void thirdTest(){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
        Map<String, String> products = get().as(new TypeRef<Map<String, String>>() {});
        assertThat(products.get("City"), equalTo("Hyderabad"));
    }


}
