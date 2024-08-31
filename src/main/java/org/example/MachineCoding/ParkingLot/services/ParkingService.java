package org.example.MachineCoding.ParkingLot.services;

import org.example.MachineCoding.ParkingLot.models.Car;
import org.example.MachineCoding.ParkingLot.models.ParkingLot;

public interface ParkingService {
    void createParkingLot(int capacity);
    void parkCar( Car car);
    void removeCar(int slotNumber);
    void status();
    void getRegistrationNumberWithColor(String color);
    void getSlotNumberForRegistrationNumber(String registrationNumber);
    void getSlotNumbersForCarsWithColor(String color);

    void leaveCar(Integer slotNumber);
}
