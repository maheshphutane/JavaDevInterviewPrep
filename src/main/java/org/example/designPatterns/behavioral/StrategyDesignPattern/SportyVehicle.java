package org.example.designPatterns.behavioral.StrategyDesignPattern;

import org.example.designPatterns.behavioral.StrategyDesignPattern.Srategies.SpecialDriveStrategy;

public class SportyVehicle extends Vehicle{
    public SportyVehicle(){
        super(new SpecialDriveStrategy());
    }
}
