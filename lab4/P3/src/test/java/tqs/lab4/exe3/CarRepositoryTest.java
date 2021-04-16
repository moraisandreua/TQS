package tqs.lab4.exe3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenFindMercedesModel_thenReturnMercedesModel() {
        Car alex = new Car("CLS 320", "Mercedes");
        entityManager.persistAndFlush(alex); //ensure data is persisted at this point

        Car found = carRepository.findByModel(alex.getModel());
        assertThat( found ).isEqualTo(alex);
    }

    @Test
    public void whenInvalidCarModel_thenReturnNull() {
        Car fromDb = carRepository.findByModel("Arteon");
        assertThat(fromDb).isNull();
    }

    @Test
    public void givenSetOfEmployees_whenFindAll_thenReturnAllCars() {
        Car ford = new Car("Sierra 2.3 Diesel", "Ford");
        Car mercedes = new Car("CLS 320", "Mercedes");
        Car volkwagen = new Car("T-Roc", "Volkswagen");

        entityManager.persist(ford);
        entityManager.persist(mercedes);
        entityManager.persist(volkwagen);
        entityManager.flush();

        List<Car> allEmployees = carRepository.findAll();

        assertThat(allEmployees).hasSize(3).extracting(Car::getModel).containsOnly(ford.getModel(), mercedes.getModel(), volkwagen.getModel());
    }
}
