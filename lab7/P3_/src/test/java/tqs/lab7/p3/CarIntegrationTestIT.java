package tqs.lab7.p3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarIntegrationTestIT {

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer("postgres")
            .withUsername("postgre")
            .withPassword("postgre")
            .withDatabaseName("postgre");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Autowired
    private TestRestTemplate restClient;

    @Autowired
    private CarRepository repository;

    @LocalServerPort
    int localPort;

    Car car1, car2;

    @BeforeEach
    public void setUpTestCars() throws Exception{
        car1 = repository.saveAndFlush(new Car("model3", "tesla"));
        car2 = repository.saveAndFlush(new Car("sierra", "ford"));
    }

    @AfterEach
    public void resetDb() {
        //repository.deleteAll();
    }

    @Test
    void getCar_returnsCarDetails_resttemplate(){
        ResponseEntity<Car> entity = restClient.getForEntity("/api/cars/"+car1.getModel(), Car.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().getModel()).isEqualTo("model3");
    }

    @Test
    void getCar_returnsCarDetails_restassure() {
        String url = "http://127.0.0.1:" + localPort + "/api/cars/"+car1.getModel();

        System.out.println(url);

        RestAssured.when().get(url).then().assertThat().statusCode(HttpStatus.OK.value()).body("model", equalTo(car1.getModel()));
    }
}
