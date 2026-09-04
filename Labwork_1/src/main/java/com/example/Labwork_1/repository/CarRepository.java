package com.example.Labwork_1.repository;

import com.example.Labwork_1.data.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}