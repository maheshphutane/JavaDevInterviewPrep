package org.example.designPatterns.behavioral.StrategyDesignPattern;

import org.example.designPatterns.behavioral.StrategyDesignPattern.Srategies.DriveStrategy;
import org.example.designPatterns.behavioral.StrategyDesignPattern.Srategies.SpecialDriveStrategy;

public class OffRodVehicle extends Vehicle{
    public OffRodVehicle() {
        super(new SpecialDriveStrategy());
    }
}
