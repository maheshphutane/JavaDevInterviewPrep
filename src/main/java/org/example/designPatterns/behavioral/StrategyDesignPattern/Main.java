package org.example.designPatterns.behavioral.StrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle passengerVehicle = new PassengerVehicle();
        Vehicle sportyVehicle = new SportyVehicle();
        Vehicle offRodVehicle = new OffRodVehicle();

        passengerVehicle.drive();
        sportyVehicle.drive();
        offRodVehicle.drive();
    }
}
