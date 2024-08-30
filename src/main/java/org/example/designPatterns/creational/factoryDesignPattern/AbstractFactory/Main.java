package org.example.designPatterns.creational.factoryDesignPattern.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Vehicle1 obj1 = carFactory.getVehicle();
        obj1.drive();
        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle1 obj2 = bikeFactory.getVehicle();
        obj2.drive();
    }
}
