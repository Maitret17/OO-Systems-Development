package com.example.Labwork_1.web;

import com.example.Labwork_1.data.Car;
import com.example.Labwork_1.data.Dates;
import com.example.Labwork_1.service.CarService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarWebService {

    private final CarService carService;

    public CarWebService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return carService.listOfCars();
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car getCar(
            @PathVariable("plateNumber") String plateNumber
    ) throws Exception {
        return carService.getCar(plateNumber);
    }

    @PutMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent,
            @RequestBody (required = false) Dates dates) throws Exception{
        carService.rentOrGetBack(plateNumber, rent, dates);
    }
}