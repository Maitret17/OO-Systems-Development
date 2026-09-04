package com.example.Labwork_1;

import com.example.Labwork_1.data.Car;
import com.example.Labwork_1.data.Dates;
import com.example.Labwork_1.service.CarService;
import com.example.Labwork_1.web.CarWebService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Labwork1Application {

	public static void main(String[] args) {
		SpringApplication.run(Labwork1Application.class, args);
	}

	@Bean public CommandLineRunner demo(CarService carRentalService) {
		return (args) -> {
			Car car = new Car("11AA22", "Ferrari", 1000, false);
			carRentalService.addCar(car);
			car = new Car("33BB44", "Peugeot", 500, false);
			carRentalService.addCar(car);
			car = new Car("55CC66", "Porsche", 1500, true);
			car.setDates(new Dates("11/11/2017", "1/1/2018"));
			carRentalService.addCar(car);
		};
	};

}
