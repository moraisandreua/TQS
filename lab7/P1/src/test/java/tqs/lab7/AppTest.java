package tqs.lab7;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

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

    @Test
    public void getResponseBody(){
        //given().when().get(url).then().log().all();

        get(url).then().body("$");

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
