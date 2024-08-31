package org.example.MachineCoding.ParkingLot.strategies;

import org.example.MachineCoding.ParkingLot.models.ParkingLot;
import org.example.MachineCoding.ParkingLot.models.Slot;

public interface ParkingStrategy {
    Slot availableSlot(ParkingLot parkingLot);
}
