package com.example.Labwork_1.data;

import java.lang.reflect.GenericDeclaration;

public class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rent;
    private Dates dates;

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
