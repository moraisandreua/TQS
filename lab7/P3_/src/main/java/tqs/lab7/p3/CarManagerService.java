package tqs.lab7.p3;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarManagerService {

    private CarRepository carRepository;

    public CarManagerService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    /*public Optional<Car> getCarDetails(long key) {
        return  carRepository.findById(key);
    }*/

    public Car getCarDetails(String model) {
        return carRepository.findByModel(model);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
