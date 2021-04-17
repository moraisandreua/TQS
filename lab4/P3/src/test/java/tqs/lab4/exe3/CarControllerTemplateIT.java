package tqs.lab4.exe3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "application-integrationtest.properties")
public class CarControllerTemplateIT {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
    public void whenValidInput_thenCreateCar() {
        Car ford = new Car("Sierra 2.3 Diesel", "Ford");
        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/cars", ford, Car.class);

        Car found = repository.findByModel(ford.getModel());
        System.out.println(found);
        assertThat(found.getModel()).isEqualTo(ford.getModel());
    }

    @Test
    public void givenEmployees_whenGetCars_thenStatus200()  {
        createTestCar("Volkswagen", "E-Tron");
        createTestCar("Mercedes", "CLS 320");


        ResponseEntity<List<Car>> response = restTemplate
                .exchange("/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
                });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Car::getModel).containsExactly("E-Tron", "CLS 320");
    }


    private void createTestCar(String maker, String model) {
        Car car = new Car(model, maker);
        repository.saveAndFlush(car);
    }
}
