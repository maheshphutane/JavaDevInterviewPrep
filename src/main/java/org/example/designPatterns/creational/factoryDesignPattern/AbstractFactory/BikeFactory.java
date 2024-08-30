package org.example.designPatterns.creational.factoryDesignPattern.AbstractFactory;

public class BikeFactory implements VehicleFactory{
    @Override
    public Vehicle1 getVehicle() {
        return new Bike();
    }
}
