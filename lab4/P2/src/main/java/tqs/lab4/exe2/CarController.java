package tqs.lab4.exe2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class CarController {
    private CarManagerService carManagerService;

    public CarController(CarManagerService carService) {
        this.carManagerService = carService;
    }

    @PostMapping
    private Car createCar(Car car){
        return carManagerService.save(car);
    }

    @GetMapping("/cars")
    private List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    private Optional<Car> getCarById(@PathVariable long id) {
        return carManagerService.getCarDetails(id);
    }
}
