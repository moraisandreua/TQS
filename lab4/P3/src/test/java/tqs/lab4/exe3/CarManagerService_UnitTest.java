package tqs.lab4.exe3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarManagerService_UnitTest {

    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carManagerService;

    @BeforeEach
    public void setUp() {
        Car ford = new Car("Sierra 2.3 Diesel", "Ford");
        Car volkswagen_art = new Car("Arteon", "Volkswagen");
        Car volkswagen_roc = new Car("T-Roc", "Volkswagen");

        Mockito.when(carRepository.findByModel("Arteon")).thenReturn(volkswagen_art);
        Mockito.when(carRepository.findByModel("T-Roc")).thenReturn(volkswagen_roc);
        Mockito.when(carRepository.findByModel("Sierra 2.3 Diesel")).thenReturn(ford);
        Mockito.when(carRepository.findByModel("CLS 320")).thenReturn(null);
    }

    @Test
    public void whenValidModel_thenCarShouldBeFound() {
        String model = "Arteon";
        Car found = carManagerService.getCarDetails(model);

        assertThat(found.getModel()).isEqualTo(model);
    }

    @Test
    public void whenInvalidName_thenCarShouldNotBeFound() {
        Car fromDb = carManagerService.getCarDetails("CLS 320");
        assertThat(fromDb).isNull();

        verifyFindByNameIsCalledOnce("CLS 320");
    }

    private void verifyFindByNameIsCalledOnce(String name) {
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByModel(name);
    }
}
