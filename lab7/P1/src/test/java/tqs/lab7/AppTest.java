package tqs.lab7;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    final static String url="https://jsonplaceholder.typicode.com/todos";

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // third point
    @Test
    public void getResponse198_199(){
        get(url).then().body("id", hasItems(198,199));
    }

    // second point
    @Test
    public void getResponsePorroTempora(){
        Map<String, Object> expected = new HashMap<String, Object>();
        expected.put("id", 4);
        expected.put("title", "et porro tempora");
        expected.put("userId", 1);
        expected.put("completed", true);

        get(url).then().body("", Matchers.hasItem(expected));
    }

    // first point
    @Test
    public void getResponseStatus() {
        int statusCode = given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(url).getStatusCode();
        System.out.println("The response status is " + statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }
}
