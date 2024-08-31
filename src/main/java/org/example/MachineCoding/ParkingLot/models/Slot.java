package org.example.MachineCoding.ParkingLot.models;

import lombok.Getter;

public class Slot {
    @Getter
    private int slotNumber;
    private boolean isOccupied;
    @Getter
    private Car car;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
        this.car = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void parkCar(Car car){
        this.car = car;
        this.isOccupied = true;
    }

    public void removeCar(){
        this.car = null;
        this.isOccupied = false;
    }
}
