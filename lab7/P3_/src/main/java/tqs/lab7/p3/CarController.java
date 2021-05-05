package tqs.lab7.p3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarManagerService carManagerService;

    public CarController(CarManagerService carService) {
        this.carManagerService = carService;
    }

    @PostMapping("/cars")
    private ResponseEntity<Car> createCar(@RequestBody Car car) {
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carManagerService.save(car);
        return new ResponseEntity<>(saved, status);
    }

    @GetMapping("/cars")
    private List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }

    // decidi alterar a implementação do Diagrama porque achei que não fazia sentido filtrar do ID, sendo que eu sei diretamente o modelo do carro mas não o ID
    @GetMapping("/cars/{model}")
    private Car getCarById(@PathVariable String id) {
        return carManagerService.getCarDetails(id);
    }
}
