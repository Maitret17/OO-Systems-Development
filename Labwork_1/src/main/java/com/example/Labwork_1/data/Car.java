package com.example.Labwork_1.data;

import jakarta.persistence.*;

import java.lang.reflect.GenericDeclaration;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNumber;
    private String brand;
    private int price;
    private boolean rent;
    @Embedded
    private Dates dates;

    public Car(){}

    public Car(String plateNumber, String brand, int price, boolean rent){
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rent = rent;
        this.dates = null;
    }

    public String getPlateNumber(){
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public boolean isRent(){
        return rent;
    }

    public Dates getDates(){
        return dates;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setRent(boolean rent) { this.rent = rent; }

    public void setDates(Dates dates) { this.dates = dates; }
}
