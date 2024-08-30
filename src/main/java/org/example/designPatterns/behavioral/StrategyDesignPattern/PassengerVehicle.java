package org.example.designPatterns.behavioral.StrategyDesignPattern;

import org.example.designPatterns.behavioral.StrategyDesignPattern.Srategies.DriveStrategy;
import org.example.designPatterns.behavioral.StrategyDesignPattern.Srategies.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
