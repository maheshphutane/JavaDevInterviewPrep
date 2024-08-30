package org.example.designPatterns.behavioral.StrategyDesignPattern.Srategies;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Drive");
    }
}
