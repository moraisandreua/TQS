package tqs.lab4.exe3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String maker;
    private String model;

    public Car() {
    }

    public Car(String model, String maker) {
        this.model = model;
        this.maker = maker;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        // field comparison
        return Objects.equals(maker, car.maker)
                && Objects.equals(model, car.model);
    }

    public int hashcode() {
        return 1;
    }

    public Long getCarId() {
        return carId;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public void setCardId(long id) {
        this.carId = id;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return "(" + this.carId + ")" + this.maker + " " + this.model;
    }

}
