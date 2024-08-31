package org.example.MachineCoding.ParkingLot.strategies;

import org.example.MachineCoding.ParkingLot.models.ParkingLot;
import org.example.MachineCoding.ParkingLot.models.Slot;

public class NearestAvailableParkingStrategy implements ParkingStrategy{
    @Override
    public Slot availableSlot(ParkingLot parkingLot) {
        if(parkingLot == null) return null;
        Slot[] slots = parkingLot.getSlots();
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }
        return null;
    }
}
