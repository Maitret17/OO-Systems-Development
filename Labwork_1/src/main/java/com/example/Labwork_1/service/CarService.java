package com.example.Labwork_1.service;

import com.example.Labwork_1.data.Car;
import com.example.Labwork_1.data.Dates;
import com.example.Labwork_1.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarService() {
    }

    public List<Car> listOfCars() {

        List<Car> cars = new ArrayList<>();

        carRepository.findAll().forEach(car -> {
            if (!car.isRent()) {
                cars.add(car);
            }
        });

        return cars;
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public Car getCar(String plateNumber) throws Exception {

        for (Car car : carRepository.findAll()) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "This car wasn't found"
        );
    }

    public void rentOrGetBack(
            String plateNumber,
            boolean rent,
            Dates dates
    ) throws Exception {

        Car car = getCar(plateNumber);

        if (rent) {
            if (car.isRent()) {
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

        carRepository.save(car);
    }
}