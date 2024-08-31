package org.example.MachineCoding.ParkingLot.models;

import lombok.Getter;

public class ParkingLot {
    @Getter
    int capacity;
    @Getter
    Slot[] slots;
    public ParkingLot(int capacity){
        this.capacity = capacity;
        slots = new Slot[capacity];
        for(int i = 0; i < capacity; i++){
            slots[i] = new Slot(i+1);
        }
    }

}
