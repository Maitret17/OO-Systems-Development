package com.example.Labwork_1.service;

import com.example.Labwork_1.data.Car;
import com.example.Labwork_1.data.Dates;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("11AA22", "Ferrari", 100, false));
        cars.add(new Car("33BB44", "Peugeot", 50, false));
        Car porsche = new Car("55CC66", "Porsche", 75, true);
        porsche.setDates(new Dates("11/11/2017", "1/1/2018"));
        cars.add(porsche);
    }

    public List<Car> listOfCars() {
        return cars.stream().filter(car -> !car.isRent()).toList();
    }

    public Car getCar(String plateNumber) throws Exception {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "This car wasn't found"
        );
    }

    public void rentOrGetBack(String plateNumber, boolean rent, Dates dates) throws Exception{
        Car car = getCar(plateNumber);
        if(rent){
            if (car.isRent()){
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "This car is unavailable"
                );
            }
                car.setRent(true);
                car.setDates(dates);
        } else {
            car.setRent(false);
            car.setDates(null);
        }
    }
}