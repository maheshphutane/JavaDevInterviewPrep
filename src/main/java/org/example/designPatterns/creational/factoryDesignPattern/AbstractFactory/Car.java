package org.example.designPatterns.creational.factoryDesignPattern.AbstractFactory;

public class Car implements Vehicle1{
    @Override
    public void drive() {
        System.out.println("Driving Car...");
    }
}
