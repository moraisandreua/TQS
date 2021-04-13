package tqs.lab4.exe2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private CarManagerService carManagerService;

    public CarController(CarManagerService carService) {
        this.carManagerService = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carManagerService.getCarDetails(name);
    }
}
