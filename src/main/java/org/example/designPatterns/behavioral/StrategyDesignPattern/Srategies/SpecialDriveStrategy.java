package org.example.designPatterns.behavioral.StrategyDesignPattern.Srategies;

public class SpecialDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Special Drive");
    }
}
