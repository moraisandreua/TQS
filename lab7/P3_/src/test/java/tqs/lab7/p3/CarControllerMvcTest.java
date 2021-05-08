package tqs.lab7.p3;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(CarController.class)
public class CarControllerMvcTest {

    @MockBean
    private CarManagerService service;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        RestAssuredMockMvc.mockMvc((mockMvc));
    }

    @Test
    void listCars(){
        Car c = new Car(1L,"tesla", "model3");
        Mockito.when(service.getAllCars()).thenReturn(List.of(c));


        RestAssuredMockMvc
                .given()
                    .auth().none()
                .when().get("/api/cars")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("$.size()", Matchers.equalTo(1))
                    .body("[0].carId", Matchers.equalTo(1));
    }


}
