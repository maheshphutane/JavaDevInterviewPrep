package org.example.designPatterns.creational.factoryDesignPattern.AbstractFactory;

public class Bike  implements Vehicle1{
    @Override
    public void drive() {
        System.out.println("Driving Bike...");
    }
}
