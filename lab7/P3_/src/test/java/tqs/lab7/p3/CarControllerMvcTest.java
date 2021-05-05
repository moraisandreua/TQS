package tqs.lab7.p3;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
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
    void listEmployees(){
        Mockito.when(service.getAllCars()).thenReturn(List.of(new Car("Tesla", "Model3")));
    }
}
