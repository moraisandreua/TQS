package tqs.lab4.exe2;

import org.springframework.stereotype.Service;

@Service
public class CarManagerService {

    private CarRepository carRepository;

    public CarManagerService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String key) {
        return  carRepository.findByModel( key);
    }
}
