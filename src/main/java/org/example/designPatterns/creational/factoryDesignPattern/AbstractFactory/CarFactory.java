package org.example.designPatterns.creational.factoryDesignPattern.AbstractFactory;

public class CarFactory implements VehicleFactory{
    @Override
    public Vehicle1 getVehicle() {
        return new Car();
    }
}
